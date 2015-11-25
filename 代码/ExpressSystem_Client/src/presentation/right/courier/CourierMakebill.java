package presentation.right.courier;

import javax.swing.*;

import presentation.Data;
import presentation.watcher.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CourierMakebill extends JPanel implements Watched, ActionListener {

	int frameWidth;
	int frameHeight;
	JPanel senderInfor;
	JLabel[] input;
	JButton confirm;
	JButton cancel;
	JTextField[] inputText;
	JComboBox<String> type;
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
		input = new JLabel[20];
		for (int i = 0; i < 20; i++) {
			input[i] = new JLabel();
		}

		inputText = new JTextField[16];
		for (int i = 0; i < 16; i++) {
			inputText[i] = new JTextField();
		}
		confirm = new JButton("确认");
		confirm.addActionListener(this);
		cancel = new JButton("取消");
		cancel.addActionListener(this);
		String[] item = { "经济快递", "标准快递", "特快快递" };
		type = new JComboBox<String>(item);

		init();

		for (int i = 0; i < 20; i++) {
			senderInfor.add(input[i]);
		}
		for (int i = 0; i < 16; i++) {
			senderInfor.add(inputText[i]);
		}
		senderInfor.add(type);
		this.add(senderInfor);
		this.add(confirm);
		this.add(cancel);

	}

	private void init() {
		senderInfor.setBounds(50, 50, frameWidth * 3 / 4 - 50,
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
		input[8].setText("尺寸");
		input[9].setText("包装费");
		input[10].setText("住址");
		input[11].setText("电话");
		input[12].setText("住址");
		input[13].setText("电话");
		input[14].setText("重量");
		input[15].setText("内件品名");
		input[16].setText("快递类型");
		input[17].setText("手机");
		input[18].setText("手机");
		input[19].setText("计费方式");
		for (int i = 0; i < 10; i++) {
			input[i].setBounds(0, 40 * i, 100, 20);
		}
		input[10].setBounds(x / 3, 40, 100, 20);
		input[11].setBounds(x / 3, 40 * 2, 100, 20);
		input[12].setBounds(x / 3, 40 * 4, 100, 20);
		input[13].setBounds(x / 3, 40 * 5, 100, 20);
		input[14].setBounds(x / 3, 40 * 7, 100, 20);
		input[15].setBounds(x / 3, 40 * 8, 100, 20);
		input[16].setBounds(x / 3, 40 * 9, 100, 20);
		input[17].setBounds(x / 3 * 2, 40 * 2, 100, 20);
		input[18].setBounds(x / 3 * 2, 40 * 5, 100, 20);
		input[19].setBounds(x / 3 * 2, 40 * 8, 100, 20);

		confirm.setMargin(new Insets(0, 0, 0, 0));
		confirm.setBounds(150, frameHeight - 100, frameWidth / 12,
				frameWidth / 20);
		confirm.addActionListener(this);
		cancel.setMargin(new Insets(0, 0, 0, 0));
		cancel.setBounds(frameWidth * 3 / 4 - 225, frameHeight - 100,
				frameWidth / 12, frameWidth / 20);
		cancel.addActionListener(this);

		for (int i = 0; i < 2; i++) {
			inputText[i].setBounds(70, 40 * (i + 1), 100, 20);
		}
		for (int i = 2; i < 4; i++) {
			inputText[i].setBounds(70, 40 * (i + 2), 100, 20);
		}
		for (int i = 4; i < 7; i++) {
			inputText[i].setBounds(70, 40 * (i + 3), 100, 20);
		}
		inputText[7].setBounds(x / 3 + 70, 40, 100, 20);
		inputText[8].setBounds(x / 3 + 70, 40 * 2, 100, 20);
		inputText[9].setBounds(x / 3 + 70, 40 * 4, 100, 20);
		inputText[10].setBounds(x / 3 + 70, 40 * 5, 100, 20);
		inputText[11].setBounds(x / 3 + 70, 40 * 7, 100, 20);
		inputText[12].setBounds(x / 3 + 70, 40 * 8, 100, 20);
		inputText[13].setBounds(x / 3 + 70, 40 * 9, 100, 20);
		inputText[14].setBounds(x / 3 * 2 + 70, 40 * 2, 100, 20);
		inputText[15].setBounds(x / 3 * 2 + 70, 40 * 5, 100, 20);
		for (int i = 0; i < 16; i++) {
			inputText[i].setText("（必填）");
		}
		type.setBounds(x / 3 * 2 + 70, 40 * 8, 100, 20);
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
			this.notifyWatchers(State.COURIERSTART);
		} else if (e.getSource() == confirm) {

			// save the data
			boolean isFull = true;
			for (int i = 0; i < 16; i++) {
				if (inputText[i].getText().equals("（必填）")) {
					isFull = false;
					break;
				}
			}
			 
		}

	}
}
