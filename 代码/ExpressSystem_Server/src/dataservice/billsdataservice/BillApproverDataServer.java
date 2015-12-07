package dataservice.billsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.bills.BillApproverList;

public interface BillApproverDataServer extends Remote {

	public BillApproverList get() throws RemoteException;

	public void update(BillApproverList list) throws RemoteException;
}
