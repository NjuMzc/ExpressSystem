package dataservice.billsdataservice;

import java.rmi.Remote;

import po.bills.TransArrivalBill;

public interface TransArrivalBillDataServer extends Remote{
    public void addBill(TransArrivalBill bill);
	
	public boolean removeBill(String id);
	
	public TransArrivalBill findBill(String id);
	
}
