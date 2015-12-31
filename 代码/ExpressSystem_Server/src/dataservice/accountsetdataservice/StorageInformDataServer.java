package dataservice.accountsetdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.accountSet.StorageInform;

public interface StorageInformDataServer extends Remote{

	public void addInform(StorageInform inform)throws RemoteException;
	
	public ArrayList<StorageInform> getInform()throws RemoteException;
	
	public void clean()throws RemoteException;//清空之前的数据
}
