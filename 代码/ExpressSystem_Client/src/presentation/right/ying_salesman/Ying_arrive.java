package presentation.right.ying_salesman;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import businesslogic.transportbl.hallStaff.Trans_HallArrivalServerImpl;
import businesslogicservice.transportblservice.hallStaff.Trans_HallArrivalServer;
import po.bills.HallArrivalBill;
import presentation.right.RightAll;
import presentation.right.YearMonthDay;
import presentation.watcher.State;
import presentation.watcher.Watcher;

public class Ying_arrive extends RightAll implements ActionListener {

	Trans_HallArrivalServer blServer;
	
	int frameWidth;
	int frameHeight;
	JLabel jl[];
	JButton confirm;
	JButton cancel;
	JTextField jtf[];
	JLabel time[];
	JComboBox<String>[] timeInput;
	JRadioButton jrb[];
	ButtonGroup bg;

	private List<Watcher> list;

	public Ying_arrive(int frameWidth, int frameHeight) {
		blServer=new Trans_HallArrivalServerImpl();
		
		this.frameHeight = frameHeight;
		this.frameWidth = frameWidth;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel[6];
		for (int i = 0; i < 6; i++) {
			jl[i] = new JLabel();
		}
		confirm = new JButton("");//确认
		cancel = new JButton("");//取消
		jtf = new JTextField[3];
		for (int i = 0; i < 3; i++) {
			jtf[i] = new JTextField();
		}
		time = new JLabel[3];
		timeInput = new JComboBox[3];
		for (int i = 0; i < 3; i++) {
			time[i] = new JLabel();
		}
		YearMonthDay time1=new YearMonthDay();
		timeInput[0] = time1.getCboYear();
		timeInput[1] = time1.getCboMonth();
		timeInput[2] = time1.getCboDay();
		jrb = new JRadioButton[3];
		for (int i = 0; i < 3; i++) {
			jrb[i] = new JRadioButton();
		}
		bg = new ButtonGroup();

		init();

		for (int i = 0; i < 6; i++) {
			this.add(jl[i]);
		}
		this.add(confirm);
		this.add(cancel);
		for (int i = 0; i < 3; i++) {
			this.add(jtf[i]);
			this.add(time[i]);
			this.add(timeInput[i]);
			this.add(jrb[i]);
		}
	}
	
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\货物到达单right.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth/4*3,frameHeight,null);
	}


	private void init() {
		jl[0].setText("货物到达单");
		jl[1].setText("到达日期");
		jl[2].setText("货物编号");
		jl[3].setText("中转单编号");
		jl[4].setText("出发地");
		jl[5].setText("货物到达状态");

		jl[0].setBounds(frameWidth / 3, frameHeight/12, frameWidth / 5, frameHeight / 20);
		jl[0].setFont(new Font("黑体",Font.BOLD,20));
		for (int i = 1; i < 6; i++) {
			jl[i].setBounds(frameWidth / 10, frameHeight / 14 + frameHeight
					/ 10 * i, frameWidth / 8, frameHeight / 18);
			jl[i].setFont(new Font("宋体",Font.BOLD,15));
		}
		for (int i = 0; i < 3; i++) {
			jtf[i].setBounds(frameWidth / 4, frameHeight / 17+ frameHeight
					/ 10 * (i + 2)+frameHeight/60, frameWidth / 9, frameHeight / 18);
			jtf[i].setFont(new Font("宋体",Font.PLAIN,15));
		}

		time[0].setText("年");
		time[1].setText("月");
		time[2].setText("日");
		for (int i = 0; i < 3; i++) {
			timeInput[i].setBounds(frameWidth / 4 + frameWidth / 10 * i,
					frameHeight / 18 + frameHeight / 10+frameHeight/60, frameWidth / 12,
					frameHeight / 20);
			time[i].setBounds(frameWidth / 3 + frameWidth / 10 * i, frameHeight
					/ 16 + frameHeight / 10+frameHeight/65, frameWidth / 12, frameHeight / 20);
			time[i].setFont(new Font("宋体",Font.PLAIN,14));
			timeInput[i].setFont(new Font("宋体",Font.PLAIN,14));
		}
		jtf[0].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		jtf[1].addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});

		jrb[0].setText("完好");
		jrb[1].setText("丢失");
		jrb[2].setText("破损");
		for (int i = 0; i < 3; i++) {
			jrb[i].setBounds(frameWidth / 4 + frameWidth / 10 * i, frameHeight
					/18 + frameHeight / 2+frameHeight/60, frameWidth / 10, frameHeight / 20);
			jrb[i].setBorderPainted(false); //不绘制边界搜索
			jrb[i].setContentAreaFilled(false); //不填充所占的矩形区域
			jrb[i].setFont(new Font("宋体",Font.PLAIN,15));
			bg.add(jrb[i]);
		}

		confirm.setBounds(frameWidth / 6, frameHeight * 8 / 10,
				 frameWidth / 9,frameHeight / 16);
		confirm.addActionListener(this);
		cancel.setBounds(frameWidth * 2 / 5+frameWidth/15, frameHeight * 8 / 10,
				 frameWidth / 9,frameHeight / 16);
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

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancel) {
			this.notifyWatchers(State.YING_START);
		} else if (e.getSource() == confirm) {
			String GoodID=jtf[0].getText();
			
			String year=timeInput[0].getSelectedItem().toString();
			String month=timeInput[1].getSelectedItem().toString();
			String day=timeInput[2].getSelectedItem().toString();
			
			String date=year+"-"+month+"-"+day;
			String transOrderNum=jtf[1].getText();
			String departure=jtf[2].getText();
			
			String state="完好 ";
			for(int i=0;i<3;i++){
				if(jrb[i].isSelected()){
					state=jrb[i].getText().toString();
				}
			}
			
			HallArrivalBill bill=blServer.makeBill(GoodID, date, transOrderNum, departure, state);
			
			if(bill==null){
				//错误信息处理
				System.out.println("输入的货物编号错误！");
			}else{

				this.notifyWatchers(State.YING_ARRIVE);
			}
			
		}
	}
}
