package client.presentation.right.accountant;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import client.presentation.watcher.*;

public class AccountantMakebill extends JPanel implements Watched,
		ActionListener {
	int frameWidth;
	int frameHeight;

	// 上侧的panel
	JPanel up;
	JLabel accountantInfor;
	JButton jb[];

	JPanel addDown = null;

	private List<Watcher> list;

	public AccountantMakebill(int frameWidth, int frameHeight) {
		this.frameHeight = frameHeight;
		this.frameWidth = frameWidth;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBackground(new Color(254, 67, 101));
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		up = new JPanel();
		accountantInfor = new JLabel("账目日期");
		jb = new JButton[6];
		for (int i = 0; i < 6; i++) {
			jb[i] = new JButton();
		}

		init();

		up.add(accountantInfor);
		for (int i = 0; i < 6; i++) {
			up.add(jb[i]);
		}

		this.add(up);
	}

	private void init() {
		up.setBounds(0, 0, frameWidth / 4 * 3, frameHeight / 3);
		up.setBackground(Color.cyan);
		accountantInfor.setBounds(frameWidth / 10, frameHeight / 30, 100, 50);
		jb[0].setText("机构信息");
		jb[1].setText("人员信息");
		jb[2].setText("车辆信息");
		jb[3].setText("收支信息");
		jb[4].setText("库存信息");
		jb[5].setText("银行信息");
		for (int i = 0; i < 3; i++) {
			jb[i].setBounds(frameWidth / 10 + i * frameWidth / 6,
					frameHeight / 8, 100, 30);
			jb[i].addActionListener(this);
		}
		for (int i = 3; i < 6; i++) {
			jb[i].setBounds(frameWidth / 10 + (i - 3) * frameWidth / 6,
					frameHeight / 4, 100, 30);
			jb[i].addActionListener(this);
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

	public void actionPerformed(ActionEvent e) {

		if (addDown != null) {
			this.remove(addDown);
		}

		if (e.getSource() == jb[5]) {
			addDown = makeBankPanel();
		} else if (e.getSource() == jb[4]) {
			System.out.println("1");
			addDown = makeStoragePanel();
		} else if (e.getSource() == jb[3]) {
			addDown = makePaymentPanel();
		} else if (e.getSource() == jb[2]) {
			addDown = makeCarPanel();
		} else if (e.getSource() == jb[1]) {
			addDown = makePeoplePanel();
		} else if (e.getSource() == jb[0]) {
			addDown = makeOrangizationPanel();
		}

		this.add(addDown);
		this.repaint();
	}

	private JPanel makeBankPanel() {
		JPanel bankPanel = new JPanel();
		JLabel jl[];
		JButton confirm;
		JButton cancel;
		jl = new JLabel[4];
		for (int i = 0; i < 4; i++) {
			jl[i] = new JLabel();
		}

		bankPanel.setBackground(Color.gray);
		bankPanel.setBounds(0, frameHeight / 3, frameWidth / 4 * 3,
				frameHeight / 3 * 2);

		confirm = new JButton("确认");
		confirm.setBounds(frameWidth / 8, frameHeight / 2, 80, 30);
		confirm.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});

		cancel = new JButton("取消");
		cancel.setBounds(frameWidth / 2, frameHeight / 2, 80, 30);
		cancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

			}
		});

		jl[0].setText("银行信息");
		jl[1].setText("名称");
		jl[2].setText("账户");
		jl[3].setText("余额");

		jl[0].setBounds(frameWidth / 10, frameHeight / 30, 100, 50);
		for (int i = 1; i < 4; i++) {
			jl[i].setBounds(frameWidth / 10 + (i - 1) * frameWidth / 6,
					frameHeight / 8, 100, 30);
		}

		bankPanel.add(confirm);
		bankPanel.add(cancel);
		for (int i = 0; i < 4; i++) {
			bankPanel.add(jl[i]);
		}

		return bankPanel;
	}

	private JPanel makeStoragePanel() {
		JPanel storagePanel = new JPanel();
		JLabel jl[];
		JButton confirm;
		JButton cancel;
		jl = new JLabel[4];
		for (int i = 0; i < 4; i++) {
			jl[i] = new JLabel();
		}

		storagePanel.setBackground(Color.gray);
		storagePanel.setBounds(0, frameHeight / 3, frameWidth / 4 * 3,
				frameHeight / 3 * 2);

		confirm = new JButton("确认");
		confirm.setBounds(frameWidth / 8, frameHeight / 2, 80, 30);
		confirm.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});

		cancel = new JButton("取消");
		cancel.setBounds(frameWidth / 2, frameHeight / 2, 80, 30);
		cancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

			}
		});

		jl[0].setText("库存信息");
		jl[1].setText("名称");
		jl[2].setText("数量");
		jl[3].setText("价格");

		jl[0].setBounds(frameWidth / 10, frameHeight / 30, 100, 50);
		for (int i = 1; i < 4; i++) {
			jl[i].setBounds(frameWidth / 10 + (i - 1) * frameWidth / 6,
					frameHeight / 8, 100, 30);
		}

		storagePanel.add(confirm);
		storagePanel.add(cancel);
		for (int i = 0; i < 4; i++) {
			storagePanel.add(jl[i]);
		}

		return storagePanel;
	}

	private JPanel makePaymentPanel() {
		JPanel paymentPanel = new JPanel();
		JLabel jl[];
		JButton confirm;
		JButton cancel;
		jl = new JLabel[4];
		for (int i = 0; i < 4; i++) {
			jl[i] = new JLabel();
		}

		paymentPanel.setBackground(Color.gray);
		paymentPanel.setBounds(0, frameHeight / 3, frameWidth / 4 * 3,
				frameHeight / 3 * 2);

		confirm = new JButton("确认");
		confirm.setBounds(frameWidth / 8, frameHeight / 2, 80, 30);
		confirm.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});

		cancel = new JButton("取消");
		cancel.setBounds(frameWidth / 2, frameHeight / 2, 80, 30);
		cancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

			}
		});

		jl[0].setText("收支信息");
		jl[1].setText("总收入");
		jl[2].setText("总支出");
		jl[3].setText("总利润");

		jl[0].setBounds(frameWidth / 10, frameHeight / 30, 100, 50);
		for (int i = 1; i < 4; i++) {
			jl[i].setBounds(frameWidth / 10, frameHeight / 8 + (i - 1)
					* frameHeight / 8, 100, 30);
		}

		paymentPanel.add(confirm);
		paymentPanel.add(cancel);
		for (int i = 0; i < 4; i++) {
			paymentPanel.add(jl[i]);
		}

		return paymentPanel;
	}

	private JPanel makeCarPanel() {
		JPanel carPanel = new JPanel();
		JLabel jl[];
		JButton confirm;
		JButton cancel;
		jl = new JLabel[3];
		for (int i = 0; i < 3; i++) {
			jl[i] = new JLabel();
		}

		carPanel.setBackground(Color.gray);
		carPanel.setBounds(0, frameHeight / 3, frameWidth / 4 * 3,
				frameHeight / 3 * 2);

		confirm = new JButton("确认");
		confirm.setBounds(frameWidth / 8, frameHeight / 2, 80, 30);
		confirm.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});

		cancel = new JButton("取消");
		cancel.setBounds(frameWidth / 2, frameHeight / 2, 80, 30);
		cancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

			}
		});

		jl[0].setText("车辆信息");
		jl[1].setText("车型");
		jl[2].setText("车牌");

		jl[0].setBounds(frameWidth / 10, frameHeight / 30, 100, 50);
		for (int i = 1; i < 3; i++) {
			jl[i].setBounds(frameWidth / 10 + (i - 1) * frameWidth / 5,
					frameHeight / 8, 100, 30);
		}

		carPanel.add(confirm);
		carPanel.add(cancel);
		for (int i = 0; i < 3; i++) {
			carPanel.add(jl[i]);
		}

		return carPanel;
	}

	private JPanel makePeoplePanel() {
		JPanel peoplePanel = new JPanel();
		JLabel jl[];
		JButton confirm;
		JButton cancel;
		jl = new JLabel[4];
		for (int i = 0; i < 4; i++) {
			jl[i] = new JLabel();
		}

		peoplePanel.setBackground(Color.gray);
		peoplePanel.setBounds(0, frameHeight / 3, frameWidth / 4 * 3,
				frameHeight / 3 * 2);

		confirm = new JButton("确认");
		confirm.setBounds(frameWidth / 8, frameHeight / 2, 80, 30);
		confirm.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});

		cancel = new JButton("取消");
		cancel.setBounds(frameWidth / 2, frameHeight / 2, 80, 30);
		cancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

			}
		});

		jl[0].setText("人员信息");
		jl[1].setText("姓名");
		jl[2].setText("性别");
		jl[3].setText("身份证号");

		jl[0].setBounds(frameWidth / 10, frameHeight / 30, 100, 50);
		for (int i = 1; i < 4; i++) {
			jl[i].setBounds(frameWidth / 10 + (i - 1) * frameWidth / 6,
					frameHeight / 8, 100, 30);
		}

		peoplePanel.add(confirm);
		peoplePanel.add(cancel);
		for (int i = 0; i < 4; i++) {
			peoplePanel.add(jl[i]);
		}

		return peoplePanel;
	}

	private JPanel makeOrangizationPanel() {
		JPanel orangizationPanel = new JPanel();
		JLabel jl[];
		JButton confirm;
		JButton cancel;
		jl = new JLabel[8];
		for (int i = 0; i < 8; i++) {
			jl[i] = new JLabel();
		}

		orangizationPanel.setBackground(Color.gray);
		orangizationPanel.setBounds(0, frameHeight / 3, frameWidth / 4 * 3,
				frameHeight / 3 * 2);

		confirm = new JButton("确认");
		confirm.setBounds(frameWidth / 8, frameHeight / 2, 80, 30);
		confirm.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});

		cancel = new JButton("取消");
		cancel.setBounds(frameWidth / 2, frameHeight / 2, 80, 30);
		cancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

			}
		});

		jl[0].setText("机构信息");
		jl[1].setText("仓库");
		jl[2].setText("营业厅");
		jl[3].setText("中转中心");
		jl[4].setText("南京");
		jl[5].setText("北京");
		jl[6].setText("上海");
		jl[7].setText("广州");

		jl[0].setBounds(frameWidth / 10, frameHeight / 20, 100, 30);
		for (int i = 1; i < 4; i++) {
			jl[i].setBounds(frameWidth / 10, frameHeight / 8 + (i-1) * frameHeight
					/ 8, 100, 30);
		}
		for (int i = 4; i < 8; i++) {
			jl[i].setBounds(frameWidth / 10 + (i - 3) * frameWidth / 10,
					frameHeight / 20, 100, 30);
		}

		orangizationPanel.add(confirm);
		orangizationPanel.add(cancel);
		for (int i = 0; i < 8; i++) {
			orangizationPanel.add(jl[i]);
		}

		return orangizationPanel;
	}
}
