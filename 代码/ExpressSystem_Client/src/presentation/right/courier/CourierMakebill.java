package presentation.right.courier;

import javax.swing.*;

import businesslogic.transportbl.courier.Trans_MakingOrderServerImpl;
import businesslogicservice.transportblservice.courier.Trans_MakingOrderServer;
import po.Message;
import po.bills.OrderBill;
import presentation.Data;
import presentation.right.RightAll;
import presentation.watcher.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class CourierMakebill extends RightAll implements ActionListener {
	Trans_MakingOrderServer blServer;

	int frameWidth;
	int frameHeight;
	// JPanel senderInfor;
	JLabel[] input;
	JButton confirm;
	JButton cancel;
	JTextField[] inputText;
	JComboBox<String> type;
	JComboBox<String> type_decorate;
	JLabel orderNum;
	JLabel orderFee;
	JLabel orderTime;
	JTextField jtf[];
	JButton over;
	private List<Watcher> list;

	public CourierMakebill(int frameWidth, int frameHeight) {
		this.blServer = new Trans_MakingOrderServerImpl();

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		input = new JLabel[21];
		for (int i = 0; i < 21; i++) {
			input[i] = new JLabel();
		}
		confirm = new JButton("确认");
		cancel = new JButton("取消");

		inputText = new JTextField[16];
		for (int i = 0; i < 16; i++) {
			inputText[i] = new JTextField();
		}
		String[] item = { "经济快递", "标准快递", "特快快递" };
		type = new JComboBox<String>(item);
		String[] items = { "纸箱", "木箱", "包装袋", "其他" };
		type_decorate = new JComboBox<String>(items);

		init();

		for (int i = 0; i < 21; i++) {
			if (i != 16)
				this.add(input[i]);
		}
		for (int i = 0; i < 16; i++) {
			if (i != 13)
				this.add(inputText[i]);
		}

		this.add(type);
		this.add(type_decorate);

		this.add(confirm);
		this.add(cancel);

	}

	private void init() {

		int x = frameWidth / 4;
		int y = frameHeight / 15;
		input[0].setText("寄件人信息");
		input[1].setText("姓名");
		input[2].setText("单位");
		input[3].setText("收件人信息");
		input[4].setText("姓名");
		input[5].setText("单位");
		input[6].setText("托运货物信息");
		input[7].setText("原件数");
		input[8].setText("尺寸");
		input[9].setText("包装费");
		input[10].setText("住址");
		input[11].setText("电话");
		input[12].setText("住址");
		input[13].setText("电话");
		input[14].setText("重量");
		input[15].setText("内件品名");
		input[16].setText("快递类型");
		input[17].setText("手机");
		input[18].setText("手机");
		input[19].setText("快递类型");
		input[20].setText("包装类型");
		for (int i = 0; i < 10; i++) {
			input[i].setBounds(0, frameHeight / 15 * i, frameWidth / 10,
					frameHeight / 20);
		}
		int width = frameWidth / 10;
		int height = frameHeight / 20;
		input[10].setBounds(x, y, width, height);
		input[11].setBounds(x, y * 2, width, height);
		input[12].setBounds(x, y * 4, width, height);
		input[13].setBounds(x, y * 5, width, height);
		input[14].setBounds(x, y * 7, width, height);
		input[15].setBounds(x, y * 8, width, height);
		input[16].setBounds(x, y * 9, width, height);
		input[17].setBounds(x * 2, y * 2, width, height);
		input[18].setBounds(x * 2, y * 5, width, height);
		input[19].setBounds(x * 2, y * 7, width, height);
		input[20].setBounds(x * 2, y * 8, width, height);

		confirm.setBounds(frameWidth / 4, frameHeight / 10 * 9, width, height);
		confirm.addActionListener(this);
		cancel.setBounds(frameWidth / 2, frameHeight / 10 * 9, width, height);
		cancel.addActionListener(this);

		for (int i = 0; i < 2; i++) {
			inputText[i].setBounds(x / 3, y * (i + 1), width, height);
		}
		for (int i = 2; i < 4; i++) {
			inputText[i].setBounds(x / 3, y * (i + 2), width, height);
		}
		for (int i = 4; i < 7; i++) {
			inputText[i].setBounds(x / 3, y * (i + 3), width, height);
		}
		inputText[7].setBounds(x + frameWidth / 10, y, width, height);
		inputText[8].setBounds(x + frameWidth / 10, y * 2, width, height);
		inputText[9].setBounds(x + frameWidth / 10, y * 4, width, height);
		inputText[10].setBounds(x + frameWidth / 10, y * 5, width, height);
		inputText[11].setBounds(x + frameWidth / 10, y * 7, width, height);
		inputText[12].setBounds(x + frameWidth / 10, y * 8, width, height);
		inputText[13].setBounds(x + frameWidth / 10, y * 9, width, height);
		inputText[14].setBounds(x * 2 + frameWidth / 10, y * 2, width, height);
		inputText[15].setBounds(x * 2 + frameWidth / 10, y * 5, width, height);
		for (int i = 0; i < 16; i++) {
			inputText[i].setText("（必填）");
		}

		// 输入栏焦点转移
		inputText[0].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					inputText[1].requestFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					inputText[7].requestFocus();
				}
			}
		});
		inputText[1].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					inputText[2].requestFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					inputText[8].requestFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					inputText[0].requestFocus();
				}
			}
		});
		inputText[2].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					inputText[3].requestFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					inputText[9].requestFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					inputText[1].requestFocus();
				}
			}
		});
		inputText[3].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					inputText[4].requestFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					inputText[10].requestFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					inputText[2].requestFocus();
				}
			}
		});
		inputText[4].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					inputText[5].requestFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					inputText[11].requestFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					inputText[3].requestFocus();
				}
			}
		});
		inputText[5].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					inputText[6].requestFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					inputText[12].requestFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					inputText[4].requestFocus();
				}
			}
		});
		inputText[6].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					inputText[13].requestFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					inputText[5].requestFocus();
				}
			}
		});
		inputText[7].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					inputText[8].requestFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					inputText[0].requestFocus();
				}
			}
		});
		inputText[8].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					inputText[9].requestFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					inputText[14].requestFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					inputText[7].requestFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					inputText[1].requestFocus();
				}
			}
		});
		inputText[9].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					inputText[10].requestFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					inputText[8].requestFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					inputText[2].requestFocus();
				}
			}
		});
		inputText[10].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					inputText[11].requestFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					inputText[15].requestFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					inputText[9].requestFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					inputText[3].requestFocus();
				}
			}
		});
		inputText[11].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					inputText[12].requestFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					inputText[10].requestFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					inputText[4].requestFocus();
				}
			}
		});
		inputText[12].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					inputText[13].requestFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					inputText[11].requestFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					inputText[5].requestFocus();
				}
			}
		});
		inputText[13].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					inputText[12].requestFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					inputText[6].requestFocus();
				}
			}
		});
		inputText[14].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					inputText[15].requestFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					inputText[8].requestFocus();
				}
			}
		});
		inputText[15].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					inputText[14].requestFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					inputText[10].requestFocus();
				}
			}
		});

		type.setBounds(x * 2 + frameWidth / 10, y * 7, width, height);
		type_decorate.setBounds(x * 2 + frameWidth / 10, y * 8, width, height);

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

	private void addOver() {
		orderFee = new JLabel("快递费用");
		orderNum = new JLabel("快递编号");
		orderTime = new JLabel("预计到达时间");
		jtf = new JTextField[3];
		for (int i = 0; i < 3; i++) {
			jtf[i] = new JTextField();
		}

		orderNum.setBounds(0, frameHeight / 15 * 10, frameWidth / 10,
				frameHeight / 20);
		orderFee.setBounds(0, frameHeight / 15 * 11, frameWidth / 10,
				frameHeight / 20);
		orderTime.setBounds(0, frameHeight / 15 * 12, frameWidth / 10,
				frameHeight / 20);
		for (int i = 0; i < 3; i++) {
			jtf[i].setBounds(frameWidth / 12, frameHeight / 15 * (i + 10),
					frameWidth / 10, frameHeight / 20);
		}

		this.add(orderFee);
		this.add(orderNum);
		this.add(orderTime);
		for (int i = 0; i < 3; i++) {
			this.add(jtf[i]);
		}
		for (int i = 0; i < 16; i++) {
			inputText[i].setEditable(false);
		}
		over = new JButton("完成");
		over.setBounds(frameWidth / 12, frameHeight / 10 * 9, frameWidth / 10,
				frameHeight / 20);
		over.addActionListener(this);
		this.remove(confirm);
		this.remove(cancel);
		this.add(over);
		this.repaint();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancel) {
			System.out.println("cancel!!!");
			this.notifyWatchers(State.COURIERSTART);
		} else if (e.getSource() == confirm) {

			// save the data
			boolean isFull = true;
			for (int i = 0; i < 16; i++) {
				if (inputText[i].getText().equals("（必填）")) {
					isFull = false;
					break;
				}
			}

			addOver();

			Message message = new Message();
			for (int i = 0; i < 16; i++) {
				if (i != 13) {
					message.addInform(inputText[i].getText());
				} else {
					message.addInform("");
				}

			}
			message.addInform((String) type.getSelectedItem());
			message.addInform((String) type_decorate.getSelectedItem());

			OrderBill bill = blServer.makeOrder(message);

			jtf[0].setText(bill.getID());
			jtf[1].setText(bill.getCharge());
			jtf[2].setText(bill.getTime());

			for (int i = 0; i < 3; i++) {
				jtf[i].setEditable(false);
			}

		}

		if (e.getSource() == over) {
			this.notifyWatchers(State.COURIERMAKEBILL);
		}

	}
}
