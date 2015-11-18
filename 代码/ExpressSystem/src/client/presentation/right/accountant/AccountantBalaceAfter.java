package client.presentation.right.accountant;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import client.presentation.watcher.*;

public class AccountantBalaceAfter extends JPanel implements Watched,
		ActionListener {
	int frameWidth;
	int frameHeight;
	JLabel jl[];
	JButton back;

	private List<Watcher> list;

	public AccountantBalaceAfter(int frameWidth, int frameHeight) {
		this.frameHeight = frameHeight;
		this.frameWidth = frameWidth;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBackground(new Color(254, 67, 101));
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel[7];
		for (int i = 0; i < 7; i++) {
			jl[i] = new JLabel();
		}
		back = new JButton("返回");

		init();

		for (int i = 0; i < 7; i++) {
			this.add(jl[i]);
		}
		this.add(back);
	}

	private void init() {
		jl[0].setText("查询日期");
		jl[1].setText("营业厅编号");
		jl[2].setText("收款日期");
		jl[3].setText("收款金额");
		jl[4].setText("收款快递员");
		jl[5].setText("快递订单号");
		jl[6].setText("合计金额");

		for (int i = 0; i < 7; i++) {
			jl[i].setBounds(frameWidth / 9, frameHeight / 15 + frameHeight / 8
					* i, 100, 65);
		}

		back.setBounds(frameWidth * 2 / 5, frameHeight * 9 / 10, 80, 30);
		back.addActionListener(this);
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
		if (e.getSource() == back) {
			this.notifyWatchers(State.ACCOUNTANTSTART);
		}
	}
}
