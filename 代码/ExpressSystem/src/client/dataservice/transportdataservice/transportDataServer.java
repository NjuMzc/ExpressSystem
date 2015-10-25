package client.dataservice.transportdataservice;

import java.rmi.RemoteException;

import client.po.GoodPO;

/**
 * 运输的数据层接口增、改、查
 * 
 * @author nick
 *
 */
public interface transportDataServer {
	public void insert(GoodPO po) throws RemoteException;

	public void update(GoodPO po) throws RemoteException;

	public GoodPO find(String id) throws RemoteException;
}
