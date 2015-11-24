package businesslogic.transportbl;

import dataservice.transportdataservice.transportDataServer;
import po.GoodPO;
import po.Message;
import po.bills.OrderBill;
import businesslogicservice.billsblservice.OrderBillServer;
import businesslogicservice.transportblservice.Trans_MakingOrderServer;

public class Trans_MakingOrderServerImpl implements Trans_MakingOrderServer{
    
	transportDataServer dataServer;
	OrderBillServer billServer;
	
	//需要RMI提供
	public Trans_MakingOrderServerImpl(transportDataServer dataServer,OrderBillServer billServer){
		this.dataServer=dataServer;
		this.billServer=billServer;
	}
	
	@Override
	public OrderBill makeOrder(Message msg) {
		// TODO Auto-generated method stub
	    OrderBill bill=billServer.makeBill(msg);
		return bill;
	}

}
