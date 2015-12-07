package presentation.right.zhong_salesman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import presentation.right.RightAll;
import presentation.watcher.State;
import presentation.watcher.Watched;
import presentation.watcher.Watcher;

public class Zhong_entrucking extends RightAll implements ActionListener {

	int frameWidth;
	int frameHeight;
	JLabel jl[];
	JTextField jtf[];
	JButton confirm;
	JButton cancel;
	JLabel time[];
	JButton add;
	JComboBox<String>[] timeInput;
	private List<Watcher> list;
	DefaultTableModel tableModel;
	JTable jtable;
	JScrollPane js;

	public Zhong_entrucking(int frameWidth, int frameHeight) {
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel[7];
		for (int i = 0; i < 7; i++) {
			jl[i] = new JLabel();
		}
		confirm = new JButton("确认");
		cancel = new JButton("取消");
		jtf = new JTextField[6];
		for (int i = 0; i < 6; i++) {
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

		tableModel = new DefaultTableModel();
		jtable = new JTable(tableModel);
		js = new JScrollPane(jtable);

		add = new JButton("添加");

		init();

		for (int i = 0; i < 7; i++) {
			this.add(jl[i]);
		}
		this.add(confirm);
		this.add(cancel);
		for (int i = 0; i < 6; i++) {
			this.add(jtf[i]);
		}
		for (int i = 0; i < 3; i++) {
			this.add(time[i]);
			this.add(timeInput[i]);
		}
		this.add(js);
		this.add(add);
	}
	
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\装车单填写right.png");
		Image bg =background.getImage();
		g.drawImage(bg, 0, 0,frameWidth*3/4,frameHeight,null);
	}

	private void init() {
		jl[0].setText("汽运编号");
		jl[1].setText("装车日期");
		jl[2].setText("到达地");
		jl[3].setText("车辆代号");
		jl[4].setText("监运员");
		jl[5].setText("押运员");
		jl[6].setText("装车订单号");
		for (int i = 0; i < 7; i++) {
			jl[i].setBounds(frameWidth / 10, frameHeight / 12 * i+frameHeight/9,
					frameWidth / 10, frameHeight / 20);
			jl[i].setFont(new Font("宋体",Font.BOLD,15));
		}
		confirm.setBounds(frameWidth / 6, frameHeight * 9 / 10, 80, 30);
		cancel.setBounds(frameWidth * 2 / 5, frameHeight * 9 / 10, 80, 30);
		cancel.addActionListener(this);
		jtf[0].setBounds(frameWidth / 4, frameHeight/9-frameHeight/100, frameWidth / 9, frameHeight / 20);
		jtf[0].setFont(new Font("宋体",Font.BOLD,15));
		for (int i = 1; i < 6; i++) {
			jtf[i].setBounds(frameWidth / 4, frameHeight / 12 * (i + 1)+frameHeight/9,
					frameWidth /9, frameHeight / 20);
			jtf[i].setFont(new Font("宋体",Font.BOLD,15));
		}
		time[0].setText("年");
		time[1].setText("月");
		time[2].setText("日");
		for (int i = 0; i < 3; i++) {
			timeInput[i].setBounds(frameWidth / 4 + frameWidth / 50*6 * i,
					frameHeight / 12 * 1+frameHeight/9-frameHeight/100, frameWidth / 11, frameHeight / 20);
			time[i].setBounds(frameWidth / 3+ frameWidth / 50*6 * i+frameWidth/85,
					frameHeight / 12 *1+frameHeight/9, frameWidth / 12, frameHeight / 20);
			time[i].setFont(new Font("宋体",Font.PLAIN,15));
			timeInput[i].setFont(new Font("宋体",Font.PLAIN,14));
		}
		add.setBounds(frameWidth / 2, frameHeight / 10 * 6, frameWidth / 10,
				frameHeight / 20);
		add.addActionListener(this);

		initTable();

		js.setBounds(frameWidth / 4, frameHeight / 10 * 7, frameWidth / 4,
				frameHeight / 5);
	}

	private void initTable() {
		tableModel.addColumn("已有单号列表");
		jtable.getTableHeader().setReorderingAllowed(false);
		jtable.getTableHeader().setResizingAllowed(false);
		initTableModel();
	}

	private void initTableModel() {
		Vector<String> vec = new Vector<>();
		vec.add("12345666");

		// 初始化已有单号列表
		tableModel.addRow(vec);
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
			this.notifyWatchers(State.ZHONG_START);
		}

		if (e.getSource() == add) {
			// 添加单号列表
			String input = jtf[5].getText();
			if (!input.equals("")) {
				Vector<String> vec = new Vector<>();
				vec.add(input);
				tableModel.addRow(vec);
				jtf[5].setText("");
			}
		}
	}
}
