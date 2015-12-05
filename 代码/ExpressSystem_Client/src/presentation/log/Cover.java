package presentation.log;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import presentation.Data;
import presentation.right.RightAll;
import presentation.watcher.State;
import presentation.watcher.Watched;
import presentation.watcher.Watcher;

public class Cover extends RightAll implements ActionListener {

	int frameWidth;
	int frameHeight;
	JLabel remind;
	JButton system;
	JButton customer;
	private List<Watcher> list;

	public Cover(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(0, 0, frameWidth, frameHeight);

		system = new JButton();
		//system.setBorderPainted(false);
		customer = new JButton();
		//customer.setBorderPainted(false);

		init();

		ImageIcon icon1 = new ImageIcon("pictures//系统登录按钮剪裁.png");
		Image temp1 = icon1.getImage().getScaledInstance(system.getWidth(),
				system.getHeight(), icon1.getImage().SCALE_DEFAULT);
		icon1 = new ImageIcon(temp1);
		system.setIcon(icon1);

		ImageIcon icon2 = new ImageIcon("pictures//客户登录按钮剪裁.png");
		Image temp2 = icon2.getImage().getScaledInstance(customer.getWidth(),
				customer.getHeight(), icon1.getImage().SCALE_DEFAULT);
		icon2 = new ImageIcon(temp2);
		customer.setIcon(icon2);

		this.add(system);
		this.add(customer);
	}

	// 添加背景
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\初始背景.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth,frameHeight,null);
	}

	// 以上为添加背景

	private void init() {
		system.setMargin(new Insets(0, 0, 0, 0));
		system.setFont(new Font("", Font.BOLD, 20));
		system.setBounds(frameWidth * 5 / 14, 2 * frameHeight / 5,
				3 * frameWidth / 11, frameWidth / 13);
		system.addActionListener(this);
		customer.setMargin(new Insets(0, 0, 0, 0));
		customer.setFont(new Font("", Font.BOLD, 20));
		customer.setBounds(frameWidth * 5 / 14, frameHeight * 3 / 5,
				3 * frameWidth / 11, frameWidth / 13);
		customer.addActionListener(this);
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
		if (e.getSource() == system) {
			this.notifyWatchers(State.LOGMAINFRAME);
		} else if (e.getSource() == customer) {
			this.notifyWatchers(State.LOGSEARCH);
		}
	}
}
