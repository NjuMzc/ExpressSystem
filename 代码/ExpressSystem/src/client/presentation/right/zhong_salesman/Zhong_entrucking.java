package client.presentation.right.zhong_salesman;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import client.presentation.watcher.State;
import client.presentation.watcher.Watched;
import client.presentation.watcher.Watcher;

public class Zhong_entrucking extends JPanel implements Watched, ActionListener {

	int frameWidth;
	int frameHeight;
	JLabel jl[];
	JButton confirm;
	JButton cancel;
	private List<Watcher> list;

	public Zhong_entrucking(int frameWidth, int frameHeight) {
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBackground(new Color(254, 67, 101));
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel[7];
		for (int i = 0; i < 7; i++) {
			jl[i] = new JLabel();
		}
		confirm = new JButton("确认");
		cancel = new JButton("取消");

		init();

		for (int i = 0; i < 7; i++) {
			this.add(jl[i]);
		}
		this.add(confirm);
		this.add(cancel);
	}

	private void init() {
		jl[0].setText("汽运编号");
		jl[1].setText("装车日期");
		jl[2].setText("到达地");
		jl[3].setText("车辆代号");
		jl[4].setText("监运员");
		jl[5].setText("押运员");
		jl[6].setText("装车订单号");
		for (int i = 0; i < 7; i++) {
			jl[i].setBounds(frameWidth / 9, frameHeight / 15 + frameHeight / 8
					* i, 100, 65);
		}
		confirm.setBounds(frameWidth / 6, frameHeight * 9 / 10, 80, 30);
		cancel.setBounds(frameWidth * 2 / 5, frameHeight * 9 / 10, 80, 30);
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
			this.notifyWatchers(State.ZHONG_START);
		}
	}
}
