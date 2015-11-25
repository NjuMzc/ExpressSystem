package businesslogicservice.billsblservice;

import po.bills.ReceiveBill;

public interface ReceiveBillServer {
	
	public ReceiveBill makeBill(String id,String name,String time);
	
	public ReceiveBill getBill(String id);
	

}
