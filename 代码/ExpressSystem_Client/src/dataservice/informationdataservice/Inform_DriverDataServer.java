package dataservice.informationdataservice;

import po.Workers.DriverPO;

public interface Inform_DriverDataServer {

	public void addDriver(DriverPO driver);
	
	public DriverPO getDriver(String driverId);
	
	public boolean updateDriver(DriverPO driver);
	
	public boolean deleteDriver(DriverPO driver);
	
}
