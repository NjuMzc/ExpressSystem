package dataservice.billsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.bills.HallEntruckBill;

public interface HallEntruckBillDataServer extends Remote {
	public void addBill(HallEntruckBill bill) throws RemoteException;

	public boolean removeBill(String id) throws RemoteException;

	public HallEntruckBill findBill(String id) throws RemoteException;

}
