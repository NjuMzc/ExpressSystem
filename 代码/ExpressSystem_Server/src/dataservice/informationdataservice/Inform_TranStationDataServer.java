package dataservice.informationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.Institution.TranStationPO;

public interface Inform_TranStationDataServer extends Remote{

	public void addTranStation(TranStationPO station)throws RemoteException;
	
	public TranStationPO find(String id)throws RemoteException;
	
	public void update(TranStationPO station)throws RemoteException;
}
