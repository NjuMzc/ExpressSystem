package dataservice.billsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.bills.ImportBill;

public interface ImportBillDataServer extends Remote{
    public void addBill(ImportBill bill)throws RemoteException;
	
	public boolean removeBill(String id)throws RemoteException;
	
	public ImportBill findBill(String id)throws RemoteException;
	
}
