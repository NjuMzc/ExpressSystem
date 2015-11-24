package dataservice.billsdataservice;

import po.bills.ExportBill;

public interface ExportBillDataServer {
    public void addBill(ExportBill bill);
	
	public boolean removeBill(String id);
	
	public ExportBill findBill(String id);
	
}
