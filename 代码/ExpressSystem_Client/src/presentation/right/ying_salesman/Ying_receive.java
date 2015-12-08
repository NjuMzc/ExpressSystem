package presentation.right.ying_salesman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import presentation.right.RightAll;
import presentation.watcher.State;
import presentation.watcher.Watched;
import presentation.watcher.Watcher;

public class Ying_receive extends RightAll implements ActionListener {

	int frameWidth;
	int frameHeight;
	JLabel jl[];
	JButton confirm;
	JButton cancel;

	private List<Watcher> list;

	public Ying_receive(int frameWidth, int frameHeight) {
		this.frameHeight = frameHeight;
		this.frameWidth = frameWidth;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBackground(new Color(254, 67, 101));
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel[4];
		for (int i = 0; i < 4; i++) {
			jl[i] = new JLabel();
		}
		confirm = new JButton("");//确认
		cancel = new JButton("");//取消

		init();

		for (int i = 0; i < 4; i++) {
			this.add(jl[i]);
		}
		this.add(confirm);
		this.add(cancel);
	}
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\货物到达单right.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth/4*3,frameHeight,null);
	}
	
	private void init() {
		jl[0].setText("货物接收单");
		jl[1].setText("货物是否接收");
		jl[2].setText("接收方名称");
		jl[3].setText("货物接收状态");

		jl[0].setBounds(frameWidth / 2, frameHeight / 10, 100, 65);
		for (int i = 1; i < 4; i++) {
			jl[i].setBounds(frameWidth / 9, frameHeight / 15 + frameHeight / 8
					* i, 100, 65);
		}
		
		ImageIcon icon1 = new ImageIcon("pictures//取消t.png");
		Image temp1 = icon1.getImage().getScaledInstance(icon1.getIconWidth(),
				icon1.getIconHeight(), icon1.getImage().SCALE_DEFAULT);
		icon1 = new ImageIcon(temp1);
		cancel.setIcon(icon1);
		
		ImageIcon icon2 = new ImageIcon("pictures//确认小.png");
		Image temp2 = icon2.getImage().getScaledInstance(icon2.getIconWidth(),
				icon2.getIconHeight(), icon2.getImage().SCALE_DEFAULT);
		icon2 = new ImageIcon(temp2);
		confirm.setIcon(icon2);
		
		confirm.setBounds(frameWidth / 6, frameHeight * 5 / 10,  frameWidth / 9,
				frameHeight / 16);
		cancel.setBounds(frameWidth * 2 / 5+frameWidth/10, frameHeight *5 / 10, frameWidth / 9,
				frameHeight / 16);
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
			this.notifyWatchers(State.YING_START);
		}
	}
}
