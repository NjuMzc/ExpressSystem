package presentation.right.stockman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import presentation.right.RightAll;
import presentation.watcher.*;

public class StockmanSearch extends RightAll implements ActionListener {
	int frameWidth;
	int frameHeight;
	JLabel[] jl;
	JButton search;
	private List<Watcher> list;

	JLabel time[];
	JComboBox<String>[] timeInput;
	JLabel timeover[];
	JComboBox<String>[] timeInputover;

	JPanel addpanel;
	DefaultTableModel tableModel;
	JTable table;
	JScrollPane js;
	JLabel inStock;
	JLabel outStock;
	JTextField jtfIn;
	JTextField jtfOut;

	public StockmanSearch(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel[2];
		for (int i = 0; i < 2; i++) {
			jl[i] = new JLabel();
		}
		search = new JButton("查询");

		time = new JLabel[3];
		timeInput = new JComboBox[3];
		timeover = new JLabel[3];
		timeInputover = new JComboBox[3];
		for (int i = 0; i < 3; i++) {
			time[i] = new JLabel();
			timeover[i] = new JLabel();
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
		timeInputover[0] = new JComboBox<String>(year);
		timeInputover[1] = new JComboBox<String>(month);
		timeInputover[2] = new JComboBox<String>(day);

		init();

		for (int i = 0; i < 2; i++) {
			this.add(jl[i]);
		}
		this.add(search);
		for (int i = 0; i < 3; i++) {
			this.add(time[i]);
			this.add(timeInput[i]);
			this.add(timeover[i]);
			this.add(timeInputover[i]);
		}

	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\系统管理startRight.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth * 3 / 4, frameHeight, null);
	}
	
	
	private void init() {

		jl[0].setText("起始时间");
		jl[1].setText("中止时间 ");
		jl[0].setBounds(frameWidth / 6, frameHeight / 10, frameWidth / 10,
				frameHeight / 20);
		jl[1].setBounds(frameWidth / 2 + frameWidth / 10, frameHeight / 10,
				frameWidth / 10, frameHeight / 20);
		search.setBounds(frameWidth / 4, frameHeight / 4, frameWidth / 10,
				frameHeight / 20);
		search.addActionListener(this);

		time[0].setText("年");
		time[1].setText("月");
		time[2].setText("日");
		for (int i = 0; i < 3; i++) {
			timeInput[i].setBounds(frameWidth / 12 + frameWidth / 10 * i,
					frameHeight / 20 + frameHeight / 10, frameWidth / 12,
					frameHeight / 20);
			time[i].setBounds(frameWidth / 6 + frameWidth / 10 * i, frameHeight
					/ 20 + frameHeight / 10, frameWidth / 12, frameHeight / 20);
		}

		timeover[0].setText("年");
		timeover[1].setText("月");
		timeover[2].setText("日");
		for (int i = 0; i < 3; i++) {
			timeInputover[i].setBounds(frameWidth / 12 * 5 + frameWidth / 10
					* i, frameHeight / 20 + frameHeight / 10, frameWidth / 12,
					frameHeight / 20);
			timeover[i].setBounds(frameWidth / 2 + frameWidth / 10 * i,
					frameHeight / 20 + frameHeight / 10, frameWidth / 12,
					frameHeight / 20);
		}
	}

	private void addPanel() {
		addpanel = new JPanel();
		addpanel.setLayout(null);
		addpanel.setBounds(0, frameHeight / 3, frameWidth / 4 * 3,
				frameHeight / 3 * 2);

		tableModel = new DefaultTableModel();
		table = new JTable(tableModel);
		js = new JScrollPane(table);
		inStock = new JLabel("入库合计");
		outStock = new JLabel("出库合计");
		jtfIn = new JTextField();
		jtfOut = new JTextField();

		js.setBounds(0, 0, frameWidth / 4 * 3, frameHeight / 2);
		inStock.setBounds(0, frameHeight / 2, frameWidth / 10, frameHeight / 20);
		outStock.setBounds(0, frameHeight / 2 + frameHeight / 10,
				frameWidth / 10, frameHeight / 20);
		jtfIn.setBounds(frameWidth / 10, frameHeight / 2, frameWidth / 10,
				frameHeight / 20);
		jtfOut.setBounds(frameWidth / 10, frameHeight / 2 + frameHeight / 10,
				frameWidth / 10, frameHeight / 20);

		initTable();

		addpanel.add(jtfIn);
		addpanel.add(jtfOut);
		addpanel.add(js);
		addpanel.add(inStock);
		addpanel.add(outStock);
		this.add(addpanel);
		this.repaint();
	}

	private void initTable() {
		tableModel.addColumn("快递编号");
		tableModel.addColumn("出/入库");
		tableModel.addColumn("金额");
		tableModel.addColumn("库存位置");
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);

		initTableModel();
	}

	private void initTableModel() {
		Vector<String> vec = new Vector<>();

		vec.add("110232124");
		vec.add("入库");
		vec.add("1000");
		vec.add("04区01排01架01号");

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
		if (e.getSource() == search) {
			addPanel();
		}
	}
}
