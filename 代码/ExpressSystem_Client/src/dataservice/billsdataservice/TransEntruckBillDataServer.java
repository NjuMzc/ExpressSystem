package dataservice.billsdataservice;

import java.rmi.Remote;

import po.bills.TransEntruckBill;

public interface TransEntruckBillDataServer extends Remote{
	
    public void addBill(TransEntruckBill bill);
	
	public boolean removeBill(String id);
	
	public TransEntruckBill findBill(String id);

}
