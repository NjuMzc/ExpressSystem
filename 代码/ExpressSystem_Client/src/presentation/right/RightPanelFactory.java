package presentation.right;

import presentation.left.*;
import presentation.log.*;
import presentation.right.accountant.*;
import presentation.right.admin.adminManage;
import presentation.right.admin.adminStart;
import presentation.right.courier.*;
import presentation.right.manager.ManagerStart;
import presentation.right.manager.Manager_Manage;
import presentation.right.manager.Manager_check;
import presentation.right.manager.Manager_find;
import presentation.right.manager.Manager_make_constant;
import presentation.right.manager.Manager_make_money;
import presentation.right.stockman.*;
import presentation.right.ying_salesman.*;
import presentation.right.zhong_salesman.*;
import presentation.watcher.State;

public class RightPanelFactory {

	public RightAll createRightPanel(State state,int frameWidth,int frameHeight ){
		RightAll right = null;
		
		if (state == State.COURIERSTART) {
			right = new StartPanel(frameWidth, frameHeight);
		} else if (state == State.COURIERMAKEBILL) {
			right = new CourierMakebill(frameWidth, frameHeight);
		} else if (state == State.COURIERINPUTINFOR) {
			right = new InputInforPanel(frameWidth, frameHeight);
		} else if (state == State.COURIERSEARCH) {
			right = new CourierSearch(frameWidth, frameHeight);
		} else if (state == State.LOGMAINFRAME) {
			right = new LogMainFrame(frameWidth, frameHeight);
		} else if (state == State.COVER) {
			right = new Cover(frameWidth, frameHeight);
		} else if (state == State.ZHONG_START) {
			right = new Zhong_start(frameWidth, frameHeight);
		} else if (state == State.ZHONG_TRANSFER) {
			right = new Zhong_transfer(frameWidth, frameHeight);
		} else if (state == State.ZHONG_ARRIVAL) {
			right = new Zhong_arrival(frameWidth, frameHeight);
		} else if (state == State.ZHONG_ENTRUCKING) {
			right = new Zhong_entrucking(frameWidth, frameHeight);
		} else if (state == State.YING_START) {
			right = new Ying_start(frameWidth, frameHeight);
		} else if (state == State.YING_COLLECT) {
			right = new Ying_collect(frameWidth, frameHeight);
		} else if (state == State.YING_ARRIVE) {
			right = new Ying_arrive(frameWidth, frameHeight);
		} else if (state == State.YING_RECEIVE) {
			right = new Ying_receive(frameWidth, frameHeight);
		} else if (state == State.YING_PAYMENT) {
			right = new Ying_payment(frameWidth, frameHeight);
		} else if (state == State.YING_LOADING) {
			right = new Ying_loading(frameWidth, frameHeight);
		} else if (state == State.YING_MANAGEINFOR) {
			right = new Ying_manageInfor(frameWidth, frameHeight);
		} else if (state == State.LOGSEARCH) {
			right = new LogSearch(frameWidth, frameHeight);
		} else if (state == State.ACCOUNTANTSTART) {
			right = new AccountantStart(frameWidth, frameHeight);
		} else if (state == State.ACCOUNTANTMAKEBILL) {
			right = new AccountantMakebill(frameWidth, frameHeight);
		} else if (state == State.ACCOUNTANTMAKESHEET) {
			right = new AccountantMakeSheet(frameWidth, frameHeight);
		} else if (state == State.ACCOUNTANTPAYMENT) {
			right = new AccountantPayment(frameWidth, frameHeight);
		} else if (state == State.ACCOUNTANTCOST) {
			right = new AccountantCost(frameWidth, frameHeight);
		} else if (state == State.ACCOUNTANTMANAGE) {
			right = new AccountantManage(frameWidth, frameHeight);
		} else if (state == State.ACCOUNTANTBALACE) {
			right = new AccountantBalace(frameWidth, frameHeight);
		} else if (state == State.ACCOUNTANTBALACEAFTER) {
			right = new AccountantBalaceAfter(frameWidth, frameHeight);
		} else if (state == State.STOCKMANSTART) {
			right = new StockmanStart(frameWidth, frameHeight);
		} else if (state == State.STOCKMANINSTOCK) {
			right = new StockmanInStock(frameWidth, frameHeight);
		} else if (state == State.STOCKMANINSTOCKAFTER) {
			right = new StockmanInStockAfter(frameWidth, frameHeight);
		} else if (state == State.STOCKMANOUTSTOCK) {
			right = new StockmanOutStock(frameWidth, frameHeight);
		} else if (state == State.STOCKMANOUTSTOCKAFTER) {
			right = new StockmanOutStockAfter(frameWidth, frameHeight);
		} else if (state == State.STOCKMANSEARCH) {
			right = new StockmanSearch(frameWidth, frameHeight);
		} else if (state == State.STOCKMANCHECK) {
			right = new StockmanCheck(frameWidth, frameHeight);
		} else if (state == State.STOCKMANCHANGE) {
			right = new StockmanChange(frameWidth, frameHeight);
		} else if (state == State.MANAGERSTART) {
			right = new ManagerStart(frameWidth, frameHeight);
		} else if (state == State.MANAGERMAKEMONEY) {
			right = new Manager_make_money(frameWidth, frameHeight);
		} else if (state == State.MANAGERMAKECONSTANT) {
			right = new Manager_make_constant(frameWidth, frameHeight);
		} else if (state == State.MANAGERMANAGE) {
			right = new Manager_Manage(frameWidth, frameHeight);
		} else if (state == State.MANAGERCHECK) {
			right = new Manager_check(frameWidth, frameHeight);
		} else if (state == State.MANAGERFIND) {
			right = new Manager_find(frameWidth, frameHeight);
		} else if (state == State.ADMINSTART) {
			right = new adminStart(frameWidth, frameHeight);
		} else if (state == State.ADMINMANAGE) {
			right = new adminManage(frameWidth, frameHeight);
		} else if (state == State.COURIERMAKEBILLAFTER) {
			right = new CourierMakebill_After(frameWidth, frameHeight);
		} else if (state == State.COURIERSEARCHAFTER) {
			right = new CourierSearch_After(frameWidth, frameHeight);
		}
		
		return right;
	}
}
