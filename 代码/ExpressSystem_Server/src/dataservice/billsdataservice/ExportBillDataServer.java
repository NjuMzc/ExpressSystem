package dataservice.billsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.bills.ExportBill;

public interface ExportBillDataServer extends Remote{
    public void addBill(ExportBill bill)throws RemoteException;
	
	public boolean removeBill(String id)throws RemoteException;
	
	public ExportBill findBill(String id)throws RemoteException;
	
}
