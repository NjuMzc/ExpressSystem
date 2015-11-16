package client.presentation.billsui.right.zhong_salesman;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import client.presentation.billsui.watcher.State;
import client.presentation.billsui.watcher.Watched;
import client.presentation.billsui.watcher.Watcher;

public class Zhong_arrival extends JPanel implements Watched,ActionListener{

	int frameWidth;
	int frameHeight;
	JLabel jl[];
	JButton end;
	JButton cancel;
	private List<Watcher> list;

	public Zhong_arrival(int frameWidth, int frameHeight) {
		this.frameHeight = frameHeight;
		this.frameWidth = frameWidth;

		list=new ArrayList<Watcher>();
		
		this.setLayout(null);
		this.setBackground(new Color(254, 67, 101));
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel[6];
		for (int i = 0; i < 5; i++) {
			jl[i] = new JLabel();
		}

		end = new JButton("完成");
		cancel = new JButton("取消");

		init();

		for (int i = 0; i < 5; i++) {
			this.add(jl[i]);
		}
		this.add(cancel);
		this.add(end);
	}

	private void init() {

		jl[0].setText("中转中心编号");
		jl[1].setText("到达日期");
		jl[2].setText("中转单编号");
		jl[3].setText("出发地");
		jl[4].setText("货物到达状态");
		for (int i = 0; i < 5; i++) {
			jl[i].setBounds(frameWidth / 6, frameHeight / 10 + frameHeight / 8
					* i, 100, 65);
		}
		end.setBounds(frameWidth / 6,frameHeight*4/5,80,30);
		cancel.setBounds(frameWidth/3,frameHeight*4/5,80,30);
		cancel.addActionListener(this);
	}

	public void addWatcher(Watcher watcher) {
		list.add(watcher);
	}

	public void removeWatcehr(Watcher watcher) {
		 list.remove(watcher);
	}

	public void notifyWatchers(State state) {
		System.out.println("2");
		for (Watcher watcher : list) {
			watcher.update(state);
		}

	}

	public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==cancel){
			 System.out.println("1");
			 this.notifyWatchers(State.ZHONG_START);
		 }
		
	}
}
