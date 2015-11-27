package presentation.log;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import presentation.watcher.*;

public class LogSearch extends JPanel implements Watched, ActionListener {

	int frameWidth;
	int frameHeight;
	JLabel remind;
	JButton confirm;
	JButton back;
	private List<Watcher> list;

	public LogSearch(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBackground(new Color(254, 67, 101));
		this.setBounds(0, 0, frameWidth, frameHeight);

		remind = new JLabel("快递单号");
		confirm = new JButton("确认");
		back = new JButton("返回");

		init();

		this.add(remind);
		this.add(confirm);
		this.add(back);
	}
	//添加背景
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\背景.png");
		Image bg =background.getImage();
		g.drawImage(bg, 0, 0, null);
	
	}
	private void init() {
		remind.setBounds(frameWidth / 4, frameHeight / 6, frameWidth / 4, 40);
		confirm.setBounds(frameWidth / 2, frameHeight / 6, frameWidth / 12,
				frameWidth / 20);
		confirm.addActionListener(this);
		back.setBounds(frameWidth / 2, frameHeight / 4 * 3, frameWidth / 12,
				frameWidth / 20);
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
			this.notifyWatchers(State.COVER);
		} else if (e.getSource() == confirm) {

		}

	}
}
