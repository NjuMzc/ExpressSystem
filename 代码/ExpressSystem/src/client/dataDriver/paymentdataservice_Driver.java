package client.dataDriver;

import java.rmi.RemoteException;

import client.dataservice.paymentdataservice.paymentDataServer;
import client.po.PaymentPO;

public class paymentdataservice_Driver {
	
	public void drive(paymentDataServer server,PaymentPO po) throws RemoteException{
		System.out.println("This is paymentdataservice_Driver.");
		server.find("123456");
		server.insert(po);
	}

}
