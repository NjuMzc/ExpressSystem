package dataservice.billsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.bills.TransArrivalBill;

public interface TransArrivalBillDataServer extends Remote {
	public void addBill(TransArrivalBill bill) throws RemoteException;

	public boolean removeBill(String id) throws RemoteException;

	public TransArrivalBill findBill(String id) throws RemoteException;

}
