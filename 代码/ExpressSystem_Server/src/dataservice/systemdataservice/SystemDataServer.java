package dataservice.systemdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.SystemUserPO;



public interface SystemDataServer extends Remote {

	public SystemUserPO find(String id)throws RemoteException;
	
	public void insert(SystemUserPO po)throws RemoteException;
	
	public void delete(SystemUserPO po)throws RemoteException;
	
	public void update(SystemUserPO po)throws RemoteException;
	
	public int getUserNum()throws RemoteException;
	 
	public ArrayList getAllUsers()throws RemoteException;
}
