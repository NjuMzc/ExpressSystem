package presentation.right.stockman;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import presentation.watcher.*;

public class StockmanSearch extends JPanel implements Watched,ActionListener{
	int frameWidth;
	int frameHeight;
	JLabel[] jl;
	JButton search;
	private List<Watcher> list;

	public StockmanSearch(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBackground(new Color(254, 67, 101));
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel[2];
		for (int i = 0; i < 2; i++) {
			jl[i] = new JLabel();
		}
		search=new JButton("查询");

		init();

		for (int i = 0; i <2; i++) {
			this.add(jl[i]);
		}
		this.add(search);

	}

	private void init() {

		jl[0].setText("起始时间");
		jl[1].setText("中止时间 ");
		 
		for (int i = 0; i < 2; i++) {
			jl[i].setBounds(frameWidth / 8+frameWidth/3*i, frameHeight / 10 , 100, 65);
		}
		 

		search.setBounds( frameWidth/4,frameHeight/5,80,30);
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
		if (e.getSource() == search) {
			//this.notifyWatchers(State.STOCKMANSTART);
		} 
	}
}
