package dataservice.informationdataservice;

import java.rmi.Remote;

import po.Institution.TranStationPO;

public interface Inform_TranStationDataServer extends Remote{

	public void addTranStation(TranStationPO station);
	
	public TranStationPO find(String id);
	
	public void update(TranStationPO station);
}
