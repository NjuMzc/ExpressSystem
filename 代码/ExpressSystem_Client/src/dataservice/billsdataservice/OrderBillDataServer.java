package dataservice.billsdataservice;

import po.bills.OrderBill;

public interface OrderBillDataServer {
	
	public void addBill(OrderBill bill);
	
	public boolean removeBill(String id);
	
	public OrderBill findBill(String id);
	
    
}
