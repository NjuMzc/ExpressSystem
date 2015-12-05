package dataservice.constantdataservice;

import po.constants.CityDistancePO;

public interface CityDistanceDataServer {

	public void add(CityDistancePO distance);
	
	public CityDistancePO get(String city1,String city2);
	
	public void update(CityDistancePO distance);
}
