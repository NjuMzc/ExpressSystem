package dataservice.billsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.bills.OrderBill;

public interface OrderBillDataServer extends Remote {

	public void addBill(OrderBill bill) throws RemoteException;

	public boolean removeBill(String id) throws RemoteException;

	public OrderBill findBill(String id) throws RemoteException;

}
