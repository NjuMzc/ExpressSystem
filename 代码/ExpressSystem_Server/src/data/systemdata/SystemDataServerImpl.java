package data.systemdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import lists.system.SystemList;
import lists.system.impl.SystemListImpl;
import dataservice.systemdataservice.SystemDataServer;
import po.SystemUserPO;

public class SystemDataServerImpl extends UnicastRemoteObject implements SystemDataServer {
	private SystemList list;
	public SystemDataServerImpl() throws RemoteException {
		list= new SystemListImpl();
	}
	public SystemUserPO find(String id) throws RemoteException{
		SystemUserPO po = list.find(id);
		return po;
	}

	public void insert(SystemUserPO po)throws RemoteException {
		list.addUser(po);
	}

	public void delete(SystemUserPO po) throws RemoteException{
		list.delUser(po);
	}

	public void update(SystemUserPO po) throws RemoteException{
		list.update(po);
	}
	public int getUserNum() throws RemoteException{
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ArrayList getAllUsers() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
