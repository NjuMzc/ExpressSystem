package presentation.right.stockman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import presentation.right.RightAll;
import presentation.watcher.*;

public class StockmanInStock extends RightAll implements ActionListener {
	int frameWidth;
	int frameHeight;
	JLabel[] jl;
	JButton confirm;
	JButton cancel;
	JTextField jtf[];
	JLabel time[];
	JComboBox<String>[] timeInput;
	private List<Watcher> list;

	public StockmanInStock(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel[8];
		for (int i = 0; i < 8; i++) {
			jl[i] = new JLabel();
		}
		confirm = new JButton("确认");
		cancel = new JButton("取消");
		jtf = new JTextField[7];
		for(int i=0;i<7;i++){
			jtf[i]=new JTextField();
		}
		
		time = new JLabel[3];
		timeInput = new JComboBox[3];
		for (int i = 0; i < 3; i++) {
			time[i] = new JLabel();
		}
		String[] year = { "2015", "2016", "2017", "2018", "2019", "2020" };
		String[] month = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12" };
		String[] day = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
				"21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
				"31" };
		timeInput[0] = new JComboBox<String>(year);
		timeInput[1] = new JComboBox<String>(month);
		timeInput[2] = new JComboBox<String>(day);

		init();

		for (int i = 0; i < 8; i++) {
			this.add(jl[i]);
		}
		this.add(confirm);
		this.add(cancel);
		for (int i = 0; i < 7; i++) {
			this.add(jtf[i]);
		}
		for(int i=0;i<3;i++){
			this.add(time[i]);
			this.add(timeInput[i]);
		}

	}
	
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\入库单填写right.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth/4*3,frameHeight,null);
	}

	private void init() {

		jl[0].setText("快递编号");
		jl[1].setText("入库日期");
		jl[2].setText("目的地");
		jl[3].setText("库存位置");
		jl[4].setText("区号");
		jl[5].setText("排号");
		jl[6].setText("架号");
		jl[7].setText("位号");

		for (int i = 0; i < 4; i++) {
			jl[i].setBounds(frameWidth / 8, frameHeight / 10 * (i + 1),
					frameWidth / 10, frameHeight / 20);
			jl[i].setFont(new Font("宋体",Font.BOLD,15));
		}
		for (int i = 4; i < 8; i++) {
			jl[i].setBounds(frameWidth / 4, frameHeight / 10 * i,
					frameWidth / 10, frameHeight / 20);
			jl[i].setFont(new Font("宋体",Font.PLAIN,16));
		}

		for (int i = 0; i < 3; i++) {
			if(i!=1)
			jtf[i].setBounds(frameWidth / 4, frameHeight / 10 * (i + 1),
					frameWidth / 9, frameHeight / 20);
			jtf[i].setFont(new Font("宋体",Font.PLAIN,15));
		}
		for (int i = 3; i < 7; i++) {
			jtf[i].setBounds(frameWidth / 3-frameWidth/25, frameHeight / 10 * (i + 1),
					frameWidth / 10, frameHeight / 20);
			jtf[i].setFont(new Font("宋体",Font.PLAIN,15));
		}
		
		time[0].setText("年");
		time[1].setText("月");
		time[2].setText("日");
		for (int i = 0; i < 3; i++) {
			timeInput[i].setBounds(frameWidth / 4 + frameWidth / 50*6 * i,
					frameHeight / 5, frameWidth / 11, frameHeight / 20);
			time[i].setBounds(frameWidth / 3+ frameWidth / 50*6 * i+frameWidth/85,
					frameHeight / 5, frameWidth / 12, frameHeight / 20);
			time[i].setFont(new Font("宋体",Font.PLAIN,15));
			timeInput[i].setFont(new Font("宋体",Font.PLAIN,14));
		}

		confirm.setBounds(frameWidth / 4, frameHeight / 10 * 9,
				frameWidth / 10, frameHeight / 20);
		confirm.addActionListener(this);
		cancel.setBounds(frameWidth / 2, frameHeight / 10 * 9, frameWidth / 10,
				frameHeight / 20);
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
			this.notifyWatchers(State.STOCKMANSTART);
		} else if (e.getSource() == confirm) {
			this.notifyWatchers(State.STOCKMANINSTOCK);
		}
	}
}
