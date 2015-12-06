package dataservice.billsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.bills.PaymentBill;

public interface PaymentBillDataServer extends Remote{
    public void addBill(PaymentBill bill) throws RemoteException;
	
	public boolean removeBill(String id) throws RemoteException;
	
	public PaymentBill findBill(String id) throws RemoteException;
	
}
