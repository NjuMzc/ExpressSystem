package dataservice.billsdataservice;

import po.bills.DeliveryBill;

public interface DeliveryBillDataServer {
    public void addBill(DeliveryBill bill);
	
	public boolean removeBill(String id);
	
	public DeliveryBill findBill(String id);
	
}
