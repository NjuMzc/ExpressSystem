package client.dataStub;

import java.rmi.RemoteException;

import client.dataservice.accountSetdataservice.accountSetDataServer;
import client.po.PaymentPO;
import client.vo.Message;

public class accountSetDataServer_Stub implements accountSetDataServer{

	public void insert(Message msg) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("A account Message is added in data!");
	}

	public PaymentPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("A account Message is found in data!");
		return null;
	}

}
