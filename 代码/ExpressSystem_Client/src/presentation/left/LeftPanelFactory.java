package presentation.left;

import presentation.watcher.State;

public class LeftPanelFactory {

	public LeftAll createLeftPanel(State state, int frameWidth, int frameHeight) {
		LeftAll left=null;
		
		if (state == State.LEFTMANAGER) {
			left = new ManagerPanel(frameWidth, frameHeight);
		} else if (state == State.LEFTACCOUNTANT) {
			left = new AccountantPanel(frameWidth, frameHeight);
		} else if (state == State.LEFTCOURIER) {
			left = new CourierPanel(frameWidth, frameHeight);
		} else if (state == State.LEFTSTOCKMAN) {
			left = new StockmanPanel(frameWidth, frameHeight);
		} else if (state == State.LEFTYING) {
			left = new Ying_salesmanPanel(frameWidth, frameHeight);
		} else if (state == State.LEFTZHONG) {
			left = new Zhong_salesmanPanel(frameWidth, frameHeight);
		} else if (state == State.LEFTADMIN) {
			left = new AdminPanel(frameWidth, frameHeight);
		}
		
		return left;
	}
}
