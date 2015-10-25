package client.dataservice.paymentdataservice;

import java.rmi.RemoteException;

import client.po.PaymentPO;
import client.vo.Message;

public interface paymentDataServer {
	public Message find(String id) throws RemoteException;
	
	public void insert(PaymentPO po) throws RemoteException;
	
	
}
