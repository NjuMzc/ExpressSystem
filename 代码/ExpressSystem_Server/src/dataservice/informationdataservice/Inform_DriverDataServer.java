package dataservice.informationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.Workers.DriverPO;

public interface Inform_DriverDataServer extends Remote{

	public void addDriver(DriverPO driver)throws RemoteException;
	
	public DriverPO getDriver(String driverId)throws RemoteException;
	
	public boolean updateDriver(DriverPO driver)throws RemoteException;
	
	public boolean deleteDriver(DriverPO driver)throws RemoteException;
	
}
