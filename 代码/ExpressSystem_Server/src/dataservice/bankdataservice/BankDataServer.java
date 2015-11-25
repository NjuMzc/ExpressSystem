package dataservice.bankdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BankPO;

public interface BankDataServer {
	
	public BankPO find(String id) throws RemoteException;

	public void insert(BankPO po) throws RemoteException;

	public void delete(BankPO po) throws RemoteException;

	public void update(BankPO po) throws RemoteException;

	public ArrayList getAllBank() throws RemoteException;

}
