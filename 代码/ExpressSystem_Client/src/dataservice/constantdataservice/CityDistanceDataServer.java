package dataservice.constantdataservice;

import java.rmi.Remote;

import po.constants.CityDistancePO;

public interface CityDistanceDataServer extends Remote{

	public void add(CityDistancePO distance);
	
	public CityDistancePO get(String city1,String city2);
	
	public void update(String city1,String city2,String distance);
}
