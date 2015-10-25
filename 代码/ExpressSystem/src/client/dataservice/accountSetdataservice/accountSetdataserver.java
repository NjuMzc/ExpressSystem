package client.dataservice.accountSetdataservice;

import java.rmi.RemoteException;

import client.po.PaymentPO;
import client.vo.Message;

/**
 * accountSet数据层的新建和查看
 * @author nick
 *
 */
public interface accountSetdataserver {
	public void insert(Message msg) throws RemoteException;
	
	public PaymentPO find(String id) throws RemoteException;
	

}
