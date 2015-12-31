package presentation.right.stockman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import businesslogic.storagebl.StorageServerImpl;
import businesslogicservice.storageblservice.StorageServer;
import presentation.right.RightAll;
import presentation.right.YearMonthDay;
import presentation.watcher.*;
import vo.storagebl.ImportVO;

public class StockmanInStock extends RightAll implements ActionListener {
	int frameWidth;
	int frameHeight;
	JLabel[] jl;
	JButton confirm;
	JButton cancel;
	JTextField jtf[];
	JLabel time[];
	JComboBox<String>[] timeInput;
	private List<Watcher> list;
	private StorageServer storage;
	ImportVO result;

	public StockmanInStock(int frameWidth, int frameHeight) {

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		storage = new StorageServerImpl();
		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel[8];
		for (int i = 0; i < 8; i++) {
			jl[i] = new JLabel();
		}
		confirm = new JButton("");
		cancel = new JButton("");
		jtf = new JTextField[7];
		for (int i = 0; i < 7; i++) {
			jtf[i] = new JTextField();
		}

		time = new JLabel[3];
		timeInput = new JComboBox[3];
		for (int i = 0; i < 3; i++) {
			time[i] = new JLabel();
		}
		YearMonthDay time1 = new YearMonthDay();
		timeInput[0] = time1.getCboYear();
		timeInput[1] = time1.getCboMonth();
		timeInput[2] = time1.getCboDay();

		init();

		for (int i = 0; i < 8; i++) {
			this.add(jl[i]);
		}
		this.add(confirm);
		this.add(cancel);
		for (int i = 0; i < 7; i++) {
			this.add(jtf[i]);
		}
		for (int i = 0; i < 3; i++) {
			this.add(time[i]);
			this.add(timeInput[i]);
		}

	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\入库单填写right.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth / 4 * 3, frameHeight, null);
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
			jl[i].setBounds(frameWidth / 8, frameHeight / 10 * (i + 1),
					frameWidth / 10, frameHeight / 20);
			jl[i].setFont(new Font("宋体", Font.BOLD, 15));
		}
		for (int i = 4; i < 8; i++) {
			jl[i].setBounds(frameWidth / 4, frameHeight / 10 * i,
					frameWidth / 10, frameHeight / 20);
			jl[i].setFont(new Font("宋体", Font.PLAIN, 16));
		}

		for (int i = 0; i < 3; i++) {
			if (i != 1)
				jtf[i].setBounds(frameWidth / 4, frameHeight / 10 * (i + 1),
						frameWidth / 9, frameHeight / 20);
			jtf[i].setFont(new Font("宋体", Font.PLAIN, 15));
		}
		for (int i = 3; i < 7; i++) {
			jtf[i].setBounds(frameWidth / 3 - frameWidth / 25, frameHeight / 10
					* (i + 1), frameWidth / 10, frameHeight / 20);
			jtf[i].setFont(new Font("宋体", Font.PLAIN, 15));
		}
		jtf[0].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		for (int i = 3; i < 7; i++) {
			jtf[i].addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					if (!Character.isDigit(e.getKeyChar())) {
						e.consume();
					}
				}
			});
		}

		time[0].setText("年");
		time[1].setText("月");
		time[2].setText("日");
		for (int i = 0; i < 3; i++) {
			timeInput[i].setBounds(frameWidth / 4 + frameWidth / 50 * 6 * i,
					frameHeight / 5, frameWidth / 11, frameHeight / 20);
			time[i].setBounds(frameWidth / 3 + frameWidth / 50 * 6 * i
					+ frameWidth / 85, frameHeight / 5, frameWidth / 12,
					frameHeight / 20);
			time[i].setFont(new Font("宋体", Font.PLAIN, 15));
			timeInput[i].setFont(new Font("宋体", Font.PLAIN, 14));
		}

		confirm.setBounds(frameWidth / 6, frameHeight * 8 / 10 + frameHeight
				/ 30, frameWidth / 9, frameHeight / 16);
		confirm.addActionListener(this);
		cancel.setBounds(frameWidth * 2 / 5 + frameWidth / 15, frameHeight * 8
				/ 10 + frameHeight / 30, frameWidth / 9, frameHeight / 16);
		cancel.addActionListener(this);

		ImageIcon icon1 = new ImageIcon("pictures//取消t.png");
		Image temp1 = icon1.getImage().getScaledInstance(icon1.getIconWidth(),
				icon1.getIconHeight(), icon1.getImage().SCALE_DEFAULT);
		icon1 = new ImageIcon(temp1);
		cancel.setIcon(icon1);

		ImageIcon icon2 = new ImageIcon("pictures//确认小.png");
		Image temp2 = icon2.getImage().getScaledInstance(icon2.getIconWidth(),
				icon2.getIconHeight(), icon2.getImage().SCALE_DEFAULT);
		icon2 = new ImageIcon(temp2);
		confirm.setIcon(icon2);

		jtf[0].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					jtf[2].requestFocus();
				}
			}
		});
		jtf[2].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					jtf[3].requestFocus();
				}
			}
		});
		jtf[3].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					jtf[4].requestFocus();
				}
			}
		});
		jtf[4].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					jtf[5].requestFocus();
				}
			}
		});
		jtf[5].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					jtf[6].requestFocus();
				}
			}
		});
		jtf[6].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					jtf[5].requestFocus();
				}
			}
		});
		jtf[5].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					jtf[4].requestFocus();
				}
			}
		});
		jtf[4].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					jtf[3].requestFocus();
				}
			}
		});
		jtf[3].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					jtf[2].requestFocus();
				}
			}
		});
		jtf[2].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					jtf[0].requestFocus();
				}
			}
		});

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

	private void wrongShow(final String input) {

		// 错误处理
		final JLabel remindWrong = new JLabel();
		remindWrong.setBounds(frameWidth / 4, frameHeight * 31 / 40,
				frameWidth / 2, frameHeight / 20);
		remindWrong.setFont(new Font("宋体", Font.BOLD, 20));

		this.add(remindWrong);
		this.repaint();

		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				// 以下根据错误类型设置文字
				remindWrong.setForeground(Color.red);
				remindWrong.setText(result.getWrongMessage());

				try {
					Thread.sleep(2000);
				} catch (Exception e2) {
					// TODO: handle exception
				}
				remindWrong.setText("");
			}
		});
		t.start();
		// 错误处理结束
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancel) {
			this.notifyWatchers(State.STOCKMANSTART);
		} else if (e.getSource() == confirm) {

			String id;
			String time;
			String destination;
			String qu;
			String pai;
			String jia;
			String wei;
			String[] location = new String[4];

			id = jtf[0].getText();
			time = timeInput[0].getSelectedItem().toString();
			time += "-";
			if (timeInput[1].getSelectedItem().toString().length() == 1) {
				time += "0";
				time += timeInput[1].getSelectedItem().toString();
			} else {
				time += timeInput[1].getSelectedItem().toString();
			}
			time += "-";
			if (timeInput[2].getSelectedItem().toString().length() == 1) {
				time += "0";
				time += timeInput[2].getSelectedItem().toString();
			} else {
				time += timeInput[2].getSelectedItem().toString();
			}
			destination = jtf[2].getText();
			qu = jtf[3].getText();
			pai = jtf[4].getText();
			jia = jtf[5].getText();
			wei = jtf[6].getText();

			location[0] = qu;
			location[1] = pai;
			location[2] = jia;
			location[3] = wei;

			ImportVO importBill = new ImportVO(id, time, destination, location);
			result = storage.Import(importBill);

			if (result.isWrong()) {
				System.out.println(result.getWrongMessage());
				wrongShow("wrong");
			} else {
				this.notifyWatchers(State.STOCKMANINSTOCK);
			}

		}
	}
}
