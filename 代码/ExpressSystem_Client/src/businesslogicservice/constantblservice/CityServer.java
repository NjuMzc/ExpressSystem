package businesslogicservice.constantblservice;

import po.CityPO;

public interface CityServer {

	public CityPO addCity(String id,String name);
	
	public String getId(String name);
	
	public boolean update(String id,String name);
	
	public boolean delete(String id);
	
}
