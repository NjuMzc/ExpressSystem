package client.presentation.billsui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import client.businesslogic.billsbl.billMaker_Stub;
import client.businesslogic.transportbl.receiveBillMaker;
import client.businesslogicservice.billsblservice.*;
import client.businesslogicservice.transportblservice.transportBillsMaker;
import client.vo.Message;

public class InputInforPanel extends JPanel implements ActionListener, Watched {
	int frameWidth;
	int frameHeight;
	JButton confirm;
	JButton cancel;
	JLabel jl[];
	JTextField jtfNum;
	JTextField jtfName;
	JComboBox jcbYear;
	JComboBox jcbMonth;
	JComboBox jcbDay;
	String num = null;
	String name = null;
	String time = null;
	private List<Watcher> list;

	transportBillsMaker billmaker;
	Message receiveMessage;

	public InputInforPanel() {
		Data d = new Data();
		this.frameWidth = d.getFrameWidth();
		this.frameHeight = d.getFrameHeight();

		list = new ArrayList<Watcher>();

		this.billmaker = new receiveBillMaker();
		this.receiveMessage = new Message();

		this.setBackground(new Color(131, 175, 155));
		this.setLayout(null);
		this.setBounds(frameWidth / 3, 0, frameWidth * 2 / 3, frameHeight);

		for (int i = 0; i < 3; i++) {
			jl = new JLabel[3];
		}
		confirm = new JButton();
		cancel = new JButton();
		jtfNum = new JTextField(15);
		jtfName = new JTextField(10);
		String[] yearList = new String[] { "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022" };
		jcbYear = new JComboBox(yearList);
		String[] monthList = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
		jcbMonth = new JComboBox(monthList);
		String[] dayList = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
				"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
		jcbDay = new JComboBox(dayList);

		init();

		for (int i = 0; i < 3; i++) {
			this.add(jl[i]);
		}
		this.add(confirm);
		this.add(cancel);
		this.add(jtfName);
		this.add(jtfNum);
		this.add(jcbDay);
		this.add(jcbMonth);
		this.add(jcbYear);

	}

	private void init() {
		// 按钮
		confirm.setBounds(frameWidth / 4, frameHeight / 10 + frameWidth / 2, frameWidth / 12, frameWidth / 20);
		confirm.setText("确认");
		confirm.addActionListener(this);
		cancel.setBounds(frameWidth * 2 / 5, frameHeight / 10 + frameWidth / 2, frameWidth / 12, frameWidth / 20);
		cancel.setText("取消");
		cancel.addActionListener(this);

		// 标签
		for (int i = 0; i < 3; i++) {
			jl[i] = new JLabel();
			jl[i].setBounds(frameWidth / 6, frameHeight / 10 + frameWidth / 5 * i, frameWidth / 9, frameWidth / 15);
		}
		jl[0].setText("收件单号");
		jl[1].setText("收件人姓名");
		jl[2].setText("收件日期");

		// 输入栏
		jtfNum.setBounds(frameWidth / 6 + 100, frameHeight / 8, frameWidth / 5, frameWidth / 30);
		jtfName.setBounds(frameWidth / 6 + 100, frameHeight / 8 + frameWidth / 5, frameWidth / 5, frameWidth / 30);

		// 组合栏
		jcbYear.setBounds(frameWidth / 6 + 100, frameHeight / 8 + frameWidth / 5 * 2, 60, frameWidth / 30);
		jcbYear.addActionListener(this);
		jcbMonth.setBounds(frameWidth / 6 + 160, frameHeight / 8 + frameWidth / 5 * 2, 60, frameWidth / 30);
		jcbMonth.addActionListener(this);
		jcbDay.setBounds(frameWidth / 6 + 220, frameHeight / 8 + frameWidth / 5 * 2, 60, frameWidth / 30);
		jcbDay.addActionListener(this);
	}

	public void save(Message msg) {
		try {
			System.out.println("xiexie");
			File msgs= new File("messages/messages.txt");
			FileWriter fwriter = new FileWriter(msgs);
			BufferedWriter writer = new BufferedWriter(fwriter);
			int n = msg.getN();
			for (int i = 0; i < n; i++) {
				writer.write(msg.getInform(i));
				writer.write(";");
			}
			writer.newLine();

			writer.close();

		} catch (Exception e) {
			System.out.println("找不到");
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == confirm) {
			num = jtfNum.getText();
			name = jtfName.getText();
			time = (String) jcbYear.getSelectedItem() + (String) jcbMonth.getSelectedItem()
					+ (String) jcbDay.getSelectedItem();
			jtfName.setText("");
			jtfNum.setText("");

			receiveMessage.addInform(name);
			receiveMessage.addInform(num);
			receiveMessage.addInform(time);

			billmaker.makeTransBill(receiveMessage);
			save(receiveMessage);
		}

		if (e.getSource() == cancel) {
			num = null;
			name = null;
			time = null;
			jtfName.setText("");
			jtfNum.setText("");

			this.notifyWatchers(State.INPUTINFORTOSTART);
		}

	}

	public void addWatcher(Watcher watcher) {
		// TODO Auto-generated method stub
		list.add(watcher);
	}

	public void removeWatcehr(Watcher watcher) {
		// TODO Auto-generated method stub
		list.remove(watcher);
	}

	public void notifyWatchers(State state) {
		// TODO Auto-generated method stub
		for (Watcher watcher : list) {
			watcher.update(state);
		}
	}

}
