package presentation.log;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import po.Message;
import po.SystemUserPO;
import presentation.right.RightAll;
import presentation.watcher.State;
import presentation.watcher.Watched;
import presentation.watcher.Watcher;
import businesslogic.systembl.SystemBlServerImpl;
import businesslogicservice.systemblservice.systemServer;

public class LogMainFrame extends RightAll implements ActionListener  {

	int frameWidth;
	int frameHeight;
	JLabel remind;
	JLabel account;
	JLabel passport;
	JButton confirm;
	JButton cancel;
	JTextField jtf;
	JPasswordField jpf;

	private List<Watcher> list;

	public LogMainFrame(int frameWidth, int frameHeight) {
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(0, 0, frameWidth, frameHeight);

		confirm = new JButton("");
		cancel = new JButton("");
		
		confirm.setContentAreaFilled(false);//设置按钮透明
		cancel.setContentAreaFilled(false);
		
		confirm.setBorderPainted(false);//隐藏边框
		cancel.setBorderPainted(false);
		
		jtf = new JTextField(12);
		jpf = new JPasswordField();
		

		init();

		this.add(confirm);
		this.add(cancel);
		this.add(jtf);
		this.add(jpf);
	}
	
	@Override
	//添加背景
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\系统登录界面.png");
		Image bg =background.getImage();
		g.drawImage(bg, 0, 0, frameWidth,frameHeight,null);
	}

	private void init() {


		confirm.setBounds(frameWidth *9/ 32, frameHeight * 23 / 32, frameWidth*7 /48,
				frameWidth / 20);
		confirm.addActionListener(this);
		cancel.setBounds(frameWidth *9/16, frameHeight *23/ 32, frameWidth *7/ 48,
				frameWidth / 20);
		cancel.addActionListener(this);

		jtf.setBounds(frameWidth * 19 /56, frameHeight * 7/16, 300,50);
		jtf.setFont(new Font("宋体",Font.PLAIN,28));
		jpf.setBounds(frameWidth * 19 / 56, frameHeight * 19 /32, 300, 50);
		jpf.setFont(new Font("宋体",Font.PLAIN,28));
		jpf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					logConfirm();
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					jtf.requestFocus();
				}
			}
		});
		jtf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					jpf.requestFocus();
				}
			}
		});
	}
	
	private void logConfirm() {
		String input_account = jtf.getText();
		String input_password = jpf.getText();

		// 登录验证

		systemServer s = new SystemBlServerImpl();

		if (!input_account.equals("") && !input_password.equals("")) {
			SystemUserPO user = s.login(input_account, input_password);
			if (user != null) {
				if (user.getIdentity().equals("manager")) {
					this.notifyWatchers(State.MANAGERSTART);
					this.notifyWatchers(State.LEFTMANAGER);

				} else if (user.getIdentity().equals("account")) {
					this.notifyWatchers(State.ACCOUNTANTSTART);
					this.notifyWatchers(State.LEFTACCOUNTANT);
				} else if (user.getIdentity().equals("courier")) {
					this.notifyWatchers(State.COURIERSTART);
					this.notifyWatchers(State.LEFTCOURIER);
				} else if (user.getIdentity().equals("hstaff")) {
					this.notifyWatchers(State.YING_START);
					this.notifyWatchers(State.LEFTYING);
				} else if (user.getIdentity().equals("tstaff")) {
					this.notifyWatchers(State.ZHONG_START);
					this.notifyWatchers(State.LEFTZHONG);
				} else if (user.getIdentity().equals("keeper")) {
					this.notifyWatchers(State.STOCKMANSTART);
					this.notifyWatchers(State.LEFTSTOCKMAN);
				} else if (user.getIdentity().equals("admin")) {

					this.notifyWatchers(State.ADMINSTART);
					this.notifyWatchers(State.LEFTADMIN);
				}
			} else {
				System.out.println("Fail login!");
			}

			jtf.setText("");
			jpf.setText("");
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == confirm) {

			logConfirm();

		} else if (e.getSource() == cancel) {
			this.notifyWatchers(State.COVER);
		}

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
}
