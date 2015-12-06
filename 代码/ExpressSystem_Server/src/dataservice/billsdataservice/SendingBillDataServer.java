package dataservice.billsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.bills.SendingBill;

public interface SendingBillDataServer extends Remote{
    public void addBill(SendingBill bill) throws RemoteException;
	
	public boolean removeBill(String id)throws RemoteException;
	
	public SendingBill findBill(String id)throws RemoteException;
	
}
