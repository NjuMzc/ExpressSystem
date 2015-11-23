package dataservice.billsdataservice;

import po.BillPO;

public interface EntruckBillDataServer {
    public void addBill(BillPO bill);
	
	public boolean removeBill(String id);
	
	public BillPO findBill(String id);
	
	public void updateBill(BillPO bill);
}
