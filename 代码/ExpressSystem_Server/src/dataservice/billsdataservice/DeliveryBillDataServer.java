package dataservice.billsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.bills.DeliveryBill;

public interface DeliveryBillDataServer extends Remote {
	public void addBill(DeliveryBill bill) throws RemoteException;

	public boolean removeBill(String id) throws RemoteException;

	public DeliveryBill findBill(String id) throws RemoteException;

}
