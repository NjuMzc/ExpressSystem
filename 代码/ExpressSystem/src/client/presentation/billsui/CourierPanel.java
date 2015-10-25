package client.presentation.billsui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class CourierPanel extends JPanel implements Watched, ActionListener {

	private List<Watcher> list;
	int frameWidth;
	int frameHeight;
	JButton[] jb;

	public CourierPanel() {
		Data d = new Data();
		this.frameWidth = d.getFrameWidth();
		this.frameHeight = d.getFrameHeight();

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(0, 0, frameWidth / 3, frameHeight);

		jb = new JButton[3];
		for (int i = 0; i < 3; i++) {
			jb[i] = new JButton();
		}

		init();

		// this.setBackground(Color.green);
		for (int i = 0; i < 3; i++) {
			this.add(jb[i]);
		}

	}

	private void init() {
		for (int i = 0; i < 3; i++) {
			jb[i] = new JButton();
			jb[i].setBounds(frameWidth / 12, frameHeight / 3 + frameWidth / 5
					* i, frameWidth / 7, frameWidth / 15);
			jb[i].addActionListener(this);
		}
		jb[0].setText("制作订单");
		jb[1].setText("查询订单");
		jb[2].setText("录入收款单");
	}

	public void addWatcher(Watcher watcher) {
		// TODO Auto-generated method stub
		list.add(watcher);
	}

	public void removeWatcehr(Watcher watcher) {
		// TODO Auto-generated method stub
		list.remove(watcher);
	}

	public void notifyWatchers(State state) {
		// TODO Auto-generated method stub
		for (Watcher watcher : list) {
			watcher.update(state);
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jb[2]) {
			this.notifyWatchers(State.STARTTOINPUTINFOR);
		}
	}
}
