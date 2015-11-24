package dataservice.billsdataservice;

import po.bills.HallArrivalBill;

public interface HallArrivalBillDataServer {
    public void addBill(HallArrivalBill bill);
	
	public boolean removeBill(String id);
	
	public HallArrivalBill findBill(String id);
	
}
