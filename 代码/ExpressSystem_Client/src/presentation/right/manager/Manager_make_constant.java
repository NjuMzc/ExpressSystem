package presentation.right.manager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.omg.CORBA.FREE_MEM;

import businesslogic.constantbl.CityDistanceServerImpl;
import businesslogic.constantbl.PriceListServerImpl;
import businesslogicservice.constantblservice.CityDistanceServer;
import businesslogicservice.constantblservice.PriceListServer;
import po.constants.CityDistancePO;
import presentation.right.ColorRenderer;
import presentation.right.Remind;
import presentation.right.RightAll;
import presentation.watcher.*;

public class Manager_make_constant extends RightAll implements ActionListener {
	CityDistanceServer distanceServer;
	PriceListServer priceServer;
	
	int frameWidth;
	int frameHeight;

	// JLabel cityremind;
	// JLabel city[];
	// JLabel km[];
	// JTextField jtf1[];
	JLabel feeremind;
	JLabel fee[];
	JLabel yuan[];
	JTextField jtf2[];
	JButton submit;
	JButton cancel;
	private List<Watcher> list;
	DefaultTableModel model;
	JTable table;
	JScrollPane js;
	DefaultTableCellRenderer dtc;
	
	JPanel jp_wrong;
	String input_wrong;
	Remind remindThread;

	public Manager_make_constant(int frameWidth, int frameHeight) {
		distanceServer=new CityDistanceServerImpl();
		priceServer=new PriceListServerImpl();

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);
      
		model = new DefaultTableModel();
		table = new JTable(model) {
			public boolean isCellEditable(int row, int column) {
				if (column == 1) {
					return true;
				} else {
					return false;
				}
			}
		};
		js = new JScrollPane(table);
  
		feeremind = new JLabel("运输价格:");
		feeremind.setFont(new Font("宋体", Font.BOLD, 20));
		fee = new JLabel[3];
		yuan = new JLabel[3];
		jtf2 = new JTextField[3];
		for (int i = 0; i < 3; i++) {
			fee[i] = new JLabel();
			yuan[i] = new JLabel("元/公里*吨");
			jtf2[i] = new JTextField();
			fee[i].setFont(new Font("宋体", Font.PLAIN, 16));
			yuan[i].setFont(new Font("宋体", Font.PLAIN, 16));
			jtf2[i].setFont(new Font("宋体", Font.PLAIN, 16));
		}
		submit = new JButton("");// 提交
		cancel = new JButton("");// 取消

		dtc = new ColorRenderer();

		init();

