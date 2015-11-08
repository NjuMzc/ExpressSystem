package client.dataStub;

import java.rmi.RemoteException;

import client.dataservice.paymentdataservice.paymentDataServer;
import client.po.PaymentPO;
import client.vo.Message;

public class paymentDataServer_Stub implements paymentDataServer{

	public Message find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("A payment message is found in data!");
		return null;
	}

	public void insert(PaymentPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("A payment message is added in data!");
	}

}
