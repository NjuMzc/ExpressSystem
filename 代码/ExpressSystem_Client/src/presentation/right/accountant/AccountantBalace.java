package presentation.right.accountant;

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
import presentation.watcher.*;

public class AccountantBalace extends RightAll implements ActionListener {
	int frameWidth;
	int frameHeight;
	JLabel jl[];
	JButton confirm;
	JTextField inputNum;
	JLabel time[];
	JComboBox<String>[] timeInput;
	JLabel sum;
	JTextField jtfSum;
	private List<Watcher> list;
	JButton back;
	DefaultTableModel model;
	JTable table;
	JScrollPane js;

	public AccountantBalace(int frameWidth, int frameHeight) {
		this.frameHeight = frameHeight;
		this.frameWidth = frameWidth;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel[2];
		for (int i = 0; i < 2; i++) {
			jl[i] = new JLabel();
		}
		confirm = new JButton("");//确认
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

		model = new DefaultTableModel();
		table = new JTable(model){ public boolean isCellEditable(int row, int column) { return false; }}; 
		js = new JScrollPane(table);

		inputNum = new JTextField();
		sum = new JLabel("金额合计");
		sum.setFont(new Font("宋体",Font.BOLD,16));
		jtfSum = new JTextField();
		back = new JButton("");//返回

		init();

		for (int i = 0; i < 2; i++) {
			this.add(jl[i]);
		}
		this.add(confirm);
		for (int i = 0; i < 3; i++) {
			this.add(time[i]);
			this.add(timeInput[i]);
		}
		this.add(inputNum);
	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\系统管理startRight.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth * 3 / 4, frameHeight, null);
	}
	
  	private void init() {
		jl[0].setText("查询日期");
		jl[1].setText("营业厅编号");
		for (int i = 0; i < 2; i++) {
			jl[i].setBounds(frameWidth / 10, frameHeight / 11 * i+frameHeight/30,
					frameWidth / 10, frameHeight / 20);
			jl[i].setFont(new Font("宋体",Font.BOLD,16));
		}
		confirm.setBounds(frameWidth / 12 * 5, frameHeight / 10+frameHeight/40,
				frameWidth / 10, frameHeight / 19);
		
		ImageIcon icon2 = new ImageIcon("pictures//确认小.png");
		Image temp2 = icon2.getImage().getScaledInstance(icon2.getIconWidth(),
				icon2.getIconHeight(), icon2.getImage().SCALE_DEFAULT);
		icon2 = new ImageIcon(temp2);
		confirm.setIcon(icon2);
		
		confirm.addActionListener(this);
		time[0].setText("年");
		time[1].setText("月");
		time[2].setText("日");
		for (int i = 0; i < 3; i++) {
			timeInput[i].setBounds(frameWidth / 4 + frameWidth / 10 * i+frameWidth/60*i, frameHeight/30,
					frameWidth / 12+frameWidth/60, frameHeight / 20);
			time[i].setBounds(frameWidth / 3 + frameWidth / 10 * i+frameWidth/60*(i+1),frameHeight/30,
					frameWidth / 12, frameHeight / 20);
			time[i].setFont(new Font("宋体", Font.PLAIN, 14));
			timeInput[i].setFont(new Font("宋体", Font.PLAIN, 13));
		}
		inputNum.setBounds(frameWidth / 4, frameHeight / 10+frameHeight/46, frameWidth / 10,
				frameHeight / 20);
		sum.setBounds(frameWidth / 10, frameHeight / 5 * 4, frameWidth / 10,
				frameHeight / 20);
		jtfSum.setBounds(frameWidth / 4, frameHeight / 5 * 4, frameWidth / 10,
				frameHeight / 20);
		
		back.setBounds(frameWidth / 4, frameHeight / 10 * 9, frameWidth / 10,
				frameHeight / 19);
		
		ImageIcon icon1 = new ImageIcon("pictures//返回小.png");
		Image temp1 = icon1.getImage().getScaledInstance(icon1.getIconWidth(),
				icon1.getIconHeight(), icon1.getImage().SCALE_DEFAULT);
		icon1 = new ImageIcon(temp1);
		back.setIcon(icon1);
		
		back.addActionListener(this);

		initTable();
		js.setBounds(0, frameHeight / 5, frameWidth / 4 * 3, frameHeight / 2);
	}

	private void initTable() {

		model.addColumn("日期");
		model.addColumn("金额");
		model.addColumn("快递员姓名");
		model.addColumn("快递员编号");
		model.addColumn("快递订单号");
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
        table.setFont(new Font("宋体", Font.PLAIN, 14));
		initTableModel();
	}

	private void initTableModel() {
		Vector<String> vec = new Vector<>();
		vec.add("2015.12.12");
		vec.add("2000");
		vec.add("陈信宏");
		vec.add("110");
		vec.add("123456");
		model.addRow(vec);
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
		if (e.getSource() == confirm) {
			this.add(js);
			this.remove(confirm);
			this.add(jtfSum);
			this.add(sum);
			this.add(back);
			this.repaint();
		}

		if (e.getSource() == back) {
			this.add(confirm);
			this.remove(js);
			this.remove(jtfSum);
			this.remove(sum);
			this.remove(back);
			this.remove(js);
			this.repaint();
		}
	}
}
