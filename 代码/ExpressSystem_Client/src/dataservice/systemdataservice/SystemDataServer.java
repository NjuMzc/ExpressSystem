package dataservice.systemdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.SystemUserPO;



public interface SystemDataServer extends Remote {

	public SystemUserPO find(String id);
	
	public void insert(SystemUserPO po);
	
	public void delete(SystemUserPO po);
	
	public void update(SystemUserPO po);
	
	public int getUserNum();
	
	public ArrayList getAllUsers();
	 
}
