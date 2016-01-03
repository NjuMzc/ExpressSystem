package dataservice.billsdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import po.bills.OrderBill;
import po.bills.ReceiveBill;

public interface ReceiveBillDataServer extends Remote {
	public void addBill(ReceiveBill bill);

	public boolean removeBill(String id);

	public ReceiveBill findBill(String id);

	public ArrayList<ReceiveBill> getAll();
}
