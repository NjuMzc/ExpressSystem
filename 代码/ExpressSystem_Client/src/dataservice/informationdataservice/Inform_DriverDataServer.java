package dataservice.informationdataservice;

import java.rmi.Remote;

import po.Workers.DriverPO;

public interface Inform_DriverDataServer extends Remote{

	public void addDriver(DriverPO driver);
	
	public DriverPO getDriver(String driverId);
	
	public boolean updateDriver(DriverPO driver);
	
	public boolean deleteDriver(DriverPO driver);
	
}
