package presentation.log;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import presentation.right.RightAll;
import presentation.watcher.*;

public class LogSearch extends RightAll implements ActionListener {

	int frameWidth;
	int frameHeight;
	JLabel remind;
	JButton confirm;
	JButton back;
	JTextField jtf;
	JPanel addPanel;
	private List<Watcher> list;

	public LogSearch(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(0, 0, frameWidth, frameHeight);

		remind = new JLabel("请输入快递单号");
		confirm = new JButton("确认");
		back = new JButton("返回");
		jtf = new JTextField();

		init();

		this.add(remind);
		this.add(confirm);
		this.add(back);
		this.add(jtf);
	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\背景.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth, frameHeight, null);
	}

	private void init() {
		remind.setBounds(frameWidth / 3, frameHeight / 5, frameWidth / 10,
				frameHeight / 20);
		confirm.setBounds(frameWidth / 3 * 2, frameHeight / 5, frameWidth / 10,
				frameWidth / 20);
		confirm.addActionListener(this);
		back.setBounds(frameWidth / 2, frameHeight / 10 * 9, frameWidth / 10,
				frameHeight / 20);
		back.addActionListener(this);
		jtf.setBounds(frameWidth / 2, frameHeight / 5, frameWidth / 10,
				frameHeight / 20);

	}

	private void initAddPanel(int num) {
		if (addPanel != null) {
			this.remove(addPanel);
		}
		addPanel = new JPanel();
		JLabel stateGoods = new JLabel("货物状态");
		JLabel traceGoods = new JLabel("货物轨迹");
		JLabel state = new JLabel();

		JLabel trace[];
		trace = new JLabel[num];
		for (int i = 0; i < num; i++) {
			trace[i] = new JLabel();
			trace[i].setText("南京到北京");
		}
		
		//根据货物状态设置文字
		state.setText("即将到达");

		addPanel.setBounds(frameWidth / 3, frameHeight / 3, frameWidth / 2,
				frameHeight / 2);
		addPanel.setLayout(null);
		this.setOpaque(false);
		stateGoods.setBounds(0, 0, frameWidth / 10, frameHeight / 20);
		traceGoods.setBounds(0, frameHeight / 10, frameWidth / 10,
				frameHeight / 20);
		for (int i = 0; i < num; i++) {
			trace[i].setBounds(frameWidth / 8, frameHeight / 10 + frameWidth
					/ 20 * i, frameWidth / 5, frameHeight / 20);
		}
		state.setBounds(frameWidth / 8, 0, frameWidth / 10, frameHeight / 20);

		addPanel.add(stateGoods);
		addPanel.add(traceGoods);
		for (int i = 0; i < num; i++) {
			addPanel.add(trace[i]);
		}
		addPanel.add(state);
		this.add(addPanel);
		this.repaint();
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
		if (e.getSource() == back) {
			this.notifyWatchers(State.COVER);
		} else if (e.getSource() == confirm) {
			initAddPanel(5);
		}

	}
}
