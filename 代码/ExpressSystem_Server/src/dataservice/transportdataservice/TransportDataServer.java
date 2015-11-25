package dataservice.transportdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.GoodPO;

/**
 * 运输模块的数据接口
 * 
 * @author nick
 *
 */
public interface TransportDataServer extends Remote {
	
	public void insert(GoodPO po) throws RemoteException;

	public void update(GoodPO po) throws RemoteException;

	public GoodPO find(String id) throws RemoteException;
}
