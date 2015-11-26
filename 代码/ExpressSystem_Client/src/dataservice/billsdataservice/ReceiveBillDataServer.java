package dataservice.billsdataservice;

import java.rmi.Remote;

import po.bills.ReceiveBill;

public interface ReceiveBillDataServer extends Remote {
	public void addBill(ReceiveBill bill);

	public boolean removeBill(String id);

	public ReceiveBill findBill(String id);

}
