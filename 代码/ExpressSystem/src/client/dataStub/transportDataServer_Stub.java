package client.dataStub;

import java.rmi.RemoteException;

import client.dataservice.transportdataservice.transportDataServer;
import client.po.GoodPO;

public class transportDataServer_Stub implements transportDataServer{

	public void insert(GoodPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Good is added in data!");
		
	}

	public void update(GoodPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Good is updated in data!");
	}

	public GoodPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Bill is found in data!");
		return null;
	}

}
