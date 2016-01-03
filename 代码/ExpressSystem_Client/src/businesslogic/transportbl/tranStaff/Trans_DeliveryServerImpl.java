package businesslogic.transportbl.tranStaff;

import java.util.Iterator;

import po.GoodPO;
import po.Message;
import po.bills.DeliveryBill;
import businesslogic.billsbl.DeliveryBillServer.DeliveryBillServer;
import businesslogic.transportbl.GoodController;
import businesslogicservice.transportblservice.tranStaff.Trans_DeliveryServer;

public class Trans_DeliveryServerImpl implements Trans_DeliveryServer{
    DeliveryBillServer billServer;
    GoodController goodController;
    
    public Trans_DeliveryServerImpl(){
    	billServer=new DeliveryBillServer();
    	goodController=new GoodController();
    }
	
	@Override
	public DeliveryBill makeBill(Message message, Iterator<String> billList) {
		// TODO Auto-generated method stub
		for(int i=0;i<message.length();i++){
			if(message.getInform(i).equals("")){
				return null;
			}
		}
        
	    DeliveryBill bill=billServer.makeBill(message, billList);
	    Iterator<String> list=bill.getBillNumList();
	    while(list.hasNext()){
			try{
				GoodPO good=goodController.getGood(list.next());
				goodController.setGoodTransState(good.getID(),"Delivering");
				
			}catch(NullPointerException  e){
				System.out.println("目标货物不存在！");
				return null;
			}
		}
		return bill;
	}

}
