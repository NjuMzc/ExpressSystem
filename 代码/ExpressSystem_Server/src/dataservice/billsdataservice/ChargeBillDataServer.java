package dataservice.billsdataservice;

import po.bills.ChargeBill;

public interface ChargeBillDataServer {

    public void addBill(ChargeBill bill);
	
	public boolean removeBill(String id);
	
	public ChargeBill findBill(String id);

}
