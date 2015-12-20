package dataservice.billsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import po.bills.ChargeBill;

public interface ChargeBillDataServer extends Remote {

    public void addBill(ChargeBill bill)throws RemoteException;
	
	public boolean removeBill(String id)throws RemoteException;
	
	public ChargeBill findBill(String id)throws RemoteException;
	
	public ArrayList<ChargeBill> findBill(String date,String hallId)throws RemoteException;

}
