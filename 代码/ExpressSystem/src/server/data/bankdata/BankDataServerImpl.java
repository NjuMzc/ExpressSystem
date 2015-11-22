package server.data.bankdata;

import java.rmi.RemoteException;

import client.po.BankPO;
import server.dataservice.bankdataservice.BankDataServer;
import server.lists.bank.BankList;
import server.lists.bank.impl.BankListImpl;

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
