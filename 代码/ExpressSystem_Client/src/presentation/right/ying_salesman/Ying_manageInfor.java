package presentation.right.ying_salesman;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.watcher.State;
import presentation.watcher.Watched;
import presentation.watcher.Watcher;

public class Ying_manageInfor extends JPanel implements Watched, ActionListener {

	int frameWidth;
	int frameHeight;
	JLabel jl;
	JButton confirm;

	private List<Watcher> list;

	public Ying_manageInfor(int frameWidth, int frameHeight) {
		this.frameHeight = frameHeight;
		this.frameWidth = frameWidth;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBackground(new Color(254, 67, 101));
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel("司机/车辆编号");
		confirm = new JButton("确认");

		init();

		this.add(jl);
		this.add(confirm);
	}

	private void init() {

		jl.setBounds(frameWidth / 2, frameHeight / 10, 100, 65);

		confirm.setBounds(frameWidth / 6, frameHeight * 9 / 10, 80, 30);

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