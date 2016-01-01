package presentation.right.ying_salesman;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import businesslogic.transportbl.hallStaff.Trans_HallSendingServerImpl;
import businesslogicservice.transportblservice.hallStaff.Trans_HallSendingServer;
import po.bills.SendingBill;
import presentation.right.Remind;
import presentation.right.RightAll;
import presentation.right.YearMonthDay;
import presentation.watcher.*;

public class Ying_collect extends RightAll implements ActionListener {
	Trans_HallSendingServer blServer;

	int frameWidth;
	int frameHeight;
	JLabel jl[];
	JTextField jtf[];
	JButton confirm;
	JButton cancel;
	JComboBox<String>[] timeInput;
	JLabel time[];
	private List<Watcher> list;
	
	JPanel jp_wrong;
	Remind remindThread;

	public Ying_collect(int frameWidth, int frameHeight) {
		blServer = new Trans_HallSendingServerImpl();

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel[4];
		for (int i = 0; i < 4; i++) {
			jl[i] = new JLabel();
		}
		confirm = new JButton("");// 确认
		cancel = new JButton("");// 取消
		jtf = new JTextField[2];
		for (int i = 0; i < 2; i++) {
			jtf[i] = new JTextField();
		}

		timeInput = new JComboBox[3];
		time = new JLabel[3];
		for (int i = 0; i < 3; i++) {
			time[i] = new JLabel();
		}
		YearMonthDay time1 = new YearMonthDay();
		timeInput[0] = time1.getCboYear();
		timeInput[1] = time1.getCboMonth();
		timeInput[2] = time1.getCboDay();

		init();

		for (int i = 0; i < 4; i++) {
			this.add(jl[i]);
		}
		this.add(confirm);
		this.add(cancel);
		for (int i = 0; i < 2; i++) {
			this.add(jtf[i]);
		}
		for (int i = 0; i < 3; i++) {
			this.add(time[i]);
			this.add(timeInput[i]);
		}
	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\派件单right.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth / 4 * 3, frameHeight, null);
	}

	private void init() {
		jl[0].setText("派件单");
		jl[1].setText("到达日期");
		jl[2].setText("托运单条形码");
		jl[3].setText("快递员");

		jl[0].setBounds(frameWidth / 3, frameHeight / 10, frameWidth / 5,
				frameHeight / 20);
		jl[0].setFont(new Font("黑体", Font.BOLD, 22));
		for (int i = 1; i < 4; i++) {
			jl[i].setBounds(frameWidth / 10, frameHeight / 36 * 5 * i
					+ frameHeight / 11 + frameHeight / 80, frameWidth / 8,
					frameHeight / 20);
			jl[i].setFont(new Font("宋体", Font.BOLD, 17));
		}

		confirm.setBounds(frameWidth / 6, frameHeight * 8 / 10, frameWidth / 9,
				frameHeight / 16);
		confirm.addActionListener(this);
		cancel.setBounds(frameWidth * 2 / 5 + frameWidth / 15,
				frameHeight * 8 / 10, frameWidth / 9, frameHeight / 16);
		cancel.addActionListener(this);

		time[0].setText("年");
		time[1].setText("月");
		time[2].setText("日");
		for (int i = 0; i < 3; i++) {
			timeInput[i].setBounds(frameWidth / 4 + frameWidth / 10 * i,
					frameHeight / 36 * 5 + frameHeight / 11 + frameHeight / 80,
					frameWidth / 12, frameHeight / 20);
			time[i].setBounds(frameWidth / 3 + frameWidth / 10 * i, frameHeight
					/ 36 * 5 + frameHeight / 11 + frameHeight / 80,
					frameWidth / 12, frameHeight / 20);
			time[i].setFont(new Font("宋体", Font.PLAIN, 14));
			timeInput[i].setFont(new Font("宋体", Font.PLAIN, 14));
		}

		jtf[0].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});

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

		for (int i = 0; i < 2; i++) {
			jtf[i].setBounds(frameWidth / 4, frameHeight / 36 * 5 * (2 + i)
					+ frameHeight / 11 + frameHeight / 80, frameWidth / 8,
					frameHeight / 18);
			jtf[i].setFont(new Font("宋体", Font.PLAIN, 15));
		}

		jtf[0].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					jtf[1].requestFocus();
				}
			}
		});

		jtf[1].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					jtf[0].requestFocus();
				}
			}
		});
	}

	public void addWatcher(Watcher watcher) {
		list.add(watcher);
	}

	public void removeWatcehr(Watcher watcher) {
		list.remove(watcher);
	}

	public void notifyWatchers(State state) {
		for (Watcher watcher : list) {
			watcher.update(state);
		}
	}
	
	private void showMessage(String message) {
		if (remindThread != null) {
			remindThread.stop();
			this.remove(jp_wrong);
		}
		jp_wrong = new JPanel();
 
		this.add(jp_wrong);
		remindThread = new Remind(jp_wrong, message);
		remindThread.start();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancel) {
			this.notifyWatchers(State.ZHONG_START);
		} else if (e.getSource() == confirm) {
			String date = "";
			String year = timeInput[0].getSelectedItem().toString();
			String month = timeInput[1].getSelectedItem().toString();
			String day = timeInput[2].getSelectedItem().toString();

			date = year + "-" + month + "-" + day;
			String orderId = jtf[0].getText();
			String sender = jtf[1].getText();

			SendingBill bill = blServer.makeBill(date, orderId, sender);

			//showMessage();
			
		}

	}
}
