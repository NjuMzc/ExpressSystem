package dataservice.constantdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.constants.CityDistancePO;

public interface CityDistanceDataServer extends Remote{

	public void add(CityDistancePO distance)throws RemoteException;
	
	public CityDistancePO get(String city1,String city2)throws RemoteException;
	
	public void update(String city1,String city2,String distance)throws RemoteException;
}
