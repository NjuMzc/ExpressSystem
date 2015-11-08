package client.dataStub;

import java.rmi.RemoteException;

import client.dataservice.informationdataservice.informationDataServer;
import client.po.InformationPO;

public class informationDataServer_Stub implements informationDataServer {

	public void insert(InformationPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("An InformationPO is added in data!");
	}

	public void delete(InformationPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("An InformationPO is deleteed in data!");
	}

	public void update(InformationPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("An InformationPO is updated in data!");
	}

	public InformationPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("An InformationPO is found in data!");
		return null;
	}

}
