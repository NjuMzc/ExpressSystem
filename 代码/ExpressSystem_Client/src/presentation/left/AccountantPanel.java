package presentation.left;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import presentation.Data;
import presentation.watcher.*;

public class AccountantPanel extends LeftAll implements ActionListener {

	private List<Watcher> list;
	int frameWidth;
	int frameHeight;
	JButton[] jb;
	JButton logout;
	JButton close;
	JPanel picture;
	JLabel name;
	JLabel num;
	JLabel photo;

	boolean isSamll = true;
	JButton addjb1;
	JButton addjb2;

	JTextField jtf_num;
	JTextField jtf_name;

	JButton jb_add1;
	JButton jb_add2;
	JButton jb_add3;
	boolean is_Small = true;

	public AccountantPanel(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(0, 0, frameWidth / 4, frameHeight);

		jb = new JButton[5];
		for (int i = 0; i < 5; i++) {
			jb[i] = new JButton();
		}
		logout = new JButton("");// 登出账户
		close = new JButton("");// 关闭系统
		logout.setContentAreaFilled(false);
		close.setContentAreaFilled(false);
		logout.setBorderPainted(false);
		close.setBorderPainted(false);

		jtf_name = new JTextField();
		jtf_num = new JTextField();

		init();

		this.setBackground(new Color(248, 147, 69));
		for (int i = 0; i < 5; i++) {
			this.add(jb[i]);
		}
		this.add(logout);
		this.add(close);
		this.add(jtf_name);
		this.add(jtf_num);
	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\account.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth / 4, frameHeight, null);
	}

	private void init() {
		for (int i = 0; i < 5; i++) {
			jb[i].setBounds(0, frameHeight / 3 + frameHeight / 13 * i,
					frameWidth / 4, frameHeight / 13);
			jb[i].addActionListener(this);
		}

		// 左栏按钮贴图
		ImageIcon icon0 = new ImageIcon("pictures//期初建账.png");
		Image temp0 = icon0.getImage().getScaledInstance(jb[0].getWidth(),
				jb[0].getHeight(), icon0.getImage().SCALE_DEFAULT);
		icon0 = new ImageIcon(temp0);
		jb[0].setIcon(icon0);

		ImageIcon icon1 = new ImageIcon("pictures//制作报表.png");
		Image temp1 = icon1.getImage().getScaledInstance(jb[1].getWidth(),
				jb[1].getHeight(), icon1.getImage().SCALE_DEFAULT);
		icon1 = new ImageIcon(temp1);
		jb[1].setIcon(icon1);

		ImageIcon icon2 = new ImageIcon("pictures//成本管理.png");
		Image temp2 = icon2.getImage().getScaledInstance(jb[2].getWidth(),
				jb[2].getHeight(), icon2.getImage().SCALE_DEFAULT);
		icon2 = new ImageIcon(temp2);
		jb[2].setIcon(icon2);

		ImageIcon icon3 = new ImageIcon("pictures//账户管理.png");
		Image temp3 = icon3.getImage().getScaledInstance(jb[3].getWidth(),
				jb[3].getHeight(), icon3.getImage().SCALE_DEFAULT);
		icon3 = new ImageIcon(temp3);
		jb[3].setIcon(icon3);

		ImageIcon icon4 = new ImageIcon("pictures//结算管理.png");
		Image temp4 = icon4.getImage().getScaledInstance(jb[4].getWidth(),
				jb[4].getHeight(), icon4.getImage().SCALE_DEFAULT);
		icon4 = new ImageIcon(temp4);
		jb[4].setIcon(icon4);

		jb[0].setText("");// 期初建账
		jb[1].setText("");// 制作报表
		jb[2].setText("");// 成本管理
		jb[3].setText("");// 账户管理
		jb[4].setText("");// 结算管理

		logout.setMargin(new Insets(0, 0, 0, 0));
		logout.setBounds(frameWidth * 3 / 80, frameHeight * 63 / 72,
				frameWidth / 17, frameWidth / 17);
		logout.addActionListener(this);
		close.setMargin(new Insets(0, 0, 0, 0));
		close.setBounds(frameWidth * 13 / 80, frameHeight * 63 / 72,
				frameWidth / 17, frameWidth / 17);
		close.addActionListener(this);

		jtf_num.setBounds(frameWidth / 10, frameHeight / 64 * 15,
				frameWidth / 10, frameHeight / 30);
		jtf_name.setBounds(frameWidth / 10, frameHeight / 64 * 18,
				frameWidth / 10, frameHeight / 30);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb[0]) {
			if (!isSamll) {
				handleIsNotSmall();
			}

			if (is_Small) {
				handle_IsSmall();
			} else {
				handle_IsNotSmall();
			}

		} else if (e.getSource() == jb[1]) {
			if (!isSamll) {
				handleIsNotSmall();
			}
			if (!is_Small) {
				handle_IsNotSmall();
			}
			this.notifyWatchers(State.ACCOUNTANTMAKESHEET);
		} else if (e.getSource() == jb[2]) {
			if (!is_Small) {
				handle_IsNotSmall();
			}

			if (isSamll) {
				handIsSmall();
			} else {
				handleIsNotSmall();
			}

		} else if (e.getSource() == jb[3]) {
			if (!isSamll) {
				handleIsNotSmall();
			}
			if (!is_Small) {
				handle_IsNotSmall();
			}
			this.notifyWatchers(State.ACCOUNTANTMANAGE);
		} else if (e.getSource() == jb[4]) {
			if (!isSamll) {
				handleIsNotSmall();
			}
			if (!is_Small) {
				handle_IsNotSmall();
			}
			this.notifyWatchers(State.ACCOUNTANTBALACE);
		}

		if (e.getSource() == logout) {
			System.out.println("logout");
			this.notifyWatchers(State.LOGOUT);
		} else if (e.getSource() == close) {
			System.exit(0);
		}

		if (e.getSource() == addjb1) {
			this.notifyWatchers(State.ACCOUNTANTCOST);
		} else if (e.getSource() == addjb2) {
			this.notifyWatchers(State.ACCOUNTANTPAYMENT);
		}

		if (e.getSource() == jb_add1) {
			this.notifyWatchers(State.ACCOUNTANTMAKEBILL_ONE);
		} else if (e.getSource() == jb_add2) {
			this.notifyWatchers(State.ACCOUNTANTMAKEBILL_TWO);
		} else if (e.getSource() == jb_add3) {
			this.notifyWatchers(State.ACCOUNTANTMAKEBILL_THREE);
		}
	}

	private void handIsSmall() {
		addjb1 = new JButton("");// 生成付款单
		addjb1.addActionListener(this);
		addjb2 = new JButton("");// 查看成本收益表
		addjb2.addActionListener(this);
		addjb1.setBounds(0, frameHeight / 3 + frameHeight / 13 * 3,
				frameWidth / 4, frameHeight / 23);
		addjb2.setBounds(0, frameHeight / 3 + frameHeight / 13 * 3
				+ frameHeight / 23, frameWidth / 4, frameHeight / 23);

		ImageIcon icon8 = new ImageIcon("pictures//查看成本收益表.png");
		Image temp8 = icon8.getImage().getScaledInstance(frameWidth / 4,
				frameHeight / 23, icon8.getImage().SCALE_DEFAULT);
		icon8 = new ImageIcon(temp8);
		addjb1.setIcon(icon8);

		ImageIcon icon9 = new ImageIcon("pictures//生成付款单.png");
		Image temp9 = icon9.getImage().getScaledInstance(addjb2.getWidth(),
				addjb2.getHeight(), icon9.getImage().SCALE_DEFAULT);
		icon9 = new ImageIcon(temp9);
		addjb2.setIcon(icon9);

		this.add(addjb1);
		this.add(addjb2);
		for (int i = 3; i < 5; i++) {
			jb[i].setBounds(0, frameHeight / 3 + frameHeight / 13 * i
					+ frameHeight / 23 * 2, frameWidth / 4, frameHeight / 13);
		}
		this.isSamll = false;
	}

	private void handle_IsSmall() {
		jb_add1 = new JButton("库存");// 库存
		jb_add1.addActionListener(this);
		jb_add2 = new JButton("账户");// 账户
		jb_add2.addActionListener(this);
		jb_add3 = new JButton("机构");// 机构
		jb_add3.addActionListener(this);

		jb_add1.setBounds(0, frameHeight / 3 + frameHeight / 13,
				frameWidth / 4, frameHeight / 23);
		jb_add2.setBounds(0, frameHeight / 3 + frameHeight / 13 + frameHeight
				/ 23, frameWidth / 4, frameHeight / 23);
		jb_add3.setBounds(0, frameHeight / 3 + frameHeight / 13 + frameHeight
				/ 23 * 2, frameWidth / 4, frameHeight / 23);

		this.add(jb_add1);
		this.add(jb_add2);
		this.add(jb_add3);
		for (int i = 1; i < 5; i++) {
			jb[i].setBounds(0, frameHeight / 3 + frameHeight / 13 * i
					+ frameHeight / 23 * 3, frameWidth / 4, frameHeight / 13);
		}
		this.is_Small = false;
	}

	private void handleIsNotSmall() {
		this.remove(addjb1);
		this.remove(addjb2);
		for (int i = 3; i < 5; i++) {
			jb[i].setBounds(0, frameHeight / 3 + frameHeight / 13 * i,
					frameWidth / 4, frameHeight / 13);
		}
		this.isSamll = true;
	}

	private void handle_IsNotSmall() {
		this.remove(jb_add1);
		this.remove(jb_add2);
		this.remove(jb_add3);
		for (int i = 1; i < 5; i++) {
			jb[i].setBounds(0, frameHeight / 3 + frameHeight / 13 * i,
					frameWidth / 4, frameHeight / 13);
		}
		this.is_Small = true;
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
}
