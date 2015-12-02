package presentation.right.manager;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import presentation.right.RightAll;
import presentation.watcher.*;

public class Manager_make_money extends RightAll implements ActionListener {
	int frameWidth;
	int frameHeight;
	JLabel[] jl;
	JLabel[] way1;
	JLabel[] way2;
	JLabel[] way3;
	JButton ok;
	JButton cancel;
	JRadioButton jradiobutton1[];
	JRadioButton jradiobutton2[];
	JRadioButton jradiobutton3[];
	JTextField jtf1[];
	JTextField jtf2[];
	JTextField jtf3[];
	ButtonGroup buttongroup[];
	private List<Watcher> list;

	public Manager_make_money(int frameWidth, int frameHeight) {

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
		ok = new JButton("提交");
		cancel = new JButton("取消");

		jradiobutton1 = new JRadioButton[7];
		jradiobutton2 = new JRadioButton[7];
		jradiobutton3 = new JRadioButton[3];
		buttongroup = new ButtonGroup[7];
		way1 = new JLabel[7];
		way2 = new JLabel[7];
		way3 = new JLabel[3];
		jtf1 = new JTextField[7];
		jtf2 = new JTextField[7];
		jtf3 = new JTextField[3];
		for (int i = 0; i < 7; i++) {
			jradiobutton1[i] = new JRadioButton("工资：");
			jradiobutton2[i] = new JRadioButton("提成：");
			buttongroup[i] = new ButtonGroup();
			way1[i] = new JLabel("元/月");
			way2[i] = new JLabel("%");
			jtf1[i] = new JTextField();
			jtf2[i] = new JTextField();
		}
		for (int i = 0; i < 3; i++) {
			jradiobutton3[i] = new JRadioButton("计次：");
			way3[i] = new JLabel("元/次 ");
			jtf3[i] = new JTextField();
		}

		init();

		for (int i = 0; i < 7; i++) {
			this.add(jl[i]);
			this.add(jradiobutton1[i]);
			this.add(jradiobutton2[i]);
			this.add(way1[i]);
			this.add(way2[i]);
			this.add(jtf1[i]);
			this.add(jtf2[i]);
		}
		for (int i = 0; i < 3; i++) {
			this.add(jradiobutton3[i]);
			this.add(way3[i]);
			this.add(jtf3[i]);
		}

		this.add(ok);
		this.add(cancel);

	}

	private void init() {

		jl[0].setText("总经理");
		jl[1].setText("管理员");
		jl[2].setText("财务人员");
		jl[3].setText("仓库管理员");
		jl[4].setText("快递员");
		jl[5].setText("营业厅业务员");
		jl[6].setText("中转中心业务员 ");

		for (int i = 0; i < 7; i++) {
			jl[i].setBounds(frameWidth / 21, frameHeight / 10 * (i + 1),
					frameWidth / 8, frameHeight / 20);
			jradiobutton1[i].setBounds(frameWidth / 40 * 6, frameHeight / 10
					* (i + 1), frameWidth / 12, frameHeight / 20);
			jradiobutton2[i].setBounds(frameWidth / 30 * 11, frameHeight / 10
					* (i + 1), frameWidth / 12, frameHeight / 20);
			way1[i].setBounds(frameWidth / 40 * 13, frameHeight / 10 * (i + 1),
					frameHeight / 20, frameHeight / 20);
			way2[i].setBounds(frameWidth / 2 + frameWidth / 60, frameHeight
					/ 10 * (i + 1), frameHeight / 20, frameHeight / 20);
			jtf1[i].setBounds(frameWidth / 120 * 31,
					frameHeight / 10 * (i + 1), frameWidth / 15,
					frameHeight / 20);
			jtf2[i].setBounds(frameWidth / 20 * 9, frameHeight / 10 * (i + 1),
					frameWidth / 15, frameHeight / 20);
		}

		for (int i = 0; i < 3; i++) {
			jradiobutton3[i].setBounds(frameWidth / 2 + frameWidth / 20,
					frameHeight / 10 * (i + 5), frameWidth / 12,
					frameHeight / 20);
			way3[i].setBounds(frameWidth / 30 * 23, frameHeight / 10 * (i + 5),
					frameHeight / 20, frameHeight / 20);
			jtf3[i].setBounds(frameWidth / 32 * 21, frameHeight / 10 * (i + 5),
					frameWidth / 15, frameHeight / 20);
		}

		for (int i = 0; i < 4; i++) {
			buttongroup[i].add(jradiobutton1[i]);
			buttongroup[i].add(jradiobutton2[i]);
		}
		for (int i = 4; i < 7; i++) {
			buttongroup[i].add(jradiobutton1[i]);
			buttongroup[i].add(jradiobutton2[i]);
			buttongroup[i].add(jradiobutton3[i - 4]);
		}

		ok.setBounds(frameWidth / 4, frameHeight / 5 * 4, 80, 30);
		ok.addActionListener(this);
		cancel.setBounds(frameWidth / 2, frameHeight / 5 * 4, 80, 30);
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
