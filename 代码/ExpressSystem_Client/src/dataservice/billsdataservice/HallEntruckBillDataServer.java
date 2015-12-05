package dataservice.billsdataservice;

import java.rmi.Remote;

import po.bills.HallEntruckBill;

public interface HallEntruckBillDataServer extends Remote {
	public void addBill(HallEntruckBill bill);

	public boolean removeBill(String id);

	public HallEntruckBill findBill(String id);

}
