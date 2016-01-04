package presentation.right.ying_salesman;

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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import businesslogic.informationbl.Inform_CarInformServerImpl;
import businesslogic.informationbl.Inform_DriverInformServerImpl;
import businesslogicservice.informationblservice.WorkerInform.Inform_CarInformServer;
import businesslogicservice.informationblservice.WorkerInform.Inform_DriverInformServer;
import po.Workers.CarPO;
import po.Workers.DriverPO;
import presentation.right.ColorRenderer;
import presentation.right.RightAll;
import presentation.watcher.State;
import presentation.watcher.Watched;
import presentation.watcher.Watcher;

public class Ying_manageInfor extends RightAll implements ActionListener {

	Inform_DriverInformServer driverServer;
	Inform_CarInformServer carServer;

	int frameWidth;
	int frameHeight;
	JLabel remind;
	JComboBox<String> type;
	JButton manage;
	JPanel addpanel;

	DefaultTableCellRenderer dtc;

	private List<Watcher> list;

	public Ying_manageInfor(int frameWidth, int frameHeight) {
		carServer = new Inform_CarInformServerImpl();
		driverServer = new Inform_DriverInformServerImpl();

		this.frameHeight = frameHeight;
		this.frameWidth = frameWidth;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		manage = new JButton("");// 确认
		type = new JComboBox<String>();
		remind = new JLabel("请选择管理类型：");

		dtc = new ColorRenderer();

		init();

		this.add(manage);
		this.add(type);
		this.add(remind);
	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\系统管理startRight.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth * 3 / 4, frameHeight, null);
	}

	private void init() {

		manage.setBounds(frameWidth / 2, frameHeight / 10, frameWidth / 10,
				frameHeight / 18);
		ImageIcon icon1 = new ImageIcon("pictures//确认小.png");
		Image temp1 = icon1.getImage().getScaledInstance(icon1.getIconWidth(),
				icon1.getIconHeight(), icon1.getImage().SCALE_DEFAULT);
		icon1 = new ImageIcon(temp1);
		manage.setIcon(icon1);

		manage.addActionListener(this);
		type.addItem("司机");
		type.addItem("车辆");
		type.setBounds(frameWidth / 4 + frameWidth / 16, frameHeight / 10,
				frameWidth / 9, frameHeight / 20);
		type.setFont(new Font("宋体", Font.PLAIN, 16));
		remind.setBounds(frameWidth / 9, frameHeight / 10, frameWidth / 4,
				frameHeight / 20);
		remind.setFont(new Font("宋体", Font.BOLD, 20));
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
				addpanel = new DriverPanel();
			} else if (selectedItem.equals("车辆")) {
				addpanel = new CarPanel();
			}

			this.add(addpanel);
			this.repaint();

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
			this.setBackground(new Color(124, 141, 117));

			tableModel = new DefaultTableModel();
			table = new JTable(tableModel) {
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
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

			jb[0].setText("");// 增加
			jb[1].setText("");// 删除
			jb[2].setText("");// 修改
			for (int i = 0; i < 3; i++) {
				jb[i].setBounds(frameWidth / 8 + frameWidth / 5 * i,
						frameHeight / 4 * 3 - frameHeight / 40,
						frameWidth / 10, frameHeight / 18);
				jb[i].addActionListener(this);
			}

			ImageIcon icon2 = new ImageIcon("pictures//增加黄.png");
			Image temp2 = icon2.getImage().getScaledInstance(
					icon2.getIconWidth(), icon2.getIconHeight(),
					icon2.getImage().SCALE_DEFAULT);
			icon2 = new ImageIcon(temp2);
			jb[0].setIcon(icon2);

			ImageIcon icon3 = new ImageIcon("pictures//删除.png");
			Image temp3 = icon3.getImage().getScaledInstance(
					icon3.getIconWidth(), icon3.getIconHeight(),
					icon3.getImage().SCALE_DEFAULT);
			icon3 = new ImageIcon(temp3);
			jb[1].setIcon(icon3);

			ImageIcon icon4 = new ImageIcon("pictures//修改.png");
			Image temp4 = icon4.getImage().getScaledInstance(
					icon4.getIconWidth(), icon4.getIconHeight(),
					icon4.getImage().SCALE_DEFAULT);
			icon4 = new ImageIcon(temp4);
			jb[2].setIcon(icon4);

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
			table.getColumnModel().getColumn(0).setCellRenderer(dtc);
			table.getColumnModel().getColumn(1).setCellRenderer(dtc);
			table.getColumnModel().getColumn(2).setCellRenderer(dtc);
			table.getColumnModel().getColumn(3).setCellRenderer(dtc);
			table.getColumnModel().getColumn(4).setCellRenderer(dtc);
			table.getColumnModel().getColumn(5).setCellRenderer(dtc);
			table.getColumnModel().getColumn(6).setCellRenderer(dtc);

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
			Iterator<DriverPO> driverList = driverServer.getAllDriver();
			while (driverList.hasNext()) {
				DriverPO driver = driverList.next();

				Vector<String> vec = new Vector<>();
				vec.add(driver.getName());
				vec.add(driver.getId());
				vec.add(driver.getBirth());
				vec.add(driver.getShenFenZheng());
				vec.add(driver.getMobileNum());
				vec.add(driver.getSex());
				vec.add(driver.getPortTime());

				tableModel.addRow(vec);
			}

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
			addover = new JButton("");//√
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
			
			ImageIcon icon4 = new ImageIcon("pictures//勾.png");
			Image temp4 = icon4.getImage().getScaledInstance(addover.getWidth(),
				addover.getHeight(), icon4.getImage().SCALE_DEFAULT);
			icon4 = new ImageIcon(temp4);
			addover.setIcon(icon4);
			
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
			changeover = new JButton("");//√
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
			ImageIcon icon4 = new ImageIcon("pictures//勾.png");
			Image temp4 = icon4.getImage().getScaledInstance(changeover.getWidth(),
					changeover.getHeight(), icon4.getImage().SCALE_DEFAULT);
			icon4 = new ImageIcon(temp4);
			changeover.setIcon(icon4);
			
			changeover.addActionListener(this);

			changepanel.add(changeover);
			this.add(changepanel);
			this.repaint();
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == jb[0]) {

				// 123
				for (int i = 0; i < 3; i++) {
					this.remove(jb[i]);
				}

				if (changepanel != null) {
					this.remove(changepanel);
					this.repaint();
				}

				// 增加
				addAddPanel();
			} else if (e.getSource() == jb[1]) {
				if (addpanel != null) {
					this.remove(addpanel);
					this.repaint();
				}

				// 删
				int selectedRow = table.getSelectedRow();
				if (selectedRow >= 0) {
					String id = (String) table.getValueAt(selectedRow, 1);
					if (driverServer.removeDriver(id))
						tableModel.removeRow(selectedRow);
				}

			} else if (e.getSource() == jb[2]) {
				 
				if (addpanel != null) {
					this.remove(addpanel);
					this.repaint();
				}
				if (changepanel != null) {
					this.remove(changepanel);
					this.repaint();
				}

				// 改
				int row = table.getSelectedRow();
				if (row >= 0) {
					//123
					for (int i = 0; i < 3; i++) {
						this.remove(jb[i]);
					}
					
					Vector<String> vec = new Vector<String>();

					vec.add((String) (table.getValueAt(row, 0)));
					vec.add((String) (table.getValueAt(row, 1)));
					vec.add((String) (table.getValueAt(row, 2)));
					vec.add((String) (table.getValueAt(row, 3)));
					vec.add((String) (table.getValueAt(row, 4)));
					vec.add((String) (table.getValueAt(row, 5)));
					vec.add((String) (table.getValueAt(row, 6)));

					addChangePanel(vec);
					tableModel.removeRow(row);

				}

			}

			// 增加成功
			if (e.getSource() == addover) {
				for (int i = 0; i < 3; i++) {
					this.add(jb[i]);
				}
				this.remove(addpanel);
				this.repaint();

				DriverPO driver = driverServer.addDriver(addjtf[0].getText(),
						addjtf[2].getText(), addjtf[3].getText(),
						addjtf[4].getText(), addjtf[5].getText(),
						addjtf[6].getText());

				Vector<String> vec = new Vector<>();
				for (int i = 0; i < 7; i++) {
					if (i == 1) {
						vec.add(driver.getId());
					} else {
						vec.add(addjtf[i].getText());
					}

				}

				tableModel.addRow(vec);
			}

			if (e.getSource() == changeover) {
				for (int i = 0; i < 3; i++) {
					this.add(jb[i]);
				}
				this.remove(changepanel);
				this.repaint();

				Boolean OK = driverServer.updateDriver(changejtf[1].getText(),
						changejtf[0].getText(), changejtf[2].getText(),
						changejtf[3].getText(), changejtf[4].getText(),
						changejtf[5].getText(), changejtf[6].getText());

				Vector<String> vec = new Vector<>();
				for (int i = 0; i < 7; i++) {
					vec.add(changejtf[i].getText());
				}
				tableModel.addRow(vec);
			}

		}
	}

	class CarPanel extends JPanel implements ActionListener {

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

		public CarPanel() {
			this.setBounds(0, frameHeight / 5, frameWidth / 4 * 3,
					frameHeight / 5 * 4);
			this.setLayout(null);
			this.setBackground(Color.gray);

			tableModel = new DefaultTableModel();
			table = new JTable(tableModel) {
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
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

			jb[0].setText("");// 增加
			jb[1].setText("");// 删除
			jb[2].setText("");// 修改
			for (int i = 0; i < 3; i++) {
				jb[i].setBounds(frameWidth / 8 + frameWidth / 5 * i,
						frameHeight / 4 * 3 - frameHeight / 40,
						frameWidth / 10, frameHeight / 18);
				jb[i].addActionListener(this);
			}

			ImageIcon icon2 = new ImageIcon("pictures//增加黄.png");
			Image temp2 = icon2.getImage().getScaledInstance(
					icon2.getIconWidth(), icon2.getIconHeight(),
					icon2.getImage().SCALE_DEFAULT);
			icon2 = new ImageIcon(temp2);
			jb[0].setIcon(icon2);

			ImageIcon icon3 = new ImageIcon("pictures//删除.png");
			Image temp3 = icon3.getImage().getScaledInstance(
					icon3.getIconWidth(), icon3.getIconHeight(),
					icon3.getImage().SCALE_DEFAULT);
			icon3 = new ImageIcon(temp3);
			jb[1].setIcon(icon3);

			ImageIcon icon4 = new ImageIcon("pictures//修改.png");
			Image temp4 = icon4.getImage().getScaledInstance(
					icon4.getIconWidth(), icon4.getIconHeight(),
					icon4.getImage().SCALE_DEFAULT);
			icon4 = new ImageIcon(temp4);
			jb[2].setIcon(icon4);
		}

		// 初始化table
		private void initThisTable() {
			tableModel.addColumn("车辆代号");
			tableModel.addColumn("发动机号");
			tableModel.addColumn("车辆号");
			tableModel.addColumn("底盘号");
			tableModel.addColumn("购买时间");
			tableModel.addColumn("服役时间");
			tableModel.addColumn("车辆描述 ");
//			table.getColumnModel().getColumn(0)
//					.setPreferredWidth(frameWidth / 30);
//			table.getColumnModel().getColumn(1)
//					.setPreferredWidth(frameWidth / 30);
//			table.getColumnModel().getColumn(2)
//					.setPreferredWidth(frameWidth / 30);
//			table.getColumnModel().getColumn(3)
//					.setPreferredWidth(frameWidth / 10);
//			table.getColumnModel().getColumn(4)
//					.setPreferredWidth(frameWidth / 30);
//			table.getColumnModel().getColumn(5)
//					.setPreferredWidth(frameWidth / 30);
			table.getTableHeader().setReorderingAllowed(false);
			table.getTableHeader().setResizingAllowed(false);

			table.getColumnModel().getColumn(0).setCellRenderer(dtc);
			table.getColumnModel().getColumn(1).setCellRenderer(dtc);
			table.getColumnModel().getColumn(2).setCellRenderer(dtc);
			table.getColumnModel().getColumn(3).setCellRenderer(dtc);
			table.getColumnModel().getColumn(4).setCellRenderer(dtc);
			table.getColumnModel().getColumn(5).setCellRenderer(dtc);
			table.getColumnModel().getColumn(6).setCellRenderer(dtc);

			initThisTableModel();

		}

		// 初始化model,@ma
		private void initThisTableModel() {
			Iterator<CarPO> carList = carServer.getAllCar();
			while (carList.hasNext()) {
				CarPO car = carList.next();

				Vector<String> vec = new Vector<>();
				vec.add(car.getId());
				vec.add("未保存");
				vec.add(car.getChePai());
				vec.add("未保存");
				vec.add(car.getUsingTime());
				vec.add(car.getUsingTime());
				vec.add("未保存");

				tableModel.addRow(vec);
			}

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
			addover = new JButton("");//√
			addlable[0].setText("车辆代号");
			addlable[1].setText("发动机号");
			addlable[2].setText("车辆号");
			addlable[3].setText("底盘号");
			addlable[4].setText("购买时间");
			addlable[5].setText("服役时间");
			addlable[6].setText("车辆描述");

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
			
			ImageIcon icon4 = new ImageIcon("pictures//勾.png");
			Image temp4 = icon4.getImage().getScaledInstance(addover.getWidth(),
					addover.getHeight(), icon4.getImage().SCALE_DEFAULT);
			icon4 = new ImageIcon(temp4);
			addover.setIcon(icon4);
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
			changeover = new JButton("");//√
			changelable[0].setText("车辆代号");
			changelable[1].setText("发动机号");
			changelable[2].setText("车辆号");
			changelable[3].setText("底盘号");
			changelable[4].setText("购买时间");
			changelable[5].setText("服役时间");
			changelable[6].setText("车辆描述");

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
			
			ImageIcon icon4 = new ImageIcon("pictures//勾.png");
			Image temp4 = icon4.getImage().getScaledInstance(changeover.getWidth(),
					changeover.getHeight(), icon4.getImage().SCALE_DEFAULT);
			icon4 = new ImageIcon(temp4);
			changeover.setIcon(icon4);
			changeover.addActionListener(this);

			changepanel.add(changeover);
			this.add(changepanel);
			this.repaint();
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == jb[0]) {
				for(int i=0;i<3;i++){
					this.remove(jb[i]);
				}
				
				if (changepanel != null) {
					this.remove(changepanel);
					this.repaint();
				}

				// 增加
				addAddPanel();
			} else if (e.getSource() == jb[1]) {
				if (addpanel != null) {
					this.remove(addpanel);
					this.repaint();
				}

				// 删
				int selectedRow = table.getSelectedRow();
				if (selectedRow >= 0) {
					String id = (String) table.getValueAt(selectedRow, 0);
					if (carServer.removeCar(id))
						tableModel.removeRow(selectedRow);
				}

			} else if (e.getSource() == jb[2]) {
				 
				if (addpanel != null) {
					this.remove(addpanel);
					this.repaint();
				}
				if (changepanel != null) {
					this.remove(changepanel);
					this.repaint();
				}

				// 改
				int row = table.getSelectedRow();
				if (row >= 0) {
					for(int i=0;i<3;i++){
						this.remove(jb[i]);
					}
					Vector<String> vec = new Vector<String>();

					vec.add((String) (table.getValueAt(row, 0)));
					vec.add((String) (table.getValueAt(row, 1)));
					vec.add((String) (table.getValueAt(row, 2)));
					vec.add((String) (table.getValueAt(row, 3)));
					vec.add((String) (table.getValueAt(row, 4)));
					vec.add((String) (table.getValueAt(row, 5)));
					vec.add((String) (table.getValueAt(row, 6)));

					addChangePanel(vec);
					tableModel.removeRow(row);

				}

			}

			// 增加成功
			if (e.getSource() == addover) {
				for(int i=0;i<3;i++){
					this.add(jb[i]);
				}
				this.remove(addpanel);
				this.repaint();

				CarPO car = carServer.addCar(addjtf[2].getText(),
						addjtf[5].getText());

				Vector<String> vec = new Vector<>();
				for (int i = 0; i < 7; i++) {
					if (i == 0) {
						vec.add(car.getId());
					} else {
						vec.add(addjtf[i].getText());
					}

				}
				tableModel.addRow(vec);
			}

			if (e.getSource() == changeover) {
				for(int i=0;i<3;i++){
					this.add(jb[i]);
				}
				this.remove(changepanel);
				this.repaint();

				Boolean OK = carServer.updateCar(changejtf[0].getText(),
						changejtf[2].getText(), changejtf[5].getText());

				Vector<String> vec = new Vector<>();
				for (int i = 0; i < 7; i++) {
					vec.add(changejtf[i].getText());
				}
				tableModel.addRow(vec);
			}

		}
	}
}