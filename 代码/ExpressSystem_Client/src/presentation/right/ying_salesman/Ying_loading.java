package presentation.right.ying_salesman;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import presentation.right.RightAll;
import presentation.watcher.State;
import presentation.watcher.Watched;
import presentation.watcher.Watcher;

public class Ying_loading extends RightAll implements ActionListener {

	int frameWidth;
	int frameHeight;
	JLabel jl[];
	JTextField jtf[];
	JButton confirm;
	JButton cancel;
	JLabel time[];
	JComboBox<String>[] timeInput;
	JButton add;
	DefaultTableModel tableModel;
	JTable jtable;
	JScrollPane js;
	JButton over;

	private List<Watcher> list;

	public Ying_loading(int frameWidth, int frameHeight) {
		this.frameHeight = frameHeight;
		this.frameWidth = frameWidth;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel[10];
		for (int i = 0; i < 10; i++) {
			jl[i] = new JLabel();
		}
		confirm = new JButton("确认");
		cancel = new JButton("取消");
		jtf = new JTextField[8];
		for (int i = 0; i < 8; i++) {
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
		add = new JButton("添加");

		tableModel = new DefaultTableModel();
		jtable = new JTable(tableModel);
		js = new JScrollPane(jtable);
		over = new JButton("完成");

		init();

		for (int i = 0; i < 9; i++) {
			this.add(jl[i]);
		}
		this.add(confirm);
		this.add(cancel);
		for (int i = 0; i < 7; i++) {
			this.add(jtf[i]);
		}
		for (int i = 0; i < 3; i++) {
			this.add(time[i]);
			this.add(timeInput[i]);
		}
		this.add(add);
		this.add(js);
	}

	private void init() {
		jl[0].setText("装车单");
		jl[1].setText("装车日期");
		jl[2].setText("营业厅编号");
		jl[3].setText("汽运编号");
		jl[4].setText("车辆编号");
		jl[5].setText("达到地");
		jl[6].setText("监运员");
		jl[7].setText("押运员");
		jl[8].setText("订单条形码号");
		jl[9].setText("运费");

		jl[0].setBounds(frameWidth / 2, frameHeight / 20, frameWidth / 10,
				frameHeight / 20);
		for (int i = 1; i < 10; i++) {
			jl[i].setBounds(frameWidth / 10, frameHeight / 20 + frameHeight
					/ 15 * i, frameWidth / 10, frameHeight / 20);
		}

		confirm.setBounds(frameWidth / 6, frameHeight * 9 / 10,
				frameWidth / 10, frameHeight / 20);
		confirm.addActionListener(this);
		cancel.setBounds(frameWidth * 2 / 5, frameHeight * 9 / 10,
				frameWidth / 10, frameHeight / 20);
		cancel.addActionListener(this);

		for (int i = 0; i < 8; i++) {
			jtf[i].setBounds(frameWidth / 4, frameHeight / 20 + frameHeight
					/ 15 * (i + 2), frameWidth / 10, frameHeight / 20);
		}

		time[0].setText("年");
		time[1].setText("月");
		time[2].setText("日");
		for (int i = 0; i < 3; i++) {
			timeInput[i].setBounds(frameWidth / 4 + frameWidth / 10 * i,
					frameHeight / 20 + frameHeight / 15, frameWidth / 12,
					frameHeight / 20);
			time[i].setBounds(frameWidth / 3 + frameWidth / 10 * i, frameHeight
					/ 20 + frameHeight / 15, frameWidth / 12, frameHeight / 20);
		}
		add.setBounds(frameWidth / 12 * 5, frameHeight / 20 + frameHeight / 15
				* 8, frameWidth / 10, frameHeight / 20);
		add.addActionListener(this);

		initTable();

		js.setBounds(frameWidth / 12 * 5, frameHeight / 20 + frameHeight / 15
				* 2, frameWidth / 5, frameHeight / 3);
		over.setBounds(frameWidth / 3, frameHeight * 9 / 10, frameWidth / 10,
				frameHeight / 20);
		over.addActionListener(this);

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
			this.notifyWatchers(State.YING_START);
		} else if (e.getSource() == confirm) {

			this.add(jl[9]);
			this.add(jtf[7]);
			for (int i = 0; i < 8; i++) {
				jtf[i].setEditable(false);
			}
			for (int i = 0; i < 3; i++) {
				timeInput[i].setEditable(false);
			}
			this.remove(confirm);
			this.remove(cancel);
			this.add(over);

			this.repaint();
		}

		if (e.getSource() == add) {
			// 添加单号列表
			String input = jtf[6].getText();
			if (!input.equals("")) {
				Vector<String> vec = new Vector<>();
				vec.add(input);
				tableModel.addRow(vec);
				jtf[6].setText("");
			}
		}

		if (e.getSource() == over) {
			this.notifyWatchers(State.YING_START);
		}
	}
}
