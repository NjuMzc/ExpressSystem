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
	JButton jb;

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
		jb = new JButton("增加");

		init();

		this.add(js);
		this.add(jb);
	}

	private void init() {

		table.setBounds(frameWidth / 10, frameHeight / 10, frameWidth / 2,
				frameHeight / 10 * 7);
		js.setBounds(frameWidth / 10, frameHeight / 10, frameWidth / 2,
				frameHeight / 10 * 7);
		jb.setBounds(frameWidth / 2, frameHeight / 10 * 9, 100, 30);
		jb.addActionListener(this);
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
        if(e.getSource()==jb){
        	model.addRow("nova", "1412500", "12345");
        	table.updateUI();
        }
	}

	// 内部类
	class Table_Model extends AbstractTableModel {

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

		public boolean isCellEditable(int rowIndex, int columnIndex) {
			if (columnIndex == 1) {
				return false;
			}
			return true;
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