package dataservice.billsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.bills.ReceiveBill;

public interface ReceiveBillDataServer extends Remote {
	public void addBill(ReceiveBill bill) throws RemoteException;

	public boolean removeBill(String id) throws RemoteException;

	public ReceiveBill findBill(String id) throws RemoteException;
	
	public ArrayList<ReceiveBill> getAll() throws RemoteException;

}
