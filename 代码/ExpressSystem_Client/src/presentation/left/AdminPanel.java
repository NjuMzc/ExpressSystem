package presentation.left;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import businesslogic.systembl.SystemHelper;
import presentation.watcher.State;
import presentation.watcher.Watched;
import presentation.watcher.Watcher;

public class AdminPanel extends LeftAll implements Watched, ActionListener {

	int frameWidth;
	int frameHeight;
	JButton manage;
	JButton logout;
	JButton close;
	JPanel picture;
	JLabel name;
	JLabel num;
	JLabel photo;
	private List<Watcher> list;
	
	JTextField jtf_num;
	JTextField jtf_name;

	public AdminPanel(int frameWidth, int frameHeight) {
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;

		list = new ArrayList<Watcher>();

		this.setLayout(null);
		this.setBounds(0, 0, frameWidth / 4, frameHeight);

		manage = new JButton("");// 系统管理
		logout = new JButton("");// 登出账号
		close = new JButton("");// 关闭系统
		
		
//		manage.setContentAreaFilled(false);
//		logout.setContentAreaFilled(false);
//		close.setContentAreaFilled(false);
	//
//		manage.setBorderPainted(false);
		logout.setBorderPainted(false);
		close.setBorderPainted(false);
		
		jtf_name = new JTextField();
		jtf_num = new JTextField();

		init();

		this.add(manage);
		this.add(logout);
		this.add(close);
		this.add(jtf_name);
		this.add(jtf_num);

	}

	// 添加背景
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("pictures\\adminleft1.png");
		Image bg = background.getImage();
		g.drawImage(bg, 0, 0, frameWidth / 4, frameHeight, null);
	}

	private void init() {
		manage.setBounds(0, frameHeight * 40 / 120, frameWidth / 4,
				frameHeight *1 / 13);
		manage.addActionListener(this);	
		logout.setMargin(new Insets(0, 0, 0, 0));
		logout.setBounds(frameWidth * 2/ 80+frameWidth/150, frameHeight * 63 / 72-frameHeight/100,
				frameWidth / 13, frameWidth / 13);
		
		 final ImageIcon icon8 = new ImageIcon("pictures//back.png");
		Image temp8 = icon8.getImage().getScaledInstance(logout.getWidth(),
				logout.getHeight(), icon8.getImage().SCALE_DEFAULT);
		//icon8= new ImageIcon(temp8);
		
		 final ImageIcon icon10= new ImageIcon("pictures//back2.png");
		Image temp10 = icon10.getImage().getScaledInstance(logout.getWidth(),
				logout.getHeight(), icon8.getImage().SCALE_DEFAULT);
		//icon10= new ImageIcon(temp10);
		
		logout.setIcon(icon8);
		logout.addActionListener(this);
		
		logout.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				logout.setIcon(icon8);
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				logout.setIcon(icon10);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				logout.setIcon(icon8);
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				logout.setIcon(icon10);
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	
		
		
		close.setMargin(new Insets(0, 0, 0, 0));
		close.setBounds(frameWidth * 12 / 80+frameWidth/150, frameHeight * 63 / 72-frameHeight/130,
				frameWidth / 13-frameWidth/110, frameWidth / 13);
		close.addActionListener(this);

		
		final ImageIcon icon9 = new ImageIcon("pictures//delete.png");
		Image temp9 = icon9.getImage().getScaledInstance(close.getWidth(),
				close.getHeight(), icon9.getImage().SCALE_DEFAULT);
		//icon9= new ImageIcon(temp9);
		close.setIcon(icon9);
		final ImageIcon icon11= new ImageIcon("pictures//delete2.png");
		Image temp11 = icon11.getImage().getScaledInstance(close.getWidth(),
				close.getHeight(), icon11.getImage().SCALE_DEFAULT);
		
		close.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				close.setIcon(icon9);
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				close.setIcon(icon11);
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				close.setIcon(icon9);
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				close.setIcon(icon11);
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//左栏按钮贴图
		ImageIcon icon0 = new ImageIcon("pictures//系统管理.png");
		Image temp0 = icon0.getImage().getScaledInstance(frameWidth/4,frameHeight/13, icon0.getImage().SCALE_DEFAULT);
		icon0 = new ImageIcon(temp0);
		manage.setIcon(icon0);
		
		jtf_name.setBounds(frameWidth / 10, frameHeight / 64*15, frameWidth / 10,
				frameHeight / 30);
		jtf_num.setBounds(frameWidth / 10, frameHeight / 64*18,
				frameWidth / 10, frameHeight / 30);
			
		jtf_name.setText(SystemHelper.getUserName());
		jtf_name.setEditable(false);
		jtf_num.setText(SystemHelper.getUserID());
		jtf_num.setEditable(false);
		}




	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == manage) {
			this.notifyWatchers(State.ADMINMANAGE);
		} else if (e.getSource() == logout) {
			this.notifyWatchers(State.LOGOUT);
		} else if (e.getSource() == close) {
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
