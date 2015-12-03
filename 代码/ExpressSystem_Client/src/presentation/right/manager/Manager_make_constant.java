package presentation.right.manager;

import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import presentation.right.RightAll;
import presentation.watcher.*;

public class Manager_make_constant extends RightAll implements ActionListener {
	int frameWidth;
	int frameHeight;

	JLabel cityremind;
	JLabel city[];
	JLabel km[];
	JTextField jtf1[];
	JLabel feeremind;
	JLabel fee[];
	JLabel yuan[];
	JTextField jtf2[];
	JButton submit;
	JButton cancel;
	private List<Watcher> list;

	public Manager_make_constant(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		cityremind = new JLabel("城市距离");
		city = new JLabel[6];
		km = new JLabel[6];
		jtf1 = new JTextField[6];
		for (int i = 0; i < 6; i++) {
			city[i] = new JLabel();
			km[i] = new JLabel("km");
			jtf1[i] = new JTextField();
		}

		feeremind = new JLabel("包装价格:");
		fee = new JLabel[3];
		yuan = new JLabel[3];
		jtf2 = new JTextField[3];
		for (int i = 0; i < 3; i++) {
			fee[i] = new JLabel();
			yuan[i] = new JLabel("元");
			jtf2[i] = new JTextField();
		}
		submit = new JButton("提交");
		cancel = new JButton("取消");

		init();

		this.add(cityremind);
		this.add(feeremind);
		for (int i = 0; i < 6; i++) {
			this.add(city[i]);
			this.add(km[i]);
			this.add(jtf1[i]);
		}
		for (int i = 0; i < 3; i++) {
			this.add(fee[i]);
			this.add(yuan[i]);
			this.add(jtf2[i]);
		}
		this.add(submit);
		this.add(cancel);

	}

	private void init() {
		cityremind.setBounds(frameWidth / 10, frameHeight / 10,
				frameWidth / 10, frameHeight / 10);
		feeremind.setBounds(frameWidth / 10,
				frameHeight / 2 + frameHeight / 10, frameWidth / 10,
				frameHeight / 10);
		city[0].setText("南京——北京");
		city[1].setText("北京——广州");
		city[2].setText("广州——上海");
		city[3].setText("上海——南京");
		city[4].setText("广州——北京");
		city[5].setText("上海——广州");
		fee[0].setText("木箱：");
		fee[1].setText("纸盒：");
		fee[2].setText("包装袋：");
		for (int i = 0; i < 3; i++) {
			city[i].setBounds(frameWidth / 10, frameHeight / 5 + frameHeight
					/ 10 * i, frameWidth / 10, frameHeight / 20);
			km[i].setBounds(frameWidth / 20 * 7, frameHeight / 5 + frameHeight
					/ 10 * i, frameWidth / 10, frameHeight / 20);
			fee[i].setBounds(frameWidth / 10 + frameWidth / 5 * i, frameHeight
					/ 2 + frameHeight / 5, frameWidth / 10, frameHeight / 20);
			yuan[i].setBounds(frameWidth / 10 + frameWidth / 8 + frameWidth / 5
					* i, frameHeight / 2 + frameHeight / 5, frameWidth / 20,
					frameHeight / 20);
			jtf1[i].setBounds(frameWidth / 40 * 9, frameHeight / 5
					+ frameHeight / 10 * i, frameWidth / 10, frameHeight / 20);
			jtf2[i].setBounds(frameWidth / 6 +  frameWidth / 5
					* i, frameHeight / 2 + frameHeight / 5, frameWidth / 20,
					frameHeight / 20);
		}
		for (int i = 3; i < 6; i++) {
			city[i].setBounds(frameWidth / 12 * 5, frameHeight / 5
					+ frameHeight / 10 * (i - 3), frameWidth / 10,
					frameHeight / 20);
			km[i].setBounds(frameWidth / 12 * 5 + frameWidth / 4, frameHeight
					/ 5 + frameHeight / 10 * (i - 3), frameWidth / 10,
					frameHeight / 20);
			jtf1[i].setBounds(frameWidth / 12 * 5 + frameWidth / 4 - frameWidth
					/ 8, frameHeight / 5 + frameHeight / 10 * (i - 3),
					frameWidth / 10, frameHeight / 20);
		}

		submit.setBounds(frameWidth / 10, frameHeight / 10 * 9,
				frameWidth / 10, frameHeight / 20);
		cancel.setBounds(frameWidth / 20 * 11, frameHeight / 10 * 9,
				frameWidth / 10, frameHeight / 20);

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
	}
}
