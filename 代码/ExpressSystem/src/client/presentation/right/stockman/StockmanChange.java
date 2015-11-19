package client.presentation.right.stockman;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import client.presentation.watcher.*;

public class StockmanChange extends JPanel implements Watched, ActionListener {
	int frameWidth;
	int frameHeight;
	JLabel[] jl;
	JButton[] jb;
	JButton change;
	JPanel jp1;
	JPanel jp2;
	boolean isOnePanel = true;
	private List<Watcher> list;

	public StockmanChange(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBackground(new Color(254, 67, 101));
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel[5];
		for (int i = 0; i < 5; i++) {
			jl[i] = new JLabel();
		}
		jb = new JButton[4];
		for (int i = 0; i < 4; i++) {
			jb[i] = new JButton("分区调整");
		}
		change = new JButton("change");
		jp1 = new JPanel();
		jp2 = new JPanel();

		init();

		this.add(jl[0]);
		this.add(change);
		jp1.add(jl[1]);
		jp1.add(jl[2]);
		jp1.add(jb[0]);
		jp1.add(jb[1]);
		
		jp2.add(jl[3]);
		jp2.add(jl[4]);
		jp2.add(jb[2]);
		jp2.add(jb[3]);

		this.add(jp1);
	}

	private void init() {

		jl[0].setText("快递编号");
		jl[1].setText("航运区");
		jl[2].setText("铁运区");
		jl[3].setText("汽运区");
		jl[4].setText("机动区 ");

		jl[0].setBounds(frameWidth / 3, 0, 100, 65);
		change.setBounds(frameWidth / 3, frameHeight / 11 * 10, 100, 30);
		change.addActionListener(this);

		jp1.setBounds(0, frameHeight / 10, frameWidth / 4 * 3,
				frameHeight / 5 * 4);
		jp1.setBackground(Color.cyan);
		jp2.setBounds(0, frameHeight / 10, frameWidth / 4 * 3,
				frameHeight / 5 * 4);
		jp2.setBackground(Color.gray);
		jl[1].setBounds(frameWidth / 4, frameHeight / 10, 100, 65);
		jl[2].setBounds(frameWidth / 2, frameHeight / 10, 100, 65);
		jb[0].setBounds(frameWidth / 4, frameHeight * 3 / 5, 100, 30);
		jb[1].setBounds(frameWidth / 2, frameHeight * 3 / 5, 100, 30);
		jl[3].setBounds(frameWidth / 4, frameHeight / 10, 100, 65);
		jl[4].setBounds(frameWidth / 2, frameHeight / 10, 100, 65);
		jb[2].setBounds(frameWidth / 4, frameHeight * 3 / 5, 100, 30);
		jb[3].setBounds(frameWidth / 2, frameHeight * 3 / 5, 100, 30);
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
		if (e.getSource() == change) {
			if (isOnePanel) {
				this.remove(jp1);
				this.add(jp2);
				repaint();
				isOnePanel=false;
			} else {
				this.remove(jp2);
				this.add(jp1);
				repaint();
				isOnePanel=true;
			}
		}
	}
}
