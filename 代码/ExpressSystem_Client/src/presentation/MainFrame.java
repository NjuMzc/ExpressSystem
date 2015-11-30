package presentation;

import java.awt.Cursor;
import java.awt.Point;

import javax.swing.*;

import presentation.left.*;
import presentation.log.*;
import presentation.right.RightAll;
import presentation.right.RightPanelFactory;
import presentation.watcher.*;

public class MainFrame extends JFrame implements Watcher {

	// 边框移动
	private boolean isMoved;
	private Point pre_point;
	private Point end_point;

	// 界面大小
	int frameWidth;
	int frameHeight;

	// 左右侧panel，在登录时仅使用right
	RightAll right;
	LeftAll left;

	// 界面状态
	State state = State.COVER;

	RightPanelFactory rightFactory;
	LeftPanelFactory leftFactory;

	
	
	public MainFrame() {
		Data d = new Data();
		this.frameWidth = d.getFrameWidth();
		this.frameHeight = d.getFrameHeight();

		right = new Cover(frameWidth, frameHeight);
		right.addWatcher(this);

		rightFactory = new RightPanelFactory();
		leftFactory = new LeftPanelFactory();

		this.setTitle("快递物流系统ELMS");
		this.setUndecorated(true);
		this.setDragable(this);
		this.setVisible(true);
		this.setResizable(false);
		this.setBounds(frameWidth / 5, frameHeight / 15, frameWidth,
				frameHeight);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.add(right);
	}

	 private void setDragable(final MainFrame lui) {  
	        this.addMouseListener(new java.awt.event.MouseAdapter() {  
	            public void mouseReleased(java.awt.event.MouseEvent e) {  
	                isMoved = false;// 鼠标释放了以后，是不能再拖拽的了  
	                lui.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));  
	            }  
	  
	            public void mousePressed(java.awt.event.MouseEvent e) {  
	                isMoved = true;  
	                pre_point = new Point(e.getX(), e.getY());// 得到按下去的位置  
	                lui.setCursor(new Cursor(Cursor.MOVE_CURSOR));  
	            }  
	        });  
	        //拖动时当前的坐标减去鼠标按下去时的坐标，就是界面所要移动的向量。  
	        this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {  
	            public void mouseDragged(java.awt.event.MouseEvent e) {  
	                if (isMoved) {// 判断是否可以拖拽  
	                    end_point = new Point(lui.getLocation().x + e.getX() - pre_point.x,  
	                            lui.getLocation().y + e.getY() - pre_point.y);  
	                    lui.setLocation(end_point);  
	                }  
	            }  
	        });  
	    }  
	
	public void update(State state) {

		this.remove(right);
		this.state = state;

		if (state != State.LOGOUT && state != State.LEFTACCOUNTANT
				&& state != State.LEFTADMIN && state != State.LEFTCOURIER
				&& state != State.LEFTMANAGER && state != State.LEFTSTOCKMAN
				&& state != State.LEFTYING && state != State.LEFTZHONG) {
			right = rightFactory.createRightPanel(state, frameWidth,
					frameHeight);
			this.repaint();
			right.addWatcher(this);
		} else if (state != State.LOGOUT) {
			left = leftFactory.createLeftPanel(state, frameWidth, frameHeight);
			left.addWatcher(this);
			this.add(left);
		} else {
			this.remove(left);
			this.remove(right);
			right = new Cover(frameWidth, frameHeight);
			right.addWatcher(this);
		}

		this.add(right);
		this.repaint();
	}
}
