package dataservice.accountSetdataservice;

import java.rmi.RemoteException;

import po.Message;
import po.PaymentPO;

/**
 * accountSet���ݲ���½��Ͳ鿴
 * @author nick
 *
 */
public interface accountSetDataServer {
	public void insert(Message msg) throws RemoteException;
	
	public PaymentPO find(String id) throws RemoteException;
	

}
