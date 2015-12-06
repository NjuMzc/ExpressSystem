package presentation.right.ying_salesman;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import presentation.right.RightAll;
import presentation.watcher.State;
import presentation.watcher.Watched;
import presentation.watcher.Watcher;

public class Ying_manageInfor extends RightAll implements ActionListener {

	int frameWidth;
	int frameHeight;
	JLabel remind;
	JComboBox<String> type;
	JButton manage;
	JPanel addpanel;

	private List<Watcher> list;

	public Ying_manageInfor(int frameWidth, int frameHeight) {
		this.frameHeight = frameHeight;
		this.frameWidth = frameWidth;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		manage = new JButton("确认");
		type = new JComboBox<String>();
		remind = new JLabel("请选择管理类型：");

		init();

		this.add(manage);
		this.add(type);
		this.add(remind);
	}

	private void init() {

		manage.setBounds(frameWidth / 2, frameHeight / 10, frameWidth / 10,
				frameHeight / 20);
		manage.addActionListener(this);
		type.addItem("司机");
		type.addItem("车辆");
		type.setBounds(frameWidth / 4, frameHeight / 10, frameWidth / 10,
				frameHeight / 20);
		remind.setBounds(frameWidth / 10, frameHeight / 10, frameWidth / 8,
				frameHeight / 20);
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
		if (e.getSource() == manage) {
			String selectedItem = (String) (type.getSelectedItem());

			if (addpanel != null) {
				this.remove(addpanel);
			}

			// 司机管理
			if (selectedItem.equals("司机")) {
				System.out.println("driver");
				addpanel = new DriverPanel();
				this.add(addpanel);
				this.repaint();
			} else if (selectedItem.equals("车辆")) {

			}

		}

	}

	class DriverPanel extends JPanel implements ActionListener {

		DefaultTableModel tableModel;
		JTable table;
		JScrollPane js;
		JButton jb[];

		JPanel addpanel;
		JTextField addjtf[];
		JLabel addlable[];
		JButton addover;

		JPanel changepanel;
		JTextField changejtf[];
		JLabel changelable[];
		JButton changeover;

		public DriverPanel() {
			this.setBounds(0, frameHeight / 5, frameWidth / 4 * 3,
					frameHeight / 5 * 4);
			this.setLayout(null);
			this.setBackground(Color.gray);

			tableModel = new DefaultTableModel();
			table = new JTable(tableModel);
			js = new JScrollPane(table);

			jb = new JButton[3];
			for (int i = 0; i < 3; i++) {
				jb[i] = new JButton();
			}

			initThis();

			this.add(js);
			for (int i = 0; i < 3; i++) {
				this.add(jb[i]);
			}
		}

		private void initThis() {
			js.setBounds(0, 0, frameWidth / 4 * 3, frameHeight / 5 * 3);
			initThisTable();

			jb[0].setText("增加");
			jb[1].setText("删除");
			jb[2].setText("修改");
			for (int i = 0; i < 3; i++) {
				jb[i].setBounds(frameWidth / 8 + frameWidth / 5 * i,
						frameHeight / 4 * 3, frameWidth / 10, frameHeight / 20);
				jb[i].addActionListener(this);
			}
		}

		// 初始化table
		private void initThisTable() {
			tableModel.addColumn("姓名");
			tableModel.addColumn("编号");
			tableModel.addColumn("出生日期");
			tableModel.addColumn("身份证号");
			tableModel.addColumn("手机号");
			tableModel.addColumn("性别");
			tableModel.addColumn("行驶证限期");
			table.getColumnModel().getColumn(0)
					.setPreferredWidth(frameWidth / 30);
			table.getColumnModel().getColumn(1)
					.setPreferredWidth(frameWidth / 30);
			table.getColumnModel().getColumn(2)
					.setPreferredWidth(frameWidth / 30);
			table.getColumnModel().getColumn(3)
					.setPreferredWidth(frameWidth / 10);
			table.getColumnModel().getColumn(4)
					.setPreferredWidth(frameWidth / 30);
			table.getColumnModel().getColumn(5)
					.setPreferredWidth(frameWidth / 30);
			table.getTableHeader().setReorderingAllowed(false);
			table.getTableHeader().setResizingAllowed(false);

			initThisTableModel();

		}

		// 初始化model,@ma
		private void initThisTableModel() {
			Vector<String> vec = new Vector<>();
			vec.add("陈信宏");
			vec.add("141250079");
			vec.add("1993.12.12");
			vec.add("321302199512181111");
			vec.add("18761681111");
			vec.add("男");
			vec.add("2015.1.1—2020.12.31");

			tableModel.addRow(vec);
		}

