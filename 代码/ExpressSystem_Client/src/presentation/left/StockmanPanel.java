 package presentation.left;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import presentation.watcher.*;
 

public class StockmanPanel extends  LeftAll implements   ActionListener{

	private List<Watcher> list;
	int frameWidth;
	int frameHeight;
	JButton[] jb;
	JButton logout;
	JButton close;
	JPanel picture;
	JLabel name;
	JLabel num;
	JLabel photo;
	
	JTextField jtf_num;
	JTextField jtf_name;
	
	public StockmanPanel(int frameWidth, int frameHeight){
		 
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		list = new ArrayList<Watcher>();
		
		this.setLayout(null);
		this.setBounds(0, 0, frameWidth / 4, frameHeight);
		
		jb = new JButton[5];
		for (int i = 0; i < 5; i++) {
			jb[i] = new JButton();
		}
		logout = new JButton();//"登出账号"
		close = new JButton();//"关闭系统"
	       logout.setContentAreaFilled(false);
	       close.setContentAreaFilled(false);
	       logout.setBorderPainted(false);
	       close.setBorderPainted(false);
        logout.addActionListener(this);
        close.addActionListener(this);
	
    	jtf_name = new JTextField();
		jtf_num = new JTextField();
		
		init();
		
		this.setBackground(new Color(248, 147, 69));
		for (int i = 0; i < 5; i++) {
			this.add(jb[i]);
		}
		this.add(logout);
		this.add(close);
		this.add(jtf_name);
		this.add(jtf_num);

	}
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\keeperleft1.png");
		Image bg =background.getImage();
		g.drawImage(bg, 0, 0,frameWidth/4,frameHeight,null);
	}
	
	
	private void init(){
		for (int i = 0; i < 5; i++) {
			jb[i] = new JButton();
			jb[i].setBounds(0, frameHeight / 3 + frameHeight / 13 * i,
					frameWidth / 4, frameHeight / 13);
			
			//jb[i].setContentAreaFilled(false);
			jb[i].addActionListener(this);
		}
			
			ImageIcon icon0 = new ImageIcon("pictures//入库单填写.png");
			Image temp0 = icon0.getImage().getScaledInstance(jb[0].getWidth(),
					jb[0].getHeight(), icon0.getImage().SCALE_DEFAULT);
			icon0 = new ImageIcon(temp0);
			jb[0].setIcon(icon0);
			
			ImageIcon icon1 = new ImageIcon("pictures//出库单填写.png");
			Image temp1 = icon1.getImage().getScaledInstance(jb[1].getWidth(),
					jb[1].getHeight(), icon1.getImage().SCALE_DEFAULT);
			icon1 = new ImageIcon(temp1);
			jb[1].setIcon(icon1);
			
			ImageIcon icon2 = new ImageIcon("pictures//库存查看.png");
			Image temp2 = icon2.getImage().getScaledInstance(jb[2].getWidth(),
					jb[1].getHeight(), icon2.getImage().SCALE_DEFAULT);
			icon2 = new ImageIcon(temp2);
			jb[2].setIcon(icon2);
			
			ImageIcon icon3 = new ImageIcon("pictures//库存盘点.png");
			Image temp3 = icon3.getImage().getScaledInstance(jb[3].getWidth(),
					jb[3].getHeight(), icon3.getImage().SCALE_DEFAULT);
			icon3 = new ImageIcon(temp3);
			jb[3].setIcon(icon3);
			
			ImageIcon icon4 = new ImageIcon("pictures//分区调整.png");
			Image temp4 = icon4.getImage().getScaledInstance(jb[4].getWidth(),
					jb[4].getHeight(), icon4.getImage().SCALE_DEFAULT);
			icon4 = new ImageIcon(temp4);
			jb[4].setIcon(icon4);
			

		jb[0].setText("");//入库单填写
		jb[1].setText("");//出库单填写
		jb[2].setText("");//库存查看
		jb[3].setText("");//库存盘点
		jb[4].setText("");//分区调整
		
		logout.setMargin(new Insets(0, 0, 0, 0));
		logout.setBounds(frameWidth*3/80, frameHeight *63/72,frameWidth/17, frameWidth/17);
		close.setMargin(new Insets(0, 0, 0, 0));
		close.setBounds(frameWidth*13/80, frameHeight *63/72,frameWidth/17, frameWidth/17);

		jtf_num.setBounds(frameWidth / 10, frameHeight / 64*15, frameWidth / 10,
				frameHeight / 30);
		jtf_name.setBounds(frameWidth / 10, frameHeight / 64*18,
				frameWidth / 10, frameHeight / 30);
	}


	public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==jb[0]){
			 this.notifyWatchers(State.STOCKMANINSTOCK);
		 }else if(e.getSource()==jb[1]){
			 this.notifyWatchers(State.STOCKMANOUTSTOCK);
		 }else if(e.getSource()==jb[2]){
			 this.notifyWatchers(State.STOCKMANSEARCH);
		 }else if(e.getSource()==jb[3]){
			 this.notifyWatchers(State.STOCKMANCHECK);
		 }else if(e.getSource()==jb[4]){
			 this.notifyWatchers(State.STOCKMANCHANGE);
		 } 
		 else if(e.getSource()==logout){
			 this.notifyWatchers(State.LOGOUT);
		 }
		 else if(e.getSource()==close){
			 System.exit(0);
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
}
