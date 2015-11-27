package businesslogicservice.transportblservice;

import po.bills.ReceiveBill;

public interface Trans_MakingReceiveBillServer {
	
	public ReceiveBill makeBill(String id,String name,String time);

}
