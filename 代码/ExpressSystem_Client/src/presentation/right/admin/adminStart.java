package presentation.right.admin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.*;

import presentation.right.RightAll;
import presentation.watcher.State;
import presentation.watcher.Watched;
import presentation.watcher.Watcher;

public class adminStart extends RightAll  {

	int frameWidth;
	int frameHeight;
	JLabel jl;

	public adminStart(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		//jl = new JLabel("");

		//init();

		this.setBackground(new Color(254, 67, 101));
		//this.add(jl);

	}
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\系统管理startRight.png");
		Image bg =background.getImage();
		g.drawImage(bg, 0, 0,frameWidth*3/4,frameHeight,null);
	}

	private void init() {
		//jl.setBounds(320, 320, 300, 300);
		//jl.setText("start");
	}

	@Override
	public void addWatcher(Watcher watcher) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeWatcehr(Watcher watcher) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyWatchers(State state) {
		// TODO Auto-generated method stub
		
	}
}
