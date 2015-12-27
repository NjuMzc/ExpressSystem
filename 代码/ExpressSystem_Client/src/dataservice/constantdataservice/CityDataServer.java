package dataservice.constantdataservice;

import java.rmi.Remote;
import java.util.ArrayList;
import java.util.Iterator;

import po.CityPO;

public interface CityDataServer extends Remote{

	public void addCity(CityPO city);
	
	public CityPO getById(String id);
	
	public CityPO getByName(String name);
	
	public boolean remove(CityPO city);
	
	public void update(CityPO city);
	
	public ArrayList<CityPO> getAll();
}
