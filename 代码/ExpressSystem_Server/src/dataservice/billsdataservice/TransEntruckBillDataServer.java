package dataservice.billsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.bills.TransEntruckBill;

public interface TransEntruckBillDataServer extends Remote {

	public void addBill(TransEntruckBill bill) throws RemoteException;

	public boolean removeBill(String id) throws RemoteException;

	public TransEntruckBill findBill(String id) throws RemoteException;

}
