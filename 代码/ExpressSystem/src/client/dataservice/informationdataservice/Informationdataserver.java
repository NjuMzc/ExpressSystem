package client.dataservice.informationdataservice;

import java.rmi.RemoteException;

import client.po.InformationPO;

/**
 * information数据层的增删改查
 * @author nick
 *
 */
public interface informationDataServer {
	
	public void insert(InformationPO po) throws RemoteException;
	
	public void delete(InformationPO po)throws RemoteException;
	
	public void update(InformationPO po)throws RemoteException;
	
	public InformationPO find(String id)throws RemoteException;
}
