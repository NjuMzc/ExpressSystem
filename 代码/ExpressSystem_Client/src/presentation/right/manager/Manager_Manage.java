package presentation.right.manager;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
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
import javax.swing.table.TableColumn;

import org.omg.CORBA.PUBLIC_MEMBER;

import businesslogicservice.informationblservice.InstitutionInform.Inform_HallInformServer;
import businesslogicservice.informationblservice.InstitutionInform.Inform_StorageInformServer;
import businesslogicservice.informationblservice.InstitutionInform.Inform_TranStationInformServer;
import po.SystemUserPO;
import po.Institution.HallPO;
import po.Institution.StoragePO;
import po.Institution.TranStationPO;
import po.Workers.HallStaffPO;
import po.Workers.StorageKeeperPO;
import po.Workers.TranStaffPO;
import presentation.right.RightAll;
import presentation.watcher.*;
import businesslogicservice.systemblservice.*;
import businesslogic.informationbl.Inform_HallInformServerImpl;
import businesslogic.informationbl.Inform_StorageInformServerImpl;
import businesslogic.informationbl.Inform_TranStationInformServerImpl;
import businesslogic.systembl.SystemBlServerImpl;

public class Manager_Manage extends RightAll {

	int frameWidth;
	int frameHeight;
	cityPanel city;
	String currentCity = null;
	String currentID=null;
	String currentOrg=null;

	private List<Watcher> list;

	Inform_TranStationInformServer tranServer;
	Inform_StorageInformServer storageServer;
	Inform_HallInformServer hallServer;
	
