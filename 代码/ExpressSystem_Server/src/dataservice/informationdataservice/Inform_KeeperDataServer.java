package dataservice.informationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.Workers.StorageKeeperPO;

public interface Inform_KeeperDataServer extends Remote{
	
	public StorageKeeperPO find(String id) throws RemoteException;
	
	public void addKeeper(StorageKeeperPO keeper) throws RemoteException;
	
	public void deleteKeeper(StorageKeeperPO keeper)throws RemoteException;
	
	public void update(StorageKeeperPO keeper)throws RemoteException;

}
