package dataservice.billsdataservice;

import java.rmi.Remote;

import po.bills.SendingBill;

public interface SendingBillDataServer extends Remote{
    public void addBill(SendingBill bill);
	
	public boolean removeBill(String id);
	
	public SendingBill findBill(String id);
	
}
