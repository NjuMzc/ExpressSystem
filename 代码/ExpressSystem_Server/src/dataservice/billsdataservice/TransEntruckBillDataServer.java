package dataservice.billsdataservice;

import po.bills.TransEntruckBill;

public interface TransEntruckBillDataServer {
	
    public void addBill(TransEntruckBill bill);
	
	public boolean removeBill(String id);
	
	public TransEntruckBill findBill(String id);

}
