package presentation.right.zhong_salesman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import businesslogic.transportbl.tranStaff.Trans_TransEntruckServerImpl;
import businesslogicservice.transportblservice.tranStaff.Trans_TransEntruckServer;
import po.Message;
import po.bills.HallEntruckBill;
import po.bills.TransEntruckBill;
import presentation.right.RightAll;
import presentation.right.YearMonthDay;
import presentation.watcher.State;
import presentation.watcher.Watched;
import presentation.watcher.Watcher;

public class Zhong_entrucking extends RightAll implements ActionListener {
	Trans_TransEntruckServer blServer;

	int frameWidth;
	int frameHeight;
	JLabel jl[];
	JTextField jtf[];
	JButton confirm;
	JButton cancel;
	JLabel time[];
	JButton add;
	JComboBox<String>[] timeInput;
	private List<Watcher> list;
	DefaultTableModel tableModel;
	JTable jtable;
	JScrollPane js;

	public Zhong_entrucking(int frameWidth, int frameHeight) {
		blServer=new Trans_TransEntruckServerImpl();
		
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel[7];
		for (int i = 0; i < 7; i++) {
			jl[i] = new JLabel();
		}
		confirm = new JButton("");
		cancel = new JButton("");
		jtf = new JTextField[6];
		for (int i = 0; i < 6; i++) {
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

		tableModel = new DefaultTableModel();
		jtable = new JTable(tableModel){ public boolean isCellEditable(int row, int column) { return false; }}; 
		js = new JScrollPane(jtable);

		add = new JButton("");

		init();

		for (int i = 0; i < 7; i++) {
			this.add(jl[i]);
		}
		this.add(confirm);
		this.add(cancel);
		for (int i = 0; i < 6; i++) {
			this.add(jtf[i]);
		}
		for (int i = 0; i < 3; i++) {
			this.add(time[i]);
			this.add(timeInput[i]);
		}
		this.add(js);
		this.add(add);
	}
	
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\装车单right.png");
		Image bg =background.getImage();
		g.drawImage(bg, 0, 0,frameWidth*3/4,frameHeight,null);
	}

	private void init() {
		jl[0].setText("汽运编号");
		jl[1].setText("装车日期");
		jl[2].setText("到达地");
		jl[3].setText("车辆代号");
		jl[4].setText("监运员");
		jl[5].setText("押运员");
		jl[6].setText("装车订单号");
		for (int i = 0; i < 7; i++) {
			jl[i].setBounds(frameWidth / 10, frameHeight / 11 * i+frameHeight/9,
					frameWidth / 10, frameHeight / 20);
			jl[i].setFont(new Font("宋体",Font.BOLD,15));
		}
		
		confirm.setBounds(frameWidth / 6, frameHeight * 8 / 10+frameHeight/30,
				 frameWidth / 9,frameHeight / 16);
		confirm.addActionListener(this);
		cancel.setBounds(frameWidth * 2 / 5+frameWidth/15, frameHeight * 8 / 10+frameHeight/30,
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
		
		jtf[0].setBounds(frameWidth / 4-frameWidth/25, frameHeight/9-frameHeight/100, frameWidth / 9, frameHeight / 20);
		jtf[0].setFont(new Font("宋体",Font.BOLD,15));
		for (int i = 1; i < 6; i++) {
			jtf[i].setBounds(frameWidth / 4-frameWidth/25, frameHeight / 11* (i + 1)+frameHeight/9,
					frameWidth /9, frameHeight / 20);
			jtf[i].setFont(new Font("宋体",Font.BOLD,15));
		}
		time[0].setText("年");
		time[1].setText("月");
		time[2].setText("日");
		for (int i = 0; i < 3; i++) {
			timeInput[i].setBounds(frameWidth / 4 + frameWidth / 50*6 * i-frameWidth/25,
					frameHeight / 11 * 1+frameHeight/9-frameHeight/100, frameWidth / 11, frameHeight / 20);
			time[i].setBounds(frameWidth / 3+ frameWidth / 50*6 * i+frameWidth/85-frameWidth/25,
					frameHeight / 11 *1+frameHeight/9, frameWidth / 12, frameHeight / 20);
			time[i].setFont(new Font("宋体",Font.PLAIN,15));
			timeInput[i].setFont(new Font("宋体",Font.PLAIN,14));
		}
		add.setBounds(frameWidth / 3, frameHeight / 10 *7-frameHeight/22, frameHeight /19,
				frameHeight /19);
		add.addActionListener(this);

		ImageIcon icon3 = new ImageIcon("pictures//添加.png");
		Image temp3 = icon3.getImage().getScaledInstance(add.getWidth(),
				add.getHeight(), icon3.getImage().SCALE_DEFAULT);
		icon3= new ImageIcon(temp3);
		add.setIcon(icon3);
		add.addActionListener(this);
		
		initTable();

		js.setBounds(frameWidth / 2-frameWidth/6+frameWidth/14, frameHeight / 10 * 3-frameHeight/40, frameWidth / 4,
				frameHeight / 3+frameHeight/8);
	}

	private void initTable() {
		tableModel.addColumn("已有单号列表");
		jtable.getTableHeader().setReorderingAllowed(false);
		jtable.getTableHeader().setResizingAllowed(false);
		initTableModel();
	}

	private void initTableModel() {
		Vector<String> vec = new Vector<>();
		vec.add("12345666");

		// 初始化已有单号列表
		tableModel.addRow(vec);
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
			this.notifyWatchers(State.ZHONG_START);
		}

		if (e.getSource() == add) {
			// 添加单号列表
			String input = jtf[5].getText();
			if (!input.equals("")) {
				Vector<String> vec = new Vector<>();
				vec.add(input);
				tableModel.addRow(vec);
				jtf[5].setText("");
			}
		}else if(e.getSource()==confirm){
			String year=timeInput[0].getSelectedItem().toString();
			String month=timeInput[1].getSelectedItem().toString();
			String day=timeInput[2].getSelectedItem().toString();
			
			String date=year+"-"+month+"-"+day;
			String transNum=jtf[0].getText();
			String carId=jtf[2].getText();
			String destination=jtf[1].getText();
			String  supervisor=jtf[3].getText();
			String  transportor=jtf[4].getText();
			
			Message message=new Message();
			message.addInform(date);
			message.addInform(transNum);
			message.addInform(destination);
			message.addInform(carId);
			message.addInform(supervisor);
			message.addInform(transportor);
			
			int row=tableModel.getRowCount();
			ArrayList<String> orderList=new ArrayList<String>();
			
			for(int i=0;i<row;i++){
				orderList.add(tableModel.getValueAt(i, 0).toString());
			}
			TransEntruckBill bill=blServer.makeBill(message, orderList.iterator());
		}
	}
}