		private void addAddPanel() {
			addpanel = new JPanel();
			addpanel.setLayout(null);
			addpanel.setBounds(0, frameHeight / 5 * 3, frameWidth / 4 * 3,
					frameHeight / 10);
			addlable = new JLabel[7];
			addjtf = new JTextField[7];
			for (int i = 0; i < 7; i++) {
				addlable[i] = new JLabel();
				addjtf[i] = new JTextField();
			}
			addover = new JButton("√");
			addlable[0].setText("姓名");
			addlable[1].setText("编号");
			addlable[2].setText("出生日期");
			addlable[3].setText("身份证号");
			addlable[4].setText("手机号");
			addlable[5].setText("性别");
			addlable[6].setText("行驶证期限");

			for (int i = 0; i < 7; i++) {
				addlable[i].setBounds(frameWidth / 10 * i, 0,
						frameWidth / 28 * 3, frameHeight / 20);
				addjtf[i].setBounds(frameWidth / 10 * i, frameHeight / 20,
						frameWidth / 28 * 3, frameHeight / 20);

				addpanel.add(addlable[i]);
				addpanel.add(addjtf[i]);
			}
			addover.setBounds(frameWidth / 10 * 7, frameHeight / 20,
					frameWidth / 20, frameHeight / 20);
			addover.addActionListener(this);

			addpanel.add(addover);
			this.add(addpanel);
			this.repaint();

		}

		private void addChangePanel(Vector<String> vec) {
			changepanel = new JPanel();
			changepanel.setLayout(null);
			changepanel.setBounds(0, frameHeight / 5 * 3, frameWidth / 4 * 3,
					frameHeight / 10);
			changelable = new JLabel[7];
			changejtf = new JTextField[7];
			for (int i = 0; i < 7; i++) {
				changelable[i] = new JLabel();
				changejtf[i] = new JTextField();
			}
			changeover = new JButton("√");
			changelable[0].setText("姓名");
			changelable[1].setText("编号");
			changelable[2].setText("出生日期");
			changelable[3].setText("身份证号");
			changelable[4].setText("手机号");
			changelable[5].setText("性别");
			changelable[6].setText("行驶证期限");

			for (int i = 0; i < 7; i++) {
				changelable[i].setBounds(frameWidth / 10 * i, 0,
						frameWidth / 28 * 3, frameHeight / 20);
				changejtf[i].setBounds(frameWidth / 10 * i, frameHeight / 20,
						frameWidth / 28 * 3, frameHeight / 20);

				changejtf[i].setText(vec.get(i));

				changepanel.add(changelable[i]);
				changepanel.add(changejtf[i]);
			}
			changeover.setBounds(frameWidth / 10 * 7, frameHeight / 20,
					frameWidth / 20, frameHeight / 20);
			changeover.addActionListener(this);

			changepanel.add(changeover);
			this.add(changepanel);
			this.repaint();
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == jb[0]) {
				// 增加
				addAddPanel();
			} else if (e.getSource() == jb[1]) {
				// 删
				int selectedRow = table.getSelectedRow();
				if (selectedRow >= 0) {
					tableModel.removeRow(selectedRow);
				}

			} else if (e.getSource() == jb[2]) {
				// 改
				int row = table.getSelectedRow();
				if (row >= 0) {
					tableModel.removeRow(row);

					Vector<String> vec = new Vector<String>();

					vec.add((String) (table.getValueAt(row, 0)));
					vec.add((String) (table.getValueAt(row, 1)));
					vec.add((String) (table.getValueAt(row, 2)));
					vec.add((String) (table.getValueAt(row, 3)));
					vec.add((String) (table.getValueAt(row, 4)));
					vec.add((String) (table.getValueAt(row, 5)));
					vec.add((String) (table.getValueAt(row, 6)));

					addChangePanel(vec);
				}

			}

			// 增加成功
			if (e.getSource() == addover) {
				this.remove(addpanel);
				this.repaint();

				Vector<String> vec = new Vector<>();
				for (int i = 0; i < 7; i++) {
					vec.add(addjtf[i].getText());
				}
				tableModel.addRow(vec);
			}

			if (e.getSource() == changeover) {
				this.remove(changepanel);
				this.repaint();

				Vector<String> vec = new Vector<>();
				for (int i = 0; i < 7; i++) {
					vec.add(changejtf[i].getText());
				}
				tableModel.addRow(vec);
			}

		}
	}
}