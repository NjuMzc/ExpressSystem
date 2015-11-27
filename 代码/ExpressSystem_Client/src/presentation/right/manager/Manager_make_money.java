package presentation.right.manager;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import presentation.right.RightAll;
import presentation.watcher.*;

public class Manager_make_money extends RightAll implements 
		ActionListener {
	int frameWidth;
	int frameHeight;
	JLabel[] jl;
	JButton ok;
	JButton cancel;
	private List<Watcher> list;

	public Manager_make_money(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBackground(new Color(254, 67, 101));
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel[4];
		for (int i = 0; i < 4; i++) {
			jl[i] = new JLabel();
		}
		ok = new JButton("提交");
		cancel = new JButton("取消");

		init();

		for (int i = 0; i < 4; i++) {
			this.add(jl[i]);
		}
		this.add(ok);
		this.add(cancel);

	}

	private void init() {

		jl[0].setText("总经理");
		jl[1].setText("财务人员");
		jl[2].setText("快递员");
		jl[3].setText("业务员");

		for (int i = 0; i < 4; i++) {
			jl[i].setBounds(frameWidth / 10, frameHeight / 10 * (i + 1), 100,
					65);
		}

		ok.setBounds(frameWidth / 4, frameHeight / 5 * 4, 80, 30);
		ok.addActionListener(this);
		cancel.setBounds(frameWidth/2,frameHeight/5*4,80,30);
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
			this.notifyWatchers(State.MANAGERSTART);
		}
	}
}
