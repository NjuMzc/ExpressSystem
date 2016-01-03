package presentation.right.zhong_salesman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import businesslogic.billsbl.TransArrivalBillServer.TransArrivalBillServer;
import businesslogic.transportbl.tranStaff.Trans_TransArrivalServerImpl;
import businesslogicservice.transportblservice.tranStaff.Trans_TransArrivalServer;
import po.bills.TransArrivalBill;
import presentation.right.Remind;
import presentation.right.RightAll;
import presentation.right.YearMonthDay;
import presentation.watcher.State;
import presentation.watcher.Watched;
import presentation.watcher.Watcher;

public class Zhong_arrival extends RightAll implements ActionListener {
	Trans_TransArrivalServer blServer;

	int frameWidth;
	int frameHeight;
	JTextField jtf[];
	JLabel remind[];
	JLabel time[];
	JComboBox<String>[] timeInput;
	JButton confirm;
	JButton cancel;
	JRadioButton state[];
	ButtonGroup bg;
	private List<Watcher> list;

	JPanel jp_wrong;
	String input_wrong;
	Remind remindThread;

	public Zhong_arrival(int frameWidth, int frameHeight) {
		blServer = new Trans_TransArrivalServerImpl();

		this.frameHeight = frameHeight;
		this.frameWidth = frameWidth;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		remind = new JLabel[6];
		for (int i = 0; i < 6; i++) {
			remind[i] = new JLabel();
		}
		jtf = new JTextField[4];
		for (int i = 0; i < 4; i++) {
			jtf[i] = new JTextField();
		}
		time = new JLabel[3];
		timeInput = new JComboBox[3];
		for (int i = 0; i < 3; i++) {
			time[i] = new JLabel();
		}
		YearMonthDay time1 = new YearMonthDay();
		timeInput[0] = time1.getCboYear();
		timeInput[1] = time1.getCboMonth();
		timeInput[2] = time1.getCboDay();

		confirm = new JButton("");// 确认
		cancel = new JButton("");// 取消

		state = new JRadioButton[3];
		state[0] = new JRadioButton("完好");
		state[1] = new JRadioButton("丢失");
		state[2] = new JRadioButton("破损");
		bg = new ButtonGroup();

		init();

		this.add(cancel);
		this.add(confirm);
		for (int i = 0; i < 4; i++) {
			this.add(jtf[i]);
		}
		for (int i = 0; i < 6; i++) {
			this.add(remind[i]);
		}
		for (int i = 0; i < 3; i++) {
			this.add(time[i]);
			this.add(timeInput[i]);
			this.add(state[i]);
		}
	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\到达单填写right.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth / 4 * 3, frameHeight, null);
	}

	private void init() {

		confirm.setBounds(frameWidth / 6, frameHeight * 8 / 10 + frameHeight
				/ 30, frameWidth / 9, frameHeight / 16);
		confirm.addActionListener(this);
		cancel.setBounds(frameWidth * 2 / 5 + frameWidth / 15, frameHeight * 8
				/ 10 + frameHeight / 30, frameWidth / 9, frameHeight / 16);
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

		remind[0].setText("中转中心编号");
		remind[1].setText("到达日期");
		remind[2].setText("货物编号");
		remind[3].setText("中转单编号");
		remind[4].setText("出发地");
		remind[5].setText("货物到达状态");
		for (int i = 0; i < 6; i++) {
			remind[i].setBounds(frameWidth / 10, frameHeight / 10 * (i + 1),
					frameWidth / 8, frameHeight / 20);
			remind[i].setFont(new Font("宋体", Font.BOLD, 15));
		}

		jtf[0].setBounds(frameWidth / 4, frameHeight / 10, frameWidth / 9,
				frameHeight / 20);
		jtf[1].setBounds(frameWidth / 4, frameHeight / 10 * 3, frameWidth / 9,
				frameHeight / 20);
		jtf[2].setBounds(frameWidth / 4, frameHeight / 10 * 4, frameWidth / 9,
				frameHeight / 20);
		jtf[3].setBounds(frameWidth / 4, frameHeight / 10 * 5, frameWidth / 9,
				frameHeight / 20);

		time[0].setText("年");
		time[1].setText("月");
		time[2].setText("日");
		for (int i = 0; i < 3; i++) {
			timeInput[i].setBounds(frameWidth / 4 + frameWidth / 50 * 6 * i,
					frameHeight / 5, frameWidth / 11, frameHeight / 20);
			time[i].setBounds(frameWidth / 3 + frameWidth / 50 * 6 * i
					+ frameWidth / 85, frameHeight / 5, frameWidth / 12,
					frameHeight / 20);
			time[i].setFont(new Font("宋体", Font.PLAIN, 15));
			timeInput[i].setFont(new Font("宋体", Font.PLAIN, 14));
		}

		for (int i = 0; i < 3; i++) {
			jtf[i].addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					if (!Character.isDigit(e.getKeyChar())) {
						e.consume();
					}
				}
			});
		}

		for (int i = 0; i < 3; i++) {
			state[i].setBounds(frameWidth / 4 + frameWidth / 10 * i,
					frameHeight / 5 * 3, frameWidth / 10, frameHeight / 20);
			state[i].setFont(new Font("宋体", Font.PLAIN, 15));
			state[i].setBorderPainted(false); // 不绘制边界搜索
			state[i].setContentAreaFilled(false); // 不填充所占的矩形区域
		}

		bg.add(state[0]);
		bg.add(state[1]);
		bg.add(state[2]);

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
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					jtf[2].requestFocus();
				}
			}
		});
		jtf[2].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					jtf[3].requestFocus();
				}
			}
		});
		jtf[3].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					jtf[2].requestFocus();
				}
			}
		});
		jtf[2].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
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

	private void showMessage() {
		if (remindThread != null) {
			remindThread.stop();
			this.remove(jp_wrong);
		}
		jp_wrong = new JPanel();

		input_wrong = "yes or not!";

		this.add(jp_wrong);
		remindThread = new Remind(jp_wrong, input_wrong);
		remindThread.start();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancel) {
			this.notifyWatchers(State.ZHONG_START);
		} else if (e.getSource() == confirm) {
			String tranStationID = jtf[0].getText();
			String GoodID = jtf[1].getText();

			String year = timeInput[0].getSelectedItem().toString();
			String month = timeInput[1].getSelectedItem().toString();
			String day = timeInput[2].getSelectedItem().toString();

			String date = year + "-" + month + "-" + day;

			String transOrderNum = jtf[2].getText();
			String departure = jtf[3].getText();

			String goodState = "完好";
			for (int i = 0; i < 3; i++) {
				if (state[i].isSelected()) {
					goodState = state[i].getText();
				}
			}

			TransArrivalBill bill = blServer.makeBill(tranStationID, GoodID,
					date, transOrderNum, departure, goodState);

			// 给我反馈，有没有成功@MA
			if (true) {
				this.notifyWatchers(State.ZHONG_START);
			} else {
				if (remindThread != null) {
					remindThread.stop();
					this.remove(jp_wrong);
				}
				jp_wrong = new JPanel();

				this.add(jp_wrong);
				remindThread = new Remind(jp_wrong, input_wrong);
				remindThread.start();
			}
		}

	}
}
