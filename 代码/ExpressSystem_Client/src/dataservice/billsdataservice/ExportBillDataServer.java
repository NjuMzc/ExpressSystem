package dataservice.billsdataservice;

import java.rmi.Remote;

import po.bills.ExportBill;

public interface ExportBillDataServer extends Remote{
    public void addBill(ExportBill bill);
	
	public boolean removeBill(String id);
	
	public ExportBill findBill(String id);
	
}
