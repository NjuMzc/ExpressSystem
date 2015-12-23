package presentation.right.accountant;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import businesslogic.billsbl.ChargeBillServer.ChargeBillServer;
import businesslogic.billsbl.PaymentBill.PaymentBillServer;
import businesslogic.paymentServer.GetRecordServerImpl;
import businesslogicservice.paymentblservice.GetRecord;
import po.bills.ChargeBill;
import po.bills.PaymentBill;
import presentation.ExportExcel;
import presentation.right.ColorRenderer;
import presentation.right.RightAll;
import presentation.right.YearMonthDay;
import presentation.watcher.State;
import presentation.watcher.Watched;
import presentation.watcher.Watcher;
import vo.paymentbl.RecordVO;

//制作报表
public class AccountantMakeSheet extends RightAll implements ActionListener {
	GetRecord blServer;
	RecordVO result;
	ChargeBillServer chargeServer;
	PaymentBillServer paymentServer;

	int frameWidth;
	int frameHeight;
	JPanel input;
	JLabel start;
	JLabel end;
	JComboBox<String>[] startbox;
	JComboBox<String>[] endbox;
	JLabel inmoney;
	JButton search;
	DefaultTableCellRenderer dtc;

	DefaultTableModel model;
	JTable table;
	JScrollPane js;

	JPanel addPanel;
	JTextArea jta;
	JButton export;

	ExportExcel excel;
	JFileChooser jfc;

	private List<Watcher> list;

