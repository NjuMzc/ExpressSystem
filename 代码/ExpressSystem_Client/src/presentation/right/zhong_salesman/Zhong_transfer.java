package presentation.right.zhong_salesman;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import businesslogic.transportbl.tranStaff.Trans_DeliveryServerImpl;
import businesslogicservice.transportblservice.tranStaff.Trans_DeliveryServer;
import po.Message;
import po.bills.DeliveryBill;
import presentation.right.ColorRenderer;
import presentation.right.Remind;
import presentation.right.RightAll;
import presentation.right.YearMonthDay;
import presentation.watcher.State;
import presentation.watcher.Watcher;

public class Zhong_transfer extends RightAll implements ActionListener {
	Trans_DeliveryServer blServer;

	int frameWidth;
	int frameHeight;
	JLabel jl[];
	JTextField jtf[];
	JButton add;
	JButton confirm;
	JButton cancel;
	DefaultTableModel tableModel;
	JTable jtable;
	DefaultTableCellRenderer dtc;
	JScrollPane js;
	JLabel time[];
	JComboBox<String>[] timeInput;
	JComboBox<String> type;
	JButton over;
	private List<Watcher> list;

	JPanel jp_wrong;
	Remind remindThread;

	public Zhong_transfer(int frameWidth, int frameHeight) {
		blServer = new Trans_DeliveryServerImpl();

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel[9];
		for (int i = 0; i < 9; i++) {
			jl[i] = new JLabel();
		}
		add = new JButton("");
		confirm = new JButton("");
		cancel = new JButton("");
		jtf = new JTextField[7];
		for (int i = 0; i < 7; i++) {
			jtf[i] = new JTextField();
		}
		tableModel = new DefaultTableModel();
		jtable = new JTable(tableModel) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		js = new JScrollPane(jtable);
		time = new JLabel[3];
		timeInput = new JComboBox[3];
		for (int i = 0; i < 3; i++) {
			time[i] = new JLabel();
		}
		YearMonthDay time1 = new YearMonthDay();
		timeInput[0] = time1.getCboYear();
		timeInput[1] = time1.getCboMonth();
		timeInput[2] = time1.getCboDay();
		type = new JComboBox<String>();
		dtc = new ColorRenderer();

		init();

		for (int i = 0; i < 8; i++) {
			this.add(jl[i]);
		}
		this.add(add);
		this.add(confirm);
		this.add(cancel);
		for (int i = 0; i < 6; i++) {
			this.add(jtf[i]);
		}
		this.add(js);
		for (int i = 0; i < 3; i++) {
			this.add(timeInput[i]);
			this.add(time[i]);
		}
		this.add(type);
	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\装车单right.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth / 4 * 3, frameHeight, null);
	}

	private void init() {
		jl[0].setText("中转单编号");
		jl[1].setText("装车日期");
		jl[2].setText("出发地");
		jl[3].setText("到达地");
		jl[4].setText("监运员");
		jl[5].setText("托运单号");
		jl[6].setText("装运形式");
		jl[7].setText("交通编号");
		jl[8].setText("运费");
		for (int i = 0; i < 9; i++) {
			jl[i].setBounds(frameWidth / 10, frameHeight / 12 + frameHeight
					/ 12 * i, frameWidth / 8, frameHeight / 20);
			jl[i].setFont(new Font("宋体", Font.BOLD, 15));
		}

		jtf[0].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		jtf[4].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		jtf[5].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});

		add.setBounds(frameWidth / 3, frameHeight / 12 * 6, frameHeight / 19,
				frameHeight / 19);
		add.addActionListener(this);

		ImageIcon icon3 = new ImageIcon("pictures//添加.png");
		Image temp3 = icon3.getImage().getScaledInstance(add.getWidth(),
				add.getHeight(), icon3.getImage().SCALE_DEFAULT);
		icon3 = new ImageIcon(temp3);
		add.setIcon(icon3);
		add.addActionListener(this);

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

		jtf[0].setBounds(frameWidth / 4 - frameWidth / 30, frameHeight / 12,
				frameWidth / 9, frameHeight / 20);
		jtf[1].setBounds(frameWidth / 4 - frameWidth / 30, frameHeight / 12
				+ frameHeight / 12 * 2, frameWidth / 10, frameHeight / 20);
		jtf[2].setBounds(frameWidth / 4 - frameWidth / 30, frameHeight / 12
				+ frameHeight / 12 * 3, frameWidth / 10, frameHeight / 20);
		jtf[3].setBounds(frameWidth / 4 - frameWidth / 30, frameHeight / 12
				+ frameHeight / 12 * 4, frameWidth / 10, frameHeight / 20);
		jtf[4].setBounds(frameWidth / 4 - frameWidth / 30, frameHeight / 12
				+ frameHeight / 12 * 5, frameWidth / 10, frameHeight / 20);
		jtf[5].setBounds(frameWidth / 4 - frameWidth / 30, frameHeight / 12
				+ frameHeight / 12 * 7, frameWidth / 10, frameHeight / 20);
		jtf[6].setBounds(frameWidth / 4 - frameWidth / 30, frameHeight / 12
				+ frameHeight / 12 * 8, frameWidth / 10, frameHeight / 20);
		time[0].setText("年");
		time[1].setText("月");
		time[2].setText("日");
		for (int i = 0; i < 3; i++) {
			timeInput[i].setBounds(frameWidth / 4 - frameWidth / 30
					+ frameWidth / 50 * 6 * i, frameHeight / 6,
					frameWidth / 11, frameHeight / 20);
			time[i].setBounds(frameWidth / 3 - frameWidth / 30 + frameWidth
					/ 50 * 6 * i + frameWidth / 85, frameHeight / 6,
					frameWidth / 12, frameHeight / 20);
			time[i].setFont(new Font("宋体", Font.PLAIN, 15));
			timeInput[i].setFont(new Font("宋体", Font.PLAIN, 14));
		}
		type.addItem("飞机");
		type.addItem("火车");
		type.addItem("汽车");
		type.setBounds(frameWidth / 4 - frameWidth / 30, frameHeight / 12
				+ frameHeight / 12 * 6, frameWidth / 10, frameHeight / 20);

		initTable();

		js.setBounds(frameWidth / 2 - frameWidth / 6 + frameWidth / 14,
				frameHeight / 10 * 3 - frameHeight / 40, frameWidth / 4,
				frameHeight / 3 + frameHeight / 8);

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
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					jtf[4].requestFocus();
				}
			}
		});
		jtf[4].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					jtf[5].requestFocus();
				}
			}
		});
		jtf[5].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					jtf[4].requestFocus();
				}
			}
		});
		jtf[4].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
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

	private void initTable() {
		tableModel.addColumn("已有单号列表");
		jtable.getTableHeader().setReorderingAllowed(false);
		jtable.getTableHeader().setResizingAllowed(false);
		jtable.getColumnModel().getColumn(0).setCellRenderer(dtc);
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
			String kind = type.getSelectedItem().toString();

			String year = timeInput[0].getSelectedItem().toString();
			String month = timeInput[1].getSelectedItem().toString();
			String day = timeInput[2].getSelectedItem().toString();

			String date = year + "-" + month + "-" + day;

			String deliveryNum = jtf[0].getText();
			String transNum = jtf[6].getText();
			String departure = jtf[1].getText();
			String destination = jtf[2].getText();
			String supervisor = jtf[3].getText();

			Message message = new Message();
			message.addInform(kind);
			message.addInform(date);
			message.addInform(deliveryNum);
			message.addInform(transNum);
			message.addInform(departure);
			message.addInform(destination);
			message.addInform(supervisor);

			int row = tableModel.getRowCount();
			ArrayList<String> orderList = new ArrayList<String>();

			for (int i = 0; i < row; i++) {
				orderList.add(tableModel.getValueAt(i, 0).toString());
			}

			DeliveryBill bill = blServer
					.makeBill(message, orderList.iterator());

			// 给我反馈@ma
			if (bill!=null) {
				this.add(jl[8]);
				this.add(jtf[6]);
				this.remove(confirm);
				this.remove(cancel);
				over = new JButton("");// 完成
				over.setBounds(frameWidth / 72 * 23, frameHeight * 8 / 10
						+ frameHeight / 30, frameWidth / 9, frameHeight / 16);
				over.addActionListener(this);

				ImageIcon icon6 = new ImageIcon("pictures//完成.png");
				Image temp6 = icon6.getImage().getScaledInstance(
						icon6.getIconWidth(), icon6.getIconHeight(),
						icon6.getImage().SCALE_DEFAULT);
				icon6 = new ImageIcon(temp6);
				over.setIcon(icon6);

				this.add(over);
				this.repaint();

				jtf[5].setText(bill.getFee());
				for (int i = 0; i < 7; i++) {
					jtf[i].setEditable(false);
				}
			} else {
				showMessage("中转单未填写完整");
			}
		}

		if (e.getSource() == add) {
			// 添加单号列表
			String input = jtf[4].getText();
			if (!input.equals("")) {
				Vector<String> vec = new Vector<>();
				vec.add(input);
				tableModel.addRow(vec);
				jtf[4].setText("");
			}
		}

		if (e.getSource() == over) {

			this.notifyWatchers(State.ZHONG_START);

		}

	}
}
