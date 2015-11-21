package server.data.bankdata;

import java.rmi.RemoteException;

import client.po.BankPO;
import server.dataservice.bankdataservice.bankDataServer;
import server.lists.bank.bankList;
import server.lists.bank.impl.bankListImpl;

public class bankDataServerImpl implements bankDataServer {
	bankList list;
	public bankDataServerImpl() {
		list = new bankListImpl();
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
