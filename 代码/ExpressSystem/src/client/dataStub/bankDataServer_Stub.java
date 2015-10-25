package client.dataStub;

import java.rmi.RemoteException;

import client.dataservice.bankdataservice.bankDataServer;
import client.po.BankPO;

public class bankDataServer_Stub implements bankDataServer {

	public BankPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("A bank account is found in data!");
		return null;
	}

	public void insert(BankPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("A bank account is added in data!");
	}

	public void delete(BankPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("A bank account is deleted in data!");
	}

	public void update(BankPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("A bank account is updated in data!");
	}

}
