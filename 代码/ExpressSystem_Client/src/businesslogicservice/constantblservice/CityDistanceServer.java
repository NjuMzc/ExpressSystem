package businesslogicservice.constantblservice;

import java.util.ArrayList;
import java.util.Iterator;

import po.constants.CityDistancePO;

public interface CityDistanceServer {

	public double getDistance(String city1,String city2);
	
	public boolean addDistance(String city1,String city2,String distance);
	
	public boolean changeDistance(String city1,String city2,String distance);
	
	public Iterator<CityDistancePO> getAll();
}
