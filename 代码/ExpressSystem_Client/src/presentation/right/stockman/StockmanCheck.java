package presentation.right.stockman;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import presentation.watcher.*;

public class StockmanCheck extends JPanel implements Watched, ActionListener {
	int frameWidth;
	int frameHeight;
	JLabel[] jl;
	JButton back;
	private List<Watcher> list;

	public StockmanCheck(int frameWidth, int frameHeight) {

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
		back = new JButton("返回");

		init();

		for (int i = 0; i < 7; i++) {
			this.add(jl[i]);
		}
		this.add(back);

	}

	private void init() {

		jl[0].setText("快递编号");
		jl[1].setText("入库日期");
		jl[2].setText("目的地");
		jl[3].setText("区号");
		jl[4].setText("排号");
		jl[5].setText("架号");
		jl[6].setText("位号");

		for (int i = 0; i < 7; i++) {
			jl[i].setBounds(frameWidth / 10 * (i + 1), frameHeight / 10, 100, 65);
		}

		back.setBounds(frameWidth / 4, frameHeight / 5 * 4, 80, 30);
		back.addActionListener(this);
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
			this.notifyWatchers(State.STOCKMANSTART);
		}
	}
}
