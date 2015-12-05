package businesslogic.transportbl.hallStaff;

import java.util.Iterator;

import po.GoodPO;
import po.Message;
import po.bills.HallEntruckBill;
import businesslogic.billsbl.HallEntruckBillServer.HallEntruckBillServer;
import businesslogic.transportbl.GoodController;
import businesslogicservice.transportblservice.hallStaff.Trans_HallEntruckServer;

public class Trans_HallEntruckServerImpl implements Trans_HallEntruckServer{
    HallEntruckBillServer billServer;
    GoodController goodController;
 
    public Trans_HallEntruckServerImpl(){
    	billServer=new HallEntruckBillServer();
    	goodController=new GoodController();
    }
	
	@Override
	public HallEntruckBill makeBill(Message message, Iterator<String> orderList) {
		// TODO Auto-generated method stub
		HallEntruckBill bill=billServer.makeBill(message, orderList);
		while(orderList.hasNext()){
			try{
				GoodPO good=goodController.getGood(orderList.next());
				good.setTransState("Delivering");
				
			}catch(NullPointerException  e){
				System.out.println("目标货物不存在！");
				
			}
		}
		
		return bill;
	}

}
