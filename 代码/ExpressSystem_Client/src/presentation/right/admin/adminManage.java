package presentation.right.admin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import presentation.watcher.*;

public class adminManage extends JPanel implements Watched, ActionListener {
	int frameWidth;
	int frameHeight;

	JTable table;
	Table_Model model;
	JScrollPane js;
	JLabel remind;
	JComboBox type;
	JButton add;
	JButton change;
	JButton delete;

	private List<Watcher> list;

	public adminManage(int frameWidth, int frameHeight) {

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
		String[] items = { "快递员", "管理员", "总经理", "财务人员", "仓库管理人员", "营业厅业务员",
				"中转中心业务员" };
		type = new JComboBox(items);
		add = new JButton("增加 ");
		change = new JButton("修改");
		delete = new JButton("删除");

		init();

		this.add(js);
		this.add(remind);
		this.add(type);
		this.add(add);
		this.add(change);
		this.add(delete);

	}

	private void init() {

		table.getTableHeader().setReorderingAllowed(false);
		js.setBounds(frameWidth / 10, frameHeight / 6, frameWidth / 2,
				frameHeight / 10 * 7);

		remind.setBounds(frameWidth / 10, frameHeight / 20, 100, 50);
		type.setBounds(frameWidth / 3, frameHeight / 20, 110, 30);
		add.setBounds(frameWidth / 2, frameHeight / 20, 100, 30);
		add.addActionListener(this);
		change.setBounds(frameWidth / 2, frameHeight / 10, 100, 30);
		change.addActionListener(this);
		delete.setBounds(frameWidth / 3, frameHeight / 10, 100, 30);
		delete.addActionListener(this);
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
			String currentType = (String) type.getSelectedItem();

			// 各个类型人员的增加
			if (currentType.equals("快递员")) {

			} else if (currentType.equals("管理员")) {

			} else if (currentType.equals("总经理")) {

			} else if (currentType.equals("财务人员")) {

			} else if (currentType.equals("仓库管理人员")) {

			} else if (currentType.equals("营业厅业务员")) {

			} else if (currentType.equals("中转中心业务员")) {

			}

			model.addRow("nova", "1412500", "12345");
			table.updateUI();
		}

		// 修改数据的实现
		if (e.getSource() == change) {
			model.getChanged(table.getSelectedRow());
		}

		// 删除数据的实现
		if (e.getSource() == delete) {
			int rowDelete = table.getSelectedRow();
			System.out.println(rowDelete);
			if (rowDelete != -1&&rowDelete<model.getRowCount()) {
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

		private String[] title_name = { "姓名", "账号", "密码" };

		public Table_Model(int count) {
			content = new Vector(count);
		}

		public void addRow(String name, String account, String password) {
			Vector v = new Vector(3);
			v.add(0, name);
			v.add(1, account);
			v.add(2, password);
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