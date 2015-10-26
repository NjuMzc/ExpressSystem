package client.dataStub;

import java.rmi.RemoteException;

import client.dataservice.billsdataservice.billsDataServer;
import client.po.BillPO;

public class billsDataServer_Stub implements billsDataServer {

	public BillPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Bill is found in data!");
		return null;
	}

	public void insert(BillPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Bill is added in data!");
	}

	public void update(BillPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Bill is updated in data!");
	}

}
