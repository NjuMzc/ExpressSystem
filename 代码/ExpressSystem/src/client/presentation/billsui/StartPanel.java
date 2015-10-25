package client.presentation.billsui;

import java.awt.Color;

import javax.swing.*;

public class StartPanel extends JPanel {

	int frameWidth;
	int frameHeight;
	JLabel jl;

	public StartPanel() {
		Data d = new Data();
		this.frameWidth = d.getFrameWidth();
		this.frameHeight = d.getFrameHeight();

		this.setLayout(null);
		this.setBounds(frameWidth / 3, 0, frameWidth * 2 / 3, frameHeight);

		jl = new JLabel("start");

		init();

		this.setBackground(Color.blue);
		this.add(jl);

	}

	private void init() {
		jl.setBounds(100, 100, 100, 100);
		jl.setText("start");
	}
}
