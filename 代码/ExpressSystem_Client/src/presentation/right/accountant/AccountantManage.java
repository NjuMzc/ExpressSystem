package presentation.right.accountant;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import po.Workers.CarPO;
import presentation.right.RightAll;
import presentation.watcher.*;

public class AccountantManage extends RightAll implements ActionListener {
	int frameWidth;
	int frameHeight;
	private List<Watcher> list;

	DefaultTableModel model;
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

	// 修改界面待完成
	JPanel searchpanel;
	JTextField searchjtf[];
	JLabel searchlable[];
	JButton searchover;
	JButton search;

	public AccountantManage(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		list = new ArrayList<Watcher>();
		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		model = new DefaultTableModel();
		table = new JTable(model);
		js = new JScrollPane(table);
		jb = new JButton[4];
		for (int i = 0; i < 4; i++) {
			jb[i] = new JButton();
		}

		init();

		this.add(js);
		for (int i = 0; i < 4; i++) {
			this.add(jb[i]);
		}
	}
	
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\系统管理startRight.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth * 3 / 4, frameHeight, null);
	}
	

	private void addSearchPanel() {
		searchpanel = new JPanel();
		searchpanel.setLayout(null);
		searchpanel.setBounds(frameWidth / 16, frameHeight / 5 * 3,
				frameWidth / 5 * 3, frameHeight / 10);
		searchlable = new JLabel[2];
		searchjtf = new JTextField[2];
		for (int i = 0; i < 2; i++) {
			searchlable[i] = new JLabel();
			searchjtf[i] = new JTextField();
		}
		searchover = new JButton("");//√
		searchlable[0].setText("名称");
		searchlable[1].setText("金额");
		search = new JButton("");//查询
		search.addActionListener(this);
		search.setBounds(frameWidth / 3, frameHeight / 22, frameWidth / 10,
				frameHeight / 19);
		ImageIcon icon4 = new ImageIcon("pictures//查询.png");
		Image temp4 = icon4.getImage().getScaledInstance(icon4.getIconWidth(),
				icon4.getIconHeight(), icon4.getImage().SCALE_DEFAULT);
		icon4= new ImageIcon(temp4);
		search.setIcon(icon4);

		for (int i = 0; i < 2; i++) {
			searchlable[i].setBounds(frameWidth / 10 * i, 0,
					frameWidth / 28 * 3, frameHeight / 20);
			searchjtf[i].setBounds(frameWidth / 10 * i, frameHeight / 20,
					frameWidth / 28 * 3, frameHeight / 20);
		}

		searchpanel.add(searchlable[0]);
		searchpanel.add(searchjtf[0]);
		searchover.setBounds(frameWidth / 2, frameHeight / 22, frameHeight / 19,
				frameHeight / 19);
		ImageIcon icon5 = new ImageIcon("pictures//勾.png");
		Image temp5 = icon5.getImage().getScaledInstance(searchover.getWidth(),
				searchover.getHeight(), icon5.getImage().SCALE_DEFAULT);
		icon5= new ImageIcon(temp5);
		searchover.setIcon(icon5);
		searchover.addActionListener(this);

		searchpanel.add(search);
		this.add(searchpanel);
		this.repaint();

	}

	private void addAddPanel() {
		addpanel = new JPanel();
		addpanel.setLayout(null);
		addpanel.setBounds(frameWidth / 16, frameHeight / 5 * 3,
				frameWidth / 5 * 3, frameHeight / 10);
		addlable = new JLabel[2];
		addjtf = new JTextField[2];
		for (int i = 0; i < 2; i++) {
			addlable[i] = new JLabel();
			addjtf[i] = new JTextField();
		}
		addover = new JButton("");//√
		addlable[0].setText("名称");
		addlable[1].setText("金额");

		for (int i = 0; i < 2; i++) {
			addlable[i].setBounds(frameWidth / 10 * i, 0, frameWidth / 28 * 3,
					frameHeight / 20);
			addjtf[i].setBounds(frameWidth / 10 * i, frameHeight / 20,
					frameWidth / 28 * 3, frameHeight / 20);

			addpanel.add(addlable[i]);
			addpanel.add(addjtf[i]);
		}
		addover.setBounds(frameWidth / 2, frameHeight / 22, frameHeight / 19,
				frameHeight / 19);
		addover.addActionListener(this);
		ImageIcon icon6 = new ImageIcon("pictures//勾.png");
		Image temp6 = icon6.getImage().getScaledInstance(addover.getWidth(),
				addover.getHeight(), icon6.getImage().SCALE_DEFAULT);
		icon6= new ImageIcon(temp6);
		addover.setIcon(icon6);

		addpanel.add(addover);
		this.add(addpanel);
		this.repaint();

	}

	private void addChangePanel(Vector<String> vec) {
		changepanel = new JPanel();
		changepanel.setLayout(null);
		changepanel.setBounds(frameWidth / 16, frameHeight / 5 * 3,
				frameWidth / 5 * 3, frameHeight / 10);
		changelable = new JLabel[2];
		changejtf = new JTextField[2];
		for (int i = 0; i < 2; i++) {
			changelable[i] = new JLabel();
			changejtf[i] = new JTextField();
		}
		changeover = new JButton("");//√
		changelable[0].setText("名称");
		changelable[1].setText("金额");

		for (int i = 0; i < 2; i++) {
			changelable[i].setBounds(frameWidth / 10 * i, 0,
					frameWidth / 28 * 3, frameHeight / 20);
			changejtf[i].setBounds(frameWidth / 10 * i, frameHeight / 20,
					frameWidth / 28 * 3, frameHeight / 20);

			changejtf[i].setText(vec.get(i));

			changepanel.add(changelable[i]);
			changepanel.add(changejtf[i]);
		}
		changeover.setBounds(frameWidth / 2, frameHeight / 22,frameHeight / 19,
				frameHeight / 19);
		
		ImageIcon icon7 = new ImageIcon("pictures//勾.png");
		Image temp7 = icon7.getImage().getScaledInstance(changeover.getWidth(),
				changeover.getHeight(), icon7.getImage().SCALE_DEFAULT);
		icon7= new ImageIcon(temp7);
		changeover.setIcon(icon7);
		
		changeover.addActionListener(this);

		changepanel.add(changeover);
		this.add(changepanel);
		this.repaint();
	}

	private void init() {
		js.setBounds(frameWidth / 16, frameHeight / 10, frameWidth / 8 * 5,
				frameHeight / 2);
		initTable();
		jb[0].setText("增加");//
		jb[1].setText("删除");//
		jb[2].setText("修改");//
		jb[3].setText("查询");//
		for (int i = 0; i < 4; i++) {
			jb[i].setBounds(frameWidth / 10 + frameWidth / 20 * 3 * i,
					frameHeight / 10 * 9, frameWidth / 10, frameHeight / 19);
			jb[i].addActionListener(this);	
			
			
//    ImageIcon icon3 = new ImageIcon("pictures//查询.png");
//	Image temp3 = icon3.getImage().getScaledInstance(icon3.getIconWidth(),
//			icon3.getIconHeight(), icon3.getImage().SCALE_DEFAULT);
//	       icon3= new ImageIcon(temp3);
//	       jb[3].setIcon(icon3);
//	       
//			ImageIcon icon0 = new ImageIcon("pictures//增加.png");
//			Image temp0 = icon0.getImage().getScaledInstance(icon0.getIconWidth(),
//					icon0.getIconHeight(), icon0.getImage().SCALE_DEFAULT);
//			icon0= new ImageIcon(temp0);
//			jb[0].setIcon(icon0);
//			
//			ImageIcon icon1 = new ImageIcon("pictures//删除.png");
//			Image temp1 = icon1.getImage().getScaledInstance(icon1.getIconWidth(),
//					icon1.getIconHeight(), icon1.getImage().SCALE_DEFAULT);
//			icon1= new ImageIcon(temp1);
//			jb[1].setIcon(icon1);
//			
//			ImageIcon icon2 = new ImageIcon("pictures//修改.png");
//			Image temp2 = icon2.getImage().getScaledInstance(icon2.getIconWidth(),
//					icon2.getIconHeight(), icon2.getImage().SCALE_DEFAULT);
//			icon2= new ImageIcon(temp2);
//			jb[2].setIcon(icon2);
		}
	}
	


	private void initTable() {

		model.addColumn("名称");
		model.addColumn("金额");
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		initTableModel();
	}

	private void initTableModel() {

		Vector<String> vec = new Vector<>();
		vec.add("人民银行");
		vec.add("100,000");

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

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == jb[0]) {
			if (changepanel != null) {
				this.remove(changepanel);
			}
			if (searchpanel != null) {
				this.remove(searchpanel);
			}
			addAddPanel();
		} else if (e.getSource() == jb[1]) {
			if (addpanel != null) {
				this.remove(addpanel);
			}
			if (searchpanel != null) {
				this.remove(searchpanel);
			}
			int selectedRow = table.getSelectedRow();
			if (selectedRow >= 0) {
				model.removeRow(selectedRow);
			}
		} else if (e.getSource() == jb[2]) {
			if (addpanel != null) {
				this.remove(addpanel);
			}
			if (changepanel != null) {
				this.remove(changepanel);
			}
			if (searchpanel != null) {
				this.remove(searchpanel);
			}
			// 改
			int row = table.getSelectedRow();
			if (row >= 0) {
				Vector<String> vec = new Vector<String>();
				vec.add(table.getValueAt(row, 0).toString());
				vec.add(table.getValueAt(row, 1).toString());
				addChangePanel(vec);
				model.removeRow(row);
			}
		} else if (e.getSource() == jb[3]) {
			if (addpanel != null) {
				this.remove(addpanel);
			}
			if (changepanel != null) {
				this.remove(changepanel);
			}

			addSearchPanel();
			this.repaint();
		}

		// 增加成功
		if (e.getSource() == addover) {
			Vector<String> vec = new Vector<>();
			vec.add(addjtf[0].getText());
			vec.add(addjtf[1].getText());

			model.addRow(vec);

			this.remove(addpanel);
			this.repaint();
		} else if (e.getSource() == changeover) {
			Vector<String> vec = new Vector<>();
			vec.add(changejtf[0].getText());
			vec.add(changejtf[1].getText());

			model.addRow(vec);

			this.remove(changepanel);
			this.repaint();

		}else if(e.getSource()==searchover){
			this.remove(searchpanel);
			this.repaint();
		}

		if (e.getSource() == search) {
			searchpanel.add(searchjtf[1]);
			searchpanel.add(searchlable[1]);
			searchpanel.add(searchover);
			this.repaint();
		}

	}
}
