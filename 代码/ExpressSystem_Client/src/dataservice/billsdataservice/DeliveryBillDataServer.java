package dataservice.billsdataservice;

import java.rmi.Remote;

import po.bills.DeliveryBill;

public interface DeliveryBillDataServer extends Remote {
	public void addBill(DeliveryBill bill);

	public boolean removeBill(String id);

	public DeliveryBill findBill(String id);

}
