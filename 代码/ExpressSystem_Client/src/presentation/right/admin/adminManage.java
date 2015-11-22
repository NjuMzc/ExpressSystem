package presentation.right.admin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import presentation.watcher.*;

public class adminManage extends JPanel implements Watched, ActionListener {
	int frameWidth;
	int frameHeight;
	JLabel remind;
	JButton add;
	JButton cancel;
	JTextField jtf;
	private List<Watcher> list;

	public adminManage(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBackground(new Color(254, 67, 101));
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		remind = new JLabel("账户名");
		add = new JButton("添加");
		cancel = new JButton("取消");
		jtf = new JTextField(20);

		init();

		this.add(remind);
		this.add(add);
		this.add(cancel);
		this.add(jtf);
	}

	private void init() {
		remind.setBounds(frameWidth / 4, frameHeight / 3, frameWidth / 4, 40);
		jtf.setBounds(frameWidth /5*2, frameHeight / 3, 200, 40);
		add.setBounds(frameWidth / 4, frameHeight / 2, frameWidth / 12,
				frameWidth / 20);
		add.addActionListener(this);
		cancel.setBounds(frameWidth / 2, frameHeight / 2, frameWidth / 12,
				frameWidth / 20);
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
			this.notifyWatchers(State.ADMINSTART);
		} else if (e.getSource() == add) {
            
			
		}

	}
}