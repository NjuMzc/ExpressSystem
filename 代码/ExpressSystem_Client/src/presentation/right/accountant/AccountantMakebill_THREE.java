package presentation.right.accountant;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import po.SystemUserPO;
import po.Institution.HallPO;
import po.Workers.HallStaffPO;
import po.Workers.StorageKeeperPO;
import po.Workers.TranStaffPO;
import presentation.right.RightAll;
import presentation.watcher.*;

public class AccountantMakebill_THREE extends RightAll implements
		ActionListener {
	int frameWidth;
	int frameHeight;
	private List<Watcher> list;

	JPanel jp1;
	JPanel jp2;
	JPanel jp3;
	JPanel jp4;

	DefaultTableModel model1;
	JTable table1;
	JScrollPane js1;

	// 机构
	DefaultTableModel model2;
	JTable table2;
	JScrollPane js2;
	JButton orgAdd;
	JButton orgDel;
	JTextField jtf;
	JLabel addLabel;
	JButton overButton;

	// 沿用总经理里的命名习惯，注意：以下代表人员
	DefaultTableModel con_tableModel;
	JTable con_table;
	JScrollPane con_js;
	JTextField jtf_people;
	JLabel addLabel_people;
	JButton overButton_people;
	JButton con_orgAdd;
	JButton con_orgDel;

	// 车辆的命名习惯与人员类似
	DefaultTableModel car_tableModel;
	JTable car_table;
	JScrollPane car_js;
	JTextField jtf_car;
	JLabel addLabel_car;
	JButton overButton_car;
	JButton car_orgAdd;
	JButton car_orgDel;

	public AccountantMakebill_THREE(int frameWidth, int frameHeight) {
		this.frameHeight = frameHeight;
		this.frameWidth = frameWidth;
		list = new ArrayList<Watcher>();
		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jp1 = new JPanel();
		model1 = new DefaultTableModel();
		table1 = new JTable(model1){ public boolean isCellEditable(int row, int column) { return false; }}; 
		js1 = new JScrollPane(table1);

		initJp1();

		jp1.add(js1);
		this.add(jp1);
	}

	private void initJp1() {
		jp1.setBounds(0, 0, frameWidth / 4, frameHeight);
		jp1.setLayout(null);
		initTable1();
		js1.setBounds(0, 0, frameWidth / 4, frameHeight / 2);
	}

	private void initTableModel1() {
		// 读取城市列表
		Vector<String> vec = new Vector<>();
		vec.add("南京");
		model1.addRow(vec);

	}

	private void initJp2() {
		jp2 = new JPanel();
		jp2.setBounds(frameWidth / 4, 0, frameWidth / 4, frameHeight);
		jp2.setLayout(null);

		model2 = new DefaultTableModel();
		table2 = new JTable(model2){ public boolean isCellEditable(int row, int column) { return false; }}; 
		js2 = new JScrollPane(table2);

		initTable2();

		js2.setBounds(0, 0, frameWidth / 4, frameHeight / 2);

		orgAdd = new JButton("增加");
		orgAdd.setBounds(frameWidth / 16, frameHeight / 2 + frameHeight / 8,
				frameWidth / 8, frameHeight / 20);
		orgAdd.addActionListener(this);
		orgDel = new JButton("删除");
		orgDel.setBounds(frameWidth / 16, frameHeight / 10 * 9, frameWidth / 8,
				frameHeight / 20);
		orgDel.addActionListener(this);

		jp2.add(js2);
		jp2.add(orgAdd);
		jp2.add(orgDel);
		this.add(jp2);
		this.repaint();
	}

	private void initJp3() {
		this.remove(jp1);
		this.remove(jp2);

		jp3 = new JPanel();
		jp3.setBounds(0, 0, frameWidth / 4, frameHeight);
		jp3.setLayout(null);

		con_tableModel = new DefaultTableModel();
		con_table = new JTable(con_tableModel){ public boolean isCellEditable(int row, int column) { return false; }}; 
		con_tableModel.addColumn("姓名");
		con_tableModel.addColumn("编号");
		con_table.getTableHeader().setReorderingAllowed(false);
		con_table.getTableHeader().setResizingAllowed(false);
		con_table.setFont(new Font("宋体", Font.PLAIN, 14));
		initTableModel();
		con_js = new JScrollPane(con_table);
		con_js.setBounds(0, 0, frameWidth / 4, frameHeight / 2);

		con_orgAdd = new JButton("增加");
		con_orgAdd.setBounds(frameWidth / 16,
				frameHeight / 2 + frameHeight / 8, frameWidth / 8,
				frameHeight / 20);
		con_orgAdd.addActionListener(this);
		con_orgDel = new JButton("删除");
		con_orgDel.setBounds(frameWidth / 16, frameHeight / 10 * 9,
				frameWidth / 8, frameHeight / 20);
		con_orgDel.addActionListener(this);

		jp3.add(con_js);
		jp3.add(con_orgAdd);
		jp3.add(con_orgDel);

		this.add(jp3);
		this.repaint();
	}

	private void initJp4() {
		jp4 = new JPanel();
		jp4.setBounds(frameWidth / 4, 0, frameWidth / 2, frameHeight);
		jp4.setLayout(null);

		car_tableModel = new DefaultTableModel();
		car_table = new JTable(car_tableModel){ public boolean isCellEditable(int row, int column) { return false; }}; 
		car_js = new JScrollPane(car_table);

		initCarModel();
		car_js.setBounds(0, 0, frameWidth / 2, frameHeight / 2);

		car_orgAdd = new JButton("增加");
		car_orgAdd.setBounds(frameWidth * 3 / 16, frameHeight / 2 + frameHeight
				/ 8, frameWidth / 8, frameHeight / 20);
		car_orgAdd.addActionListener(this);
		car_orgDel = new JButton("删除");
		car_orgDel.setBounds(frameWidth * 3 / 16, frameHeight / 10 * 9,
				frameWidth / 8, frameHeight / 20);
		car_orgDel.addActionListener(this);

		jp4.add(car_js);
		jp4.add(car_orgAdd);
		jp4.add(car_orgDel);
		this.add(jp4);
		this.repaint();
	}

	private void initTable1() {
		model1.addColumn("城市");
		table1.getTableHeader().setReorderingAllowed(false);
		table1.getTableHeader().setResizingAllowed(false);
		table1.setFont(new Font("宋体", Font.PLAIN, 14));
		table1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				initJp2();
			}
		});
		initTableModel1();
	}

	private void initTable2() {
		model2.addColumn("机构");
		model2.addColumn("编号");
		table2.getTableHeader().setReorderingAllowed(false);
		table2.getTableHeader().setResizingAllowed(false);
		table2.setFont(new Font("宋体", Font.PLAIN, 14));
		table2.addMouseListener(new MouseListener() {

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
				initJp3();

				// 如果是营业厅，使用下面的方法
				initJp4();
			}
		});
		initTableModel2();
	}

	private void initCarModel() {
		car_tableModel.addColumn("车辆代号");
		car_tableModel.addColumn("发动机号");
		car_tableModel.addColumn("车辆号");
		car_tableModel.addColumn("地盘号");
		car_tableModel.addColumn("购买时间");
		car_tableModel.addColumn("服役时间");
		car_tableModel.addColumn("车辆描述");
		car_table.getTableHeader().setReorderingAllowed(false);
		car_table.getTableHeader().setResizingAllowed(false);
		car_table.setFont(new Font("宋体", Font.PLAIN, 14));
		car_table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				addPanel_Car();
			}
		});
	}

	private void initTableModel() {
		Vector<String> vec = new Vector<>();

		vec.add("陈信宏");
		vec.add("t12131");

		con_tableModel.addRow(vec);

	}

	private void initTableModel2() {
		Vector<String> vec = new Vector<>();
		vec.add("南京仙林营业厅");
		vec.add("110");
		model2.addRow(vec);
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

		// 机构
		if (e.getSource() == orgAdd) {
			addPanel();
		} else if (e.getSource() == orgDel) {
			int row = table2.getSelectedRow();
			if (row >= 0) {
				model2.removeRow(row);
			}
		}

		// 人员
		if (e.getSource() == con_orgAdd) {
			addPanel_People();
		} else if (e.getSource() == con_orgDel) {
			int row = con_table.getSelectedRow();
			if (row >= 0) {
				con_tableModel.removeRow(row);
			}
		}
		
		//车辆
		if (e.getSource() == car_orgAdd) {
			addPanel_Car();
		} else if (e.getSource() == car_orgDel) {
			int row = con_table.getSelectedRow();
			if (row >= 0) {
				car_tableModel.removeRow(row);
			}
		}
	}

	private void addPanel_Car() {
		if (jtf_car == null) {
			this.repaint();
			this.jtf_car = new JTextField();
			this.addLabel_car = new JLabel("请输入员工编号:");
			this.overButton_car = new JButton("完成");
			jtf_car.setBounds(frameWidth / 6,
					frameHeight / 2 + frameHeight / 4, frameWidth / 6,
					frameHeight / 20);
			addLabel_car.setBounds(frameWidth / 6, frameHeight / 2
					+ frameHeight / 5, frameWidth / 6, frameHeight / 20);
			overButton_car.setBounds(frameWidth / 16 * 3,
					frameHeight / 20 * 17, frameWidth / 8, frameHeight / 20);
			overButton_car.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String input = jtf_car.getText();
					Vector<String> vec = new Vector<>();
					vec.add(input);
					vec.add("123");
					car_tableModel.addRow(vec);
					removeAddPanel_Car();

				}
			});

			jp4.add(jtf_car);
			jp4.add(addLabel_car);
			jp4.add(overButton_car);
			this.repaint();
		}
	}

	private void removeAddPanel_Car() {
		jp4.remove(jtf_car);
		jp4.remove(addLabel_car);
		jp4.remove(overButton_car);

		jtf_car = null;
		addLabel_car = null;
		overButton_car = null;
		this.repaint();
	}

	private void addPanel_People() {
		if (jtf_people == null) {
			this.repaint();
			this.jtf_people = new JTextField();
			this.addLabel_people = new JLabel("请输入员工编号:");
			this.overButton_people = new JButton("完成");
			jtf_people.setBounds(frameWidth / 24, frameHeight / 2 + frameHeight
					/ 4, frameWidth / 6, frameHeight / 20);
			addLabel_people.setBounds(frameWidth / 24, frameHeight / 2
					+ frameHeight / 5, frameWidth / 6, frameHeight / 20);
			overButton_people.setBounds(frameWidth / 16, frameHeight / 20 * 17,
					frameWidth / 8, frameHeight / 20);
			overButton_people.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String input = jtf_people.getText();
					Vector<String> vec = new Vector<>();
					vec.add(input);
					vec.add("123");
					con_tableModel.addRow(vec);
					removeAddPanel_People();

				}
			});

			jp3.add(jtf_people);
			jp3.add(addLabel_people);
			jp3.add(overButton_people);
			this.repaint();
		}
	}

	private void removeAddPanel_People() {
		jp3.remove(jtf_people);
		jp3.remove(addLabel_people);
		jp3.remove(overButton_people);

		jtf_people = null;
		addLabel_people = null;
		overButton_people = null;
		this.repaint();
	}

	private void addPanel() {
		if (jtf == null) {
			this.repaint();
			this.jtf = new JTextField();
			this.addLabel = new JLabel("请输入机构名称:");
			this.overButton = new JButton("完成");
			jtf.setBounds(frameWidth / 24, frameHeight / 2 + frameHeight / 4,
					frameWidth / 6, frameHeight / 20);
			addLabel.setBounds(frameWidth / 24, frameHeight / 2 + frameHeight
					/ 5, frameWidth / 6, frameHeight / 20);
			overButton.setBounds(frameWidth / 16, frameHeight / 20 * 17,
					frameWidth / 8, frameHeight / 20);
			overButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String input = jtf.getText();
					if (!input.equals("")) {

						Vector<String> vec = new Vector<>();
						vec.add(input);
						vec.add("222");
						model2.addRow(vec);

						removeAddPanel();
					}
				}
			});

			jp2.add(jtf);
			jp2.add(addLabel);
			jp2.add(overButton);
			this.repaint();
		}
	}

	private void removeAddPanel() {
		jp2.remove(jtf);
		jp2.remove(addLabel);
		jp2.remove(overButton);

		jtf = null;
		addLabel = null;
		overButton = null;
		jp2.repaint();
	}

}