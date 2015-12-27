package presentation.right.manager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import businesslogic.salarybl.SalaryServerImpl;
import businesslogicservice.salaryblservice.SalaryServer;
import presentation.right.RightAll;
import presentation.watcher.*;
import vo.SalaryVO;

public class Manager_make_money extends RightAll implements ActionListener {
	SalaryServer blServer;

	SalaryVO manager;
	SalaryVO transman;
	SalaryVO courier;
	SalaryVO systemManager;
	SalaryVO storageManager;
	SalaryVO accountant;
	SalaryVO businessman;

	int frameWidth;
	int frameHeight;
	JLabel[] jl;
	JLabel[] way1;
	JLabel[] way2;
	JLabel[] way3;
	JButton ok;
	JButton cancel;
	JRadioButton jradiobutton1[];
	JRadioButton jradiobutton2[];
	JRadioButton jradiobutton3[];
	JTextField jtf1[];
	JTextField jtf2[];
	JTextField jtf3[];
	ButtonGroup buttongroup[];
	private List<Watcher> list;

	public Manager_make_money(int frameWidth, int frameHeight) {
		blServer = new SalaryServerImpl();

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel[7];
		for (int i = 0; i < 7; i++) {
			jl[i] = new JLabel();
		}
		ok = new JButton("");// 提交
		ok.setFont(new Font("宋体", Font.PLAIN, 18));
		cancel = new JButton("");// 取消
		cancel.setFont(new Font("宋体", Font.PLAIN, 18));

		jradiobutton1 = new JRadioButton[7];
		jradiobutton2 = new JRadioButton[7];
		jradiobutton3 = new JRadioButton[3];
		buttongroup = new ButtonGroup[7];
		way1 = new JLabel[10];
		way2 = new JLabel[7];
		way3 = new JLabel[10];
		jtf1 = new JTextField[7];
		jtf2 = new JTextField[7];
		jtf3 = new JTextField[3];
		for (int i = 0; i < 7; i++) {
			jradiobutton1[i] = new JRadioButton("工资：");
			jradiobutton2[i] = new JRadioButton("提成：");
			jradiobutton1[i].setBorderPainted(false); // 不绘制边界搜索
			jradiobutton1[i].setContentAreaFilled(false); // 不填充所占的矩形区域
			jradiobutton2[i].setBorderPainted(false); // 不绘制边界搜索
			jradiobutton2[i].setContentAreaFilled(false); // 不填充所占的矩形区域
			buttongroup[i] = new ButtonGroup();
			way1[i] = new JLabel("元/月");
			way2[i] = new JLabel("%");
			jtf1[i] = new JTextField();
			jtf2[i] = new JTextField();

			jradiobutton1[i].setFont(new Font("宋体", Font.PLAIN, 15));
			jradiobutton2[i].setFont(new Font("宋体", Font.PLAIN, 15));
			way1[i].setFont(new Font("宋体", Font.PLAIN, 15));
			way2[i].setFont(new Font("宋体", Font.PLAIN, 15));
			jtf1[i].setFont(new Font("宋体", Font.PLAIN, 15));
			jtf2[i].setFont(new Font("宋体", Font.PLAIN, 15));

		}
		for (int i = 0; i < 3; i++) {
			jradiobutton3[i] = new JRadioButton("计次：");
			jradiobutton3[i].setFont(new Font("宋体", Font.PLAIN, 15));
			jradiobutton3[i].setBorderPainted(false); // 不绘制边界搜索
			jradiobutton3[i].setContentAreaFilled(false); // 不填充所占的矩形区域
			way3[i] = new JLabel("元/次 ");
			way3[i].setFont(new Font("宋体", Font.PLAIN, 15));
			jtf3[i] = new JTextField();
			jtf3[i].setFont(new Font("宋体", Font.PLAIN, 15));
		}

		init();

		for (int i = 0; i < 7; i++) {
			this.add(jl[i]);
			this.add(jradiobutton1[i]);
			this.add(jradiobutton2[i]);
			this.add(way1[i]);
			this.add(way2[i]);
			this.add(jtf1[i]);
			this.add(jtf2[i]);
		}
		for (int i = 0; i < 3; i++) {
			this.add(jradiobutton3[i]);
			this.add(way3[i]);
			this.add(jtf3[i]);
		}

		this.add(ok);
		this.add(cancel);

	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\制定薪水right.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth * 3 / 4, frameHeight, null);
	}

	private void init() {

		jl[0].setText("总经理");
		jl[1].setText("管理员");
		jl[2].setText("财务人员");
		jl[3].setText("仓库管理员");
		jl[4].setText("快递员");
		jl[5].setText("营业厅业务员");
		jl[6].setText("中转中心业务员 ");

		for (int i = 0; i < 7; i++) {
			jl[i].setFont(new Font("宋体", Font.BOLD, 15));
			jl[i].setBounds(frameWidth / 31, frameHeight / 10 * (i + 1),
					frameWidth / 7, frameHeight / 20);
			jradiobutton1[i].setBounds(frameWidth / 38 * 6, frameHeight / 10
					* (i + 1), frameWidth / 10, frameHeight / 20);
			jradiobutton2[i].setBounds(frameWidth / 29 * 11, frameHeight / 10
					* (i + 1), frameWidth / 10, frameHeight / 20);
			jradiobutton1[i].addActionListener(this);
			jradiobutton2[i].addActionListener(this);
			way1[i].setBounds(frameWidth / 240 * 92,
					frameHeight / 10 * (i + 1), frameWidth / 13,
					frameHeight / 20);
			way2[i].setBounds(frameWidth / 2 + frameWidth / 55, frameHeight
					/ 10 * (i + 1), frameWidth / 13, frameHeight / 20);
			jtf1[i].setBounds(frameWidth / 120 * 31,
					frameHeight / 10 * (i + 1), frameWidth / 16,
					frameHeight / 20);
			jtf2[i].setBounds(frameWidth / 100 * 50,
					frameHeight / 10 * (i + 1), frameWidth / 16,
					frameHeight / 20);

			jtf1[i].addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					if (!Character.isDigit(e.getKeyChar())
							&& e.getKeyChar() != KeyEvent.VK_PERIOD) {
						e.consume();
					}
				}
			});
			jtf2[i].addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					if (!Character.isDigit(e.getKeyChar())
							&& e.getKeyChar() != KeyEvent.VK_PERIOD) {
						e.consume();
					}
				}
			});
		}

		for (int i = 0; i < 3; i++) {
			jradiobutton3[i].setBounds(frameWidth / 2 + frameWidth / 22,
					frameHeight / 10 * (i + 5), frameWidth / 11,
					frameHeight / 20);
			jradiobutton3[i].addActionListener(this);
			way3[i].setBounds(frameWidth / 256 * 203, frameHeight / 10
					* (i + 5), frameWidth / 13, frameHeight / 20);
			jtf3[i].setBounds(frameWidth / 124 * 79,
					frameHeight / 10 * (i + 5), frameWidth / 16,
					frameHeight / 20);
			jtf3[i].addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					if (!Character.isDigit(e.getKeyChar())
							&& e.getKeyChar() != KeyEvent.VK_PERIOD) {
						e.consume();
					}
				}
			});
		}

		for (int i = 0; i < 4; i++) {
			buttongroup[i].add(jradiobutton1[i]);
			buttongroup[i].add(jradiobutton2[i]);
		}
		for (int i = 4; i < 7; i++) {
			buttongroup[i].add(jradiobutton1[i]);
			buttongroup[i].add(jradiobutton2[i]);
			buttongroup[i].add(jradiobutton3[i - 4]);
		}

		// ok.setUI(new
		// BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));
		ok.setBounds(frameWidth / 20 * 3, frameHeight / 20 * 17,
				frameWidth / 10, frameHeight / 18);
		ok.addActionListener(this);
		// cancel.setUI(new
		// BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
		cancel.setBounds(frameWidth / 20 * 9, frameHeight / 20 * 17,
				frameWidth / 10, frameHeight / 18);
		cancel.addActionListener(this);
		ImageIcon icon1 = new ImageIcon("pictures//取消t.png");
		Image temp1 = icon1.getImage().getScaledInstance(icon1.getIconWidth(),
				icon1.getIconHeight(), icon1.getImage().SCALE_DEFAULT);
		icon1 = new ImageIcon(temp1);
		cancel.setIcon(icon1);

		ImageIcon icon2 = new ImageIcon("pictures//提交.png");
		Image temp2 = icon2.getImage().getScaledInstance(icon2.getIconWidth(),
				icon2.getIconHeight(), icon2.getImage().SCALE_DEFAULT);
		icon2 = new ImageIcon(temp2);
		ok.setIcon(icon2);

		initData();

	}

	// 数据初始化
	private void initData() {

		SalaryVO[] salarys = new SalaryVO[7];

		salarys[0] = blServer.getSalary("MANAGER");
		salarys[1] = blServer.getSalary("SYSTEM_MANAGER");
		salarys[2] = blServer.getSalary("ACCOUNTANT");
		salarys[3] = blServer.getSalary("STORAGE_MANAGER");
		salarys[4] = blServer.getSalary("COURIER");
		salarys[5] = blServer.getSalary("BUSINESSMAN");
		salarys[6] = blServer.getSalary("TRANSMAN");

		for (int i = 0; i < 7; i++) {

			if (salarys[i].getSalaryType().equals("MONTH")) {
				jradiobutton1[i].setSelected(true);
				jtf1[i].setText(salarys[i].getNum());
				jtf2[i].setEditable(false);
				if(i>3&&i<7)
				jtf3[i-4].setEditable(false);

			}

			if (salarys[i].getSalaryType().equals("PERCENTAGE")) {
				jradiobutton2[i].setSelected(true);
				jtf2[i].setText(salarys[i].getNum());
				jtf1[i].setEditable(false);
				if(i>3&&i<7)
				jtf3[i-4].setEditable(false);

			}

			if (salarys[i].getSalaryType().equals("COUNT")) {
				if(i>3&&i<7)
				jradiobutton3[i-4].setSelected(true);
				if(i>3&&i<7)
				jtf3[i-4].setText(salarys[i].getNum());
				jtf2[i].setEditable(false);
				jtf1[i-4].setEditable(false);

			}
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
		if (e.getSource() == cancel) {
			this.notifyWatchers(State.MANAGERSTART);
		} else if (e.getSource() == ok) {
			String[] salary;
			int[] choice;

			salary = new String[7];
			choice = new int[7];

			for (int i = 0; i < 7; i++) {
				if (jradiobutton1[i].isSelected()) {
					choice[i] = 0;
					salary[i] = jtf1[i].getText();
				}
			}
			for (int i = 0; i < 7; i++) {
				if (jradiobutton2[i].isSelected()) {
					choice[i] = 1;
					salary[i] = jtf2[i].getText();
				}
			}
			for (int i = 0; i < 3; i++) {
				if (jradiobutton3[i].isSelected()) {
					choice[i + 4] = 2;
					salary[i + 4] = jtf3[i].getText();
				}
			}

			for (int i = 0; i < 7; i++) {
				SalaryVO salaryVO = new SalaryVO(salary[i], choice[i], i);
				blServer.setSalary(salaryVO);
			}

			SalaryVO ss = blServer.getSalary("MANAGER");
			System.out.println(ss.getStaffType() + " " + ss.getNum());
			 this.notifyWatchers(State.MANAGERSTART);
		}

		for (int i = 0; i < 7; i++) {
			if (e.getSource() == jradiobutton1[i]) {
				jtf2[i].setText("");
				if (i < 7 && i > 3)
					jtf3[i - 4].setText("");

				jtf1[i].setEditable(true);
				jtf2[i].setEditable(false);
				if (i > 3 && i < 7) {
					jtf3[i - 4].setEditable(false);
				}

			}

			if (e.getSource() == jradiobutton2[i]) {
				jtf1[i].setText("");
				if (i < 7 && i > 3)
					jtf3[i - 4].setText("");

				jtf2[i].setEditable(true);
				jtf1[i].setEditable(false);
				if (i > 3 && i < 7) {
					jtf3[i - 4].setEditable(false);
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			if (e.getSource() == jradiobutton3[i]) {
				jtf1[i + 4].setText("");
				jtf2[i + 4].setText("");

				jtf3[i].setEditable(true);
				jtf1[i + 4].setEditable(false);
				jtf2[i + 4].setEditable(false);
			}
			
			
		}
           
	}
}
