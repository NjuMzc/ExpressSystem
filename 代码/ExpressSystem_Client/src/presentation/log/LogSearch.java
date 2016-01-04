package presentation.log;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

import businesslogic.transportbl.client.Trans_InquireGoodStateServerImpl;
import businesslogicservice.transportblservice.client.Trans_InquireGoodStateServer;
import presentation.right.RightAll;
import presentation.watcher.*;

public class LogSearch extends RightAll implements ActionListener {
	Trans_InquireGoodStateServer blServer;
	String goodState;
	ArrayList<String> traceRecord;

	int frameWidth;
	int frameHeight;
	JLabel remind;
	JButton confirm;
	JButton back;
	JTextField jtf;
	JPanel addPanel;
	private List<Watcher> list;

	public LogSearch(int frameWidth, int frameHeight) {
		blServer = new Trans_InquireGoodStateServerImpl();

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(0, 0, frameWidth, frameHeight);

		remind = new JLabel("请输入快递单号");
		confirm = new JButton("");// 确认
		back = new JButton("");// 返回
		jtf = new JTextField();

		init();

		this.add(remind);
		this.add(confirm);
		this.add(back);
		this.add(jtf);
	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\背景.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth, frameHeight, null);
	}

	private void init() {
		remind.setBounds(frameWidth / 3 - frameWidth / 40, frameHeight / 5,
				frameWidth / 4, frameHeight / 20);
		remind.setFont(new Font("宋体", Font.BOLD, 20));
		confirm.setBounds(frameWidth / 3 * 2 + frameWidth / 50,
				frameHeight / 5, frameWidth / 10, frameHeight / 19);
		confirm.addActionListener(this);
		back.setBounds(frameWidth / 2, frameHeight / 10 * 9, frameWidth / 10,
				frameHeight / 19);
		back.addActionListener(this);

		ImageIcon icon2 = new ImageIcon("pictures//确认小.png");
		Image temp2 = icon2.getImage().getScaledInstance(icon2.getIconWidth(),
				icon2.getIconHeight(), icon2.getImage().SCALE_DEFAULT);
		icon2 = new ImageIcon(temp2);
		confirm.setIcon(icon2);

		ImageIcon icon1 = new ImageIcon("pictures//返回小.png");
		Image temp1 = icon1.getImage().getScaledInstance(icon1.getIconWidth(),
				icon1.getIconHeight(), icon1.getImage().SCALE_DEFAULT);
		icon1 = new ImageIcon(temp1);
		back.setIcon(icon1);

		jtf.setBounds(frameWidth / 2, frameHeight / 5, frameWidth / 7,
				frameHeight / 20);
		jtf.setFont(new Font("宋体", Font.PLAIN, 16));
		jtf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					confirmButton();
				}
			}

			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
	}

	private void initAddPanel(int num) {
		if (addPanel != null) {
			this.remove(addPanel);
		}
		addPanel = new JPanel();
		addPanel.setBackground(new Color(221, 232, 216));
		JLabel stateGoods = new JLabel("货物状态");
		JLabel traceGoods = new JLabel("货物轨迹");
		JLabel state = new JLabel();

		stateGoods.setFont(new Font("宋体", Font.BOLD, 16));
		traceGoods.setFont(new Font("宋体", Font.BOLD, 16));

		JLabel trace[];
		trace = new JLabel[num];
		for (int i = 0; i < num; i++) {
			trace[i] = new JLabel();
			trace[i].setText(traceRecord.get(i));
		}
		for (int i = 0; i < num; i++) {
			if (i < 5) {
				trace[i].setBounds(frameWidth / 8, frameHeight / 10
						+ frameWidth / 20 * i, frameWidth / 5, frameHeight / 20);
			} else {
				trace[i].setBounds(frameWidth * 13 / 40, frameHeight / 10
						+ frameWidth / 20 * i, frameWidth / 5, frameHeight / 20);
			}
		}

		// 根据货物状态设置文字
		if(goodState.equals("Delivering")){
			state.setText("您的宝贝正在路上");
		}else if(goodState.equals("ArriveSendHall")){
			state.setText("到达寄件方营业厅");
		}else if(goodState.equals("ArriveSendStorage")){
			state.setText("到达寄件方中转中心仓库");
		}else if(goodState.equals("Received")){
			state.setText("已被签收");
		}else if(goodState.equals("ArriveReceiveHall")){
			state.setText("到达收件方营业厅");
		}else if(goodState.equals("ArriveReceiveStorage")){
			state.setText("到达收件方中转中心仓库");
		}
		

		addPanel.setBounds(frameWidth / 3, frameHeight / 3, frameWidth / 2,
				frameHeight / 2);
		addPanel.setLayout(null);
		this.setOpaque(false);
		stateGoods.setBounds(0, 0, frameWidth / 10, frameHeight / 20);
		traceGoods.setBounds(0, frameHeight / 10, frameWidth / 10,
				frameHeight / 20);
		state.setBounds(frameWidth / 8, 0, frameWidth / 10, frameHeight / 20);

		addPanel.add(stateGoods);
		addPanel.add(traceGoods);
		for (int i = 0; i < num; i++) {
			addPanel.add(trace[i]);
		}
		addPanel.add(state);
		this.add(addPanel);
		this.repaint();
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

	private void confirmButton() {
		String id = jtf.getText();

		goodState = blServer.getGoodState(id);
		// 错误信息提示
		if (goodState == "0") {
			final JLabel remindWrong = new JLabel();
			remindWrong.setBounds(frameWidth / 3 - frameWidth / 40, frameHeight
					/ 5 - frameHeight / 20, frameWidth / 4, frameHeight / 20);
			remindWrong.setFont(new Font("宋体", Font.BOLD, 20));
			remindWrong.setForeground(Color.red);
			this.add(remindWrong);
			this.repaint();

			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					remindWrong.setText("输入的快递单号不存在");
					try {
						Thread.sleep(800);
					} catch (Exception e2) {
						// TODO: handle exception
					}
					remindWrong.setText("");
				}
			});
			t.start();

		} else {
			Iterator<String> trace = blServer.getTrace(id);

			traceRecord = new ArrayList<String>();
			int counter = 0;
			while (trace.hasNext()) {
				traceRecord.add(trace.next());
				counter++;
			}
			initAddPanel(counter);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) {
			this.notifyWatchers(State.COVER);
		} else if (e.getSource() == confirm) {

			confirmButton();

		}

	}
}
