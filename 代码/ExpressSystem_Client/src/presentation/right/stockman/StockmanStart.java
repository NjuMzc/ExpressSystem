package presentation.right.stockman;

import java.awt.Color;

import javax.swing.*;

import presentation.right.RightAll;
import presentation.watcher.State;
import presentation.watcher.Watched;
import presentation.watcher.Watcher;

public class StockmanStart extends RightAll   {
	int frameWidth;
	int frameHeight;
	JLabel jl;

	public StockmanStart(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel("start");

		init();

		this.setBackground(new Color(254, 67, 101));
		this.add(jl);

	}

	private void init() {
		jl.setBounds(320, 320, 300, 300);
		jl.setText("start");
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
