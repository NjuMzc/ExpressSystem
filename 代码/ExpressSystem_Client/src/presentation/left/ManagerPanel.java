package presentation.left;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import presentation.Data;
import presentation.watcher.*;

public class ManagerPanel extends LeftAll implements ActionListener {

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

	public ManagerPanel(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(0, 0, frameWidth / 4, frameHeight);

		jb = new JButton[5];
		for (int i = 0; i < 5; i++) {
			jb[i] = new JButton();
		}
		logout = new JButton("");//登出系统
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
		ImageIcon background = new ImageIcon("pictures\\manageleft.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth/4,frameHeight,null);
	}
	
	private void init() {
		for (int i = 0; i < 5; i++) {
			jb[i] = new JButton();
			jb[i].setBounds(0, frameHeight / 3 + frameHeight / 13 * i,
					frameWidth / 4, frameHeight / 13);
			jb[i].addActionListener(this);
			jb[i].setContentAreaFilled(false);
	//		jb[i].setBorderPainted(false);
		}
		jb[0].setText("");//人员机构管理
		jb[1].setText("");//制定薪水
		jb[2].setText("");//制定常量
		jb[3].setText("");//审批单据
		jb[4].setText("");//查看报表

		logout.setMargin(new Insets(0, 0, 0, 0));
		logout.setBounds(frameWidth*3/80, frameHeight *63/72,frameWidth/17, frameWidth/17);
		logout.addActionListener(this);
		close.setMargin(new Insets(0, 0, 0, 0));
		close.setBounds(frameWidth *13/ 80, frameHeight *63/72,frameWidth/17 , frameWidth/17);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb[0]) {
			this.notifyWatchers(State.MANAGERMANAGE);
		} else if (e.getSource() == jb[1]) {
			this.notifyWatchers(State.MANAGERMAKEMONEY);
		} else if (e.getSource() == jb[2]) {
			this.notifyWatchers(State.MANAGERMAKECONSTANT);
		} else if (e.getSource() == jb[3]) {
			this.notifyWatchers(State.MANAGERCHECK);
		} else if (e.getSource() == jb[4]) {
			this.notifyWatchers(State.MANAGERFIND);
		}

		if (e.getSource() == logout) {
			this.notifyWatchers(State.LOGOUT);
		} else if (e.getSource() == close) {
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