package businesslogic.transportbl;

import po.Message;
import po.bills.OrderBill;
import businesslogic.billsbl.billsServerImpl.OrderBillServer.OrderBillServerImpl;
import businesslogicservice.billsblservice.OrderBillServer;
import businesslogicservice.transportblservice.Trans_MakingOrderServer;

public class Trans_MakingOrderServerImpl implements Trans_MakingOrderServer{
    
	OrderBillServer billServer;
	GoodController goodController;
	
	//需要RMI提供
	public Trans_MakingOrderServerImpl(){
		this.billServer=new OrderBillServerImpl();
		this.goodController=new GoodController();
	}
	
	@Override
	public OrderBill makeOrder(Message msg) {
		// TODO Auto-generated method stub
	    OrderBill bill=billServer.makeBill(msg);
	    //还需要计算预计时间
	    {
	    	
	    }
	    
	    //添加一个新的货物
	    goodController.makeGood(bill);
		return bill;
	}

}
