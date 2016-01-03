package presentation.right.courier;

import javax.swing.*;

import businesslogic.constantbl.CityServerImpl;
import businesslogic.transportbl.courier.Trans_MakingOrderServerImpl;
import businesslogicservice.constantblservice.CityServer;
import businesslogicservice.transportblservice.courier.Trans_MakingOrderServer;
import po.CityPO;
import po.Message;
import po.bills.OrderBill;
import presentation.Data;
import presentation.right.Remind;
import presentation.right.RightAll;
import presentation.watcher.*;
import vo.BillVO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
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
	JLabel bg2;
	private List<Watcher> list;
	JComboBox<String> city1;
	JComboBox<String> city2;

	JLabel kg;
	JLabel cm;
	JLabel yuan;

	JPanel jp_wrong;
	Remind remindThread;

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
		confirm = new JButton("");// 确认
		cancel = new JButton("");// 取消

		inputText = new JTextField[16];
		for (int i = 0; i < 16; i++) {
			inputText[i] = new JTextField();
		}
		String[] item = { "经济快递", "标准快递", "特快快递" };
		type = new JComboBox<String>(item);
		String[] items = { "纸箱", "木箱", "包装袋", "其他" };
		type_decorate = new JComboBox<String>(items);
		city1 = new JComboBox<String>();
		city2 = new JComboBox<String>();
		kg = new JLabel("kg");
		cm = new JLabel("cm^3");
		yuan = new JLabel("元");

		init();

		for (int i = 0; i < 21; i++) {
			if (i != 16)
				this.add(input[i]);
		}
		for (int i = 0; i < 16; i++) {
			if (i != 13)
				this.add(inputText[i]);
		}

		this.add(kg);
		this.add(cm);
		this.add(yuan);

		this.add(type);
		this.add(type_decorate);

		this.add(city1);
		this.add(city2);
		this.add(confirm);
		this.add(cancel);

	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\makebillafter.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth * 3 / 4, frameHeight, null);
	}

	private void init() {

		int x = frameWidth / 4;
		int y = frameHeight / 15;

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

		initJCombobox();

		confirm.setBounds(frameWidth / 4 - frameWidth / 10, frameHeight / 10
				* 9 - height, width - frameWidth / 50, height + frameHeight
				/ 70);
		confirm.addActionListener(this);
		cancel.setBounds(frameWidth / 2, frameHeight / 10 * 9 - height, width
				- frameWidth / 50, height + frameHeight / 70);
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

		for (int i = 0; i < 2; i++) {
			inputText[i].setBounds(x / 3 + frameWidth / 25,
					(y + frameHeight / 100) * (i + 1) + frameHeight / 19,
					width, height);
		}
		for (int i = 2; i < 4; i++) {
			inputText[i].setBounds(x / 3 + frameWidth / 25,
					(y + frameHeight / 96) * (i + 2) + frameHeight / 31, width,
					height);
		}
		for (int i = 4; i < 6; i++) {
			inputText[i].setBounds(x / 3 + frameWidth / 25,
					(y + frameHeight / 95) * (i + 2) + frameHeight / 10, width,
					height);
		}
		city1.setBounds(x + frameWidth / 10 + frameWidth / 50,
				(y + frameHeight / 100) * 1 + frameHeight / 19, width / 4 * 3,
				height);
		city2.setBounds(x + frameWidth / 10 + frameWidth / 50,
				(y + frameHeight / 96) * 4 + frameHeight / 31, width / 4 * 3,
				height);
		inputText[6].setBounds(x / 3 + frameWidth / 25, (y + frameHeight / 95)
				* 8 - frameHeight / 70 + frameHeight / 10, width, height);
		inputText[7].setBounds(x + frameWidth / 10 + frameWidth / 50 + width
				/ 4 * 3, (y + frameHeight / 100) * 1 + frameHeight / 19, width,
				height);
		inputText[8].setBounds(x + frameWidth / 10 + frameWidth / 50,
				(y + frameHeight / 100) * 2 + frameHeight / 19, width, height);
		inputText[9].setBounds(x + frameWidth / 10 + frameWidth / 50 + width
				/ 4 * 3, (y + frameHeight / 96) * 4 + frameHeight / 31, width,
				height);
		inputText[10].setBounds(x + frameWidth / 10 + frameWidth / 50,
				(y + frameHeight / 96) * 5 + frameHeight / 31, width, height);
		inputText[11].setBounds(x + frameWidth / 10 + frameWidth / 50,
				(y + frameHeight / 95) * 6 + frameHeight / 10, width, height);
		inputText[12].setBounds(x + frameWidth / 10 + frameWidth / 50,
				(y + frameHeight / 95) * 7 + frameHeight / 10, width, height);
		inputText[13].setBounds(x + frameWidth / 10 + frameWidth / 50,
				(y + frameHeight / 95) * 8 + frameHeight / 10, width, height);
		inputText[14].setBounds(x * 2 + frameWidth / 17,
				(y + frameHeight / 100) * 2 + frameHeight / 19, width, height);
		inputText[15].setBounds(x * 2 + frameWidth / 17,
				(y + frameHeight / 100) * 5 + frameHeight / 31, width, height);

		kg.setBounds(x + frameWidth / 10 + frameWidth / 50 + width,
				(y + frameHeight / 95) * 6 + frameHeight / 10, height, height);
		cm.setBounds(x / 3 + frameWidth / 25 + width, (y + frameHeight / 95)
				* (5 + 2) + frameHeight / 10, height, height);
		yuan.setBounds(x / 3 + frameWidth / 25 + width, (y + frameHeight / 95)
				* (6 + 2) + frameHeight / 10, height, height);
		inputText[11].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (!((e.getKeyChar() == KeyEvent.VK_PERIOD) || Character
						.isDigit(e.getKeyChar()))) {
					e.consume();
				}
			}
		});
		inputText[5].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (!((e.getKeyChar() == KeyEvent.VK_PERIOD) || Character
						.isDigit(e.getKeyChar()))) {
					e.consume();
				}
			}
		});
		inputText[6].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {

				if (!((e.getKeyChar() == KeyEvent.VK_PERIOD) || Character
						.isDigit(e.getKeyChar()))) {
					e.consume();
				}
			}
		});
		inputText[4].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});

		Font f = new Font("宋体", Font.PLAIN, 13);
		for (int i = 0; i < 16; i++) {
			inputText[i].setFont(f);
			kg.setFont(f);
			cm.setFont(f);
			yuan.setFont(f);
		}

		inputText[8].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		inputText[10].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		inputText[14].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		inputText[15].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});

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

		type.setBounds(x * 2 + frameWidth / 11, (y + frameHeight / 95) * 6
				+ frameHeight / 10, width, height);
		type_decorate.setBounds(x * 2 + frameWidth / 11, (y + frameHeight / 95)
				* 7 + frameHeight / 10, width, height);
		type_decorate.setFont(new Font("宋体", Font.PLAIN, 13));
		type.setFont(new Font("宋体", Font.PLAIN, 13));

	}

	private void initJCombobox() {
		CityServer server = new CityServerImpl();

		Iterator<CityPO> it1 = server.getAll();

		while (it1.hasNext()) {
			CityPO city = it1.next();
			city1.addItem(city.getName());
			city2.addItem(city.getName());
		}
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
		orderFee = new JLabel("");// 快递费用
		orderNum = new JLabel("");// 快递编号
		orderTime = new JLabel("");// 预计到达时间
		bg2 = new JLabel();
		bg2.setIcon(new ImageIcon("pictures\\makebillafter.png"));
		jtf = new JTextField[3];
		for (int i = 0; i < 3; i++) {
			jtf[i] = new JTextField();
		}
		bg2.setBounds(0, 0, frameWidth / 4 * 3, frameHeight);
		orderNum.setBounds(0, frameHeight / 15 * 10, frameWidth / 10,
				frameHeight / 20);
		orderFee.setBounds(0, frameHeight / 15 * 11, frameWidth / 10,
				frameHeight / 20);
		orderTime.setBounds(0, frameHeight / 15 * 12, frameWidth / 10,
				frameHeight / 20);
		jtf[0].setBounds(frameWidth / 12 + frameWidth / 25 + frameWidth / 35,
				(frameHeight / 15 + frameHeight / 95) * 9 + frameHeight / 10
						- frameHeight / 35, frameWidth / 8 - frameWidth / 35,
				frameHeight / 20);
		jtf[1].setBounds(frameWidth / 4 + frameWidth / 10 + frameWidth / 30,
				(frameHeight / 15 + frameHeight / 95) * 9 + frameHeight / 10
						- frameHeight / 35, frameWidth / 8 - frameWidth / 35,
				frameHeight / 20);
		jtf[2].setBounds(frameWidth / 2 + frameWidth / 11 + frameWidth / 35,
				(frameHeight / 15 + frameHeight / 95) * 9 + frameHeight / 10
						- frameHeight / 35, frameWidth / 8 - frameWidth / 35,
				frameHeight / 20);

		this.add(orderFee);
		this.add(orderNum);
		this.add(orderTime);
		this.add(bg2);
		for (int i = 0; i < 3; i++) {
			this.add(jtf[i]);
		}
		for (int i = 0; i < 16; i++) {
			inputText[i].setEditable(false);
		}
		over = new JButton("");// 完成
		over.setBounds(frameWidth / 3, frameHeight / 10 * 9, frameWidth / 10,
				frameHeight / 18);
		ImageIcon icon3 = new ImageIcon("pictures//完成.png");
		Image temp3 = icon3.getImage().getScaledInstance(icon3.getIconWidth(),
				icon3.getIconHeight(), icon3.getImage().SCALE_DEFAULT);
		icon3 = new ImageIcon(temp3);
		over.setIcon(icon3);
		over.addActionListener(this);
		this.remove(confirm);
		this.remove(cancel);
		this.remove(bg2);
		this.add(over);
		this.repaint();
	}

	private void solveInfor() {
		Message message = new Message();
		for (int i = 0; i < 16; i++) {
			if (i != 13 && i != 7 && i != 9) {
				message.addInform(inputText[i].getText());
			} else if (i == 7) {
				String loc1 = city1.getSelectedItem().toString()
						+ inputText[7].getText();
				message.addInform(loc1);
			} else if (i == 9) {
				String loc2 = city2.getSelectedItem().toString()
						+ inputText[9].getText();
				message.addInform(loc2);
			} else {
				message.addInform("");
			}

		}
		message.addInform((String) type.getSelectedItem());
		message.addInform((String) type_decorate.getSelectedItem());

		BillVO result = blServer.makeOrder(message);

		if (!result.isWrong()) {
			jtf[0].setText(result.getId());
			jtf[1].setText(result.getFee());
			jtf[2].setText(result.getDate());
		} else {
			// 错误信息处理
			System.out.println(result.getWrongMessage());
		}
		for (int i = 0; i < 3; i++) {
			jtf[i].setEditable(false);
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
			System.out.println("cancel!!!");
			this.notifyWatchers(State.COURIERSTART);
		} else if (e.getSource() == confirm) {

			// save the data
			boolean isFull = true;
			for (int i = 0; i < 16; i++) {
				if (i != 13 && inputText[i].getText().equals("")) {
					isFull = false;
					break;
				}
			}

			if (isFull) {
				addOver();
				solveInfor();
			} else {
				showMessage("快递单未填写完整");
			}

		}

		if (e.getSource() == over) {
			this.notifyWatchers(State.COURIERMAKEBILL);
		}

	}
}
