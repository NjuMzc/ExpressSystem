package dataservice.billsdataservice;

import po.bills.EntruckBill;

public interface EntruckBillDataServer {
    public void addBill(EntruckBill bill);
	
	public boolean removeBill(String id);
	
	public EntruckBill findBill(String id);
	
}
