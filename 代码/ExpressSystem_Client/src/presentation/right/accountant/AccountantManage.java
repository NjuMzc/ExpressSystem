package presentation.right.accountant;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import presentation.watcher.*;

public class AccountantManage extends JPanel implements Watched, ActionListener {
	int frameWidth;
	int frameHeight;
	JLabel[] jl;
	private List<Watcher> list;

	public AccountantManage(int frameWidth, int frameHeight) {

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

		init();

		for (int i = 0; i < 4; i++) {
			this.add(jl[i]);
		}

	}

	private void init() {

		jl[0].setText("输入关键字");
		jl[1].setText("账户名称");
		jl[2].setText("账户号");
		jl[3].setText("余额");

		jl[0].setBounds(frameWidth / 4, frameHeight / 10, 100, 65);
		for (int i = 1; i < 4; i++) {
			jl[i].setBounds(frameWidth / 8 * (i + 1), frameHeight / 4, 100, 65);
		}

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
