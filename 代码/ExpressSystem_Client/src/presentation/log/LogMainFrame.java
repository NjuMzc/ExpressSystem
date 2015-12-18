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

import presentation.right.RightAll;
import presentation.watcher.State;
import presentation.watcher.Watched;
import presentation.watcher.Watcher;
import vo.SystemUserVO;
import businesslogic.systembl.SystemBlServerImpl;
import businesslogicservice.systemblservice.systemServer;

public class LogMainFrame extends RightAll implements ActionListener {
	SystemUserVO user;

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

		confirm.setContentAreaFilled(false);// 设置按钮透明
		cancel.setContentAreaFilled(false);

		confirm.setBorderPainted(false);// 隐藏边框
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
	// 添加背景
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\系统登录界面.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth, frameHeight, null);
	}

	private void init() {

		confirm.setBounds(frameWidth * 9 / 32, frameHeight * 93 / 128,
				frameWidth * 7 / 48, frameWidth / 20);
		confirm.addActionListener(this);
		cancel.setBounds(frameWidth * 9 / 16, frameHeight * 93 / 128,
				frameWidth * 7 / 48, frameWidth / 20);
		cancel.addActionListener(this);

		// //左栏按钮贴图
		// ImageIcon icon0 = new ImageIcon("pictures//确认.png");
		// Image temp0 = icon0.getImage().getScaledInstance(confirm.getWidth(),
		// confirm.getHeight(), icon0.getImage().SCALE_DEFAULT);
		// icon0 = new ImageIcon(temp0);
		// confirm.setIcon(icon0);
		//
		// //左栏按钮贴图
		// ImageIcon icon1 = new ImageIcon("pictures//取消.png");
		// Image temp1 = icon1.getImage().getScaledInstance(cancel.getWidth(),
		// cancel.getHeight(), icon1.getImage().SCALE_DEFAULT);
		// icon1 = new ImageIcon(temp1);
		// cancel.setIcon(icon1);

		jtf.setBounds(frameWidth * 38 / 112, frameHeight * 57 / 128, 300, 50);
		jtf.setFont(new Font("宋体", Font.PLAIN, 28));
		jtf.setOpaque(false);
		jtf.setBorder(null);
		jpf.setBounds(frameWidth * 38 / 112, frameHeight * 77 / 128, 300, 50);
		jpf.setFont(new Font("宋体", Font.PLAIN, 20));
		jpf.setBorder(null);
		jpf.setOpaque(false);
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

		jtf.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
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
			user = s.login(input_account, input_password);
			if (!user.isWrong()) {
				if (user.getIdentity().equals("总经理")) {
					this.notifyWatchers(State.MANAGERSTART);
					this.notifyWatchers(State.LEFTMANAGER);

				} else if (user.getIdentity().equals("财务人员")) {
					this.notifyWatchers(State.ACCOUNTANTSTART);
					this.notifyWatchers(State.LEFTACCOUNTANT);
				} else if (user.getIdentity().equals("快递员")) {
					this.notifyWatchers(State.COURIERSTART);
					this.notifyWatchers(State.LEFTCOURIER);
				} else if (user.getIdentity().equals("营业厅业务员")) {
					this.notifyWatchers(State.YING_START);
					this.notifyWatchers(State.LEFTYING);
				} else if (user.getIdentity().equals("中转中心业务员")) {
					this.notifyWatchers(State.ZHONG_START);
					this.notifyWatchers(State.LEFTZHONG);
				} else if (user.getIdentity().equals("中转中心仓库管理员")) {
					this.notifyWatchers(State.STOCKMANSTART);
					this.notifyWatchers(State.LEFTSTOCKMAN);
				} else if (user.getIdentity().equals("系统管理员")) {

					this.notifyWatchers(State.ADMINSTART);
					this.notifyWatchers(State.LEFTADMIN);
				}
			} else {
				System.out.println("Fail login!");
				// 错误处理
				final JLabel remindWrong = new JLabel();
				remindWrong.setBounds(frameWidth * 3 / 8, frameHeight * 17 / 20,
						frameWidth / 4, frameHeight / 20);
				remindWrong.setFont(new Font("宋体", Font.BOLD, 20));
				remindWrong.setForeground(Color.red);
				this.add(remindWrong);
				this.repaint();

				Thread t = new Thread(new Runnable() {
					@Override
					public void run() {
						// 以下根据错误类型设置文字
						remindWrong.setText(user.getWrongMessage());
						try {
							Thread.sleep(2000);
						} catch (Exception e2) {
							// TODO: handle exception
						}
						remindWrong.setText("");
					}
				});
				t.start();
				// 错误处理结束
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
