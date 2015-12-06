package presentation.right.stockman;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import presentation.right.RightAll;
import presentation.watcher.*;

public class StockmanChange extends RightAll implements ActionListener {
	int frameWidth;
	int frameHeight;

	JPanel jp1;
	JPanel jp2;
	JPanel jp3;
	JPanel jp4;
	JLabel jl1;
	JLabel jl2;
	JLabel jl3;
	JLabel jl4;
	JButton jb1[];
	JButton jb2[];
	JButton jb3[];
	JButton jb4[];
	private List<Watcher> list;
	String qu;
	String pai;
	String jia;
	String wei;

	public StockmanChange(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jp1 = new JPanel();
		jb1 = new JButton[3];
		for (int i = 0; i < 3; i++) {
			jb1[i] = new JButton();
		}
		jl1 = new JLabel("请选择调整的分区：");

		init();

		for (int i = 0; i < 3; i++) {
			jp1.add(jb1[i]);
		}
		jp1.add(jl1);
		this.add(jp1);
	}

	private void init() {
		jp1.setLayout(null);
		jp1.setBounds(0, 0, frameWidth / 4 * 3, frameHeight);
		jb1[0].setText("航空区");
		jb1[1].setText("火车区");
		jb1[2].setText("汽运区");
		for (int i = 0; i < 3; i++) {
			jb1[i].setBounds(frameWidth / 16 + frameWidth / 48 * 11 * i,
					frameHeight / 8 * 3, frameWidth / 6, frameHeight / 4);
			jb1[i].addActionListener(this);
		}
		jl1.setBounds(frameWidth / 16, frameHeight / 4, frameWidth / 8,
				frameHeight / 8);
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
		for (int i = 0; i < 3; i++) {
			if (e.getSource() == jb1[i]) {
				qu = jb1[i].getText();
				this.remove(jp1);
				initJp2();
				this.add(jp2);
				this.repaint();
				break;
			}
		}

		for (int i = 0; i < 8; i++) {
			if (e.getSource() == jb2[i]) {
				pai = jb2[i].getText();
				this.remove(jp2);
				initJp3();
				this.add(jp3);
				this.repaint();
				break;
			}
		}

		for (int i = 0; i < 10; i++) {
			if (e.getSource() == jb3[i]) {
				jia = jb3[i].getText();
				this.remove(jp3);
				initJp4();
				this.add(jp4);
				this.repaint();
				break;
			}
		}
	}

	private void initJp4() {
		jp4 = new JPanel();
		jb4 = new JButton[30];
		for (int i = 0; i < 30; i++) {
			jb4[i] = new JButton();
			jb4[i].setText("" + (i + 1));
		}
		jl4 = new JLabel("请选择调整的位号：");
		jl4.setBounds(0, 0, frameWidth / 8, frameHeight / 20);
		jp4.setBounds(0, 0, frameWidth / 4 * 3, frameHeight);
		jp4.setLayout(null);
		for (int i = 0; i < 10; i++) {
			jb4[i].setBounds(frameWidth / 8, frameHeight / 10 * i + frameHeight
					/ 20, frameWidth / 12, frameHeight / 20);
			jp4.add(jb4[i]);
			jb4[i].addActionListener(this);
		}
		for (int i = 0; i < 10; i++) {
			jb4[i + 10].setBounds(frameWidth / 3, frameHeight / 10 * i
					+ frameHeight / 20, frameWidth / 12, frameHeight / 20);
			jp4.add(jb4[i + 10]);
			jb4[i + 10].addActionListener(this);
		}
		for (int i = 0; i < 10; i++) {
			jb4[i + 20].setBounds(frameWidth / 24 * 13, frameHeight / 10 * i
					+ frameHeight / 20, frameWidth / 12, frameHeight / 20);
			jp4.add(jb4[i + 20]);
			jb4[i + 20].addActionListener(this);
		}
		jp4.add(jl4);
	}

	private void initJp3() {
		jp3 = new JPanel();
		jb3 = new JButton[10];
		for (int i = 0; i < 10; i++) {
			jb3[i] = new JButton();
			jb3[i].setText("" + (i + 1));
		}
		jl3 = new JLabel("请选择调整的架号：");
		jl3.setBounds(0, 0, frameWidth / 8, frameHeight / 8);
		jp3.setBounds(0, 0, frameWidth / 4 * 3, frameHeight);
		jp3.setLayout(null);
		for (int i = 0; i < 5; i++) {
			jb3[i].setBounds(frameWidth / 6, frameHeight / 40 * 9 * i,
					frameWidth / 6, frameHeight / 10);
			jp3.add(jb3[i]);
			jb3[i].addActionListener(this);
		}
		for (int i = 0; i < 5; i++) {
			jb3[i + 5].setBounds(frameWidth / 12 * 5, frameHeight / 40 * 9 * i,
					frameWidth / 6, frameHeight / 10);
			jp3.add(jb3[i + 5]);
			jb3[i + 5].addActionListener(this);
		}
		jp3.add(jl3);
	}

	private void initJp2() {
		jp2 = new JPanel();
		jb2 = new JButton[8];
		for (int i = 0; i < 8; i++) {
			jb2[i] = new JButton();
			jb2[i].setText("" + (i + 1));
		}
		jl2 = new JLabel("请选择调整的排号：");
		jl2.setBounds(0, 0, frameWidth / 8, frameHeight / 8);
		jp2.setBounds(0, 0, frameWidth / 4 * 3, frameHeight);
		jp2.setLayout(null);
		for (int i = 0; i < 4; i++) {
			jb2[i].setBounds(frameWidth / 6, frameHeight / 10 + frameHeight
					/ 40 * 9 * i, frameWidth / 6, frameHeight / 8);
			jp2.add(jb2[i]);
			jb2[i].addActionListener(this);
		}
		for (int i = 0; i < 4; i++) {
			jb2[i + 4]
					.setBounds(frameWidth / 12 * 5, frameHeight / 10
							+ frameHeight / 40 * 9 * i, frameWidth / 6,
							frameHeight / 8);
			jp2.add(jb2[i + 4]);
			jb2[i + 4].addActionListener(this);
		}
		jp2.add(jl2);
	}
}
