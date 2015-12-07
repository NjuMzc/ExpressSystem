package dataservice.constantdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.CityPO;

public interface CityDataServer extends Remote {

	public void addCity(CityPO city) throws RemoteException;

	public CityPO getById(String id) throws RemoteException;

	public CityPO getByName(String name) throws RemoteException;

	public boolean remove(CityPO city) throws RemoteException;

	public void update(CityPO city) throws RemoteException;
}
