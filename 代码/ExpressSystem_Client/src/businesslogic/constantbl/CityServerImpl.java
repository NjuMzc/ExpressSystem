package businesslogic.constantbl;

import client.RMIHelper;
import dataservice.constantdataservice.CityDataServer;
import po.CityPO;
import businesslogicservice.constantblservice.CityServer;

public class CityServerImpl implements CityServer {

	
    CityDataServer dataServer;
	
	public CityServerImpl(){
		//RMI
		dataServer=RMIHelper.getCityData();
		
		//初始化四个城市
		if(dataServer.getById("025")==null){
			addCity("025", "南京");
			addCity("010", "北京");
			addCity("021","广州");
			addCity("020", "上海");
		}

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
