package data.bankdata;

import java.rmi.RemoteException;

import lists.bank.BankList;
import lists.bank.impl.BankListImpl;
import dataservice.bankdataservice.BankDataServer;
import po.BankPO;

public class BankDataServerImpl implements BankDataServer {
	BankList list;
	public BankDataServerImpl() {
		list = new BankListImpl();
	}

	public BankPO find(String id) throws RemoteException {
		BankPO  po = list.find(id);
		return po;
	}

	public void insert(BankPO po) throws RemoteException {
		list.addUser(po);
	}

	public void delete(BankPO po) throws RemoteException {
		list.delUser(po);
	}

	public void update(BankPO po) throws RemoteException {
		list.update(po);
	}

}
