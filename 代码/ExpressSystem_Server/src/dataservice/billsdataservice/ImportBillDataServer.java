package dataservice.billsdataservice;

import po.bills.ImportBill;

public interface ImportBillDataServer {
    public void addBill(ImportBill bill);
	
	public boolean removeBill(String id);
	
	public ImportBill findBill(String id);
	
}
