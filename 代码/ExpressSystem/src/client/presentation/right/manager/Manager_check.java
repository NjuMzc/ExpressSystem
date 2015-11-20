package client.presentation.right.manager;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import client.presentation.watcher.*;

public class Manager_check extends JPanel implements Watched, ActionListener {
	int frameWidth;
	int frameHeight;
	JLabel tobe;
	JLabel infor;
	JButton allpass;

	private List<Watcher> list;

	public Manager_check(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		tobe = new JLabel("待审批单据");
		infor = new JLabel("详细信息");
		allpass = new JButton("批量审批");

		this.setLayout(null);
		this.setBackground(new Color(254, 67, 101));
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		init();

		this.add(tobe);
		this.add(infor);
		this.add(allpass);
	}

	private void init() {
		tobe.setBounds(frameWidth / 4, frameHeight / 10, 100, 60);
		infor.setBounds(frameWidth / 2, frameHeight / 10, 100, 60);
		allpass.setBounds(frameWidth / 3, frameHeight / 5 * 4, 100, 30);
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

	}
}
