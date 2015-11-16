package client.presentation.billsui.log;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import client.presentation.Data;
import client.presentation.billsui.watcher.State;
import client.presentation.billsui.watcher.Watched;
import client.presentation.billsui.watcher.Watcher;

public class Cover extends JPanel implements Watched,ActionListener {
 
	int frameWidth;
	int frameHeight;
	JLabel remind;
	JButton system;
	JButton customer;
	private List<Watcher> list;

	public Cover(int frameWidth, int frameHeight) {
		 
		this.frameWidth =frameWidth;
		this.frameHeight = frameHeight;
		
		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(0, 0, frameWidth, frameHeight);
		this.setBackground(new Color(248, 147, 69));

		remind = new JLabel("快递物流系统");
		system = new JButton("系统登录");
		customer = new JButton("客户登录");

		init();

		this.add(remind);
		this.add(system);
		this.add(customer);
	}

	private void init() {
		Font f=new Font("",Font.BOLD,45);
		remind.setFont(f);
		remind.setBounds(frameWidth / 3, frameHeight / 4, frameWidth / 3,
				frameWidth / 18);
		
		system.setMargin(new Insets(0, 0, 0, 0));
		system.setFont(new Font( "",Font.BOLD,20));
		system.setBounds(frameWidth / 3, frameHeight / 2, frameWidth / 3,
				frameWidth / 12);
		system.addActionListener(this);
		customer.setMargin(new Insets(0, 0, 0, 0));
		customer.setFont(new Font( "",Font.BOLD,20));
		customer.setBounds(frameWidth / 3, frameHeight * 3 / 4, frameWidth / 3,
				frameWidth / 12);
		customer.addActionListener(this);
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
		 if(e.getSource()==system){
			 this.notifyWatchers(State.LOGMAINFRAME);
		 }
		
	}
}
