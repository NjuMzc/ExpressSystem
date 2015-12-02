package dataservice.billsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.bills.HallArrivalBill;

public interface HallArrivalBillDataServer extends Remote {
    public void addBill(HallArrivalBill bill)throws RemoteException;
	
	public boolean removeBill(String id)throws RemoteException;
	
	public HallArrivalBill findBill(String id)throws RemoteException;
	
}
