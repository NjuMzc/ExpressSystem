package presentation.right.courier;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

import presentation.Data;
import presentation.right.RightAll;
import presentation.watcher.State;
import presentation.watcher.Watched;
import presentation.watcher.Watcher;

public class StartPanel extends RightAll   {

	int frameWidth;
	int frameHeight;
	JLabel jl;

	public StartPanel(int frameWidth, int frameHeight) {
	 
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);


		init();

		this.setBackground(new Color(254,67,101));


	}
	
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\系统管理startRight.png");
		Image bg =background.getImage();
		g.drawImage(bg, 0, 0,frameWidth*3/4,frameHeight,null);
	}

	private void init() {
		
	}

	@Override
	public void addWatcher(Watcher watcher) {
		 
	}

	@Override
	public void removeWatcehr(Watcher watcher) {
		 
	}

	@Override
	public void notifyWatchers(State state) {
		 
	}
}
