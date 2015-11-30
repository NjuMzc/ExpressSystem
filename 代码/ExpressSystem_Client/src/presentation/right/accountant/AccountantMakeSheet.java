package presentation.right.accountant;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import presentation.right.RightAll;
import presentation.watcher.State;
import presentation.watcher.Watched;
import presentation.watcher.Watcher;

//制作报表
public class AccountantMakeSheet extends RightAll {

	int frameWidth;
	int frameHeight;
	JPanel input;
	JButton export;
	JLabel start;
	JLabel end;
	JComboBox<String>[] startbox;
	JComboBox<String>[] endbox;
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
		startbox = new JComboBox[3];
		endbox = new JComboBox[3];

		init();

		for (int i = 0; i < 3; i++) {
			input.add(startbox[i]);
		}
		for (int i = 0; i < 3; i++) {
			input.add(endbox[i]);
		}
		input.add(start);
		input.add(end);
		input.add(export);
		this.add(input);
	}

	private void init() {
		String[] modelYear = { "2015", "2016", "2017", "2018", "2019", "2020" };
		String[] modelMonth = { "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "11", "12" };
		String[] modelDay = { "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
				"20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
				"30", "31" };
		for (int i = 0; i < 3; i++) {
			if (i == 0) {
				startbox[i] = new JComboBox<String>(modelYear);
				endbox[i] = new JComboBox<String>(modelYear);
			} else if (i == 1) {
				startbox[i] = new JComboBox<String>(modelMonth);
				endbox[i] = new JComboBox<String>(modelMonth);
			} else {
				startbox[i] = new JComboBox<String>(modelDay);
				endbox[i] = new JComboBox<String>(modelDay);
			}
		}
		for (int i = 0; i < 3; i++) {
			startbox[i].setBounds(frameWidth / 15 * (i + 2), frameWidth / 20,
					frameWidth / 15, frameWidth / 30);
		}
		for (int i = 0; i < 3; i++) {
			endbox[i].setBounds(frameWidth / 15 * (i + 2), frameWidth / 10,
					frameWidth / 15, frameWidth / 30);
		}

		input.setLayout(null);
		input.setBounds(0, 0, frameWidth / 3, frameHeight );
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
