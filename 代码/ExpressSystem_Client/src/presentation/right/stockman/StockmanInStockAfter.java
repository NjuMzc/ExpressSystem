package presentation.right.stockman;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import presentation.watcher.*;

public class StockmanInStockAfter extends JPanel implements Watched,
		ActionListener {
	int frameWidth;
	int frameHeight;
	JLabel[] jl;
	JButton confirm;
	JButton cancel;
	private List<Watcher> list;

	public StockmanInStockAfter(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBackground(new Color(254, 67, 101));
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel[8];
		for (int i = 0; i < 8; i++) {
			jl[i] = new JLabel();
		}
		confirm = new JButton("确认");
		cancel = new JButton("返回修改");

		init();

		for (int i = 0; i < 8; i++) {
			this.add(jl[i]);
		}
		this.add(confirm);
		this.add(cancel);

	}

	private void init() {

		jl[0].setText("请输入单据信息");
		jl[1].setText("中转中心仓库入库单");
		jl[2].setText("快递编号");
		jl[3].setText("货物目的地");
		jl[4].setText("货物位置");
		jl[5].setText("入库日期");
		jl[6].setText("填写人");
		jl[7].setText("单据状态");

		jl[0].setBounds(frameWidth / 10, frameHeight / 20, 100, 65);
		jl[1].setBounds(frameWidth / 4, frameHeight / 8, 100, 65);
		for (int i = 2; i < 5; i++) {
			jl[i].setBounds(frameWidth / 10, frameHeight / 10 * i, 100, 65);
		}
		jl[5].setBounds(frameWidth / 2, frameHeight / 5, 100, 65);
		jl[6].setBounds(frameWidth / 2, frameHeight / 2, 100, 65);
		jl[7].setBounds(frameWidth / 2, frameHeight / 5 * 3, 100, 65);

		confirm.setMargin(new Insets(0, 0, 0, 0));
		confirm.setBounds(150, frameHeight - 100, frameWidth / 12,
				frameWidth / 20);
		confirm.addActionListener(this);
		cancel.setMargin(new Insets(0, 0, 0, 0));
		cancel.setBounds(frameWidth * 3 / 4 - 225, frameHeight - 100,
				frameWidth / 12, frameWidth / 20);
		cancel.addActionListener(this);

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
		if (e.getSource() == cancel) {
			this.notifyWatchers(State.STOCKMANINSTOCK);
		} else if (e.getSource() == confirm) {
			this.notifyWatchers(State.STOCKMANSTART);
		}
	}
}
