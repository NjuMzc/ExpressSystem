package client.presentation.billsui.log;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import client.presentation.billsui.watcher.State;
import client.presentation.billsui.watcher.Watched;
import client.presentation.billsui.watcher.Watcher;

public class LogMainFrame extends JPanel implements ActionListener, Watched {

	int frameWidth;
	int frameHeight;
	JLabel remind;
	JButton system;
	JLabel account;
	JLabel passport;
	JButton confirm;
	JButton cancel;

	private List<Watcher> list;

	public LogMainFrame(int frameWidth, int frameHeight) {
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(0, 0, frameWidth, frameHeight);
		this.setBackground(new Color(248, 147, 69));

		remind = new JLabel("快递物流系统");
		system = new JButton("系统登录");

		account = new JLabel("账户");
		passport = new JLabel("密码");
		confirm = new JButton("确认");
		cancel = new JButton("取消");

		init();

		this.add(remind);
		this.add(system);
		this.add(account);
		this.add(passport);
		this.add(confirm);
		this.add(cancel);
	}

	private void init() {
		Font f = new Font("", Font.BOLD, 45);
		remind.setFont(f);
		remind.setBounds(frameWidth / 3, frameHeight / 4, frameWidth / 3,
				frameWidth / 18);
		system.setMargin(new Insets(0, 0, 0, 0));
		system.setFont(new Font("", Font.BOLD, 20));
		system.setBounds(frameWidth / 3, frameHeight / 2, frameWidth / 3,
				frameWidth / 12);

		account.setBounds(frameWidth / 3, frameHeight * 5 / 8, frameWidth / 12,
				frameWidth / 20);
		passport.setBounds(frameWidth / 3, frameHeight * 3 / 4,
				frameWidth / 12, frameWidth / 20);
		confirm.setBounds(frameWidth / 3, frameHeight * 7 / 8, frameWidth / 12,
				frameWidth / 20);
		confirm.addActionListener(this);
		cancel.setBounds(frameWidth / 2, frameHeight * 7 / 8, frameWidth / 12,
				frameWidth / 20);
		cancel.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == confirm) {

		} else if (e.getSource() == cancel) {
			this.notifyWatchers(State.COVER);
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
