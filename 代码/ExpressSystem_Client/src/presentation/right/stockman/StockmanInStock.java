package presentation.right.stockman;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import presentation.right.RightAll;
import presentation.watcher.*;

public class StockmanInStock extends RightAll implements  ActionListener {
	int frameWidth;
	int frameHeight;
	JLabel[] jl;
	JButton confirm;
	JButton cancel;
	private List<Watcher> list;

	public StockmanInStock(int frameWidth, int frameHeight) {

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
		cancel = new JButton("取消");

		init();

		for (int i = 0; i < 8; i++) {
			this.add(jl[i]);
		}
		this.add(confirm);
		this.add(cancel);

	}

	private void init() {

		jl[0].setText("快递编号");
		jl[1].setText("入库日期");
		jl[2].setText("目的地");
		jl[3].setText("库存位置");
		jl[4].setText("区号");
		jl[5].setText("排号");
		jl[6].setText("架号");
		jl[7].setText("位号");

		for (int i = 0; i < 4; i++) {
			jl[i].setBounds(frameWidth / 8, frameHeight / 10 * (i + 1), 100, 65);
		}
		for (int i = 4; i < 8; i++) {
			jl[i].setBounds(frameWidth / 4, frameHeight / 10 * i, 100, 65);
		}

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
			this.notifyWatchers(State.STOCKMANSTART);
		}else if(e.getSource()==confirm){
			this.notifyWatchers(State.STOCKMANINSTOCKAFTER);
		}
	}
}
