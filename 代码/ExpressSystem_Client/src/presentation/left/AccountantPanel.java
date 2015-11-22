package presentation.left;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import presentation.Data;
import presentation.watcher.*;

public class AccountantPanel extends JPanel implements Watched, ActionListener {

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
		logout = new JButton("登出账户");
		close = new JButton("关闭系统");
		picture = new JPanel();
		picture.setLayout(null);
		name = new JLabel("姓名");
		num = new JLabel("编号");
		photo = new JLabel("hhh");

		init();

		this.setBackground(new Color(248, 147, 69));
		for (int i = 0; i < 5; i++) {
			this.add(jb[i]);
		}
		this.add(logout);
		this.add(close);
		picture.add(name);
		picture.add(num);
		picture.add(photo);
		this.add(picture);
	}

	private void init() {
		for (int i = 0; i < 5; i++) {
			jb[i] = new JButton();
			jb[i].setBounds(0, frameHeight / 3 + frameHeight / 15 * i,
					frameWidth / 4, frameHeight / 15);
			jb[i].addActionListener(this);
		}
		jb[0].setText("期初建账");
		jb[1].setText("制作报表");
		jb[2].setText("成本管理");
		jb[3].setText("账户管理");
		jb[4].setText("结算管理");

		logout.setMargin(new Insets(0, 0, 0, 0));
		logout.setBounds(20, frameHeight - 100, 80, 30);
		close.setMargin(new Insets(0, 0, 0, 0));
		close.setBounds(frameWidth / 4 - 100, frameHeight - 100, 80, 30);

		picture.setBounds(0, 0, frameWidth / 4, frameHeight / 3);
		name.setBounds(10, frameHeight / 3 - 50, 75, 25);
		num.setBounds(10, frameHeight / 3 - 25, 75, 25);
		photo.setBounds(frameWidth / 40, frameWidth / 40, frameWidth / 5,
				frameWidth / 5);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb[0]) {
			this.notifyWatchers(State.ACCOUNTANTMAKEBILL);
		} else if (e.getSource() == jb[1]) {
			this.notifyWatchers(State.ACCOUNTANTMAKESHEET);
		} else if (e.getSource() == jb[2]) {

			if (isSamll) {
				addjb1 = new JButton("生成付款单");
				addjb1.addActionListener(this);
				addjb2 = new JButton("查看成本收益表");
				addjb2.addActionListener(this);
				addjb1.setBounds(frameWidth / 16, frameHeight / 3 + frameHeight
						/ 15 * 3, frameWidth / 16 * 3, frameHeight / 30);
				addjb2.setBounds(frameWidth / 16, frameHeight / 3 + frameHeight
						/ 15 * 3 + frameHeight / 30, frameWidth / 16 * 3,
						frameHeight / 30);
				this.add(addjb1);
				this.add(addjb2);
				for (int i = 3; i < 5; i++) {
					jb[i].setBounds(0, frameHeight / 3 + frameHeight / 15
							* (i + 1), frameWidth / 4, frameHeight / 15);
				}
				this.isSamll = false;
			} else {
				this.remove(addjb1);
				this.remove(addjb2);
				for (int i = 3; i < 5; i++) {
					jb[i].setBounds(0, frameHeight / 3 + frameHeight / 15 * i,
							frameWidth / 4, frameHeight / 15);
				}
				this.isSamll = true;
			}

		} else if (e.getSource() == jb[3]) {
			this.notifyWatchers(State.ACCOUNTANTMANAGE);
		} else if (e.getSource() == jb[4]) {
			this.notifyWatchers(State.ACCOUNTANTBALACE);
		}

		if (e.getSource() == addjb1) {
			this.notifyWatchers(State.ACCOUNTANTPAYMENT);
		} else if (e.getSource() == addjb2) {
			this.notifyWatchers(State.ACCOUNTANTCOST);
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
}
