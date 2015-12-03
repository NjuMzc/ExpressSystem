package businesslogic.informationbl;

import client.RMIHelper;
import po.Institution.StoragePO;
import po.Institution.TranStationPO;
import dataservice.informationdataservice.Inform_StorageDataServer;
import dataservice.informationdataservice.Inform_TranStationDataServer;

public class Inform_TranStationInitial {
	Inform_TranStationDataServer dataServer;
	Inform_StorageDataServer storageDataServer;
	
	public Inform_TranStationInitial(){
		dataServer=RMIHelper.getTranStationData();
		storageDataServer=RMIHelper.getStorageData();
	}

	public  void init(){
		if(dataServer.find("025")==null){
			TranStationPO station=new TranStationPO("025", "南京市中转中心");
			dataServer.addTranStation(station);
			StoragePO storage=new StoragePO("025");
			storage.setName("南京市中转中心仓库");
			storageDataServer.add(storage);
		}
		if(dataServer.find("010")==null){
			TranStationPO station=new TranStationPO("010", "北京市中转中心");
			dataServer.addTranStation(station);
			StoragePO storage=new StoragePO("010");
			storage.setName("北京市中转中心仓库");
			storageDataServer.add(storage);
		}
		if(dataServer.find("020")==null){
			TranStationPO station=new TranStationPO("020", "广州市中转中心");
			dataServer.addTranStation(station);
			StoragePO storage=new StoragePO("020");
			storage.setName("广州市中转中心仓库");
			storageDataServer.add(storage);
		}
		if(dataServer.find("021")==null){
			TranStationPO station=new TranStationPO("021", "上海市中转中心");
			dataServer.addTranStation(station);
			StoragePO storage=new StoragePO("021");
			storage.setName("上海市中转中心仓库");
			storageDataServer.add(storage);
		}
		
	}
}