		this.add(feeremind);
		for (int i = 0; i < 3; i++) {
			this.add(fee[i]);
			this.add(yuan[i]);
			this.add(jtf2[i]);
		}
		this.add(submit);
		this.add(cancel);
		this.add(js);
	}

	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\系统管理startRight.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth * 3 / 4, frameHeight, null);
	}

	private void init() {
		feeremind.setBounds(frameWidth / 10,
				frameHeight / 2 + frameHeight / 10, frameWidth / 8,
				frameHeight / 10);
      
		model.addColumn("出发地-到达地");
		model.addColumn("距离（/km）");
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.getColumnModel().getColumn(0).setCellRenderer(dtc);
		table.getColumnModel().getColumn(1).setCellRenderer(dtc);
		initModel();
	       table.setFont(new Font("宋体",Font.PLAIN,13));

		js.setBounds(frameWidth / 8, frameHeight / 10, frameWidth / 2,
				frameHeight / 2);

		fee[0].setText("飞机：");
		fee[1].setText("火车：");
		fee[2].setText("汽车：");
		for (int i = 0; i < 3; i++) {
			fee[i].setBounds(frameWidth / 10 + frameWidth / 5 * i, frameHeight
					/ 2 + frameHeight / 5, frameWidth / 9, frameHeight / 20);
			yuan[i].setBounds(frameWidth / 10 + frameWidth / 8 + frameWidth / 5
					* i, frameHeight / 2 + frameHeight / 5, frameWidth / 20,
					frameHeight / 20);
			jtf2[i].setBounds(frameWidth / 6 + frameWidth / 5 * i, frameHeight
					/ 2 + frameHeight / 5, frameWidth / 20, frameHeight / 20);
		}

		for (int i = 0; i < 3; i++) {
			jtf2[i].addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					if (!Character.isDigit(e.getKeyChar())
							&& e.getKeyChar() != KeyEvent.VK_PERIOD) {
						e.consume();
					}
				}
			});
		}

		submit.setBounds(frameWidth / 10 + frameHeight / 17, frameHeight / 10
				* 9 - frameHeight / 55, frameWidth / 10, frameHeight / 18);
		submit.addActionListener(this);
		cancel.setBounds(frameWidth / 20 * 10, frameHeight / 10 * 9
				- frameHeight / 55, frameWidth / 10, frameHeight / 18);
		cancel.addActionListener(this);
		ImageIcon icon1 = new ImageIcon("pictures//取消t.png");
		Image temp1 = icon1.getImage().getScaledInstance(icon1.getIconWidth(),
				icon1.getIconHeight(), icon1.getImage().SCALE_DEFAULT);
		icon1 = new ImageIcon(temp1);
		cancel.setIcon(icon1);

		ImageIcon icon2 = new ImageIcon("pictures//提交.png");
		Image temp2 = icon2.getImage().getScaledInstance(icon2.getIconWidth(),
				icon2.getIconHeight(), icon2.getImage().SCALE_DEFAULT);
		icon2 = new ImageIcon(temp2);
		submit.setIcon(icon2);

		jtf2[0].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					jtf2[1].requestFocus();
				}
			}
		});
		jtf2[1].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					jtf2[2].requestFocus();
				}
			}
		});
		jtf2[2].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					jtf2[1].requestFocus();
				}
			}
		});
		jtf2[1].addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					jtf2[0].requestFocus();
				}
			}
		});

		
		jtf2[0].setText(""+priceServer.getAirPrice());
		jtf2[1].setText(""+priceServer.getTrainPrice());
		jtf2[2].setText(""+priceServer.getCarPrice());
	}

	private void initModel() {
		
		Iterator<CityDistancePO> it=distanceServer.getAll();
		while(it.hasNext()){
			CityDistancePO po=it.next();
			
			Vector<String> vec = new Vector<>();
			vec.add(po.getCity1()+"-"+po.getCity2());
			vec.add(""+po.getDistance());
			
			model.addRow(vec);
		}
		
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

	private void wrongsolve() {
		// 错误处理
		final JLabel remindWrong = new JLabel();
		remindWrong.setBounds(frameWidth / 10 - frameWidth / 30, frameHeight
				/ 14 + frameHeight / 7 * 5 + frameHeight / 70 - frameHeight
				/ 12, frameWidth / 2, frameHeight / 18);
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
			this.notifyWatchers(State.MANAGERSTART);
		} else if (e.getSource() == submit) {

			String fee[];
			String cities[];
			String distance[];
			fee = new String[3];
			cities = new String[table.getRowCount()];
			distance = new String[table.getRowCount()];
			for (int i = 0; i < 3; i++) {
				fee[i] = jtf2[i].getText();
				// System.out.print("fee=" + fee[i] + " ");
			}
			// System.out.println();
			for (int i = 0; i < table.getRowCount(); i++) {
				cities[i] = table.getValueAt(i, 0).toString();
				distance[i] = table.getValueAt(i, 1).toString();
				// System.out.println("城市：" + cities[i] + "  " + " 距离："
				// + distance[i]);
			}
			// System.out.println();

			//错误提示
			if (remindThread != null) {
				remindThread.stop();
				this.remove(jp_wrong);
			}
			jp_wrong = new JPanel();
			 
			this.add(jp_wrong);
			remindThread = new Remind(jp_wrong, input_wrong);
			remindThread.start();
			
			for(int i=0;i<table.getRowCount();i++){
				String[] a=cities[i].split("-");
				
				distanceServer.changeDistance(a[0], a[1], distance[i]);
				priceServer.setAirPrice(Double.valueOf(fee[0]));
				priceServer.setTrainPrice(Double.valueOf(fee[1]));
				priceServer.setCarPrice(Double.valueOf(fee[2]));
			}
			
		}

	}
}
