package dataservice.constantdataservice;

import po.CityPO;

public interface CityDataServer {

	public void addCity(CityPO city);
	
	public CityPO getById(String id);
	
	public CityPO getByName(String name);
	
	public boolean remove(CityPO city);
	
	public void update(CityPO city);
}