	systemServer systemServer;
	
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\系统管理startRight.png");
		Image bg =background.getImage();
		g.drawImage(bg, 0, 0,frameWidth*3/4,frameHeight,null);
	}

	public Manager_Manage(int frameWidth, int frameHeight) {
		tranServer=new Inform_TranStationInformServerImpl();
		storageServer=new Inform_StorageInformServerImpl();
		hallServer=new Inform_HallInformServerImpl();
		systemServer=new SystemBlServerImpl();

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
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

		JButton newCity;
		JButton addCity;
		JTextField jtf;
		JLabel addLabel;
		JButton overButton;

		Vector<JButton> vecButton;
		OrgPanel org = null;
		int numCity = 4;

		public cityPanel() {
			this.setLayout(null);
			this.setBounds(0, 0, frameWidth / 4, frameHeight);
			this.setBackground(Color.gray);

			city_remind = new JLabel("请选择城市");
			nj = new JButton("南京");
			bj = new JButton("北京");
			sh = new JButton("上海");
			gz = new JButton("广州");
			addCity = new JButton("增加城市");
			vecButton = new Vector<JButton>();


			
			initCityPanel();

			this.add(addCity);
			this.add(city_remind);
			this.add(nj);
			this.add(bj);
			this.add(sh);
			this.add(gz);
		}

		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			ImageIcon background = new ImageIcon("pictures\\系统管理startRight.png");
			Image bg =background.getImage();
			g.drawImage(bg, 0, 0,frameWidth*3/4,frameHeight,null);
		}
		
		
		private void initCityPanel() {
			city_remind.setBounds(0, 0, frameWidth / 4, frameHeight / 15);
			nj.setBounds(0, frameHeight / 5, frameWidth / 4, frameHeight / 15);
			
			nj.setBackground(Color.orange);
			nj.setOpaque(true);
			
//			JLabel nj1=new JLabel("南京");
//			nj1.setBounds(0, frameHeight / 5, frameWidth / 4, frameHeight / 15);
//			this.add(nj);
			nj.addActionListener(this);
			nj.setActionCommand("NanJing");
			bj.setBounds(0, frameHeight / 5 + frameHeight / 15, frameWidth / 4,
					frameHeight / 15);
			bj.addActionListener(this);
			bj.setActionCommand("BeiJing");
			sh.setBounds(0, frameHeight / 5 + frameHeight / 15 * 2,
					frameWidth / 4, frameHeight / 15);
			sh.addActionListener(this);
			sh.setActionCommand("ShangHai");
			gz.setBounds(0, frameHeight / 5 + frameHeight / 5, frameWidth / 4,
					frameHeight / 15);
			gz.addActionListener(this);
			gz.setActionCommand("GuangZhou");
			addCity.setBounds(frameWidth / 16, frameHeight / 10 * 9,
					frameWidth / 8, frameHeight / 20);
			addCity.addActionListener(this);
			
//			ImageIcon icon1 = new ImageIcon("pictures//城市标签.png");
//			Image temp1 = icon1.getImage().getScaledInstance(nj.getWidth(),
//					nj.getHeight(), icon1.getImage().SCALE_DEFAULT);
//			icon1 = new ImageIcon(temp1);
//			nj.setIcon(icon1);
//			
//			nj.setMargin(new Insets(0, 0, 0, 0));

			vecButton.add(nj);
			vecButton.add(bj);
			vecButton.add(gz);
			vecButton.add(sh);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < vecButton.size(); i++) {
				if (e.getSource() == vecButton.elementAt(i)) {
					System.out.println("in");
					currentCity = e.getActionCommand();

					if (org != null) {
						Manager_Manage.this.remove(org);
						if (org.conOrgPanel != null) {
							Manager_Manage.this.remove(org.conOrgPanel);
						}
					}

					org = new OrgPanel();

					Manager_Manage.this.add(org);
					Manager_Manage.this.repaint();
				}
			}
			if (e.getSource() == addCity) {
				numCity++;
				newCity = new JButton("");
				newCity.addActionListener(this);
				newCity.setBounds(0, frameHeight / 5 + frameHeight / 15
						* (numCity - 1), frameWidth / 4, frameHeight / 15);

				addPanel();

				vecButton.add(newCity);
				this.add(newCity);
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

		private void addPanel() {
			if (jtf == null) {
				this.repaint();
				this.jtf = new JTextField();
				this.addLabel = new JLabel("请新城市名称:");
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
							newCity.setText(input);
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

		ConcretOrgPanel conOrgPanel = null;

		public OrgPanel() {

			this.setLayout(null);
			this.setBounds(frameWidth / 4, 0, frameWidth / 4, frameHeight);
			this.setBackground(Color.magenta);

			initOrgPanel();

			this.add(orgJs);
			this.add(orgAdd);
			this.add(orgDel);

		}
		
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			ImageIcon background = new ImageIcon("pictures\\系统管理startRight.png");
			Image bg =background.getImage();
			g.drawImage(bg, 0, 0,frameWidth*3/4,frameHeight,null);
		}

		private void initOrgPanel() {

			initOrgTable(currentCity);
			orgTablel = new JTable(orgTableModel){ public boolean isCellEditable(int row, int column) { return false; }}; ;
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
				    currentOrg=location;
					currentID= (String) ((JTable) e.getSource())
							.getValueAt(orgTablel.getSelectedRow(), 1);
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
			Vector<String> vec;
			Iterator it;
			
			
			if((it=tranServer.getByLocation(city1))!=null){
				while(it.hasNext())
				{
					vec= new Vector<String>();
					TranStationPO station=(TranStationPO) it.next();
					vec.add(station.getName());
					vec.add(station.getID());
					orgTableModel.addRow(vec);
				}
			}
			
			
			if((it=storageServer.getByLocation(city1))!=null){
				while(it.hasNext())
				{
					vec= new Vector<String>();
					StoragePO storage=(StoragePO) it.next();
					vec.add(storage.getName());
					vec.add(storage.getID());
					orgTableModel.addRow(vec);
				}
			}
			
			
			if((it=hallServer.getByLocation(city1))!=null){
				while(it.hasNext())
				{
					vec= new Vector<String>();
					HallPO hall=(HallPO) it.next();
					vec.add(hall.getName());
					vec.add(hall.getID());
					orgTableModel.addRow(vec);
				}
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == orgAdd) {
				addPanel();
			} else if (e.getSource() == orgDel) {

				int row = orgTablel.getSelectedRow();
				if (row >= 2) {
					String id=(String) orgTablel.getValueAt(row, 1);
					System.out.println("delete!");
					
					hallServer.removeHall(id);
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
							HallPO hall=hallServer.addHall(currentCity,input);
							Vector vec = new Vector();
							vec.add(input);
							vec.add(hall.getID());
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

		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			ImageIcon background = new ImageIcon("pictures\\系统管理startRight.png");
			Image bg =background.getImage();
			g.drawImage(bg, 0, 0,frameWidth*3/4,frameHeight,null);
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
			
			if(currentOrg.contains("仓库")){
				Iterator<StorageKeeperPO> it=storageServer.getAllKeeper(currentID);
				while(it.hasNext()){
					StorageKeeperPO keeper=it.next();
					Vector vec=new Vector<>();
					
					vec.add(keeper.getName());
					vec.add(keeper.getID());
					
					con_tableModel.addRow(vec);
					
				}
			}else if(currentOrg.contains("中转中心")){
				Iterator<TranStaffPO> it=tranServer.getAllStaff(currentID);
				while(it.hasNext()){
					TranStaffPO staff=it.next();
					Vector vec=new Vector<>();
					
					vec.add(staff.getName());
					vec.add(staff.getId());
					
					con_tableModel.addRow(vec);
					
				}
			}else{
				Iterator<HallStaffPO> it=hallServer.getAllStaff(currentID);
				while(it.hasNext()){
					HallStaffPO staff=it.next();
					Vector vec=new Vector<>();
					
					vec.add(staff.getName());
					vec.add(staff.getId());
					
					con_tableModel.addRow(vec);
					
				}
			}
			
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
					
						SystemUserPO user=systemServer.inquire(input);
						if(user==null)
							System.out.println("不存在该系统用户！");
						else{
							vec.add(user.getUserName());
							vec.add(input);
						}
						boolean OK;
						if(currentOrg.contains("仓库")){
							OK=storageServer.addKeeper(currentID, input);
						}else if(currentOrg.contains("中转中心")){
							OK=tranServer.addStaff(currentID, input);
						}else{
							OK=hallServer.addStaff(currentID, input);
						}

						if (!input.equals("")&&user!=null&&OK) {
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
				String currentStaffID=(String) con_table.getValueAt(row, 1);
				boolean ok;
				if (row >= 0) {
					if(currentOrg.contains("仓库")){
						ok=storageServer.removeKeeper(currentID, currentStaffID);
					}else if(currentOrg.contains("中转中心")){
						ok=tranServer.removeStaff(currentID,  currentStaffID);
					}else{
						ok=hallServer.removeStaff(currentID,  currentStaffID);
						System.out.println(currentID);
						System.out.println(currentStaffID);
					}
					if(ok){
						con_tableModel.removeRow(row);
					}
					
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
