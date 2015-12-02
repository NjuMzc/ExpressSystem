package presentation.right.manager;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import presentation.right.RightAll;
import presentation.watcher.*;

public class Manager_Manage extends RightAll {

	int frameWidth;
	int frameHeight;
	cityPanel city;
	String currentCity = null;

	private List<Watcher> list;

	public Manager_Manage(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBackground(new Color(254, 67, 101));
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		city = new cityPanel();
		this.add(city);
	}

	class cityPanel extends JPanel implements ActionListener {
		// 1
		JLabel city_remind;
		JButton nj;
		JButton bj;
		JButton sh;
		JButton gz;
		OrgPanel org = null;

		public cityPanel() {
			this.setLayout(null);
			this.setBounds(0, 0, frameWidth / 4, frameHeight);
			this.setBackground(Color.gray);

			city_remind = new JLabel("请选择城市");
			nj = new JButton("南京");
			bj = new JButton("北京");
			sh = new JButton("上海");
			gz = new JButton("广州");

			initCityPanel();

			this.add(city_remind);
			this.add(nj);
			this.add(bj);
			this.add(sh);
			this.add(gz);
		}

		private void initCityPanel() {
			city_remind.setBounds(0, 0, frameWidth / 4, frameHeight / 15);
			nj.setBounds(0, frameHeight / 3, frameWidth / 4, frameHeight / 15);
			nj.addActionListener(this);
			nj.setActionCommand("nj");
			bj.setBounds(0, frameHeight / 3 + frameHeight / 15, frameWidth / 4,
					frameHeight / 15);
			bj.addActionListener(this);
			bj.setActionCommand("bj");
			sh.setBounds(0, frameHeight / 3 + frameHeight / 15 * 2,
					frameWidth / 4, frameHeight / 15);
			sh.addActionListener(this);
			sh.setActionCommand("sh");
			gz.setBounds(0, frameHeight / 3 + frameHeight / 5, frameWidth / 4,
					frameHeight / 15);
			gz.addActionListener(this);
			gz.setActionCommand("gz");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == nj || e.getSource() == bj
					|| e.getSource() == sh || e.getSource() == gz) {
				currentCity = e.getActionCommand();
				if (org != null) {
					Manager_Manage.this.remove(org);
				}

				org = new OrgPanel();

				Manager_Manage.this.add(org);
				Manager_Manage.this.repaint();
			}
		}
	}

	class OrgPanel extends JPanel implements ActionListener {

		JTable orgTablel;
		DefaultTableModel orgTableModel;
		JScrollPane orgJs;
		JButton orgAdd;
		JButton orgDel;

		JTextField jtf;
		JLabel addLabel;
		JButton overButton;

		ConcretOrgPanel conOrgPanel;

		public OrgPanel() {

			this.setLayout(null);
			this.setBounds(frameWidth / 4, 0, frameWidth / 4, frameHeight);
			this.setBackground(Color.magenta);

			initOrgPanel();

			this.add(orgJs);
			this.add(orgAdd);
			this.add(orgDel);

		}

		private void initOrgPanel() {

			initOrgTable(currentCity);
			orgTablel = new JTable(orgTableModel);
			TableColumn firstColumn = orgTablel.getColumnModel().getColumn(0);
			firstColumn.setPreferredWidth(frameWidth / 6);
			orgTablel.getTableHeader().setReorderingAllowed(false);
			orgTablel.getTableHeader().setResizingAllowed(false);
			orgTablel.addMouseListener(new MouseListener() {

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
				public void mouseClicked(MouseEvent e) {
					String location = (String) ((JTable) e.getSource())
							.getValueAt(orgTablel.getSelectedRow(), 0);

					if (conOrgPanel != null) {
						Manager_Manage.this.remove(conOrgPanel);
					}
					conOrgPanel = new ConcretOrgPanel(location);
					Manager_Manage.this.add(conOrgPanel);
					Manager_Manage.this.repaint();
				}
			});
			orgTablel.setRowSelectionAllowed(true);
			orgTablel.setEditingRow(-1);
			orgJs = new JScrollPane(orgTablel);

			orgJs.setBounds(0, 0, frameWidth / 4, frameHeight / 2);

			orgAdd = new JButton("增加");
			orgAdd.setBounds(frameWidth / 16,
					frameHeight / 2 + frameHeight / 8, frameWidth / 8,
					frameHeight / 20);
			orgAdd.addActionListener(this);
			orgDel = new JButton("删除");
			orgDel.setBounds(frameWidth / 16, frameHeight / 10 * 9,
					frameWidth / 8, frameHeight / 20);
			orgDel.addActionListener(this);

		}

		// 机构的初始化
		private void initOrgTable(String city1) {
			orgTableModel = new DefaultTableModel();
			orgTableModel.addColumn("机构");
			orgTableModel.addColumn("编号");
			Vector<String> vec = new Vector<String>();
			if (city1.equals("nj")) {
				vec.add("南京大学仙林营业厅");
				vec.add("110");
				orgTableModel.addRow(vec);
			} else if (city1.equals("bj")) {
				vec.add("北京大学营业厅");
				vec.add("110");
				orgTableModel.addRow(vec);
			} else if (city1.equals("sh")) {
				vec.add("复旦大学营业厅");
				vec.add("110");
				orgTableModel.addRow(vec);
			} else if (city1.equals("gz")) {
				vec.add("中山大学营业厅");
				vec.add("110");
				orgTableModel.addRow(vec);
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == orgAdd) {
				addPanel();
			} else if (e.getSource() == orgDel) {

				int row = orgTablel.getSelectedRow();
				if (row >= 0) {
					orgTableModel.removeRow(row);
				}
				// 逻辑层删除

			}
		}

		private void addPanel() {
			if (jtf == null) {
				this.repaint();
				this.jtf = new JTextField();
				this.addLabel = new JLabel("请输入机构名称:");
				this.overButton = new JButton("完成");
				jtf.setBounds(frameWidth / 24, frameHeight / 2 + frameHeight
						/ 4, frameWidth / 6, frameHeight / 20);
				addLabel.setBounds(frameWidth / 24, frameHeight / 2
						+ frameHeight / 5, frameWidth / 6, frameHeight / 20);
				overButton.setBounds(frameWidth / 16, frameHeight / 20 * 17,
						frameWidth / 8, frameHeight / 20);
				overButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String input = jtf.getText();
						if (!input.equals("")) {

							// listModel.addElement(input);
							Vector vec = new Vector();
							vec.add(input);
							vec.add("110");
							orgTableModel.addRow(vec);

							removeAddPanel();
						}
					}
				});

				this.add(jtf);
				this.add(addLabel);
				this.add(overButton);
				this.repaint();
			}
		}

		private void removeAddPanel() {
			this.remove(jtf);
			this.remove(addLabel);
			this.remove(overButton);

			jtf = null;
			addLabel = null;
			overButton = null;
			this.repaint();
		}

	}

	class ConcretOrgPanel extends JPanel implements ActionListener {

		DefaultTableModel con_tableModel;
		JTable con_table;
		JScrollPane con_js;

		JTextField jtf;
		JLabel addLabel;
		JButton overButton;

		JButton con_orgAdd;
		JButton con_orgDel;

		String currentOrg;

		public ConcretOrgPanel(String currentOrg) {
			this.setLayout(null);
			this.setBounds(frameWidth / 2, 0, frameWidth / 4, frameHeight);
			this.setBackground(Color.lightGray);

			this.currentOrg = currentOrg;

			initConcretOrgPanel();

			this.add(con_js);
			this.add(con_orgAdd);
			this.add(con_orgDel);
		}

		private void initConcretOrgPanel() {
			con_tableModel = new DefaultTableModel();
			con_table = new JTable(con_tableModel);
			con_table.setRowSelectionAllowed(true);
			con_table.setEditingRow(-1);
			initTableModel();
			con_js = new JScrollPane(con_table);
			con_js.setBounds(0, 0, frameWidth / 4, frameHeight / 2);

			con_orgAdd = new JButton("增加");
			con_orgAdd.setBounds(frameWidth / 16, frameHeight / 2 + frameHeight
					/ 8, frameWidth / 8, frameHeight / 20);
			con_orgAdd.addActionListener(this);
			con_orgDel = new JButton("删除");
			con_orgDel.setBounds(frameWidth / 16, frameHeight / 10 * 9,
					frameWidth / 8, frameHeight / 20);
			con_orgDel.addActionListener(this);

		}

		// 人员的初始化
		private void initTableModel() {
			con_tableModel.addColumn("姓名");
			con_tableModel.addColumn("编号");

			// 根据currentOrg判断初始化信息，并加入
		}

		private void addPanel() {
			if (jtf == null) {
				this.repaint();
				this.jtf = new JTextField();
				this.addLabel = new JLabel("请输入员工编号:");
				this.overButton = new JButton("完成");
				jtf.setBounds(frameWidth / 24, frameHeight / 2 + frameHeight
						/ 4, frameWidth / 6, frameHeight / 20);
				addLabel.setBounds(frameWidth / 24, frameHeight / 2
						+ frameHeight / 5, frameWidth / 6, frameHeight / 20);
				overButton.setBounds(frameWidth / 16, frameHeight / 20 * 17,
						frameWidth / 8, frameHeight / 20);
				overButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String input = jtf.getText();
						Vector<String> vec = new Vector<String>();

						// 向量的第一维根据由input根据逻辑层得到员工姓名
						vec.add("110");
						vec.add(input);

						if (!input.equals("")) {
							con_tableModel.addRow(vec);
							removeAddPanel();
						}
					}
				});

				this.add(jtf);
				this.add(addLabel);
				this.add(overButton);
				this.repaint();
			}
		}

		private void removeAddPanel() {
			this.remove(jtf);
			this.remove(addLabel);
			this.remove(overButton);

			jtf = null;
			addLabel = null;
			overButton = null;
			this.repaint();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == con_orgAdd) {
				addPanel();
			} else if (e.getSource() == con_orgDel) {
				int row = con_table.getSelectedRow();
				if (row >= 0) {
					con_tableModel.removeRow(row);
				}
			}
		}
	}

	@Override
	public void addWatcher(Watcher watcher) {
		list.add(watcher);
	}

	@Override
	public void removeWatcehr(Watcher watcher) {
		list.remove(watcher);
	}

	@Override
	public void notifyWatchers(State state) {

		for (Watcher watcher : list) {
			watcher.update(state);
		}

	}

}
