package dataservice.billsdataservice;

import po.bills.ReceiveBill;

public interface ReceiveBillDataServer {
    public void addBill(ReceiveBill bill);
	
	public boolean removeBill(String id);
	
	public ReceiveBill findBill(String id);
	
}
