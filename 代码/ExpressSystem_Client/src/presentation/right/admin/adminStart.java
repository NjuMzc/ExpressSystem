package presentation.right.admin;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.*;

public class adminStart extends JPanel {

	int frameWidth;
	int frameHeight;
	JLabel jl;

	public adminStart(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel("start");

		init();

		this.setBackground(new Color(254, 67, 101));
		this.add(jl);

	}

	private void init() {
		jl.setBounds(320, 320, 300, 300);
		jl.setText("start");
	}
}
