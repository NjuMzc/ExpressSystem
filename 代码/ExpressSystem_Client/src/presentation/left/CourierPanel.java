package presentation.left;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import presentation.Data;
import presentation.watcher.*;

public class CourierPanel extends LeftAll implements  ActionListener {

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

	public CourierPanel(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(0, 0, frameWidth / 4, frameHeight);

		jb = new JButton[3];
		for (int i = 0; i < 3; i++) {
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
		for (int i = 0; i < 3; i++) {
			this.add(jb[i]);
		}
		this.add(logout);
		this.add(close);


	}
	
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\courierleft.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth/4,frameHeight,null);
	}

	private void init() {
		for (int i = 0; i < 3; i++) {
			jb[i] = new JButton();
		jb[i].setBounds(0, frameHeight / 3 + frameHeight / 13 * i,
					frameWidth / 4, frameHeight / 13);
		jb[i].setContentAreaFilled(false);
			jb[i].addActionListener(this);
		}
		jb[0].setText("");//制作订单
		jb[1].setText("");//查询订单
		jb[2].setText("");//收件

		logout.setMargin(new Insets(0, 0, 0, 0));
		logout.setBounds(frameWidth*3/80, frameHeight *63/72,frameWidth/17, frameWidth/17);
		logout.addActionListener(this);
		close.setMargin(new Insets(0, 0, 0, 0));
		close.setBounds(frameWidth*13/80, frameHeight *63/72,frameWidth/17, frameWidth/17);
		close.addActionListener(this);

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
		// TODO Auto-generated method stub
		for (Watcher watcher : list) {
			watcher.update(state);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb[2]) {
			this.notifyWatchers(State.COURIERINPUTINFOR);
		} else if (e.getSource() == jb[0]) {
			this.notifyWatchers(State.COURIERMAKEBILL);
		} else if (e.getSource() == jb[1]) {
			this.notifyWatchers(State.COURIERSEARCH);
		}

		if (e.getSource() == logout) {
			this.notifyWatchers(State.LOGOUT);
		}else if(e.getSource()==close){
			System.exit(0);
		}
	}
}
