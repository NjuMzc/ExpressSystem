package presentation.left;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import presentation.watcher.State;
import presentation.watcher.Watched;
import presentation.watcher.Watcher;

public class AdminPanel extends LeftAll implements Watched, ActionListener {

	int frameWidth;
	int frameHeight;
	JButton manage;
	JButton logout;
	JButton close;
	JPanel picture;
	JLabel name;
	JLabel num;
	JLabel photo;
	private List<Watcher> list;

	public AdminPanel(int frameWidth, int frameHeight) {
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(0, 0, frameWidth / 4, frameHeight);

		manage = new JButton("");// 系统管理
		logout = new JButton("");// 登出账号
		close = new JButton("");// 关闭系统
		manage.setContentAreaFilled(false);
		logout.setContentAreaFilled(false);
		close.setContentAreaFilled(false);

		manage.setBorderPainted(false);
		logout.setBorderPainted(false);
		close.setBorderPainted(false);

		init();

		this.add(manage);
		this.add(logout);
		this.add(close);

	}

	// 添加背景
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\adminleft.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth / 4, frameHeight, null);
	}

	private void init() {
		manage.setBounds(0, frameHeight * 40 / 120, frameWidth / 4,
				frameHeight * 3 / 32);
		manage.addActionListener(this);
		logout.setMargin(new Insets(0, 0, 0, 0));
		logout.setBounds(frameWidth * 3 / 80, frameHeight * 63 / 72,
				frameWidth / 17, frameWidth / 17);
		logout.addActionListener(this);
		close.setMargin(new Insets(0, 0, 0, 0));
		close.setBounds(frameWidth * 13 / 80, frameHeight * 63 / 72,
				frameWidth / 17, frameWidth / 17);
		close.addActionListener(this);
		close.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == manage) {
			this.notifyWatchers(State.ADMINMANAGE);
		} else if (e.getSource() == logout) {
			this.notifyWatchers(State.LOGOUT);
		} else if (e.getSource() == close) {
			System.exit(0);
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
