package dataservice.constantdataservice;

import java.rmi.Remote;

import po.constants.PriceListPO;

public interface PriceListDataServer extends Remote{

	
	public PriceListPO get();
	
	public void update();
}
