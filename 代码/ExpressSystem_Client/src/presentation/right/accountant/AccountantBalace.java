package presentation.right.accountant;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import businesslogic.paymentServer.SettleServerImpl;
import businesslogicservice.paymentblservice.SettleServer;
import po.bills.ChargeBill;
import presentation.right.ColorRenderer;
import presentation.right.RightAll;
import presentation.right.YearMonthDay;
import presentation.watcher.*;
import vo.paymentbl.SettleVO;

public class AccountantBalace extends RightAll implements ActionListener {
	SettleServer blServer;
	SettleVO result;
	double money;

	int frameWidth;
	int frameHeight;
	JLabel jl[];
	JButton confirm;
	JTextField inputNum;
	JLabel time[];
	JComboBox<String>[] timeInput;
	JLabel sum;
	JTextField jtfSum;
	private List<Watcher> list;
	JButton back;
	DefaultTableModel model;
	JTable table;
	JScrollPane js;
	DefaultTableCellRenderer dtc;

	public AccountantBalace(int frameWidth, int frameHeight) {
		blServer = new SettleServerImpl();

		this.frameHeight = frameHeight;
		this.frameWidth = frameWidth;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel[2];
		for (int i = 0; i < 2; i++) {
			jl[i] = new JLabel();
		}
		confirm = new JButton("");// 确认
		time = new JLabel[3];
		timeInput = new JComboBox[3];
		for (int i = 0; i < 3; i++) {
			time[i] = new JLabel();
		}
		YearMonthDay time1 = new YearMonthDay();
		timeInput[0] = time1.getCboYear();
		timeInput[1] = time1.getCboMonth();
		timeInput[2] = time1.getCboDay();

		model = new DefaultTableModel();
		table = new JTable(model) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		js = new JScrollPane(table);

		inputNum = new JTextField();
		sum = new JLabel("金额合计");
		sum.setFont(new Font("宋体", Font.BOLD, 16));
		jtfSum = new JTextField();
		back = new JButton("");// 返回

		dtc = new ColorRenderer();

		init();

		for (int i = 0; i < 2; i++) {
			this.add(jl[i]);
		}
		this.add(confirm);
		for (int i = 0; i < 3; i++) {
			this.add(time[i]);
			this.add(timeInput[i]);
		}
		this.add(inputNum);
	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\系统管理startRight.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth * 3 / 4, frameHeight, null);
	}

	private void init() {
		jl[0].setText("查询日期");
		jl[1].setText("营业厅编号");
		for (int i = 0; i < 2; i++) {
			jl[i].setBounds(frameWidth / 10, frameHeight / 11 * i + frameHeight
					/ 30, frameWidth / 10, frameHeight / 20);
			jl[i].setFont(new Font("宋体", Font.BOLD, 16));
		}
		confirm.setBounds(frameWidth / 12 * 5, frameHeight / 10 + frameHeight
				/ 40, frameWidth / 10, frameHeight / 19);

		ImageIcon icon2 = new ImageIcon("pictures//确认小.png");
		Image temp2 = icon2.getImage().getScaledInstance(icon2.getIconWidth(),
				icon2.getIconHeight(), icon2.getImage().SCALE_DEFAULT);
		icon2 = new ImageIcon(temp2);
		confirm.setIcon(icon2);

		confirm.addActionListener(this);
		time[0].setText("年");
		time[1].setText("月");
		time[2].setText("日");
		for (int i = 0; i < 3; i++) {
			timeInput[i].setBounds(frameWidth / 4 + frameWidth / 10 * i
					+ frameWidth / 60 * i, frameHeight / 30, frameWidth / 12
					+ frameWidth / 60, frameHeight / 20);
			time[i].setBounds(frameWidth / 3 + frameWidth / 10 * i + frameWidth
					/ 60 * (i + 1), frameHeight / 30, frameWidth / 12,
					frameHeight / 20);
			time[i].setFont(new Font("宋体", Font.PLAIN, 14));
			timeInput[i].setFont(new Font("宋体", Font.PLAIN, 13));
		}
		inputNum.setBounds(frameWidth / 4, frameHeight / 10 + frameHeight / 46,
				frameWidth / 10, frameHeight / 20);
		inputNum.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					confirmPressed();
				}
			}
		});
		sum.setBounds(frameWidth / 10, frameHeight / 5 * 4, frameWidth / 10,
				frameHeight / 20);
		jtfSum.setBounds(frameWidth / 4, frameHeight / 5 * 4, frameWidth / 10,
				frameHeight / 20);

		back.setBounds(frameWidth / 4, frameHeight / 10 * 9, frameWidth / 10,
				frameHeight / 19);
		inputNum.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});

		ImageIcon icon1 = new ImageIcon("pictures//返回小.png");
		Image temp1 = icon1.getImage().getScaledInstance(icon1.getIconWidth(),
				icon1.getIconHeight(), icon1.getImage().SCALE_DEFAULT);
		icon1 = new ImageIcon(temp1);
		back.setIcon(icon1);

		back.addActionListener(this);

		initTable();
		js.setBounds(0, frameHeight / 5, frameWidth / 4 * 3, frameHeight / 2);
	}

	private void initTable() {

		model.addColumn("日期");
		model.addColumn("金额");
		model.addColumn("快递员姓名");
		model.addColumn("快递员编号");
		model.addColumn("收款单编号");
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setFont(new Font("宋体", Font.PLAIN, 14));
		table.getColumnModel().getColumn(0).setCellRenderer(dtc);
		table.getColumnModel().getColumn(1).setCellRenderer(dtc);
		table.getColumnModel().getColumn(2).setCellRenderer(dtc);
		table.getColumnModel().getColumn(3).setCellRenderer(dtc);
		table.getColumnModel().getColumn(4).setCellRenderer(dtc);
	}

	private void initTableModel() {
		Iterator<ChargeBill> bills = result.getList();
		while (bills.hasNext()) {
			ChargeBill bill = bills.next();

			Vector<String> vec = new Vector<>();
			vec.add(bill.getDate());
			vec.add(String.valueOf(bill.getMoney()));
			vec.add(bill.getSenderName());
			vec.add(bill.getSenderNum());
			vec.add(bill.getId());

			money += bill.getMoney();
			model.addRow(vec);
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

	private void wrongShow() {
		// 错误处理
		final JLabel remindWrong = new JLabel();
		remindWrong.setBounds(frameWidth * 3 / 8, frameHeight * 17 / 20,
				frameWidth / 4, frameHeight / 20);
		remindWrong.setFont(new Font("宋体", Font.BOLD, 20));
		remindWrong.setForeground(Color.red);
		this.add(remindWrong);
		this.repaint();

		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				// 以下根据错误类型设置文字
				remindWrong.setText(result.getWrongMessage());
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

	private void confirmPressed() {
		String year = timeInput[0].getSelectedItem().toString();
		String month = timeInput[1].getSelectedItem().toString();
		String day = timeInput[2].getSelectedItem().toString();

		String date = year + "-" + month + "-" + day;

		String hallNum = inputNum.getText();

		result = blServer.Settle(date, hallNum);

		if (result.isWrong()) {
			// 錯誤信息處理
			wrongShow();
		} else {
			initTableModel();

			this.jtfSum.setText(String.valueOf(money));
			this.add(js);
			this.remove(confirm);
			this.add(jtfSum);
			this.add(sum);
			this.add(back);
			this.repaint();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == confirm) {
			confirmPressed();
		}

		if (e.getSource() == back) {
			this.notifyWatchers(State.ACCOUNTANTBALACE);
		}
	}
}
