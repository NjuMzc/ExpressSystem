package client.presentation.billsui.right.courier;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import client.presentation.Data;
import client.presentation.billsui.watcher.*;

public class CourierMakebill extends JPanel implements Watched, ActionListener {

	int frameWidth;
	int frameHeight;
	JPanel senderInfor;
	JLabel[] input;
	JButton confirm;
	JButton cancel;
	private List<Watcher> list;

	public CourierMakebill(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBackground(new Color(254, 67, 101));
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		senderInfor = new JPanel();
		senderInfor.setLayout(null);
		input = new JLabel[22];
		for (int i = 0; i < 22; i++) {
			input[i] = new JLabel();
		}
		confirm = new JButton("确认");
		confirm.addActionListener(this);
		cancel = new JButton("取消");
		cancel.addActionListener(this);

		init();

		for (int i = 0; i < 22; i++) {
			senderInfor.add(input[i]);
		}
		this.add(senderInfor);
		this.add(confirm);
		this.add(cancel);

	}

	private void init() {
		senderInfor.setBounds(50, 50, frameWidth * 3 / 4 - 100,
				frameHeight - 200);

		int x = frameWidth * 3 / 4 - 20;
		int y = frameHeight - 200;
		input[0].setText("寄件人信息");
		input[1].setText("姓名");
		input[2].setText("单位");
		input[3].setText("收件人信息");
		input[4].setText("姓名");
		input[5].setText("单位");
		input[6].setText("托运货物信息");
		input[7].setText("原件数");
		input[8].setText("体积");
		input[9].setText("包装费");
		input[10].setText("快递单号");
		input[11].setText("住址");
		input[12].setText("电话");
		input[13].setText("住址");
		input[14].setText("电话");
		input[15].setText("重量");
		input[16].setText("内件品名");
		input[17].setText("快递类型");
		input[18].setText("手机");
		input[19].setText("手机");
		input[20].setText("尺寸");
		input[21].setText("计费方式");
		for (int i = 0; i < 11; i++) {
			input[i].setBounds(0, y / 11 * i, 100, y / 11);
		}
		input[11].setBounds(x / 3, y / 11, 100, y / 11);
		input[12].setBounds(x / 3, y / 11 * 2, 100, y / 11);
		input[13].setBounds(x / 3, y / 11 * 4, 100, y / 11);
		input[14].setBounds(x / 3, y / 11 * 5, 100, y / 11);
		input[15].setBounds(x / 3, y / 11 * 7, 100, y / 11);
		input[16].setBounds(x / 3, y / 11 * 8, 100, y / 11);
		input[17].setBounds(x / 3, y / 11 * 9, 100, y / 11);
		input[18].setBounds(x / 3 * 2, y / 11 * 2, 100, y / 11);
		input[19].setBounds(x / 3 * 2, y / 11 * 5, 100, y / 11);
		input[20].setBounds(x / 3 * 2, y / 11 * 8, 100, y / 11);
		input[21].setBounds(x / 3 * 2, y / 11 * 9, 100, y / 11);

		confirm.setMargin(new Insets(0, 0, 0, 0));
		confirm.setBounds(150, frameHeight - 100, frameWidth / 12,
				frameWidth / 20);
		cancel.setMargin(new Insets(0, 0, 0, 0));
		cancel.setBounds(frameWidth * 3 / 4 - 225, frameHeight - 100,
				frameWidth / 12, frameWidth / 20);

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
		for (Watcher watcher : list) {
			watcher.update(state);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancel) {
			System.out.println("1");
			this.notifyWatchers(State.COURIERSTART);
		} else if (e.getSource() == confirm) {

		}

	}
}
