package UI;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	private int width = 350;
	private int height = 500;
	private JPanel panel;
	private JButton local;
	private JButton network;

	public MainFrame() {

		this.setBackground(Color.blue);
		this.setBounds(0, 0, width, height);
		// this.setLayout(null);
		panel = new JPanel();
		panel.setBounds(0, 0, width, height);
		panel.setBackground(Color.orange);
		panel.setLayout(null);
		this.add(panel);
		buttonInit();

		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void buttonInit() {
		local = new JButton("本地服务器");
		local.setBounds(50, 350, 100, 50);
		panel.add(local);
		network = new JButton("局域网服务器");
		network.setBounds(200, 350, 100, 50);
		panel.add(network);
	}

	public static void main(String[] args) {
		MainFrame a = new MainFrame();
	}
}
