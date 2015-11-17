package client.presentation;

import javax.swing.*;

import client.presentation.left.*;
import client.presentation.log.*;
import client.presentation.right.courier.*;
import client.presentation.right.ying_salesman.*;
import client.presentation.right.zhong_salesman.*;
import client.presentation.watcher.*;

public class MainFrame extends JFrame implements Watcher {

	int frameWidth;
	int frameHeight;

	// 封面声明
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

	// 快递员右侧panel声明
	StartPanel startpanel;
	InputInforPanel inputinforpanel;
	CourierMakebill courierMakebill;
	CourierSearch courierSearch;

	// 中转中心业务员右侧panel声明
	Zhong_arrival zhong_arrival;
	Zhong_start zhong_start;
	Zhong_transfer zhong_transfer;
	Zhong_entrucking zhong_entrucking;

	// 营业厅业务员右侧panel声明
	Ying_start ying_start;
	Ying_collect ying_collect;
	Ying_arrive ying_arrive;
	Ying_receive ying_receive;
	Ying_payment ying_payment;
	Ying_loading ying_loading;
	Ying_manageInfor ying_manageInfor;

	// 界面状态
	State state = State.YING_START;

	public static void main(String[] args) {

		MainFrame m = new MainFrame();
	}

	public MainFrame() {
		Data d = new Data();
		this.frameWidth = d.getFrameWidth();
		this.frameHeight = d.getFrameHeight();

		// 封面实例化
		// cover = new Cover(frameWidth, frameHeight);
		// cover.addWatcher(this);

		// 左侧panel实例化
		courierPanel = new CourierPanel(frameWidth, frameHeight);
		adminPanel = new AdminPanel(frameWidth, frameHeight);
		accountantPanel = new AccountantPanel(frameWidth, frameHeight);
		managerPanel = new ManagerPanel(frameWidth, frameHeight);
		stockmanPanel = new StockmanPanel(frameWidth, frameHeight);
		ying_salesmanPanel = new Ying_salesmanPanel(frameWidth, frameHeight);
		zhong_salesmanPanel = new Zhong_salesmanPanel(frameWidth, frameHeight);

		this.setTitle("快递物流系统");
		this.setVisible(true);
		this.setResizable(false);
		this.setBounds(0, 0, frameWidth, frameHeight);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 中转中心业务员右侧panel
		ying_start = new Ying_start(frameWidth, frameHeight);
		// zhong_arrival.addWatcher(this);
		this.add(ying_start);
		this.add(ying_salesmanPanel);

		// 左侧panel设置观察者
		courierPanel.addWatcher(this);
		accountantPanel.addWatcher(this);
		managerPanel.addWatcher(this);
		stockmanPanel.addWatcher(this);
		ying_salesmanPanel.addWatcher(this);
		zhong_salesmanPanel.addWatcher(this);

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
		} else if (state == State.ZHONG_START) {
			if (zhong_start == null) {
				zhong_start = new Zhong_start(frameWidth, frameHeight);
			}
			this.add(zhong_start);
		} else if (state == State.ZHONG_TRANSFER) {
			if (zhong_transfer == null) {
				zhong_transfer = new Zhong_transfer(frameWidth, frameHeight);
				zhong_transfer.addWatcher(this);
			}
			this.add(zhong_transfer);
		} else if (state == State.ZHONG_ARRIVAL) {
			if (zhong_arrival == null) {
				zhong_arrival = new Zhong_arrival(frameWidth, frameHeight);
				zhong_arrival.addWatcher(this);
			}
			this.add(zhong_arrival);
		} else if (state == State.ZHONG_ENTRUCKING) {
			if (zhong_entrucking == null) {
				zhong_entrucking = new Zhong_entrucking(frameWidth, frameHeight);
				zhong_entrucking.addWatcher(this);
			}
			this.add(zhong_entrucking);
		} else if (state == State.YING_START) {
			if (ying_start == null) {
				ying_start = new Ying_start(frameWidth, frameHeight);
			}
			this.add(ying_start);
		} else if (state == State.YING_COLLECT) {
			if (ying_collect == null) {
				ying_collect = new Ying_collect(frameWidth, frameHeight);
				ying_collect.addWatcher(this);
			}
			this.add(ying_collect);
		} else if (state == State.YING_ARRIVE) {
			if (ying_arrive == null) {
				ying_arrive = new Ying_arrive(frameWidth, frameHeight);
				ying_arrive.addWatcher(this);
			}
			this.add(ying_arrive);
		} else if (state == State.YING_RECEIVE) {
			if (ying_receive == null) {
				ying_receive = new Ying_receive(frameWidth, frameHeight);
				ying_receive.addWatcher(this);
			}
			this.add(ying_receive);
		} else if (state == State.YING_PAYMENT) {
			if (ying_payment == null) {
				ying_payment = new Ying_payment(frameWidth, frameHeight);
				ying_payment.addWatcher(this);
			}
			this.add(ying_payment);
		} else if (state == State.YING_LOADING) {
			if (ying_loading == null) {
				ying_loading = new Ying_loading(frameWidth, frameHeight);
				ying_loading.addWatcher(this);
			}
			this.add(ying_loading);
		} else if (state == State.YING_MANAGEINFOR) {
			if (ying_manageInfor == null) {
				ying_manageInfor = new Ying_manageInfor(frameWidth, frameHeight);
				ying_manageInfor.addWatcher(this);
			}
			this.add(ying_manageInfor);
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
		case ZHONG_ARRIVAL:
			res = this.zhong_arrival;
			break;
		case ZHONG_TRANSFER:
			res = zhong_transfer;
			break;
		case ZHONG_START:
			res = zhong_start;
			break;
		case ZHONG_ENTRUCKING:
			res = zhong_entrucking;
			break;
		case YING_START:
			res = ying_start;
			break;
		case YING_COLLECT:
			res = ying_collect;
			break;
		case YING_ARRIVE:
			res = ying_arrive;
			break;
		case YING_RECEIVE:
			res = ying_receive;
			break;
		case YING_PAYMENT:
			res = ying_payment;
			break;
		case YING_LOADING:
			res = ying_loading;
			break;
		case YING_MANAGEINFOR:
			res = ying_manageInfor;
			break;
		}
		return res;
	}
}
