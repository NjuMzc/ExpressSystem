package dataservice.billsdataservice;

import po.bills.TransArrivalBill;

public interface TransArrivalBillDataServer {
    public void addBill(TransArrivalBill bill);
	
	public boolean removeBill(String id);
	
	public TransArrivalBill findBill(String id);
	
}
