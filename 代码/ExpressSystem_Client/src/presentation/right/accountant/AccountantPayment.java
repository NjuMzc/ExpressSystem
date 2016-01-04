package presentation.right.accountant;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businesslogic.paymentServer.PayServerImpl;
import businesslogicservice.paymentblservice.PayServer;
import presentation.right.Remind;
import presentation.right.RightAll;
import presentation.right.YearMonthDay;
import presentation.watcher.*;
import vo.paymentbl.PayVO;

public class AccountantPayment extends RightAll implements ActionListener {
	PayServer blServer;
	PayVO inputMessage;
	PayVO result;

	int frameWidth;
	int frameHeight;
	JLabel[] jl;
	JButton confirm;
	JButton cancel;
	private List<Watcher> list;

	JLabel time[];
	JComboBox<String>[] timeInput;
	JTextField jtf[];
	JLabel yuan;

	JComboBox<String> type;

	JPanel jp_wrong;
	Remind remindThread;

	public AccountantPayment(int frameWidth, int frameHeight) {
		blServer = new PayServerImpl();

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel[6];
		for (int i = 0; i < 6; i++) {
			jl[i] = new JLabel();
		}
		confirm = new JButton("");// 确认
		confirm.addActionListener(this);
		cancel = new JButton("");// 取消
		cancel.addActionListener(this);

		time = new JLabel[3];
		timeInput = new JComboBox[3];
		for (int i = 0; i < 3; i++) {
			time[i] = new JLabel();
		}

		YearMonthDay time1 = new YearMonthDay();
		timeInput[0] = time1.getCboYear();
		timeInput[1] = time1.getCboMonth();
		timeInput[2] = time1.getCboDay();

		jtf = new JTextField[5];
		for (int i = 0; i < 5; i++) {
			jtf[i] = new JTextField();
			jtf[i].setFont(new Font("宋体", Font.PLAIN, 14));
		}

		yuan = new JLabel("元");
		type = new JComboBox<String>();

		init();

		for (int i = 0; i < 6; i++) {
			this.add(jl[i]);
		}
		this.add(confirm);
		this.add(cancel);
		for (int i = 0; i < 3; i++) {
			this.add(time[i]);
			this.add(timeInput[i]);
		}
		for (int i = 0; i < 5; i++) {
			if (i != 2)
				this.add(jtf[i]);
		}
		this.add(yuan);
		this.add(type);
	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\成本管理right.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth * 3 / 4, frameHeight, null);
	}

	private void init() {

		jl[0].setText("付款日期");
		jl[1].setText("付款人");
		jl[2].setText("付款账户");
		jl[3].setText("付款条目");
		jl[4].setText("付款金额");
		jl[5].setText("备注");
		for (int i = 0; i < 6; i++) {
			jl[i].setBounds(frameWidth / 10, frameHeight / 15 + frameHeight / 8
					* i, frameWidth / 8, frameHeight / 20);
			jl[i].setFont(new Font("宋体", Font.BOLD, 16));
		}
		confirm.setBounds(frameWidth / 6, frameHeight * 8 / 10 + frameHeight
				/ 30, frameWidth / 9, frameHeight / 16);

		cancel.setBounds(frameWidth * 2 / 5 + frameWidth / 15, frameHeight * 8
				/ 10 + frameHeight / 30, frameWidth / 9, frameHeight / 16);

		ImageIcon icon1 = new ImageIcon("pictures//取消t.png");
		Image temp1 = icon1.getImage().getScaledInstance(icon1.getIconWidth(),
				icon1.getIconHeight(), icon1.getImage().SCALE_DEFAULT);
		icon1 = new ImageIcon(temp1);
		cancel.setIcon(icon1);

		ImageIcon icon2 = new ImageIcon("pictures//确认小.png");
		Image temp2 = icon2.getImage().getScaledInstance(icon2.getIconWidth(),
				icon2.getIconHeight(), icon2.getImage().SCALE_DEFAULT);
		icon2 = new ImageIcon(temp2);
		confirm.setIcon(icon2);

		time[0].setText("年");
		time[1].setText("月");
		time[2].setText("日");
		for (int i = 0; i < 3; i++) {
			timeInput[i].setBounds(frameWidth / 4 + frameWidth / 10 * i,
					frameHeight / 15, frameWidth / 12, frameHeight / 20);
			time[i].setBounds(frameWidth / 3 + frameWidth / 10 * i,
					frameHeight / 15, frameWidth / 12, frameHeight / 20);
			time[i].setFont(new Font("宋体", Font.PLAIN, 14));
		}

		for (int i = 0; i < 5; i++) {
			if (i != 4) {
				jtf[i].setBounds(frameWidth / 4, frameHeight / 15 + frameHeight
						/ 8 * (i + 1), frameWidth / 10, frameHeight / 20);
				jtf[i].setFont(new Font("宋体", Font.PLAIN, 14));
			} else {
				jtf[i].setBounds(frameWidth / 4, frameHeight / 15 + frameHeight
						/ 8 * (i + 1), frameWidth / 5, frameHeight / 20);
				jtf[i].setFont(new Font("宋体", Font.PLAIN, 14));
			}
		}
		type.addItem("租金");
		type.addItem("运费");
		type.addItem("工资");
		type.addItem("奖励");
		type.setBounds(frameWidth / 4, frameHeight / 15 + frameHeight / 8 * 3,
				frameWidth / 10, frameHeight / 20);
		type.setFont(new Font("宋体", Font.PLAIN, 13));

		jtf[3].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())
						&& e.getKeyChar() != KeyEvent.VK_PERIOD) {
					e.consume();
				}
			}
		});
		yuan.setBounds(frameWidth / 5 * 2 - frameWidth / 25, frameHeight / 15
				+ frameHeight / 2, frameWidth / 10, frameHeight / 20);
		yuan.setFont(new Font("宋体", Font.BOLD, 16));

		jtf[0].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					jtf[1].requestFocus();
				}
			}
		});
		jtf[1].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					jtf[3].requestFocus();
				}
			}
		});

		jtf[3].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					jtf[4].requestFocus();
				}
			}
		});
		jtf[4].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					jtf[3].requestFocus();
				}
			}
		});
		jtf[3].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					jtf[1].requestFocus();
				}
			}
		});

		jtf[1].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					jtf[0].requestFocus();
				}
			}
		});
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

	private void showMessage(String message) {
		if (remindThread != null) {
			remindThread.stop();
			this.remove(jp_wrong);
		}
		jp_wrong = new JPanel();

		this.add(jp_wrong);
		remindThread = new Remind(jp_wrong, message);
		remindThread.start();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancel) {
			this.notifyWatchers(State.ACCOUNTANTSTART);
		} else if (e.getSource() == confirm) {
			inputMessage = new PayVO();

			String year = timeInput[0].getSelectedItem().toString();
			String month = timeInput[1].getSelectedItem().toString();
			String day = timeInput[2].getSelectedItem().toString();

			String date = year + "-" + month + "-" + day;
			inputMessage.setDate(date);

			String payer = jtf[0].getText();
			String account = jtf[1].getText();
			String tiaoMu = jtf[2].getText();
			String money = jtf[3].getText();
			String beiZhu = jtf[4].getText();

			inputMessage.setPayer(payer);
			inputMessage.setAccount(account);
			inputMessage.setTiaoMu(tiaoMu);
			inputMessage.setMoney(money);
			inputMessage.setBeiZhu(beiZhu);

			result = blServer.makeBill(inputMessage);

			if (result.isWrong()) {
				// 錯誤處理
				showMessage(result.getWrongMessage());
			} else {
				this.notifyWatchers(State.ACCOUNTANTSTART);
			}

		}

	}

}
