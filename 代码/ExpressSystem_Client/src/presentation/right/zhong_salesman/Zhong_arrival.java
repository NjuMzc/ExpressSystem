package presentation.right.zhong_salesman;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import presentation.right.RightAll;
import presentation.watcher.State;
import presentation.watcher.Watched;
import presentation.watcher.Watcher;

public class Zhong_arrival extends RightAll implements ActionListener {

	int frameWidth;
	int frameHeight;
	JTextField jtf[];
	JLabel remind[];
	JLabel time[];
	JComboBox<String>[] timeInput;
	JButton confirm;
	JButton cancel;
	JRadioButton state[];
	ButtonGroup bg;
	private List<Watcher> list;

	public Zhong_arrival(int frameWidth, int frameHeight) {
		this.frameHeight = frameHeight;
		this.frameWidth = frameWidth;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		remind = new JLabel[6];
		for (int i = 0; i < 6; i++) {
			remind[i] = new JLabel();
		}
		jtf = new JTextField[4];
		for (int i = 0; i < 4; i++) {
			jtf[i] = new JTextField();
		}
		time = new JLabel[3];
		timeInput = new JComboBox[3];
		for (int i = 0; i < 3; i++) {
			time[i] = new JLabel();
		}
		String[] year = { "2015", "2016", "2017", "2018", "2019", "2020" };
		String[] month = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12" };
		String[] day = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
				"21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
				"31" };
		timeInput[0] = new JComboBox<String>(year);
		timeInput[1] = new JComboBox<String>(month);
		timeInput[2] = new JComboBox<String>(day);

		confirm = new JButton("确认");
		cancel = new JButton("取消");

		state = new JRadioButton[3];
		state[0] = new JRadioButton("完好");
		state[1] = new JRadioButton("丢失");
		state[2] = new JRadioButton("破损");
		bg = new ButtonGroup();

		init();

		this.add(cancel);
		this.add(confirm);
		for (int i = 0; i < 4; i++) {
			this.add(jtf[i]);
		}
		for (int i = 0; i < 6; i++) {
			this.add(remind[i]);
		}
		for (int i = 0; i < 3; i++) {
			this.add(time[i]);
			this.add(timeInput[i]);
			this.add(state[i]);
		}
	}

	private void init() {

		confirm.setBounds(frameWidth / 6, frameHeight * 9 / 10, 80, 30);
		cancel.setBounds(frameWidth * 2 / 5, frameHeight * 9 / 10, 80, 30);
		cancel.addActionListener(this);

		remind[0].setText("中转中心编号");
		remind[1].setText("到达日期");
		remind[2].setText("货物编号");
		remind[3].setText("中转单编号");
		remind[4].setText("出发地");
		remind[5].setText("货物到达状态");
		for (int i = 0; i < 6; i++) {
			remind[i].setBounds(frameWidth / 10, frameHeight / 10 * (i + 1),
					frameWidth / 10, frameHeight / 20);
		}

		jtf[0].setBounds(frameWidth / 4, frameHeight / 10, frameWidth / 10,
				frameHeight / 20);
		jtf[1].setBounds(frameWidth / 4, frameHeight / 10 * 3, frameWidth / 10,
				frameHeight / 20);
		jtf[2].setBounds(frameWidth / 4, frameHeight / 10 * 4, frameWidth / 10,
				frameHeight / 20);
		jtf[3].setBounds(frameWidth / 4, frameHeight / 10 * 5, frameWidth / 10,
				frameHeight / 20);

		time[0].setText("年");
		time[1].setText("月");
		time[2].setText("日");
		for (int i = 0; i < 3; i++) {
			timeInput[i].setBounds(frameWidth / 4 + frameWidth / 10 * i,
					frameHeight / 5, frameWidth / 12, frameHeight / 20);
			time[i].setBounds(frameWidth / 3 + frameWidth / 10 * i,
					frameHeight / 5, frameWidth / 12, frameHeight / 20);
		}

		for (int i = 0; i < 3; i++) {
			state[i].setBounds(frameWidth / 4 + frameWidth / 10 * i,
					frameHeight / 5 * 3, frameWidth / 10, frameHeight / 20);
		}

		bg.add(state[0]);
		bg.add(state[1]);
		bg.add(state[2]);

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
