package presentation.right.stockman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.peer.FramePeer;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import presentation.right.RightAll;
import presentation.watcher.*;

public class StockmanOutStock extends RightAll implements ActionListener {
	int frameWidth;
	int frameHeight;
	JLabel[] jl;
	JButton confirm;
	JButton cancel;
	JTextField jtf[];
	JLabel time[];
	JComboBox<String>[] timeInput;
	JComboBox<String> type;
	private List<Watcher> list;

	public StockmanOutStock(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel[5];
		for (int i = 0; i < 5; i++) {
			jl[i] = new JLabel();
		}
		confirm = new JButton("");
		cancel = new JButton("");
		jtf = new JTextField[3];
		for (int i = 0; i < 3; i++) {
			jtf[i] = new JTextField();
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

		String transportType[] = { "飞机", "火车", "汽车" };
		type = new JComboBox<String>(transportType);

		init();

		for (int i = 0; i < 5; i++) {
			this.add(jl[i]);
		}
		this.add(confirm);
		this.add(cancel);
		for (int i = 0; i < 3; i++) {
			this.add(jtf[i]);
			this.add(time[i]);
			this.add(timeInput[i]);
		}
		this.add(type);

	}
	
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\出库单填写right.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth/4*3,frameHeight,null);
	}

	private void init() {

		jl[0].setText("快递编号");
		jl[1].setText("出库日期");
		jl[2].setText("目的地");
		jl[3].setText("装运形式");
		jl[4].setText("中转/汽运单号");

		for (int i = 0; i < 5; i++) {
			jl[i].setBounds(frameWidth / 10, frameHeight / 10 * (i + 1),
					frameWidth / 8, frameHeight / 20);
			jl[i].setFont(new Font("宋体",Font.BOLD,15));
			
		}
		
		for(int i =0;i<3;i++){
		jtf[i].setFont(new Font("宋体",Font.PLAIN,15));
		time[i].setFont(new Font("宋体",Font.PLAIN,15));
		}
		
		jtf[0].setBounds(frameWidth / 4, frameHeight / 10, frameWidth / 9,
				frameHeight / 20);
		jtf[1].setBounds(frameWidth / 4, frameHeight / 10 * 3, frameWidth / 9,
				frameHeight / 20);
		jtf[2].setBounds(frameWidth / 4, frameHeight / 10 * 5, frameWidth / 9,
				frameHeight / 20);

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
		type.setBounds(frameWidth / 4, frameHeight / 10 * 4, frameWidth / 9,
				frameHeight / 20);
		type.setFont(new Font("宋体",Font.PLAIN,15));

		confirm.setBounds(frameWidth / 6, frameHeight * 8 / 10+frameHeight/30,
				 frameWidth / 9,frameHeight / 16);
		confirm.addActionListener(this);
		cancel.setBounds(frameWidth * 2 / 5+frameWidth/15, frameHeight * 8 / 10+frameHeight/30,
				 frameWidth / 9,frameHeight / 16);
		cancel.addActionListener(this);
		
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

		}
	}
}