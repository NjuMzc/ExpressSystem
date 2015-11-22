package presentation.right.manager;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import presentation.watcher.*;

public class Manager_find extends JPanel implements Watched, ActionListener {
	int frameWidth;
	int frameHeight;
	JLabel start;
	JLabel end;

	private List<Watcher> list;

	public Manager_find(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		start = new JLabel("开始");
		end = new JLabel("结束");

		this.setLayout(null);
		this.setBackground(new Color(254, 67, 101));
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		init();

		this.add(start);
		this.add(end);
	}

	private void init() {
		start.setBounds(frameWidth / 4, frameHeight / 10, 100, 30);
		end.setBounds(frameWidth / 2, frameHeight / 10, 100, 30);
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
