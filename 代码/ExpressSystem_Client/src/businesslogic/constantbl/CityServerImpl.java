package businesslogic.constantbl;

import java.util.Iterator;

import client.RMIHelper;
import dataservice.constantdataservice.CityDataServer;
import dataservice.informationdataservice.Inform_StorageDataServer;
import dataservice.informationdataservice.Inform_TranStationDataServer;
import po.CityPO;
import po.Institution.StoragePO;
import po.Institution.TranStationPO;
import businesslogicservice.constantblservice.CityServer;

public class CityServerImpl implements CityServer {

	Inform_StorageDataServer storageDataServer;
	Inform_TranStationDataServer tranServer;
    CityDataServer dataServer;
	
	public CityServerImpl(){
		//RMI
		dataServer=RMIHelper.getCityData();
		tranServer=RMIHelper.getTranStationData();
		storageDataServer=RMIHelper.getStorageData();
		
		//初始化四个城市
		if(dataServer.getById("025")==null){
			addCity("025", "南京");
			addCity("010", "北京");
			addCity("020","广州");
			addCity("021", "上海");
		}

	}
	
	@Override
	public CityPO addCity(String id,String name){
		if(dataServer.getById(id)!=null){
			return null;
		}
		CityPO city=new CityPO(id, name);
		dataServer.addCity(city);
		
		TranStationPO station=new TranStationPO(id,name+"中转中心");
		tranServer.addTranStation(station);
		StoragePO storage=new StoragePO(id);
		storage.setName(name+"中转中心仓库");
		storageDataServer.add(storage);
		return city;
		
	}

	@Override
	public String getId(String name) {
		// TODO Auto-generated method stub
		CityPO city=dataServer.getByName(name);
		if(city==null){
			return "";
		}else
			
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

	@Override
	public Iterator<CityPO> getAll() {
		// TODO Auto-generated method stub
		
		return dataServer.getAll().iterator();
	}

}
