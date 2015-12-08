package presentation.right.ying_salesman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import presentation.right.RightAll;
import presentation.watcher.*;

public class Ying_collect extends RightAll implements ActionListener {

	int frameWidth;
	int frameHeight;
	JLabel jl[];
	JTextField jtf[];
	JButton confirm;
	JButton cancel;
	JButton over;

	private List<Watcher> list;

	public Ying_collect(int frameWidth, int frameHeight) {
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(frameWidth / 4, 0, frameWidth * 3 / 4, frameHeight);

		jl = new JLabel[5];
		for (int i = 0; i < 5; i++) {
			jl[i] = new JLabel();
		}
		confirm = new JButton("");//确认
		cancel = new JButton("");//取消
		jtf = new JTextField[4];
		for (int i = 0; i < 4; i++) {
			jtf[i] = new JTextField();
		}
		over = new JButton("");

		init();

		for (int i = 0; i < 4; i++) {
			this.add(jl[i]);
		}
		this.add(confirm);
		this.add(cancel);
		for (int i = 0; i < 3; i++) {
			this.add(jtf[i]);
		}
	}
	
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\派件单right.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth/4*3,frameHeight,null);
	}
	
	private void init() {
		jl[0].setText("派件单");
		jl[1].setText("到达日期");
		jl[2].setText("托运单条形码");
		jl[3].setText("快递员编号");
		jl[4].setText("快递员姓名");

		jl[0].setBounds(frameWidth /3, frameHeight / 10, frameWidth /5,
				frameHeight / 20);
		jl[0].setFont(new Font("黑体",Font.BOLD,22));
		for (int i = 1; i < 5; i++) {
			jl[i].setBounds(frameWidth / 10, frameHeight / 36*5*i + frameHeight/11+frameHeight/80,
					frameWidth / 8, frameHeight / 20);
			jl[i].setFont(new Font("宋体",Font.BOLD,17));
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

		for (int i = 0; i < 4; i++) {
			jtf[i].setBounds(frameWidth / 4, frameHeight / 36*5* (1 + i)+frameHeight/11+frameHeight/80,
					frameWidth / 8, frameHeight / 18);
			jtf[i].setFont(new Font("宋体",Font.PLAIN,15));
		}

		over.setBounds(frameWidth /3, frameHeight * 8 / 10+frameHeight/30,
				 frameWidth / 9,frameHeight / 16);
		over.addActionListener(this);
		ImageIcon icon3 = new ImageIcon("pictures//完成.png");
		Image temp3 = icon3.getImage().getScaledInstance(icon3.getIconWidth(),
				icon3.getIconHeight(), icon3.getImage().SCALE_DEFAULT);
		icon3 = new ImageIcon(temp3);
		over.setIcon(icon3);
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
		} else if (e.getSource() == confirm) {
			this.remove(confirm);
			this.remove(cancel);
			this.add(over);
			this.add(jtf[3]);
			this.add(jl[4]);
			for (int i = 0; i < 4; i++) {
				jtf[i].setEditable(false);
			}
			this.repaint();
		}

		if (e.getSource() == over) {
			this.notifyWatchers(State.YING_START);
		}
	}
}
