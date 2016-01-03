package server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.*;

public class ServerIP extends JFrame {

	JPanel jp;
	JLabel jl;
	JTextField jtf[];
	JButton jb;
	JLabel jl2;
	JTextField jtf2;
	JLabel state;
	JTextField ip_state;

	RemindIP remind;
	JPanel jp_remind;
	String ip[];
	String port;
	String hostIP;

	public ServerIP() {

		jp = new JPanel();
		jl = new JLabel("IP地址：");
		jtf = new JTextField[4];
		ip = new String[4];
		for (int i = 0; i < 4; i++) {
			jtf[i] = new JTextField();
			ip[i] = new String();
		}
		jb = new JButton("开启");
		jl2 = new JLabel("端口：");
		jtf2 = new JTextField();
		state = new JLabel("状态");
		ip_state = new JTextField();

		init();
		this.add(jp);
		this.setSize(300, 500);
		this.setLocation(200, 100);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void init() {

		ip[0] = "123";
		ip[1] = "12";
		ip[2] = "32";
		ip[3] = "321";

		try {
			hostIP = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		ip = hostIP.split("\\.");

		port = "8400";

		jp.setBounds(0, 0, 300, 500);
		jp.setLayout(null);
		jl.setBounds(25, 100, 50, 25);
		for (int i = 0; i < 4; i++) {
			jtf[i].setBounds(100 + 35 * i, 100, 33, 25);
			jtf[i].addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					if (!Character.isDigit(e.getKeyChar())) {
						e.consume();
					}
				}
			});
		}

		jb.setBounds(110, 320, 80, 30);
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == jb) {

					String ip = "";
					String port = jtf2.getText();
					for (int i = 0; i < 4; i++) {
						if (i != 3)
							ip += (jtf[i].getText() + ".");
						else
							ip += jtf[i].getText();
					}

					success();
					RMIHelper.init(hostIP, port);
				}
			}
		});

		jl2.setBounds(25, 175, 50, 25);
		jtf2.setBounds(100, 175, 100, 25);
		jtf2.setEditable(false);
		jtf2.setText(port);
		state.setBounds(25, 250, 50, 25);
		ip_state.setBounds(100, 250, 100, 25);
		ip_state.setText("未连接");
		ip_state.setEditable(false);

		jp.add(jl);
		for (int i = 0; i < 4; i++) {
			jtf[i].setText(ip[i]);
			jtf[i].setEditable(false);
			jp.add(jtf[i]);
		}
		jp.add(jb);
		jp.add(jl2);
		jp.add(jtf2);
		jp.add(state);
		jp.add(ip_state);

	}

	private void success() {
		jp.remove(jb);
		ip_state.setText("已连接");
		jp.repaint();
	}

	public static void main(String[] args) {
		ServerIP service = new ServerIP();
	}

}
