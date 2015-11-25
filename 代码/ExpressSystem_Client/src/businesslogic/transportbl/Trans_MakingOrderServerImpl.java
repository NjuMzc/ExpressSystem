package businesslogic.transportbl;

import dataservice.transportdataservice.TransportDataServer;
import po.GoodPO;
import po.Message;
import po.bills.OrderBill;
import businesslogicservice.billsblservice.OrderBillServer;
import businesslogicservice.transportblservice.Trans_MakingOrderServer;

public class Trans_MakingOrderServerImpl implements Trans_MakingOrderServer{
    
	TransportDataServer dataServer;
	OrderBillServer billServer;
	GoodController goodController;
	
	//需要RMI提供
	public Trans_MakingOrderServerImpl(TransportDataServer dataServer,OrderBillServer billServer){
		this.dataServer=dataServer;
		this.billServer=billServer;
		this.goodController=new GoodController(dataServer);
	}
	
	@Override
	public OrderBill makeOrder(Message msg) {
		// TODO Auto-generated method stub
	    OrderBill bill=billServer.makeBill(msg);
	    //还需要计算预计时间
	    {
	    	
	    }
	    
	    goodController.makeGood(bill);
		return bill;
	}

}
