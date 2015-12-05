package presentation.right.ying_salesman;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import presentation.right.RightAll;
import presentation.watcher.*;

public class Ying_collect extends RightAll implements ActionListener {

	int frameWidth;
	int frameHeight;
	JLabel jl[];
	JTextField jtf[];
	JButton confirm;
	JButton cancel;
	JButton over;

	private List<Watcher> list;

	public Ying_collect(int frameWidth, int frameHeight) {
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel[5];
		for (int i = 0; i < 5; i++) {
			jl[i] = new JLabel();
		}
		confirm = new JButton("确认");
		cancel = new JButton("取消");
		jtf = new JTextField[4];
		for (int i = 0; i < 4; i++) {
			jtf[i] = new JTextField();
		}
		over = new JButton("完成");

		init();

		for (int i = 0; i < 4; i++) {
			this.add(jl[i]);
		}
		this.add(confirm);
		this.add(cancel);
		for (int i = 0; i < 3; i++) {
			this.add(jtf[i]);
		}
	}

	private void init() {
		jl[0].setText("派件单");
		jl[1].setText("到达日期");
		jl[2].setText("托运单条形码");
		jl[3].setText("快递员编号");
		jl[4].setText("快递员姓名");

		jl[0].setBounds(frameWidth / 2, frameHeight / 10, frameWidth / 10,
				frameHeight / 20);
		for (int i = 1; i < 5; i++) {
			jl[i].setBounds(frameWidth / 10, frameHeight / 6 * i,
					frameWidth / 10, frameHeight / 20);
		}

		confirm.setBounds(frameWidth / 6, frameHeight * 9 / 10,
				frameWidth / 10, frameHeight / 20);
		confirm.addActionListener(this);
		cancel.setBounds(frameWidth * 2 / 5, frameHeight * 9 / 10,
				frameWidth / 10, frameHeight / 20);
		cancel.addActionListener(this);

		for (int i = 0; i < 4; i++) {
			jtf[i].setBounds(frameWidth / 4, frameHeight / 6 * (1 + i),
					frameWidth / 10, frameHeight / 20);
		}
		over.setBounds(frameWidth / 3, frameHeight * 9 / 10, frameWidth / 10,
				frameHeight / 20);
		over.addActionListener(this);
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
		} else if (e.getSource() == confirm) {
			this.remove(confirm);
			this.remove(cancel);
			this.add(over);
			this.add(jtf[3]);
			this.add(jl[4]);
			for (int i = 0; i < 4; i++) {
				jtf[i].setEditable(false);
			}
			this.repaint();
		}

		if (e.getSource() == over) {
			this.notifyWatchers(State.YING_START);
		}
	}
}
