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
import java.awt.peer.FramePeer;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import businesslogic.storagebl.StorageManagerImpl;
import businesslogicservice.storageblservice.StorageManager;
import presentation.right.RightAll;
import presentation.right.YearMonthDay;
import presentation.watcher.*;

public class StockmanOutStock extends RightAll implements ActionListener {
	int frameWidth;
	int frameHeight;
	JLabel[] jl;
	JButton confirm;
	JButton cancel;
	JTextField jtf[];
	JLabel time[];
	JComboBox<String>[] timeInput;
	JComboBox<String> type;
	private List<Watcher> list;
	private StorageManager storageM;

	public StockmanOutStock(int frameWidth, int frameHeight) {
		storageM= new  StorageManagerImpl();
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel[5];
		for (int i = 0; i < 5; i++) {
			jl[i] = new JLabel();
		}
		confirm = new JButton("");
		cancel = new JButton("");
		jtf = new JTextField[3];
		for (int i = 0; i < 3; i++) {
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

		String transportType[] = { "飞机", "火车", "汽车" };
		type = new JComboBox<String>(transportType);

		init();

		for (int i = 0; i < 5; i++) {
			this.add(jl[i]);
		}
		this.add(confirm);
		this.add(cancel);
		for (int i = 0; i < 3; i++) {
			this.add(jtf[i]);
			this.add(time[i]);
			this.add(timeInput[i]);
		}
		this.add(type);

	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\出库单填写right.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth / 4 * 3, frameHeight, null);
	}

	private void init() {

		jl[0].setText("快递编号");
		jl[1].setText("出库日期");
		jl[2].setText("目的地");
		jl[3].setText("装运形式");
		jl[4].setText("中转/汽运单号");

		for (int i = 0; i < 5; i++) {
			jl[i].setBounds(frameWidth / 10, frameHeight / 10 * (i + 1),
					frameWidth / 8, frameHeight / 20);
			jl[i].setFont(new Font("宋体", Font.BOLD, 15));

		}

		for (int i = 0; i < 3; i++) {
			jtf[i].setFont(new Font("宋体", Font.PLAIN, 15));
			time[i].setFont(new Font("宋体", Font.PLAIN, 15));
		}

		jtf[0].setBounds(frameWidth / 4, frameHeight / 10, frameWidth / 9,
				frameHeight / 20);
		jtf[1].setBounds(frameWidth / 4, frameHeight / 10 * 3, frameWidth / 9,
				frameHeight / 20);
		jtf[2].setBounds(frameWidth / 4, frameHeight / 10 * 5, frameWidth / 9,
				frameHeight / 20);

		jtf[0].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		jtf[2].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});

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
		type.setBounds(frameWidth / 4, frameHeight / 10 * 4, frameWidth / 9,
				frameHeight / 20);
		type.setFont(new Font("宋体", Font.PLAIN, 15));

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
					jtf[1].requestFocus();
				}
			}
		});
		jtf[1].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					jtf[2].requestFocus();
				}
			}
		});

		jtf[2].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					jtf[1].requestFocus();
				}
			}
		});
		jtf[1].addKeyListener(new KeyAdapter() {
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
	

	private void wrongShow() {
		// 错误处理
		final JLabel remindWrong = new JLabel();
		remindWrong.setBounds(frameWidth / 4, frameHeight * 31 / 40,
				frameWidth / 4, frameHeight / 20);
		remindWrong.setFont(new Font("宋体", Font.BOLD, 20));
		remindWrong.setForeground(Color.red);
		this.add(remindWrong);
		this.repaint();

		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				// 以下根据错误类型设置文字
				remindWrong.setText("wrong");
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
			String types;
			String num;
			
			id=jtf[0].getText();
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
			destination=jtf[1].getText();
			types=type.getSelectedItem().toString();
			num=jtf[2].getText();
 
			//错误处理
			if(true){
				wrongShow();
			}else{
				
			}
		}
	}
}