package client.presentation;

import javax.swing.*;

import client.presentation.left.*;
import client.presentation.log.*;
import client.presentation.right.accountant.*;
import client.presentation.right.courier.*;
import client.presentation.right.stockman.*;
import client.presentation.right.ying_salesman.*;
import client.presentation.right.zhong_salesman.*;
import client.presentation.watcher.*;

public class MainFrame extends JFrame implements Watcher {

	int frameWidth;
	int frameHeight;

	// 左右侧panel，在登录时仅使用right
	JPanel right;
	JPanel left;

	// 界面状态
	State state = State.STOCKMANSTART;

	public static void main(String[] args) {
		MainFrame m = new MainFrame();
	}

	public MainFrame() {
		Data d = new Data();
		this.frameWidth = d.getFrameWidth();
		this.frameHeight = d.getFrameHeight();

		left = new StockmanPanel(frameWidth, frameHeight);
		((StockmanPanel) left).addWatcher(this);
		right = new StockmanStart(frameWidth, frameHeight);

		this.setTitle("快递物流系统");
		this.setVisible(true);
		this.setResizable(false);
		this.setBounds(0, 0, frameWidth, frameHeight);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.add(left);
		this.add(right);
	}

	public void update(State state) {

		this.remove(right);
		this.state = state;

		if (state == State.COURIERSTART) {
			right = new StartPanel(frameWidth, frameHeight);
		} else if (state == State.COURIERMAKEBILL) {
			right = new CourierMakebill(frameWidth, frameHeight);
			((CourierMakebill) right).addWatcher(this);
		} else if (state == State.COURIERINPUTINFOR) {
			right = new InputInforPanel(frameWidth, frameHeight);
			((InputInforPanel) right).addWatcher(this);
		} else if (state == State.COURIERSEARCH) {
			right = new CourierSearch(frameWidth, frameHeight);
			((CourierSearch) right).addWatcher(this);
		} else if (state == State.LOGMAINFRAME) {
			right = new LogMainFrame(frameWidth, frameHeight);
			((LogMainFrame) right).addWatcher(this);
		} else if (state == State.COVER) {
			right = new Cover(frameWidth, frameHeight);
			((Cover) right).addWatcher(this);
		} else if (state == State.ZHONG_START) {
			right = new Zhong_start(frameWidth, frameHeight);
		} else if (state == State.ZHONG_TRANSFER) {
			right = new Zhong_transfer(frameWidth, frameHeight);
			((Zhong_transfer) right).addWatcher(this);
		} else if (state == State.ZHONG_ARRIVAL) {
			right = new Zhong_arrival(frameWidth, frameHeight);
			((Zhong_arrival) right).addWatcher(this);
		} else if (state == State.ZHONG_ENTRUCKING) {
			right = new Zhong_entrucking(frameWidth, frameHeight);
			((Zhong_entrucking) right).addWatcher(this);
		} else if (state == State.YING_START) {
			right = new Ying_start(frameWidth, frameHeight);
		} else if (state == State.YING_COLLECT) {
			right = new Ying_collect(frameWidth, frameHeight);
			((Ying_collect) right).addWatcher(this);
		} else if (state == State.YING_ARRIVE) {
			right = new Ying_arrive(frameWidth, frameHeight);
			((Ying_arrive) right).addWatcher(this);
		} else if (state == State.YING_RECEIVE) {
			right = new Ying_receive(frameWidth, frameHeight);
			((Ying_receive) right).addWatcher(this);
		} else if (state == State.YING_PAYMENT) {
			right = new Ying_payment(frameWidth, frameHeight);
			((Ying_payment) right).addWatcher(this);
		} else if (state == State.YING_LOADING) {
			right = new Ying_loading(frameWidth, frameHeight);
			((Ying_loading) right).addWatcher(this);
		} else if (state == State.YING_MANAGEINFOR) {
			right = new Ying_manageInfor(frameWidth, frameHeight);
			((Ying_manageInfor) right).addWatcher(this);
		} else if (state == State.LOGSEARCH) {
			right = new LogSearch(frameWidth, frameHeight);
			((LogSearch) right).addWatcher(this);
		} else if (state == State.ACCOUNTANTSTART) {
			right = new AccountantStart(frameWidth, frameHeight);
		} else if (state == State.ACCOUNTANTMAKEBILL) {
			right = new AccountantMakebill(frameWidth, frameHeight);
			((AccountantMakebill) right).addWatcher(this);
		} else if (state == State.ACCOUNTANTMAKESHEET) {
			right = new AccountantMakeSheet(frameWidth, frameHeight);
			((AccountantMakeSheet) right).addWatcher(this);
		} else if (state == State.ACCOUNTANTPAYMENT) {
			right = new AccountantPayment(frameWidth, frameHeight);
			((AccountantPayment) right).addWatcher(this);
		} else if (state == State.ACCOUNTANTCOST) {
			right = new AccountantCost(frameWidth, frameHeight);
			((AccountantCost) right).addWatcher(this);
		} else if (state == State.ACCOUNTANTMANAGE) {
			right = new AccountantManage(frameWidth, frameHeight);
			((AccountantManage) right).addWatcher(this);
		} else if (state == State.ACCOUNTANTBALACE) {
			right = new AccountantBalace(frameWidth, frameHeight);
			((AccountantBalace) right).addWatcher(this);
		} else if (state == State.ACCOUNTANTBALACEAFTER) {
			right = new AccountantBalaceAfter(frameWidth, frameHeight);
			((AccountantBalaceAfter) right).addWatcher(this);
		} else if (state == State.STOCKMANSTART) {
			right = new StockmanStart(frameWidth, frameHeight);
		}else if(state==State.STOCKMANINSTOCK){
			right=new StockmanInStock(frameWidth, frameHeight);
			((StockmanInStock)right).addWatcher(this);
		}else if(state==State.STOCKMANINSTOCKAFTER){
			right=new StockmanInStockAfter(frameWidth, frameHeight);
			((StockmanInStockAfter)right).addWatcher(this);
		}else if(state==State.STOCKMANOUTSTOCK){
			right=new StockmanOutStock(frameWidth, frameHeight);
			((StockmanOutStock)right).addWatcher(this);
		}else if(state==State.STOCKMANOUTSTOCKAFTER){
			right=new StockmanOutStockAfter(frameWidth, frameHeight);
			((StockmanOutStockAfter)right).addWatcher(this);
		}else if(state==State.STOCKMANSEARCH){
			right=new StockmanSearch(frameWidth, frameHeight);
			((StockmanSearch)right).addWatcher(this);
		}else if(state==State.STOCKMANCHECK){
			right=new StockmanCheck(frameWidth, frameHeight);
			((StockmanCheck)right).addWatcher(this);
		}else if(state==State.STOCKMANCHANGE){
			right=new StockmanChange(frameWidth, frameHeight);
			((StockmanChange)right).addWatcher(this);
		}
		
		this.add(right);
		this.repaint();
	}

}
