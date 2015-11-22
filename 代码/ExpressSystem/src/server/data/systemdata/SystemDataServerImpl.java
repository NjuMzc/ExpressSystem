package server.data.systemdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import client.po.SystemUserPO;
import server.dataservice.systemdataservice.SystemDataServer;
import server.lists.system.SystemList;
import server.lists.system.impl.SystemListImpl;

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

}
