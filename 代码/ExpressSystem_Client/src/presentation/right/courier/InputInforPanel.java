package presentation.right.courier;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import businesslogic.transportbl.courier.Trans_MakingReceiveBillServerImpl;
import businesslogicservice.transportblservice.courier.Trans_MakingReceiveBillServer;

import javax.swing.*;

import po.Message;
import presentation.right.RightAll;
import presentation.watcher.*;

public class InputInforPanel extends RightAll implements ActionListener {
	int frameWidth;
	int frameHeight;
	JButton confirm;
	JButton cancel;
	JLabel jl[];
	JLabel wrong;
	JTextField jtfNum;
	JTextField jtfName;
	private List<Watcher> list;
	boolean isWrongShow = false;
	JLabel time[];
	JComboBox<String>[] timeInput;

	Trans_MakingReceiveBillServer blServer;

	public InputInforPanel(int frameWidth, int frameHeight) {
		this.blServer = new Trans_MakingReceiveBillServerImpl();

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

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

		jl = new JLabel[3];
		for (int i = 0; i < 3; i++) {
			jl[i] = new JLabel();
		}
		confirm = new JButton();
		cancel = new JButton();
		jtfNum = new JTextField();
		jtfName = new JTextField();

		wrong = new JLabel("输入的订单不存在");

		init();

		this.add(wrong);
		this.add(confirm);
		this.add(cancel);
		this.add(jtfName);
		this.add(jtfNum);
		for (int i = 0; i < 3; i++) {
			this.add(jl[i]);
			this.add(time[i]);
			this.add(timeInput[i]);
		}
	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\收件2right.png");
		Image bg =background.getImage();
		g.drawImage(bg, 0, 0,frameWidth*3/4,frameHeight,null);
	}
	
	private void init() {

		confirm.setBounds(frameWidth / 4, frameHeight / 10 + frameWidth / 2,
				frameWidth / 10, frameWidth / 20);
		confirm.setText("确认");
		confirm.addActionListener(this);
		cancel.setBounds(frameWidth * 2 / 5, frameHeight / 10 + frameWidth / 2,
				frameWidth / 10, frameWidth / 20);
		cancel.setText("取消");
		cancel.addActionListener(this);

		for (int i = 0; i < 3; i++) {
			jl[i].setBounds(frameWidth / 6, frameHeight / 10 + frameHeight / 5
					* i, frameWidth / 10, frameWidth / 20);
		}
		jl[0].setText("快递单号");
		jl[1].setText("收件人姓名");
		jl[2].setText("收件日期");

		jtfNum.setBounds(frameWidth / 4, frameHeight / 10, frameWidth / 10,
				frameWidth / 20);
		jtfName.setBounds(frameWidth / 4, frameHeight / 10 * 3,
				frameWidth / 10, frameWidth / 20);

		wrong.setBounds(frameWidth * 2 / 5, frameHeight / 10 + frameWidth / 2
				+ 30, frameWidth / 8, frameWidth / 20);
		wrong.setVisible(false);
		wrong.setForeground(Color.red);

		time[0].setText("年");
		time[1].setText("月");
		time[2].setText("日");
		for (int i = 0; i < 3; i++) {
			timeInput[i].setBounds(frameWidth / 4 + frameWidth / 10 * i,
					frameHeight / 2, frameWidth / 12, frameHeight / 20);
			time[i].setBounds(frameWidth / 3 + frameWidth / 10 * i,
					frameHeight / 2, frameWidth / 10, frameHeight / 20);
		}
	}

	public void save(Message msg) {
		try {
			System.out.println("xiexie");
			File msgs = new File("messages/messages.txt");
			FileWriter fwriter = new FileWriter(msgs);
			BufferedWriter writer = new BufferedWriter(fwriter);
			int n = msg.length();
			for (int i = 0; i < n; i++) {
				writer.write(msg.getInform(i));
				writer.write(";");
			}
			writer.newLine();

			writer.close();

		} catch (Exception e) {
			System.out.println("xxx");
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String num;
		String name;
		String time;

		if (e.getSource() == confirm) {
			num = jtfNum.getText();
			name = jtfName.getText();
			time = (String) timeInput[0].getSelectedItem()
					+ (String) timeInput[1].getSelectedItem()
					+ (String) timeInput[2].getSelectedItem();
			jtfNum.setText("");
			jtfName.setText("");

			if (blServer.makeBill(num, name, time) == null) {
				isWrongShow = true;
			} else {
				isWrongShow = false;
			}

			if (isWrongShow) {
				wrong.setVisible(true);
			}

		}

		if (e.getSource() == cancel) {
			num = null;
			name = null;
			time = null;
			jtfName.setText("");
			jtfNum.setText("");

			this.notifyWatchers(State.COURIERSTART);
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