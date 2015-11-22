package presentation.right.accountant;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.watcher.*;

public class AccountantPayment extends JPanel implements Watched,
		ActionListener {
	int frameWidth;
	int frameHeight;
	JLabel[] jl;
	JButton confirm;
	JButton cancel;
	private List<Watcher> list;

	public AccountantPayment(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBackground(new Color(254, 67, 101));
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel[6];
		for (int i = 0; i < 6; i++) {
			jl[i] = new JLabel();
		}
		confirm = new JButton("确认");
		confirm.addActionListener(this);
		cancel = new JButton("取消");
		cancel.addActionListener(this);

		init();

		for (int i = 0; i < 6; i++) {
			this.add(jl[i]);
		}
		this.add(confirm);
		this.add(cancel);

	}

	private void init() {

		jl[0].setText("付款日期");
		jl[1].setText("付款人");
		jl[2].setText("付款账户");
		jl[3].setText("付款条目");
		jl[4].setText("付款金额");
		jl[5].setText("备注");

		for (int i = 0; i < 6; i++) {
			jl[i].setBounds(frameWidth / 9, frameHeight / 15 + frameHeight / 8
					* i, 100, 65);
		}

		confirm.setMargin(new Insets(0, 0, 0, 0));
		confirm.setBounds(150, frameHeight - 100, frameWidth / 12,
				frameWidth / 20);
		cancel.setMargin(new Insets(0, 0, 0, 0));
		cancel.setBounds(frameWidth * 3 / 4 - 225, frameHeight - 100,
				frameWidth / 12, frameWidth / 20);

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

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancel) {
			this.notifyWatchers(State.ACCOUNTANTSTART);
		} else if (e.getSource() == confirm) {

		}

	}
}
