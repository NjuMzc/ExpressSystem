package data.bankdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.bankdataservice.BankDataServer;
import po.BankPO;

public class BankDataServerImpl implements BankDataServer {
	final String path="src/dataList/bankList.dat";
	private ArrayList<BankPO> banks;
	public BankDataServerImpl() {
		
	}

	public BankPO find(String id) throws RemoteException {
//		for (BankPO po : banks) {
//			if(po.getID().equals(id))
//				return po;
//		}
		return null;
	}

	public void insert(BankPO po) throws RemoteException {
		
	}

	public void delete(BankPO po) throws RemoteException {

	}

	public void update(BankPO po) throws RemoteException {
		
	}

	@Override
	public ArrayList getAllBank() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
