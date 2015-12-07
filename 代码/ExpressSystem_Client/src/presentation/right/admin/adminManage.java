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

	JPanel changepanel;
	JTextField changejtf[];
	JLabel changelable[];
	JButton changeover;

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

		model.addColumn("姓名");
		model.addColumn("账号");
		model.addColumn("密码");
		model.addColumn("职位");

		initModel();

	}

	private void initModel() {
		
        
	    users=blserver.getAllUsers();
	    Iterator<SystemUserPO> userList=users.iterator();
	    
	    while(userList.hasNext()){
	    	SystemUserPO user=userList.next();
	    	Vector<String> vec = new Vector<>();
	    	
	    	vec.add(user.getUserName());
	    	vec.add(user.getID());
	    	vec.add(user.getKey());
	    	vec.add(user.getIdentity());
	    	
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

	private void addChangePanel(Vector<String> vec) {
		changepanel = new JPanel();
		changepanel.setLayout(null);
		changepanel.setBounds(0, frameHeight / 30 * 23, frameWidth / 4 * 3,
				frameHeight / 10);
		changelable = new JLabel[4];
		changejtf = new JTextField[4];
		for (int i = 0; i < 4; i++) {
			changelable[i] = new JLabel();
			changejtf[i] = new JTextField();
		}
		changeover = new JButton("√");
		changelable[0].setText("姓名");
		changelable[1].setText("账号");
		changelable[2].setText("密码");
		changelable[3].setText("职位");

		for (int i = 0; i < 4; i++) {
			changelable[i].setBounds(frameWidth / 6 * i, 0, frameWidth / 6,
					frameHeight / 20);
			changejtf[i].setBounds(frameWidth / 6 * i, frameHeight / 20,
					frameWidth / 6, frameHeight / 20);

			changejtf[i].setText(vec.get(i));

			changepanel.add(changelable[i]);
			changepanel.add(changejtf[i]);
		}
		changejtf[1].setEditable(false);
		changejtf[3].setEditable(false);
		changeover.setBounds(frameWidth / 3 * 2, frameHeight / 20,
				frameWidth / 20, frameHeight / 20);
		changeover.addActionListener(this);

		changepanel.add(changeover);
		this.add(changepanel);
		this.repaint();
	}

	private void addAddPanel() {
		addpanel = new JPanel();
		addpanel.setLayout(null);
		addpanel.setBounds(0, frameHeight / 30 * 23, frameWidth / 4 * 3,
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
			if(i!=1&&i!=3){
			addlable[i].setBounds(frameWidth / 6 * i, 0, frameWidth / 6,
					frameHeight / 20);
			addjtf[i].setBounds(frameWidth / 6 * i, frameHeight / 20,
					frameWidth / 6, frameHeight / 20);

			addpanel.add(addlable[i]);
			addpanel.add(addjtf[i]);}
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
			if (changepanel != null) {
				this.remove(changepanel);
				this.repaint();
			}
			addAddPanel();


			table.updateUI();
		}

		// 修改数据的实现
		if (e.getSource() == change) {
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
				Vector<String> vec = new Vector<String>();

				vec.add((String) (table.getValueAt(row, 0)));
				vec.add((String) (table.getValueAt(row, 1)));
				vec.add((String) (table.getValueAt(row, 2)));
				vec.add((String) (table.getValueAt(row, 3)));

				addChangePanel(vec);
				model.removeRow(row);

			}
		}

		// 删除数据的实现
		if (e.getSource() == delete) {
			if (addpanel != null) {
				this.remove(addpanel);
				this.repaint();
			}
			int row = table.getSelectedRow();
			if (row >= 0) {
				String id=table.getValueAt(row, 1).toString();
				if(blserver.removeUser(id)){
					model.removeRow(row);
				}else{
				    System.out.println("Cant find user!");
				}
				
			}
			
		}

		// 增加
		if (e.getSource() == addover) {
			this.remove(addpanel);
			this.repaint();
			
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
			Message msg=new Message();
			msg.addInform(addjtf[0].getText());
			msg.addInform(addjtf[2].getText());
			blserver.changeUser(user.getID(), msg);

			Vector<String> vec = new Vector<>();
			vec.add(addjtf[0].getText());
			vec.add(user.getID());
			vec.add(addjtf[2].getText());
			vec.add(user.getIdentity());
			model.addRow(vec);
		}

		if (e.getSource() == changeover) {
			this.remove(changepanel);
			this.repaint();

			String newName=changejtf[0].getText();
			String newKey=changejtf[2].getText();
			
			Message msg=new Message();
			msg.addInform(newName);
			msg.addInform(newKey);
			
			blserver.changeUser(changejtf[1].getText(),msg);
			SystemUserPO user=blserver.inquire(changejtf[1].getText());
			
			Vector<String> vec = new Vector<>();
			vec.add(user.getUserName());
			vec.add(user.getID());
			vec.add(user.getKey());
			vec.add(user.getIdentity());
			
			model.addRow(vec);
		}

	}
}