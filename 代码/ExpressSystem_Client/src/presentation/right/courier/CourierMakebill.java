package presentation.right.courier;

import javax.swing.*;

import po.Message;
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
	JPanel senderInfor;
	JLabel[] input;
	JButton confirm;
	JButton cancel;
	JTextField[] inputText;
	JComboBox<String> type;
	JComboBox<String> type_decorate;
	private List<Watcher> list;

	public CourierMakebill(int frameWidth, int frameHeight) {
		this.blServer = new Trans_MakingOrderServerImpl();

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBackground(new Color(254, 67, 101));
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		senderInfor = new JPanel();
		senderInfor.setLayout(null);
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
			senderInfor.add(input[i]);
		}
		for (int i = 0; i < 16; i++) {
			senderInfor.add(inputText[i]);
		}
		senderInfor.add(type);
		senderInfor.add(type_decorate);

		this.add(senderInfor);
		this.add(confirm);
		this.add(cancel);

	}

	private void init() {
		senderInfor.setBounds(50, 50, frameWidth * 3 / 4 - 50,
				frameHeight - 150);

		int x = frameWidth * 3 / 4 - 20;
		int y = frameHeight - 200;
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
		input[19].setText("计费方式");
		input[20].setText("包装类型");
		for (int i = 0; i < 10; i++) {
			input[i].setBounds(0, 40 * i, 100, 20);
		}
		input[10].setBounds(x / 3, 40, 100, 20);
		input[11].setBounds(x / 3, 40 * 2, 100, 20);
		input[12].setBounds(x / 3, 40 * 4, 100, 20);
		input[13].setBounds(x / 3, 40 * 5, 100, 20);
		input[14].setBounds(x / 3, 40 * 7, 100, 20);
		input[15].setBounds(x / 3, 40 * 8, 100, 20);
		input[16].setBounds(x / 3, 40 * 9, 100, 20);
		input[17].setBounds(x / 3 * 2, 40 * 2, 100, 20);
		input[18].setBounds(x / 3 * 2, 40 * 5, 100, 20);
		input[19].setBounds(x / 3 * 2, 40 * 8, 100, 20);
		input[20].setBounds(x / 3 * 2, 40 * 9, 100, 20);

		confirm.setMargin(new Insets(0, 0, 0, 0));
		confirm.setBounds(150, frameHeight - 100, frameWidth / 12,
				frameWidth / 20);
		confirm.addActionListener(this);
		cancel.setMargin(new Insets(0, 0, 0, 0));
		cancel.setBounds(frameWidth * 3 / 4 - 225, frameHeight - 100,
				frameWidth / 12, frameWidth / 20);
		cancel.addActionListener(this);

		for (int i = 0; i < 2; i++) {
			inputText[i].setBounds(80, 40 * (i + 1), 100, 20);
		}
		for (int i = 2; i < 4; i++) {
			inputText[i].setBounds(80, 40 * (i + 2), 100, 20);
		}
		for (int i = 4; i < 7; i++) {
			inputText[i].setBounds(80, 40 * (i + 3), 100, 20);
		}
		inputText[7].setBounds(x / 3 + 70, 40, 100, 20);
		inputText[8].setBounds(x / 3 + 70, 40 * 2, 100, 20);
		inputText[9].setBounds(x / 3 + 70, 40 * 4, 100, 20);
		inputText[10].setBounds(x / 3 + 70, 40 * 5, 100, 20);
		inputText[11].setBounds(x / 3 + 70, 40 * 7, 100, 20);
		inputText[12].setBounds(x / 3 + 70, 40 * 8, 100, 20);
		inputText[13].setBounds(x / 3 + 70, 40 * 9, 100, 20);
		inputText[14].setBounds(x / 3 * 2 + 70, 40 * 2, 100, 20);
		inputText[15].setBounds(x / 3 * 2 + 70, 40 * 5, 100, 20);
		for (int i = 0; i < 16; i++) {
			inputText[i].setText(String.valueOf(i));
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

		type.setBounds(x / 3 * 2 + 70, 40 * 8, 100, 20);
		type_decorate.setBounds(x / 3 * 2 + 70, 40 * 9, 100, 20);

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

			Message message = new Message();
			for (int i = 0; i < 16; i++) {
				message.addInform(inputText[i].getText());
			}

			blServer.makeOrder(message);

			System.out.println("Added!");

			this.notifyWatchers(State.COURIERMAKEBILLAFTER);

		}

	}
}
