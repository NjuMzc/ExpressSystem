package presentation.right.courier;

import javax.swing.*;

import businesslogic.transportbl.courier.Trans_InquireOrderServerImpl;
import businesslogicservice.transportblservice.courier.Trans_InquireOrderServer;
import po.bills.OrderBill;
import presentation.Data;
import presentation.right.RightAll;
import presentation.watcher.State;
import presentation.watcher.Watched;
import presentation.watcher.Watcher;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CourierSearch extends RightAll implements ActionListener {
	Trans_InquireOrderServer blServer;

	int frameWidth;
	int frameHeight;
	JLabel remind;
	JLabel wrong;
	JButton confirm;
	JButton cancel;
	JTextField inputOrder;
	boolean isWrongShow = false;
	private List<Watcher> list;

	public CourierSearch(int frameWidth, int frameHeight) {
		blServer = new Trans_InquireOrderServerImpl();

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		remind = new JLabel("请输入快递单号");
		confirm = new JButton("确认");
		cancel = new JButton("取消");
		wrong = new JLabel("输入的快递单号不存在");
		wrong.setVisible(false);
		inputOrder = new JTextField();

		init();

		this.add(remind);
		this.add(confirm);
		this.add(cancel);
		this.add(wrong);
		this.add(inputOrder);
	}

	private void init() {
		remind.setBounds(frameWidth / 4, frameHeight / 3, frameWidth / 4,
				frameHeight / 20);
		confirm.setBounds(frameWidth / 4, frameHeight / 2, frameWidth / 10,
				frameWidth / 20);
		confirm.addActionListener(this);
		cancel.setBounds(frameWidth / 2, frameHeight / 2, frameWidth / 10,
				frameWidth / 20);
		cancel.addActionListener(this);
		wrong.setBounds(frameWidth / 2, frameHeight / 4 * 3, frameWidth / 5,
				frameWidth / 20);
		wrong.setForeground(new Color(227, 23, 13));
		inputOrder.setBounds(frameWidth / 2, frameHeight / 3, frameWidth / 5,
				frameWidth / 20);

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
			this.notifyWatchers(State.COURIERSTART);
		} else if (e.getSource() == confirm) {
			OrderBill bill = blServer.inquire(inputOrder.getText());
			System.out.println(inputOrder.getText());
			if (bill == null) {
				wrong.setVisible(true);
			} else {
				BillNow.setBill(bill);
				this.notifyWatchers(State.COURIERSEARCHAFTER);
			}

		}

	}
}
