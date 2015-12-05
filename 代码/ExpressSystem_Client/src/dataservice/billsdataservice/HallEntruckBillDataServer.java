package dataservice.billsdataservice;

import po.bills.HallEntruckBill;

public interface HallEntruckBillDataServer {
    public void addBill(HallEntruckBill bill);
	
	public boolean removeBill(String id);
	
	public HallEntruckBill findBill(String id);
	
}
