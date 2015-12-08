package presentation.right.accountant;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.right.RightAll;
import presentation.watcher.*;

public class AccountantPayment extends RightAll implements ActionListener {
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
	JButton search;

	public AccountantPayment(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel[6];
		for (int i = 0; i < 6; i++) {
			jl[i] = new JLabel();
		}
		confirm = new JButton("确认");
		confirm.addActionListener(this);
		cancel = new JButton("取消");
		cancel.addActionListener(this);

		time = new JLabel[3];
		timeInput = new JComboBox[3];
		for (int i = 0; i < 3; i++) {
			time[i] = new JLabel();
		}
		String[] year = { "2015", "2016", "2017", "2018", "2019", "2020" };
		String[] month = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12" };
		String[] day = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
				"21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
				"31" };
		timeInput[0] = new JComboBox<String>(year);
		timeInput[1] = new JComboBox<String>(month);
		timeInput[2] = new JComboBox<String>(day);

		jtf = new JTextField[5];
		for (int i = 0; i < 5; i++) {
			jtf[i] = new JTextField();
		}
		yuan = new JLabel("元");
		search = new JButton("查询");

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
			this.add(jtf[i]);
		}
		this.add(yuan);
		this.add(search);

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
			jl[i].setFont(new Font("宋体",Font.BOLD,16));
		}
		confirm.setBounds(frameWidth / 4, frameHeight / 10 * 9,
				frameWidth / 10, frameWidth / 20);
		cancel.setBounds(frameWidth / 2, frameHeight / 10 * 9, frameWidth / 10,
				frameWidth / 20);

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
			jtf[i].setBounds(frameWidth / 4, frameHeight / 15 + frameHeight / 8
					* (i + 1), frameWidth / 10, frameHeight / 20);
		}
		yuan.setBounds(frameWidth / 5 * 2, frameHeight / 15 + frameHeight / 2,
				frameWidth / 10, frameHeight / 20);
		yuan.setFont(new Font("宋体",Font.BOLD,16));
		search.setBounds(frameWidth / 8 * 5, frameHeight / 15, frameWidth / 12,
				frameHeight / 20);

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
