package dataservice.informationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.Workers.TranStaffPO;

public interface Inform_TranStaffDataServer extends Remote {

	public void addStaff(TranStaffPO staff) throws RemoteException;

	public TranStaffPO find(String id) throws RemoteException;

	public void deleteStaff(TranStaffPO staff) throws RemoteException;

	public void update(TranStaffPO staff) throws RemoteException;
}
