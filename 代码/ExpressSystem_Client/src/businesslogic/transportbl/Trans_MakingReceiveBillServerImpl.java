package businesslogic.transportbl;

import po.bills.ReceiveBill;
import businesslogic.billsbl.ReceiveBillServer.ReceiveBillServer;
import businesslogicservice.transportblservice.Trans_MakingReceiveBillServer;

public class Trans_MakingReceiveBillServerImpl implements
		Trans_MakingReceiveBillServer {
	
	ReceiveBillServer billServer;
	GoodController goodController;
	
	public Trans_MakingReceiveBillServerImpl(){
		this.billServer=new ReceiveBillServer();
		this.goodController=new GoodController();
	}
	
	
	@Override
	public ReceiveBill makeBill(String id, String name, String time) {
		// TODO Auto-generated method stub
		ReceiveBill bill=billServer.makeBill(id, name, time);
		if(bill==null)
			return null;
		goodController.setGoodTransState(id, "Received");
		
		return bill;
	}

}
