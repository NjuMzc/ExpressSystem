package dataservice.informationdataservice;

import po.Institution.TranStationPO;

public interface Inform_TranStationDataServer {

	public void addTranStation(TranStationPO station);
	
	public TranStationPO find(String id);
	
	public void update(TranStationPO station);
}
