package presentation.right.manager;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import presentation.right.RightAll;
import presentation.right.YearMonthDay;
import presentation.watcher.*;

public class Manager_find extends RightAll implements ActionListener {
	int frameWidth;
	int frameHeight;

	JLabel remind;
	JLabel remindTime;
	JLabel start;
	JLabel end;
	JButton search;
	JComboBox<String> type;
	JComboBox<String>[] startTime;
	JComboBox<String>[] endTime;
	JLabel calendar1[];
	JLabel calendar2[];
	JTextArea jta;

	private List<Watcher> list;

	public Manager_find(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		type = new JComboBox<String>();
		remind = new JLabel("请选择报表类型:");
		remindTime = new JLabel("请选择查询时间段:");
		start = new JLabel("开始时间");
		end = new JLabel("结束时间");
		startTime = new JComboBox[3];
		endTime = new JComboBox[3];
		YearMonthDay time1=new YearMonthDay();
		startTime[0] = time1.getCboYear();
		startTime[1] = time1.getCboMonth();
		startTime[2] = time1.getCboDay();
		YearMonthDay time2=new YearMonthDay();
		endTime[0] = time2.getCboYear();
		endTime[1] = time2.getCboMonth();
		endTime[2] = time2.getCboDay();
		calendar1 = new JLabel[3];
		calendar2 = new JLabel[3];
		for (int i = 0; i < 3; i++) {
			calendar1[i] = new JLabel();
			calendar2[i] = new JLabel();
		}
		search = new JButton("查询");

		init();

		this.add(type);
		this.add(remind);
		this.add(remindTime);
		this.add(start);
		this.add(end);
		for (int i = 0; i < 3; i++) {
			this.add(startTime[i]);
			this.add(endTime[i]);
			this.add(calendar1[i]);
			this.add(calendar2[i]);
		}
		this.add(search);
	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\系统管理startRight.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth * 3 / 4, frameHeight, null);
	}

	private void init() {

		type.addItem("成本收益表");
		type.addItem("经营情况表");
		type.setBounds(frameWidth / 4, frameHeight / 20, frameWidth / 8,
				frameHeight / 20);
		remind.setBounds(frameWidth / 20, frameHeight / 20, frameWidth / 8,
				frameHeight / 20);
		remindTime.setBounds(frameWidth / 20, frameHeight / 20 * 3,
				frameWidth / 8, frameHeight / 20);
		start.setBounds(frameWidth / 4, frameHeight / 20 * 3, frameWidth / 10,
				frameHeight / 20);
		end.setBounds(frameWidth / 4, frameHeight / 20 * 5, frameWidth / 10,
				frameHeight / 20);
		calendar1[0].setText("年");
		calendar1[1].setText("月");
		calendar1[2].setText("日");
		calendar2[0].setText("年");
		calendar2[1].setText("月");
		calendar2[2].setText("日");
		for (int i = 0; i < 3; i++) {
			startTime[i].setBounds(frameWidth / 3 + frameWidth / 8 * i,
					frameHeight / 20 * 3, frameWidth / 12, frameHeight / 20);
			endTime[i].setBounds(frameWidth / 3 + frameWidth / 8 * i,
					frameHeight / 20 * 5, frameWidth / 12, frameHeight / 20);
			calendar1[i].setBounds(frameWidth / 30 * 13 + frameWidth / 8 * i,
					frameHeight / 20 * 3, frameWidth / 20, frameHeight / 20);
			calendar2[i].setBounds(frameWidth / 30 * 13 + frameWidth / 8 * i,
					frameHeight / 20 * 5, frameWidth / 20, frameHeight / 20);
		}
		search.setBounds(frameWidth / 2, frameHeight / 20, frameWidth / 8,
				frameHeight / 20);
		search.addActionListener(this);

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

	private void initJTa() {
		jta = new JTextArea();
		jta.setBounds(frameWidth / 8, frameHeight / 3, frameWidth / 2,
				frameHeight / 3 * 2);

		jta.append("成本收益表\r\n");
		jta.append("成本收益表\r\n");
		jta.setEditable(false);

		this.add(jta);
		this.repaint();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == search) {

			initJTa();

		}
	}
}
