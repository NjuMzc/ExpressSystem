package presentation.right.admin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import businesslogic.systembl.SystemBlServerImpl;
import businesslogicservice.systemblservice.systemServer;
import po.Message;
import po.SystemUserPO;
import presentation.watcher.*;

public class adminManage extends JPanel implements Watched, ActionListener {
	systemServer blserver;
	ArrayList users;

	int frameWidth;
	int frameHeight;

	JTable table;
	Table_Model model;
	JScrollPane js;
	JLabel remind;
	JComboBox<String> type;
	JButton add;
	JButton change;
	JButton delete;
	JButton change_success;
	boolean isChanged = false;
	int row_Change = -1;

	private List<Watcher> list;

	public adminManage(int frameWidth, int frameHeight) {
		this.blserver = new SystemBlServerImpl();

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBackground(new Color(254, 67, 101));
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		model = new Table_Model(20);
		table = new JTable(model);
		js = new JScrollPane(table);
		remind = new JLabel("选择类型:");
		type = new JComboBox<String>();
		add = new JButton("增加 ");
		change = new JButton("修改");
		delete = new JButton("删除");
		change_success = new JButton("完成修改");

		init();

		this.add(js);
		this.add(remind);
		this.add(type);
		this.add(add);
		this.add(change);
		this.add(delete);
		this.add(change_success);

	}

	private void init() {

		table.setBackground(new Color(188, 199, 199));
		table.getTableHeader().setBackground(new Color(126, 205, 182));
		table.getTableHeader().setReorderingAllowed(false);
		js.setBounds(frameWidth / 10, frameHeight / 6, frameWidth / 2,
				frameHeight / 10 * 7);

		remind.setBounds(frameWidth / 10, frameHeight / 20, 100, 50);
		type.addItem("快递员");
		type.addItem("管理员");
		type.addItem("总经理");
		type.addItem("财务人员");
		type.addItem("仓库管理人员");
		type.addItem("营业厅业务员");
		type.setBounds(frameWidth / 4, frameHeight / 20, 100, 30);
		add.setBounds(frameWidth / 2, frameHeight / 20, 80, 30);
		add.addActionListener(this);
		change.setBounds(frameWidth / 8 * 3, frameHeight / 10 * 9, 80, 30);
		change.addActionListener(this);
		change_success.setBounds(frameWidth / 16 * 9, frameHeight / 10 * 9,
				100, 30);
		change_success.addActionListener(this);
		delete.setBounds(frameWidth / 16 * 3, frameHeight / 10 * 9, 80, 30);
		delete.addActionListener(this);

		// 初始化表内数据
		users = blserver.getAllUsers();
		Iterator it = users.iterator();

		while (it.hasNext()) {
			System.out.println("Running!");
			SystemUserPO user = (SystemUserPO) it.next();
			model.addRow(user.getUserName(), user.getID(), user.getKey(),
					user.getIdentity());
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

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {
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

			model.addRow(user.getUserName(), user.getID(), user.getKey(),
					user.getIdentity());

			table.updateUI();
		}

		// 修改数据的实现
		if (e.getSource() == change) {
			isChanged = true;
			int changeRow = table.getSelectedRow();
			if (changeRow != -1 && changeRow < model.getRowCount()) {
				this.row_Change = changeRow;
				model.setValueAt("***", changeRow, 0);
				model.setValueAt("***", changeRow, 2);
				model.getChanged(changeRow);
			}
		}

		if (e.getSource() == change_success && isChanged) {
			isChanged = false;
			model.getChanged(-2);
			if (this.row_Change != -1) {
				Message message = new Message();
				message.addInform((String) model.getValueAt(this.row_Change, 0));
				message.addInform((String) model.getValueAt(this.row_Change, 2));

				blserver.changeUser(
						(String) model.getValueAt(this.row_Change, 1), message);
			}
		}

		// 删除数据的实现
		if (e.getSource() == delete) {
			int rowDelete = table.getSelectedRow();
			if (rowDelete != -1 && rowDelete < model.getRowCount()) {

				// 逻辑层数据删除
				blserver.removeUser((String) model.getValueAt(rowDelete, 1));
				model.removeRow(rowDelete);
			}
			table.updateUI();

		}

	}

	public void removeData(int row) {
		model.removeRow(row);
		table.updateUI();
	}

	// 内部类
	class Table_Model extends AbstractTableModel {

		private int rowChange = -2;

		private Vector content = null;

		private String[] title_name = { "姓名", "账号", "密码", "职位" };

		public Table_Model(int count) {
			content = new Vector(count);
		}

		public void addRow(String name, String account, String password,
				String work) {
			Vector v = new Vector(4);
			v.add(0, name);
			v.add(1, account);
			v.add(2, password);
			v.add(3, work);
			content.add(v);
		}

		public void removeRow(int row) {
			content.remove(row);
		}

		public void getChanged(int row) {
			this.rowChange = row;
		}

		public boolean isCellEditable(int rowIndex, int columnIndex) {
			if (rowIndex == rowChange && (columnIndex == 0 || columnIndex == 2)) {
				return true;
			}
			return false;
		}

		public void setValueAt(Object value, int row, int col) {
			((Vector) content.get(row)).remove(col);
			((Vector) content.get(row)).add(col, value);
			this.fireTableCellUpdated(row, col);
		}

		public String getColumnName(int col) {
			return title_name[col];
		}

		@Override
		public int getColumnCount() {
			return title_name.length;
		}

		@Override
		public int getRowCount() {
			return content.size();
		}

		@Override
		public Object getValueAt(int row, int col) {
			return ((Vector) content.get(row)).get(col);
		}

		public Class getColumnClass(int col) {
			return getValueAt(0, col).getClass();
		}

	}
}