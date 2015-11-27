package presentation;

import javax.swing.*;

import presentation.left.*;
import presentation.log.*;
import presentation.right.RightAll;
import presentation.right.RightPanelFactory;
import presentation.watcher.*;

public class MainFrame extends JFrame implements Watcher {

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
		this.setVisible(true);
		this.setResizable(false);
		this.setBounds(frameWidth / 5, frameHeight / 15, frameWidth,
				frameHeight);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.add(right);
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
