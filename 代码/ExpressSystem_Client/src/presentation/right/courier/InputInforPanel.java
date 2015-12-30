package presentation.right.courier;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import businesslogic.transportbl.courier.Trans_MakingReceiveBillServerImpl;
import businesslogicservice.transportblservice.courier.Trans_MakingReceiveBillServer;

import javax.swing.*;

import po.Message;
import presentation.right.Remind;
import presentation.right.RightAll;
import presentation.right.YearMonthDay;
import presentation.watcher.*;

public class InputInforPanel extends RightAll implements ActionListener {
	int frameWidth;
	int frameHeight;
	JButton confirm;
	JButton cancel;
	JLabel jl[];
	// JLabel wrong;
	JTextField jtfNum;
	JTextField jtfName;
	private List<Watcher> list;
	boolean isWrongShow = false;
	JLabel time[];
	JComboBox<String>[] timeInput;

	Trans_MakingReceiveBillServer blServer;

	public InputInforPanel(int frameWidth, int frameHeight) {
		this.blServer = new Trans_MakingReceiveBillServerImpl();

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		time = new JLabel[3];
		timeInput = new JComboBox[3];
		for (int i = 0; i < 3; i++) {
			time[i] = new JLabel();
		}
		YearMonthDay time1 = new YearMonthDay();
		timeInput[0] = time1.getCboYear();
		timeInput[1] = time1.getCboMonth();
		timeInput[2] = time1.getCboDay();

		jl = new JLabel[3];
		for (int i = 0; i < 3; i++) {
			jl[i] = new JLabel();
		}
		confirm = new JButton();
		cancel = new JButton();
		jtfNum = new JTextField();
		jtfName = new JTextField();

		init();

		this.add(confirm);
		this.add(cancel);
		this.add(jtfName);
		this.add(jtfNum);
		for (int i = 0; i < 3; i++) {
			this.add(jl[i]);
			this.add(time[i]);
			this.add(timeInput[i]);
		}
	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\收件2right.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth * 3 / 4, frameHeight, null);
	}

	private void init() {

		confirm.setBounds(frameWidth / 4 - frameWidth / 25, frameHeight / 10
				+ frameWidth / 2, frameWidth / 10 + frameWidth / 70,
				frameWidth / 21);
		confirm.setText("");// 确认
		confirm.addActionListener(this);
		cancel.setBounds(frameWidth * 2 / 5 + frameWidth / 25, frameHeight / 10
				+ frameWidth / 2, frameWidth / 10 + frameWidth / 70,
				frameWidth / 21);
		cancel.setText("");// 取消
		cancel.addActionListener(this);

		ImageIcon icon1 = new ImageIcon("pictures//取消t.png");
		Image temp1 = icon1.getImage().getScaledInstance(icon1.getIconWidth(),
				icon1.getIconHeight(), icon1.getImage().SCALE_DEFAULT);
		icon1 = new ImageIcon(temp1);
		cancel.setIcon(icon1);

		ImageIcon icon2 = new ImageIcon("pictures//确认小.png");
		Image temp2 = icon2.getImage().getScaledInstance(icon2.getIconWidth(),
				icon2.getIconHeight(), icon2.getImage().SCALE_DEFAULT);
		icon2 = new ImageIcon(temp2);
		confirm.setIcon(icon2);

		for (int i = 0; i < 3; i++) {
			jl[i].setBounds(frameWidth / 6 - frameWidth / 35, frameHeight / 10
					+ frameHeight / 30 + frameHeight / 5 * i, frameWidth / 7,
					frameHeight / 18);
			jl[i].setFont(new Font("宋体", Font.BOLD, 18));
		}
		jl[0].setText("快递单号");
		jl[1].setText("收件人姓名");
		jl[2].setText("收件日期");

		jtfNum.setBounds(frameWidth / 4 + frameWidth / 35, frameHeight / 10
				+ frameHeight / 30, frameWidth / 8, frameHeight / 16);
		jtfName.setBounds(frameWidth / 4 + frameWidth / 35, frameHeight / 10
				* 3 + frameHeight / 30, frameWidth / 8, frameHeight / 16);
		jtfNum.setFont(new Font("宋体", Font.PLAIN, 16));
		jtfName.setFont(new Font("宋体", Font.PLAIN, 16));
		jtfNum.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});

		time[0].setText("年");
		time[1].setText("月");
		time[2].setText("日");
		for (int i = 0; i < 3; i++) {
			timeInput[i].setBounds(frameWidth / 4 + frameWidth / 35
					+ frameWidth / 10 * i + frameWidth / 60 * i, frameHeight
					/ 2 + frameHeight / 25, frameWidth / 12 + frameWidth / 60,
					frameHeight / 18);
			time[i].setBounds(frameWidth / 3 + frameWidth / 35 + frameWidth
					/ 60 * (i + 1) + frameWidth / 10 * i, frameHeight / 2
					+ frameHeight / 25, frameWidth / 10, frameHeight / 18);
			time[i].setFont(new Font("宋体", Font.PLAIN, 14));
			timeInput[i].setFont(new Font("宋体", Font.PLAIN, 14));
		}

		jtfName.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					jtfNum.requestFocus();
				}
			}
		});
		jtfNum.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					jtfName.requestFocus();
				}
			}
		});
	}

	private void wrongShow() {
		// 错误处理
		final JLabel remindWrong = new JLabel();
		remindWrong.setBounds(frameWidth / 3 - frameWidth / 15,
				frameHeight / 5 * 3, frameWidth / 3, frameHeight / 10);
		remindWrong.setFont(new Font("宋体", Font.BOLD, 20));
		remindWrong.setForeground(Color.red);
		this.add(remindWrong);
		this.repaint();

		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				// 以下根据错误类型设置文字
				remindWrong.setText("输入的订单不存在!");
				try {
					Thread.sleep(2000);
				} catch (Exception e2) {
					// TODO: handle exception
				}
				remindWrong.setText("");
			}
		});
		t.start();
		// 错误处理结束
	}

	public void save(Message msg) {
		try {
			System.out.println("xiexie");
			File msgs = new File("messages/messages.txt");
			FileWriter fwriter = new FileWriter(msgs);
			BufferedWriter writer = new BufferedWriter(fwriter);
			int n = msg.length();
			for (int i = 0; i < n; i++) {
				writer.write(msg.getInform(i));
				writer.write(";");
			}
			writer.newLine();

			writer.close();

		} catch (Exception e) {
			System.out.println("xxx");
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String num;
		String name;
		String time;

		if (e.getSource() == confirm) {
			num = jtfNum.getText();
			name = jtfName.getText();
			time = (String) timeInput[0].getSelectedItem()
					+ (String) timeInput[1].getSelectedItem()
					+ (String) timeInput[2].getSelectedItem();
			jtfNum.setText("");
			jtfName.setText("");

			if (blServer.makeBill(num, name, time) == null) {
				isWrongShow = true;
			} else {
				isWrongShow = false;
			}

			if (isWrongShow) {
				wrongShow();
				// Remind remind = new Remind("wrong!");
				// this.add(remind);
			}

		}

		if (e.getSource() == cancel) {
			num = null;
			name = null;
			time = null;
			jtfName.setText("");
			jtfNum.setText("");

			this.notifyWatchers(State.COURIERSTART);
		}

	}

	public void addWatcher(Watcher watcher) {
		// TODO Auto-generated method stub
		list.add(watcher);
	}

	public void removeWatcehr(Watcher watcher) {
		// TODO Auto-generated method stub
		list.remove(watcher);
	}

	public void notifyWatchers(State state) {
		// TODO Auto-generated method stub
		for (Watcher watcher : list) {
			watcher.update(state);
		}
	}

}