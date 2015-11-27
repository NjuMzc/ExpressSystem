package presentation.right.accountant;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
 


import javax.swing.*;

import presentation.right.RightAll;
import presentation.watcher.*;


public class AccountantCost extends RightAll implements  ActionListener{
	int frameWidth;
	int frameHeight;
	JLabel[] jl;
	JButton back;
	private List<Watcher> list;

	public AccountantCost(int frameWidth, int frameHeight) {

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
		back= new JButton("返回");
		back.addActionListener(this);
		 
		init();

		for (int i = 0; i < 5; i++) {
			this.add(jl[i]);
		}
		this.add(back);

	}

	private void init() {

		jl[0].setText("开始时间");
		jl[1].setText("结束时间");
		jl[2].setText("总收入");
		jl[3].setText("总支出");
		jl[4].setText("总利润");

		for (int i = 0; i < 5; i++) {
			jl[i].setBounds(frameWidth / 9, frameHeight / 15 + frameHeight / 8
					* i, 100, 65);
		}

		back.setMargin(new Insets(0, 0, 0, 0));
		back.setBounds(150, frameHeight - 100, frameWidth / 12,
				frameWidth / 20);
	}

	public void addWatcher(Watcher watcher) {
		// TODO Auto-generated method stub
		list.add(watcher);
	}

	public void removeWatcehr(Watcher watcher) {
		// TODO Auto-generated method stub
		list.remove(watcher);
	}

	public void notifyWatchers(State state) {
		for (Watcher watcher : list) {
			watcher.update(state);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) {
			this.notifyWatchers(State.ACCOUNTANTSTART);
		} 

	}
}
