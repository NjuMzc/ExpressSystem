package client.dataservice.bankdataservice;

import java.rmi.RemoteException;

import client.po.BankPO;

public interface bankDataServer {
	public BankPO find(String id) throws RemoteException;

	public void insert(BankPO po) throws RemoteException;

	public void delete(BankPO po) throws RemoteException;

	public void update(BankPO po) throws RemoteException;

	

}
