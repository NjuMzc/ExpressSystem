package dataservice.billsdataservice;

import java.rmi.Remote;

import po.bills.ImportBill;

public interface ImportBillDataServer extends Remote{
    public void addBill(ImportBill bill);
	
	public boolean removeBill(String id);
	
	public ImportBill findBill(String id);
	
}
