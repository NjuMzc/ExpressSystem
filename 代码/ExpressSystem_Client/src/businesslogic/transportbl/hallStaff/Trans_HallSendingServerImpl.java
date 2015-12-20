package businesslogic.transportbl.hallStaff;

import po.GoodPO;
import po.bills.SendingBill;
import businesslogic.billsbl.SendingBillServer.SendingBillServer;
import businesslogic.transportbl.GoodController;
import businesslogicservice.transportblservice.hallStaff.Trans_HallSendingServer;

public class Trans_HallSendingServerImpl implements Trans_HallSendingServer{
	SendingBillServer billServer;
	GoodController goodController;

	public Trans_HallSendingServerImpl(){
		billServer=new SendingBillServer();
		goodController=new GoodController();
	}
	@Override
	public SendingBill makeBill(String time, String orderID, String sender) {
		// TODO Auto-generated method stu
		SendingBill bill=billServer.makeBill(time, orderID, sender);
	    try{
	    	GoodPO good=goodController.getGood(orderID);
	    	
		    good.setTransState("Delivering");
		    return bill;
	    }catch(NullPointerException e){
	  
	    	return null;
	    }
	}
     
	
}
