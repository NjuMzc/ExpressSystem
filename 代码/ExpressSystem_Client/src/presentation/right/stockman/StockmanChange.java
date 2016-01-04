package presentation.right.stockman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import businesslogic.storagebl.StorageServerImpl;
import businesslogicservice.storageblservice.StorageServer;
import po.Institution.storageAssist.StorageInfo;
import presentation.right.Remind;
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
	JButton jb1[] = null;
	JButton jb2[] = null;
	JButton jb3[] = null;
	JButton jb4[] = null;
	private List<Watcher> list;
	String qu;
	String pai;
	String jia;
	String wei;

	JPanel jp5;
	JLabel jl5;
	JLabel location[];
	JTextField jtf[];
	JButton confirm;

	private StorageServer storage;

	JPanel jp_wrong;
	Remind remindThread;

	public StockmanChange(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		storage = new StorageServerImpl();

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

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\系统管理startRight.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth * 3 / 4, frameHeight, null);
	}

	private void init() {

		jp1.setBackground(new Color(221, 232, 216));
		jp1.setLayout(null);
		jp1.setBounds(0, 0, frameWidth / 4 * 3, frameHeight);
		jb1[0].setText("航空区(1区)");
		jb1[1].setText("火车区(2区)");
		jb1[2].setText("汽运区(3区)");
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
				if (i == 0) {
					qu = "01";
				} else if (i == 1) {
					qu = "02";
				} else if (i == 2) {
					qu = "03";
				}
				this.remove(jp1);
				initJp2();
				this.add(jp2);
				this.repaint();
				break;
			}
		}

		for (int i = 0; i < 8; i++) {
			if (jb2 != null && e.getSource() == jb2[i]) {
				pai = "0" + jb2[i].getText();
				this.remove(jp2);
				initJp3();
				this.add(jp3);
				this.repaint();
				break;
			}
		}

		for (int i = 0; i < 10; i++) {
			if (jb3 != null && e.getSource() == jb3[i]) {
				if (i != 9) {
					jia = "0" + jb3[i].getText();
				} else {
					jia = jb3[i].getText();
				}
				this.remove(jp3);
				initJp4();
				this.add(jp4);
				this.repaint();
				break;
			}
		}

		for (int i = 0; i < 30; i++) {
			if (jb4 != null && e.getSource() == jb4[i]) {
				if (i < 9) {
					wei = "0" + jb4[i].getText();
				} else {
					wei = jb4[i].getText();
				}
				this.remove(jp4);
				initJp5();
				this.add(jp5);
				this.repaint();
				break;
			}
		}

		if (e.getSource() == confirm) {
			String change_pai = jtf[0].getText();
			if (change_pai.length() == 1) {
				change_pai = "0" + change_pai;
			}
			String change_jia = jtf[1].getText();
			if (change_jia.length() == 1) {
				change_jia = "0" + change_jia;
			}
			String change_wei = jtf[2].getText();
			if (change_wei.length() == 1) {
				change_wei = "0" + change_wei;
			}
			String oldLoc = qu + pai + jia + wei;
			String loc = "04" + change_pai + change_jia + change_wei;
		 

			// @li,根据是否成功
			if (storage.changeStorage(oldLoc, loc)) {
				this.notifyWatchers(State.STOCKMANSTART);
			} else {
				showMessage("");
			}
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

	private void initJp5() {
		jp5 = new JPanel();
		jp5.setBackground(new Color(221, 232, 216));
		jl5 = new JLabel("请输入调整到的机动区位置：");
		location = new JLabel[3];
		for (int i = 0; i < 3; i++) {
			location[i] = new JLabel();
		}
		jtf = new JTextField[3];
		for (int i = 0; i < 3; i++) {
			jtf[i] = new JTextField();
		}
		for (int i = 0; i < 3; i++) {
			jtf[i].addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					if (!Character.isDigit(e.getKeyChar())) {
						e.consume();
					}
				}
			});
		}
		confirm = new JButton("确认");

		jp5.setLayout(null);
		jp5.setBounds(0, 0, frameWidth / 4 * 3, frameHeight);
		jl5.setBounds(frameWidth / 6, frameHeight / 3, frameWidth / 5,
				frameHeight / 10);
		location[0].setText("排");
		location[1].setText("架");
		location[2].setText("位");
		for (int i = 0; i < 3; i++) {
			location[i].setBounds(frameWidth / 6 + frameWidth / 5 * i,
					frameHeight / 2, frameWidth / 10, frameHeight / 20);
			jtf[i].setBounds(frameWidth / 12 + frameWidth / 5 * i,
					frameHeight / 2, frameWidth / 12, frameHeight / 20);
		}
		confirm.setBounds(frameWidth * 13 / 40, frameHeight / 5 * 4,
				frameWidth / 10, frameHeight / 20);
		confirm.addActionListener(this);

		jp5.add(jl5);
		jp5.add(confirm);
		for (int i = 0; i < 3; i++) {
			jp5.add(jtf[i]);
	  	jp5.add(location[i]);
		}
	}

	private void initJp4() {
		int area=Integer.valueOf(qu);
		int row = Integer.valueOf(pai);
		int shelf=Integer.valueOf(jia);
		StorageInfo[] st=  storage.getGoodsList(area, row, shelf);
		jp4 = new JPanel();
		jp4.setBackground(new Color(221, 232, 216));
		jb4 = new JButton[30];
		for (int i = 0; i < 30; i++) {
			jb4[i] = new JButton();
			jb4[i].setText("" + (i + 1));
			if(st[i]==null){
				
				jb4[i].setForeground(Color.green);
			}else{
				jb4[i].setForeground(Color.red);
			}
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
		jp3.setBackground(new Color(221, 232, 216));
		jb3 = new JButton[10];
		for (int i = 0; i < 10; i++) {
			jb3[i] = new JButton();
			jb3[i].setText("" + (i + 1));
		}
		jl3 = new JLabel("请选择调整的架号：");
		jl3.setFont(new Font("宋体", Font.BOLD, 20));
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
		jp2.setBackground(new Color(221, 232, 216));
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
