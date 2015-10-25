package client.presentation.billsui;

import java.awt.Color;

import javax.swing.*;

public class CourierPanel extends JPanel {

	int frameWidth;
	int frameHeight;
	JButton[] jb;

	public CourierPanel() {
		Data d = new Data();
		this.frameWidth = d.getFrameWidth();
		this.frameHeight = d.getFrameHeight();

		this.setLayout(null);
		this.setBounds(0, 0, frameWidth / 3, frameHeight);

		jb = new JButton[3];
		for (int i = 0; i < 3; i++) {
			jb[i] = new JButton();
		}

		init();

		//this.setBackground(Color.green);
		for (int i = 0; i < 3; i++) {
			this.add(jb[i]);
		}

	}

	private void init() {
		for (int i = 0; i < 3; i++) {
			jb[i] = new JButton();
			jb[i].setBounds(frameWidth / 12, frameHeight / 3 + frameWidth / 5
					* i, frameWidth / 7, frameWidth / 15);
		}
		jb[0].setText("制作订单");
		jb[1].setText("查询订单");
		jb[2].setText("录入收款单");
	}
}
