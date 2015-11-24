package dataservice.billsdataservice;

import po.bills.SendingBill;

public interface SendingBillDataServer {
    public void addBill(SendingBill bill);
	
	public boolean removeBill(String id);
	
	public SendingBill findBill(String id);
	
}
