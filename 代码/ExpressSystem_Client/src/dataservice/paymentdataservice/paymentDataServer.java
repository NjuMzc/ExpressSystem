package dataservice.paymentdataservice;

import java.rmi.RemoteException;

import po.Message;
import po.PaymentPO;

public interface paymentDataServer {
	public Message find(String id) throws RemoteException;
	
	public void insert(PaymentPO po) throws RemoteException;
	
	
}
