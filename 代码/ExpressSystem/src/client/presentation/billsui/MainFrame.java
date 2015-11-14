package client.presentation.billsui;

import javax.swing.*;

import client.presentation.billsui.right.courier.*;
import client.presentation.billsui.watcher.*;
import client.presentation.billsui.left.*;
import client.presentation.billsui.log.Cover;
import client.presentation.billsui.log.LogMainFrame;

public class MainFrame extends JFrame implements Watcher {

	int frameWidth;
	int frameHeight;

	// 登录界面
	Cover cover;
	LogMainFrame logMainFrame;

	// 左侧panel声明
	CourierPanel courierPanel;
	AccountantPanel accountantPanel;
	ManagerPanel managerPanel;
	StockmanPanel stockmanPanel;
	Ying_salesmanPanel ying_salesmanPanel;
	Zhong_salesmanPanel zhong_salesmanPanel;
	AdminPanel adminPanel;

	// 右侧panel声明
	StartPanel startpanel;
	InputInforPanel inputinforpanel;
	CourierMakebill courierMakebill;
	CourierSearch courierSearch;

	State state = State.COVER;

	public static void main(String[] args) {

		MainFrame m = new MainFrame();
	}

	public MainFrame() {
		Data d = new Data();
		this.frameWidth = d.getFrameWidth();
		this.frameHeight = d.getFrameHeight();

		// 封面实例化
		cover = new Cover(frameWidth, frameHeight);
		cover.addWatcher(this);

		// 左侧panel实例化
		courierPanel = new CourierPanel(frameWidth, frameHeight);
		adminPanel = new AdminPanel(frameWidth, frameHeight);
		accountantPanel = new AccountantPanel(frameWidth, frameHeight);
		managerPanel = new ManagerPanel(frameWidth, frameHeight);
		stockmanPanel = new StockmanPanel(frameWidth, frameHeight);
		ying_salesmanPanel = new Ying_salesmanPanel(frameWidth, frameHeight);
		zhong_salesmanPanel = new Zhong_salesmanPanel(frameWidth, frameHeight);

		// 右侧panel实例化
		// startpanel = new StartPanel(frameWidth, frameHeight);

		// inputinforpanel = new InputInforPanel(frameWidth, frameHeight);
		// courierMakebill = new CourierMakebill(frameWidth, frameHeight);
		// courierSearch = new CourierSearch(frameWidth, frameHeight);

		this.setTitle("快递物流系统");
		this.setVisible(true);
		this.setResizable(false);
		this.setBounds(0, 0, frameWidth, frameHeight);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// this.add(adminPanel);
		// this.add(startpanel);
		this.add(cover);

		// 对左侧panel设置观察者
		courierPanel.addWatcher(this);
		accountantPanel.addWatcher(this);
		managerPanel.addWatcher(this);
		stockmanPanel.addWatcher(this);
		ying_salesmanPanel.addWatcher(this);
		zhong_salesmanPanel.addWatcher(this);

		// 对右侧的panel设置观察者
		// inputinforpanel.addWatcher(this);
		// courierMakebill.addWatcher(this);
		// courierSearch.addWatcher(this);

	}

	public void update(State state) {

		if (choose() != null) {
			this.remove(choose());
		}
		this.state = state;
		if (state == State.COURIERSTART) {
			if (startpanel == null) {
				startpanel = new StartPanel(frameWidth, frameHeight);
			}
			this.add(startpanel);

		} else if (state == State.COURIERMAKEBILL) {
			if (courierMakebill == null) {
				courierMakebill = new CourierMakebill(frameWidth, frameHeight);
				courierMakebill.addWatcher(this);
			}
			this.add(courierMakebill);

		} else if (state == State.COURIERINPUTINFOR) {
			if (inputinforpanel == null) {
				inputinforpanel = new InputInforPanel(frameWidth, frameHeight);
				inputinforpanel.addWatcher(this);
			}
			this.add(inputinforpanel);

		} else if (state == State.COURIERSEARCH) {
			if (courierSearch == null) {
				courierSearch = new CourierSearch(frameWidth, frameHeight);
				courierSearch.addWatcher(this);
			}
			this.add(courierSearch);

		} else if (state == State.LOGMAINFRAME) {
			if (logMainFrame == null) {
				logMainFrame = new LogMainFrame(frameWidth, frameHeight);
				logMainFrame.addWatcher(this);
			}
			this.add(logMainFrame);

		} else if (state == State.COVER) {
			if (cover == null) {
				cover = new Cover(frameWidth, frameHeight);
				cover.addWatcher(this);
			}
			this.add(cover);
		}

		this.repaint();
	}

	private JPanel choose() {
		JPanel res = null;
		switch (this.state) {
		case COURIERSTART:
			res = this.startpanel;
			break;
		case COURIERINPUTINFOR:
			res = this.inputinforpanel;
			break;
		case COURIERMAKEBILL:
			res = this.courierMakebill;
			break;
		case COURIERSEARCH:
			res = this.courierSearch;
			break;
		case COVER:
			res = this.cover;
			break;
		case LOGMAINFRAME:
			res = this.logMainFrame;
			break;
		}
		return res;
	}
}
