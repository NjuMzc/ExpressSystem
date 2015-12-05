package dataservice.billsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.bills.EntruckBill;

public interface EntruckBillDataServer extends Remote {
	public void addBill(EntruckBill bill) throws RemoteException;

	public boolean removeBill(String id) throws RemoteException;

	public EntruckBill findBill(String id) throws RemoteException;

}
