package presentation.right.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import businesslogic.systembl.SystemBlServerImpl;
import businesslogicservice.systemblservice.systemServer;
import po.Message;
import po.SystemUserPO;
import presentation.right.RightAll;
import presentation.watcher.*;

public class adminManage extends RightAll implements ActionListener {
	systemServer blserver;
	ArrayList users;

	int frameWidth;
	int frameHeight;

	DefaultTableModel model;
	JTable table;
	JScrollPane js;
	JLabel remind;
	JComboBox<String> type;
	JButton add;
	JButton change;
	JButton delete;

	JPanel addpanel;
	JTextField addjtf[];
	JLabel addlable[];
	JButton addover;

	private List<Watcher> list;

	public adminManage(int frameWidth, int frameHeight) {
		this.blserver = new SystemBlServerImpl();

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBackground(new Color(254, 67, 101));
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		model = new DefaultTableModel();
		table = new JTable(model);
		js = new JScrollPane(table);
		type = new JComboBox<String>();
		add = new JButton(" ");// 增加
		change = new JButton("");// 修改
		delete = new JButton("");// 删除

		init();

		this.add(js);
		this.add(type);
		this.add(add);
		this.add(change);
		this.add(delete);

	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\系统管理right.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth * 3 / 4, frameHeight, null);
	}

	private void init() {

		initTable();
		js.setBounds(0, frameHeight / 6, frameWidth / 4 * 3,
				frameHeight / 5 * 3);

		type.addItem("快递员");
		type.addItem("管理员");
		type.addItem("总经理");
		type.addItem("财务人员");
		type.addItem("仓库管理人员");
		type.addItem("营业厅业务员");
		type.addItem("中转中心业务员");
		type.setBounds(frameWidth * 29 / 128, frameHeight / 30, 150, 40);
		type.setFont(new Font("宋体", Font.PLAIN, 18));
		add.setBounds(frameWidth * 34 / 64, frameHeight / 33, 105, 45);
		add.addActionListener(this);
		change.setBounds(frameWidth / 64 * 21, frameHeight / 10 * 9, 105, 45);
		change.addActionListener(this);
		delete.setBounds(frameWidth / 128 * 10, frameHeight / 10 * 9, 105, 45);
		delete.addActionListener(this);

		delete.setContentAreaFilled(false);
		delete.setBorderPainted(false);
		change.setContentAreaFilled(false);
		change.setBorderPainted(false);
		add.setContentAreaFilled(false);
		add.setBorderPainted(false);

	}

	private void initTable() {
		table.setBackground(new Color(188, 199, 199));
		table.getTableHeader().setBackground(new Color(126, 205, 182));
		table.getTableHeader().setReorderingAllowed(false);
		table.setEnabled(false);
		model.addColumn("姓名");
		model.addColumn("账号");
		model.addColumn("密码");
		model.addColumn("职位");

		initModel();

	}

	private void initModel() {
		Vector<String> vec = new Vector<>();
		vec.add("刘兴");
		vec.add("123456789");
		vec.add("123434");
		vec.add("总经理");

		model.addRow(vec);
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

	private void addAddPanel() {
		addpanel = new JPanel();
		addpanel.setLayout(null);
		addpanel.setBounds(0, frameHeight / 6 * 5, frameWidth / 4 * 3,
				frameHeight / 10);
		addlable = new JLabel[4];
		addjtf = new JTextField[4];
		for (int i = 0; i < 4; i++) {
			addlable[i] = new JLabel();
			addjtf[i] = new JTextField();
		}
		addover = new JButton("√");
		addlable[0].setText("姓名");
		addlable[1].setText("账号");
		addlable[2].setText("密码");
		addlable[3].setText("职位");

		for (int i = 0; i < 4; i++) {
			addlable[i].setBounds(frameWidth / 10 * i, 0, frameWidth / 6,
					frameHeight / 20);
			addjtf[i].setBounds(frameWidth / 10 * i, frameHeight / 20,
					frameWidth / 6, frameHeight / 20);

			addpanel.add(addlable[i]);
			addpanel.add(addjtf[i]);
		}
		addover.setBounds(frameWidth / 3 * 2, frameHeight / 20,
				frameWidth / 20, frameHeight / 20);
		addover.addActionListener(this);

		addpanel.add(addover);
		this.add(addpanel);
		this.repaint();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {
			addAddPanel();

			SystemUserPO user = null;
			String currentType = (String) type.getSelectedItem();

			// 各个类型人员的增加
			if (currentType.equals("快递员")) {
				user = blserver.addUser("courier");

			} else if (currentType.equals("管理员")) {
				user = blserver.addUser("admin");

			} else if (currentType.equals("总经理")) {
				user = blserver.addUser("manager");

			} else if (currentType.equals("财务人员")) {
				user = blserver.addUser("account");

			} else if (currentType.equals("仓库管理人员")) {
				user = blserver.addUser("keeper");

			} else if (currentType.equals("营业厅业务员")) {
				user = blserver.addUser("hstaff");

			} else if (currentType.equals("中转中心业务员")) {
				user = blserver.addUser("tstaff");

			}

			table.updateUI();
		}

		// 修改数据的实现
		if (e.getSource() == change) {

		}

		// 删除数据的实现
		if (e.getSource() == delete) {
			int row = table.getSelectedRow();
			if (row >= 0) {
				model.removeRow(row);
			}
		}

	}
}