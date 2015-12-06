package businesslogic.constantbl;

import dataservice.constantdataservice.CityDataServer;
import po.CityPO;
import businesslogicservice.constantblservice.CityServer;

public class CityServerImpl implements CityServer {

	
    CityDataServer dataServer;
	
	public CityServerImpl(){
		//RMI
	}
	
	@Override
	public CityPO addCity(String id,String name){
		if(dataServer.getById(id)!=null){
			return null;
		}
		CityPO city=new CityPO(id, name);
		dataServer.addCity(city);
		return city;
		
	}

	@Override
	public String getId(String name) {
		// TODO Auto-generated method stub
		CityPO city=dataServer.getByName(name);
		
		return city.getId();
	}

	@Override
	public boolean update(String id, String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
