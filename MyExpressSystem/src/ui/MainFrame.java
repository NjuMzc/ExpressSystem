package ui;

import javax.swing.*;

public class MainFrame extends JFrame {

	int frameWidth;
	int frameHeight;
	StartPanel startpanel;
	CourierPanel courierpanel;
	InputInforPanel inputinforpanel;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MainFrame m = new MainFrame();
	}

	public MainFrame() {
		Data d = new Data();
		this.frameWidth = d.getFrameWidth();
		this.frameHeight = d.getFrameHeight();

		startpanel = new StartPanel();
		courierpanel = new CourierPanel();
		inputinforpanel = new InputInforPanel();

		this.setTitle("快递物流系统");
		this.setVisible(true);
		this.setResizable(false);
		this.setBounds(0, 0, frameWidth, frameHeight);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// this.add(startpanel);
		this.add(courierpanel);
		this.add(inputinforpanel);
 
	}

}
