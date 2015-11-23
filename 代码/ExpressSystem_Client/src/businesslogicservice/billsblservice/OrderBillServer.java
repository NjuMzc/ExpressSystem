package businesslogicservice.billsblservice;

import po.Message;
import po.bills.OrderBill;

public interface OrderBillServer {

	public OrderBill makeBill(Message msg);
	
	public OrderBill findBill(String id);
	
	public boolean removeBill(String id);
	
	public void updateBill(OrderBill bill);
	
}
