package presentation.right.courier;

import javax.swing.*;

import po.bills.OrderBill;
import presentation.right.Remind;
import presentation.right.RightAll;
import presentation.watcher.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class CourierSearch_After extends RightAll implements   ActionListener {

	int frameWidth;
	int frameHeight;
	JPanel senderInfor;
	JLabel[] input;
	JLabel extra1;
	JLabel extra2;
	JLabel extra3;
	JButton confirm;
	JTextField[] inputText;
	private List<Watcher> list;
	OrderBill bill;
 
	public CourierSearch_After(int frameWidth, int frameHeight) {
		bill=BillNow.getBill();
		

		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);
	   this.setBackground(new Color(193,223, 164));

		senderInfor = new JPanel();
		senderInfor.setLayout(null);
		input = new JLabel[21];
		for (int i = 0; i < 21; i++) {
			input[i] = new JLabel();
		}

		inputText = new JTextField[21];
		for (int i = 0; i < 21; i++) {
			inputText[i] = new JTextField();
		}
		extra1 = new JLabel("快递单号");
		extra2 = new JLabel("快递费用");
		extra3 = new JLabel("预计到达日期");
		confirm = new JButton("");//确认

		init();

		for (int i = 0; i < 21; i++) {
			senderInfor.add(input[i]);
		}
		for (int i = 0; i < 21; i++) {
			senderInfor.add(inputText[i]);
		}

		senderInfor.add(extra1);
		senderInfor.add(extra2);
		senderInfor.add(extra3);
		this.add(senderInfor);
		this.add(confirm);

	}
	
 

	private void init() {
		senderInfor.setBounds(30, 50, frameWidth * 3 / 4 - 40, frameHeight - 150);
       senderInfor.setBackground(new Color(193,223, 164));
		int x = frameWidth * 3 / 4 - 20;
		int y = frameHeight - 200;
		input[0].setText("寄件人信息");
		input[1].setText("姓名");
		input[2].setText("单位");
		input[3].setText("收件人信息");
		input[4].setText("姓名");
		input[5].setText("单位");
		input[6].setText("托运货物信息");
		input[7].setText("原件数");
		input[8].setText("尺寸");
		input[9].setText("包装费");
		input[10].setText("住址");
		input[11].setText("电话");
		input[12].setText("住址");
		input[13].setText("电话");
		input[14].setText("重量");
		input[15].setText("内件品名");
		input[16].setText("快递类型");
		input[17].setText("手机");
		input[18].setText("手机");
		input[19].setText("计费方式");
		input[20].setText("包装类型");
		for (int i = 0; i < 10; i++) {
			input[i].setBounds(0, 40 * i, 100, 20);
			input[i].setFont(new Font("宋体",Font.BOLD,15));
		}
		for(int i=10;i<21;i++){
			input[i].setFont(new Font("宋体",Font.BOLD,15));
		}
		input[10].setBounds(x / 3, 40, 100, 20);
		input[11].setBounds(x / 3, 40 * 2, 100, 20);
		input[12].setBounds(x / 3, 40 * 4, 100, 20);
		input[13].setBounds(x / 3, 40 * 5, 100, 20);
		input[14].setBounds(x / 3, 40 * 7, 100, 20);
		input[15].setBounds(x / 3, 40 * 8, 100, 20);
		input[16].setBounds(x / 3, 40 * 9, 100, 20);
		input[17].setBounds(x / 3 * 2, 40 * 2, 100, 20);
		input[18].setBounds(x / 3 * 2, 40 * 5, 100, 20);
		input[19].setBounds(x / 3 * 2, 40 * 8, 100, 20);
		input[20].setBounds(x / 3 * 2, 40 * 9, 100, 20);
		extra1.setBounds(0, 40 * 10, 100, 20);
		extra1.setFont(new Font("宋体",Font.BOLD,15));
		extra2.setBounds(0, 40 * 11, 100, 20);
		extra2.setFont(new Font("宋体",Font.BOLD,15));
		extra3.setBounds(0, 40 * 12, 100, 20);
       extra3.setFont(new Font("宋体",Font.BOLD,15));

		for (int i = 0; i < 2; i++) {
			inputText[i].setBounds(80, 40 * (i + 1), 100, 20);
			inputText[i].setFont(new Font("宋体",Font.PLAIN,13));
		}
		for (int i = 2; i < 4; i++) {
			inputText[i].setBounds(80, 40 * (i + 2), 100, 20);
			inputText[i].setFont(new Font("宋体",Font.PLAIN,13));
		}
		for (int i = 4; i < 7; i++) {
			inputText[i].setBounds(80, 40 * (i + 3), 100, 20);
			inputText[i].setFont(new Font("宋体",Font.PLAIN,13));
		}
		inputText[7].setBounds(x / 3 + 70, 40, 100, 20);
		inputText[8].setBounds(x / 3 + 70, 40 * 2, 100, 20);
		inputText[9].setBounds(x / 3 + 70, 40 * 4, 100, 20);
		inputText[10].setBounds(x / 3 + 70, 40 * 5, 100, 20);
		inputText[11].setBounds(x / 3 + 70, 40 * 7, 100, 20);
		inputText[12].setBounds(x / 3 + 70, 40 * 8, 100, 20);
		inputText[13].setBounds(x / 3 + 70, 40 * 9, 100, 20);
		inputText[14].setBounds(x / 3 * 2 + 70, 40 * 2, 100, 20);
		inputText[15].setBounds(x / 3 * 2 + 70, 40 * 5, 100, 20);
		inputText[16].setBounds(x / 3 * 2 + 70, 40 * 8, 100, 20);
		inputText[17].setBounds(x / 3 * 2 + 70, 40 * 9, 100, 20);
		inputText[18].setBounds(80, 40 * 10, 100, 20);
		inputText[19].setBounds(80, 40 * 11, 100, 20);
		inputText[20].setBounds(80, 40 * 12, 100, 20);
		for (int i = 0; i < 21; i++) {
			
			inputText[i].setFont(new Font("宋体",Font.PLAIN,13));
			inputText[i].setEditable(false);
		}
		
		inputText[0].setText(bill.getSenderName());
		inputText[1].setText(bill.getSenderUnit());
		inputText[2].setText(bill.getReceiverName());
		inputText[3].setText(bill.getReceiverUnit());
		inputText[4].setText(bill.getGoodNum());
		inputText[5].setText(bill.getGoodSize()+"立方厘米");
		inputText[6].setText(bill.getBagFee()+"元");
		inputText[7].setText(bill.getSenderLocation());
		inputText[8].setText(bill.getSenderTelephone());
		inputText[9].setText(bill.getReceiverLocation());
		inputText[10].setText(bill.getReceiverTelephone());
		inputText[11].setText(bill.getGoodWeight()+"千克");
		inputText[12].setText(bill.getGoodName());
		if(bill.getKind().equals("ecnomic")){
			inputText[13].setText("经济快递");
		}else if(bill.getKind().equals("standard")){
			inputText[13].setText("标准快递");
		}else if(bill.getKind().equals("express")){
			inputText[13].setText("特快专递");
		}else {
			inputText[13].setText("种类出错");
		}
		
		
		
		inputText[14].setText(bill.getSenderMobile());
		inputText[15].setText(bill.getReceiverMobile());
		inputText[16].setText("实际重量");
		if(bill.getBagging().equals("paper")){
			inputText[17].setText("纸箱");
		}else if(bill.getBagging().equals("wood")){
			inputText[17].setText("木箱");
		}else if(bill.getBagging().equals("bag")){
			inputText[17].setText("包装袋");
		}else {
			inputText[17].setText("其他");
		}
		
		inputText[18].setText(bill.getID());
		inputText[19].setText(bill.getCharge());
		inputText[20].setText(bill.getTime());
		
		confirm.setBounds(frameWidth / 3* 1 , frameHeight*18/20 , frameWidth/9, frameHeight/19);
		confirm.addActionListener(this);

		ImageIcon icon2 = new ImageIcon("pictures//确认小.png");
		Image temp2 = icon2.getImage().getScaledInstance(icon2.getIconWidth(),
				icon2.getIconHeight(), icon2.getImage().SCALE_DEFAULT);
		icon2 = new ImageIcon(temp2);
		confirm.setIcon(icon2);
		
		
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
		if (e.getSource() == confirm) {
			this.notifyWatchers(State.COURIERSTART);
		}
	}
}