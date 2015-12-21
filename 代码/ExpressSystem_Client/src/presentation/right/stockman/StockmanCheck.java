package presentation.right.stockman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.util.Calendar;

import presentation.right.ColorRenderer;
import presentation.right.RightAll;
import presentation.watcher.*;

public class StockmanCheck extends RightAll implements ActionListener {
	int frameWidth;
	int frameHeight;
	JButton cancel;
	JButton export;
	JLabel currenttime;
	private List<Watcher> list;

	JLabel time[];
	JTextField timeInput[];
	DefaultTableModel tableModel;
	JTable table;
	JScrollPane js;
	DefaultTableCellRenderer dtc;

	public StockmanCheck(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		cancel = new JButton("返回");
		tableModel = new DefaultTableModel();
		table = new JTable(tableModel);
		js = new JScrollPane(table);
		currenttime = new JLabel("当前日期");
		time = new JLabel[3];
		timeInput = new JTextField[3];
		for (int i = 0; i < 3; i++) {
			time[i] = new JLabel();
			timeInput[i] = new JTextField();
		}
		export = new JButton("导出报表");
		dtc=new ColorRenderer();

		init();

		this.add(cancel);
		this.add(js);
		this.add(currenttime);
		for (int i = 0; i < 3; i++) {
			this.add(time[i]);
			this.add(timeInput[i]);
		}
		this.add(export);
	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\系统管理startRight.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth * 3 / 4, frameHeight, null);
	}
	
	
	private void init() {
		cancel.setBounds(frameWidth / 2, frameHeight / 10 * 9, frameWidth / 10,
				frameHeight / 20);
		cancel.addActionListener(this);
		export.setBounds(frameWidth / 5, frameHeight / 10 * 9, frameWidth / 10,
				frameHeight / 20);
		export.addActionListener(this);
		currenttime.setBounds(0, 0, frameWidth / 10, frameHeight / 10);

		time[0].setText("年");
		time[1].setText("月");
		time[2].setText("日");
		for (int i = 0; i < 3; i++) {
			timeInput[i].setBounds(frameWidth / 10 * (i + 1), frameHeight / 40,
					frameWidth / 12, frameHeight / 20);
			time[i].setBounds(frameWidth / 12 + frameWidth / 10 * (i + 1),
					frameHeight / 40, frameWidth / 12, frameHeight / 20);
		}

		initTime();
		initTable();

		js.setBounds(0, frameHeight / 10, frameWidth / 4 * 3,
				frameHeight / 5 * 4);
	}

	private void initTime() {

		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);

		System.out.println(year + " " + month + " " + day);

		// 获取当前时间
		timeInput[0].setText(year + "");
		timeInput[1].setText(month + "");
		timeInput[2].setText(day + "");

		for (int i = 0; i < 3; i++) {
			timeInput[i].setEditable(false);
		}
	}

	private void initTable() {
		tableModel.addColumn("快递编号");
		tableModel.addColumn("入库日期");
		tableModel.addColumn("目的地");
		tableModel.addColumn("区号");
		tableModel.addColumn("排号");
		tableModel.addColumn("架号");
		tableModel.addColumn("位号");
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.getColumnModel().getColumn(0).setCellRenderer(dtc);
		table.getColumnModel().getColumn(1).setCellRenderer(dtc);
		table.getColumnModel().getColumn(2).setCellRenderer(dtc);
		table.getColumnModel().getColumn(3).setCellRenderer(dtc);
		table.getColumnModel().getColumn(4).setCellRenderer(dtc);
		table.getColumnModel().getColumn(5).setCellRenderer(dtc);
		table.getColumnModel().getColumn(6).setCellRenderer(dtc);
	
		
		initTableModel();
	}

	private void initTableModel() {
		Vector<String> vec = new Vector<>();

		vec.add("123456789");
		vec.add("2015.12.12");
		vec.add("南京");
		vec.add("1");
		vec.add("1");
		vec.add("1");
		vec.add("1");

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
			this.notifyWatchers(State.STOCKMANSTART);
		} else if (e.getSource() == export) {

			// 导出报表

		}
	}
}
