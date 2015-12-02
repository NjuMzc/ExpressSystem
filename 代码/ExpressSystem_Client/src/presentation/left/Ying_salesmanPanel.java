package presentation.left;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import businesslogicservice.systemblservice.systemServer;
import presentation.Data;
import presentation.watcher.*;

public class Ying_salesmanPanel extends LeftAll implements  
		ActionListener {

	private List<Watcher> list;
	int frameWidth;
	int frameHeight;
	JButton[] jb;
	JButton logout;
	JButton close;
	JPanel picture;
	JLabel name;
	JLabel num;
	JLabel photo;

	JButton arrival;
	JButton receive;
	boolean isSamll = true;

	public Ying_salesmanPanel(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(0, 0, frameWidth / 4, frameHeight);

		jb = new JButton[5];
		for (int i = 0; i < 5; i++) {
			jb[i] = new JButton();
		}
		logout = new JButton("");//登出账号
		close = new JButton("");//关闭系统
	       logout.setContentAreaFilled(false);
	       close.setContentAreaFilled(false);
	       logout.setBorderPainted(false);
	       close.setBorderPainted(false);

		init();

		this.setBackground(new Color(248, 147, 69));
		for (int i = 0; i < 5; i++) {
			this.add(jb[i]);
		}
		this.add(logout);
		this.add(close);

	}
	
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\yingleft.png");
		Image bg =background.getImage();
		g.drawImage(bg, 0, 0,frameWidth/4,frameHeight,null);
	}
	
	private void init() {
		for (int i = 0; i < 5; i++) {
			jb[i] = new JButton();
			jb[i].setBounds(0, frameHeight / 3 + frameHeight / 13 * i,
					frameWidth / 4, frameHeight / 13);
			jb[i].setContentAreaFilled(false);
			jb[i].addActionListener(this);
		}
		jb[0].setText("");//收件
		jb[1].setText("");//派件
		jb[2].setText("");//信息管理
		jb[3].setText("");//装运管理
		jb[4].setText("");//建立收款单

		logout.setMargin(new Insets(0, 0, 0, 0));
		logout.setBounds(frameWidth*3/80, frameHeight *63/72,frameWidth/17, frameWidth/17);
		close.setMargin(new Insets(0, 0, 0, 0));
		close.setBounds(frameWidth*13/80, frameHeight *63/72,frameWidth/17, frameWidth/17);
       logout.addActionListener(this);
       close.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb[0]) {
			this.notifyWatchers(State.YING_COLLECT);
		} else if (e.getSource() == jb[1]) {
			if (isSamll) {
				arrival = new JButton("货物到达单");
				arrival.addActionListener(this);
				receive = new JButton("货物接收单");
				receive.addActionListener(this);
				arrival.setBounds(frameWidth / 16, frameHeight / 3
						+ frameHeight / 15 * 2, frameWidth / 16 * 3,
						frameHeight / 30);
				receive.setBounds(frameWidth / 16, frameHeight / 3
						+ frameHeight / 15 * 2 + frameHeight / 30,
						frameWidth / 16 * 3, frameHeight / 30);
				this.add(arrival);
				this.add(receive);
				for (int i = 2; i < 5; i++) {
					jb[i].setBounds(0, frameHeight / 3 + frameHeight / 13
							* (i + 1), frameWidth / 4, frameHeight / 13);
				}
				this.isSamll = false;
			} else {
				this.remove(arrival);
				this.remove(receive);
				for (int i = 2; i < 5; i++) {
					jb[i].setBounds(0, frameHeight / 3 + frameHeight / 13 * i,
							frameWidth / 4, frameHeight / 13);
				}
				this.isSamll = true;
			}
		} else if (e.getSource() == jb[2]) {
			this.notifyWatchers(State.YING_MANAGEINFOR);
		} else if (e.getSource() == jb[3]) {
			this.notifyWatchers(State.YING_PAYMENT);
		} else if (e.getSource() == jb[4]) {
			this.notifyWatchers(State.YING_LOADING);
		}

		if (e.getSource() == arrival) {
			this.notifyWatchers(State.YING_ARRIVE);
		} else if (e.getSource() == receive) {
			this.notifyWatchers(State.YING_RECEIVE);
		}

		if(e.getSource()==logout){
			this.notifyWatchers(State.LOGOUT);
		}
		else if(e.getSource()==close){
			System.exit(0);
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
}