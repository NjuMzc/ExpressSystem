package dataservice.informationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.Institution.StoragePO;

public interface Inform_StorageDataServer extends Remote{

	public void update(StoragePO storage)throws RemoteException;
	
	public StoragePO find(String id)throws RemoteException;
	
}
