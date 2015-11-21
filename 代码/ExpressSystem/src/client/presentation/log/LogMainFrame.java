package client.presentation.log;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import client.businesslogic.systembl.SystemBlServerImpl;
import client.po.SystemUserPO;
import client.presentation.watcher.State;
import client.presentation.watcher.Watched;
import client.presentation.watcher.Watcher;
import client.vo.Message;

public class LogMainFrame extends JPanel implements ActionListener, Watched {

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
		this.setBackground(new Color(107, 155, 184));

		remind = new JLabel("快递物流系统");

		account = new JLabel("账户");
		passport = new JLabel("密码");
		confirm = new JButton("确认");
		cancel = new JButton("取消");
		jtf = new JTextField(12);
		jpf = new JPasswordField();

		init();

		this.add(remind);
		this.add(account);
		this.add(passport);
		this.add(confirm);
		this.add(cancel);
		this.add(jtf);
		this.add(jpf);
	}

	private void init() {
		Font f = new Font("", Font.BOLD, 45);
		remind.setFont(f);
		remind.setBounds(frameWidth / 3, frameHeight / 4, frameWidth / 3,
				frameWidth / 18);

		account.setBounds(frameWidth / 3, frameHeight / 8 * 5, frameWidth / 12,
				frameWidth / 20);
		passport.setBounds(frameWidth / 3, frameHeight / 4 * 3,
				frameWidth / 12, frameWidth / 20);
		confirm.setBounds(frameWidth / 3, frameHeight * 7 / 8, frameWidth / 12,
				frameWidth / 20);
		confirm.addActionListener(this);
		cancel.setBounds(frameWidth / 2, frameHeight * 7 / 8, frameWidth / 12,
				frameWidth / 20);
		cancel.addActionListener(this);

		jtf.setBounds(frameWidth * 2 / 5, frameHeight * 5 / 8, 150, 30);
		jpf.setBounds(frameWidth * 2 / 5, frameHeight * 3 / 4, 150, 30);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == confirm) {

			String input_account = jtf.getText();
			String input_password = jpf.getText();

			// 登录验证

			SystemBlServerImpl s = new SystemBlServerImpl();
			
			Message msg=new Message();
			msg.addInform("2015010002");
			msg.addInform("nova123321");
			msg.addInform("manager");
			s.addUser(msg);
			
			Message msg2=new Message();
			msg2.addInform("2015020001");
			msg2.addInform("nova123321");
			msg2.addInform("account");
			s.addUser(msg2);
			
			System.out.println("added!");

			if (!input_account .equals("") && !input_password.equals("") ) {
				SystemUserPO user=s.login(input_account, input_password);
				if(user!=null){
					if (user.getIdentity()
							.equals("manager")) {
						this.notifyWatchers(State.MANAGERSTART);
						this.notifyWatchers(State.LEFTMANAGER);

					} else if (user.getIdentity()
							.equals("account")) {
						this.notifyWatchers(State.ACCOUNTANTSTART);
						this.notifyWatchers(State.LEFTACCOUNTANT);
					} else if (user.getIdentity()
							.equals("courier")) {
						this.notifyWatchers(State.COURIERSTART);
						this.notifyWatchers(State.LEFTCOURIER);
					} else if (user.getIdentity()
							.equals("hstaff")) {
						this.notifyWatchers(State.YING_START);
						this.notifyWatchers(State.LEFTYING);
					} else if (user.getIdentity()
							.equals("tstaff")) {
						this.notifyWatchers(State.ZHONG_START);
						this.notifyWatchers(State.LEFTZHONG);
					} else if (user.getIdentity()
							.equals("keeper")) {
						this.notifyWatchers(State.STOCKMANSTART);
						this.notifyWatchers(State.LEFTSTOCKMAN);
					} else if (user.getIdentity()
							.equals("admin")) {

					}
				}else{
					System.out.println("Fail login!");
				}
				

				jtf.setText("");
				jpf.setText("");
			}
 

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
