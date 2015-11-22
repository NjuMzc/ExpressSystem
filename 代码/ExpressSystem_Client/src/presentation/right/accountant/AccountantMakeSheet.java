package presentation.right.accountant;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import presentation.watcher.State;
import presentation.watcher.Watched;
import presentation.watcher.Watcher;

public class AccountantMakeSheet extends JPanel implements Watched {

	int frameWidth;
	int frameHeight;
	JPanel input;
	JButton export;
	JLabel start;
	JLabel end;
	JPanel output;
	JLabel inmoney;

	private List<Watcher> list;

	public AccountantMakeSheet(int frameWidth, int frameheight) {
		this.frameHeight = frameheight;
		this.frameWidth = frameWidth;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBackground(new Color(254, 67, 101));
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		input = new JPanel();
		input.setBackground(Color.cyan);
		export = new JButton("导出报表");
		start = new JLabel("开始时间");
		end = new JLabel("结束时间");

		init();

		input.add(start);
		input.add(end);
		input.add(export);
		this.add(input);
	}

	private void init() {
		input.setBounds(0, 0, frameWidth / 3, frameHeight / 10 * 8);
		start.setBounds(frameWidth / 20, frameHeight / 20, 100, 65);
		end.setBounds(frameWidth / 20, frameHeight / 10, 100, 65);
		export.setBounds(frameWidth / 10, frameHeight / 10 * 7, 100, 30);
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
}