	public AccountantMakeSheet(int frameWidth, int frameheight) {
		blServer = new GetRecordServerImpl();
		chargeServer = new ChargeBillServer();
		paymentServer = new PaymentBillServer();

		this.frameHeight = frameheight;
		this.frameWidth = frameWidth;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		input = new JPanel();
		start = new JLabel("开始时间");
		start.setFont(new Font("宋体", Font.PLAIN, 15));
		end = new JLabel("结束时间");
		end.setFont(new Font("宋体", Font.PLAIN, 15));
		startbox = new JComboBox[3];
		endbox = new JComboBox[3];

		model = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(model);
		js = new JScrollPane(table);
		search = new JButton("查询");
		dtc = new ColorRenderer();

		export = new JButton("导出报表");

		init();

		for (int i = 0; i < 3; i++) {
			input.add(startbox[i]);
		}
		for (int i = 0; i < 3; i++) {
			input.add(endbox[i]);
		}
		input.add(search);
		input.add(js);
		input.add(start);
		input.add(end);
		input.add(export);
		this.add(input);

	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\系统管理startRight.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth * 3 / 4, frameHeight, null);
	}

	private void init() {
		YearMonthDay time1 = new YearMonthDay();
		startbox[0] = time1.getCboYear();
		startbox[1] = time1.getCboMonth();
		startbox[2] = time1.getCboDay();
		YearMonthDay time2 = new YearMonthDay();
		endbox[0] = time2.getCboYear();
		endbox[1] = time2.getCboMonth();
		endbox[2] = time2.getCboDay();

		for (int i = 0; i < 3; i++) {
			startbox[i].setBounds(frameWidth / 12 * (i + 2), frameHeight / 20,
					frameWidth / 12, frameHeight / 20);
		}
		for (int i = 0; i < 3; i++) {
			endbox[i].setBounds(frameWidth / 12 * (i + 2), frameHeight / 10,
					frameWidth / 12, frameHeight / 20);
		}

		input.setLayout(null);
		input.setBounds(0, 0, frameWidth / 2, frameHeight);
		start.setBounds(frameWidth / 20, frameHeight / 20, frameWidth / 12,
				frameHeight / 20);
		end.setBounds(frameWidth / 20, frameHeight / 10, frameWidth / 12,
				frameHeight / 20);
		js.setBounds(0, frameHeight / 5, frameWidth / 2, frameHeight / 10 * 7);
		search.setBounds(frameWidth / 12 * 5, frameHeight / 10,
				frameWidth / 12, frameHeight / 20);
		search.addActionListener(this);

		export.setBounds(frameWidth / 20 * 3, frameHeight / 16 * 15,
				frameWidth / 10, frameHeight / 20);
		export.addActionListener(this);

		initTable();
	}

	private void initTable() {
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);

		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				addAddPanel();
			}
		});

		model.addColumn("编号");
		model.addColumn("日期");
		model.addColumn("类型");
		model.addColumn("单据号");
		table.getColumnModel().getColumn(0).setCellRenderer(dtc);
		table.getColumnModel().getColumn(1).setCellRenderer(dtc);
		table.getColumnModel().getColumn(2).setCellRenderer(dtc);
		table.getColumnModel().getColumn(3).setCellRenderer(dtc);

	}

	private void addAddPanel() {
		addPanel = new JPanel();
		jta = new JTextArea();
		addPanel.setLayout(null);
		addPanel.setBounds(frameWidth / 2, 0, frameWidth / 4, frameHeight);
		jta.setBounds(0, 0, frameWidth / 2, frameHeight / 4 * 3);

		int row = table.getSelectedRow();
		String type = model.getValueAt(row, 2).toString();
		String id = model.getValueAt(row, 3).toString();
		if (type.equals("收款单")) {
			ChargeBill bill = chargeServer.getBill(id);

			jta.append("收款单编号:" + bill.getId() + "\r\n");
			jta.append("收款金额:" + bill.getMoney() + "\r\n");
			jta.append("收款日期 :" + bill.getDate() + "\r\n");
			jta.append("收款快递员 :" + bill.getSenderName() + "\r\n");
			jta.append("托运订单号列表 :" + "\r\n");

			Iterator<String> it = bill.getOrderNumbers().iterator();
			while (it.hasNext()) {
				jta.append(it.next() + "\r\n");
			}
		} else if (type.equals("付款单")) {
			PaymentBill bill = paymentServer.getBill(id);

			jta.append("付款单编号:" + bill.getId() + "\r\n");
			jta.append("付款金额:" + bill.getMoney() + "\r\n");
			jta.append("付款日期 :" + bill.getDate() + "\r\n");
			jta.append("付款账号 :" + bill.getAccount() + "\r\n");
			jta.append("付款条目 :" + bill.getTiaoMu() + "\r\n");
			jta.append("付款备注 :" + bill.getBeiZhu() + "\r\n");

		}

		addPanel.add(jta);

		this.add(addPanel);
		this.repaint();

	}

	private void wrongShow() {
		// 错误处理
		final JLabel remindWrong = new JLabel();
		remindWrong.setBounds(frameWidth / 4, frameHeight * 19 / 20,
				frameWidth / 4, frameHeight / 20);
		remindWrong.setFont(new Font("宋体", Font.BOLD, 20));
		remindWrong.setForeground(Color.red);
		input.add(remindWrong);
		input.repaint();
		this.repaint();

		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				// 以下根据错误类型设置文字
				remindWrong.setText(result.getWrongMessage());
				remindWrong.setText("wrong");
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

	private void initTableModel() {

		Iterator<ChargeBill> charges = result.getCharges();
		Iterator<PaymentBill> payments = result.getPayments();
		int counter = 1;

		while (charges.hasNext()) {
			ChargeBill bill = charges.next();
			Vector<String> vec = new Vector<>();

			vec.add(String.valueOf(counter));
			vec.add(bill.getDate());
			vec.add("收款单");
			vec.add(bill.getId());

			counter++;

			model.addRow(vec);
		}

		while (payments.hasNext()) {
			PaymentBill bill = payments.next();
			Vector<String> vec = new Vector<>();

			vec.add(String.valueOf(counter));
			vec.add(bill.getDate());
			vec.add("付款单");
			vec.add(bill.getId());

			counter++;

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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == export) {
			// 导出报表
			jfc = new JFileChooser();
			jfc.showSaveDialog(this);
			jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

			String path = jfc.getCurrentDirectory().toString().trim();
			String name = jfc.getSelectedFile().getName();
			System.out.println("path:" + path);
			System.out.println("name:" + name);
			excel = new ExportExcel(table, path, name);
			excel.export();

		}

		if (e.getSource() == search) {
			String year = startbox[0].getSelectedItem().toString();
			String month = startbox[1].getSelectedItem().toString();
			String day = startbox[2].getSelectedItem().toString();

			String date1 = year + "-" + month + "-" + day;

			String year2 = endbox[0].getSelectedItem().toString();
			String month2 = endbox[1].getSelectedItem().toString();
			String day2 = endbox[2].getSelectedItem().toString();

			String date2 = year2 + "-" + month2 + "-" + day2;

			result = blServer.getRecord(date1, date2);

			if (result.isWrong()) {
				// 错误信息处理
				wrongShow();
			}

			else {
				initTableModel();
			}

		}

	}
}
