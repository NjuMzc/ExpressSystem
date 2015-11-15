package client.presentation.billsui.right.courier;

import javax.swing.*;

import client.presentation.billsui.Data;
import client.presentation.billsui.watcher.State;
import client.presentation.billsui.watcher.Watched;
import client.presentation.billsui.watcher.Watcher;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CourierSearch extends JPanel implements Watched, ActionListener {

	int frameWidth;
	int frameHeight;
	JLabel remind;
	JButton confirm;
	JButton cancel;
	private List<Watcher> list;

	public CourierSearch(int frameWidth, int frameHeight) {
	 
		this.frameWidth =frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBackground(new Color(254, 67, 101));
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		remind = new JLabel("快递物流系统");
		confirm = new JButton("确认");
		cancel = new JButton("取消");

		init();

		this.add(remind);
		this.add(confirm);
		this.add(cancel);
	}

	private void init() {
		remind.setForeground(Color.blue);
		remind.setBounds(frameWidth / 4, frameHeight / 3, frameWidth / 4, 40);
		confirm.setBounds(frameWidth / 4, frameHeight / 2, frameWidth / 12,
				frameWidth / 20);
		confirm.addActionListener(this);
		cancel.setBounds(frameWidth / 2, frameHeight / 2, frameWidth / 12,
				frameWidth / 20);
		cancel.addActionListener(this);

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
			this.notifyWatchers(State.COURIERSTART);
		} else if (e.getSource() == confirm) {

		}

	}
}
