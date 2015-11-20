package client.presentation.right.manager;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import client.presentation.watcher.*;

public class Manager_make_constant extends JPanel implements Watched,
		ActionListener {
	int frameWidth;
	int frameHeight;
    JLabel remind;
	private List<Watcher> list;

	public Manager_make_constant(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();
		
		remind=new JLabel("I don't know how to imlpement this");

		this.setLayout(null);
		this.setBackground(new Color(254, 67, 101));
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		init();

		this.add(remind);
	}

	private void init() {
        remind.setBounds(frameWidth/2,frameHeight/2,100,60);
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
