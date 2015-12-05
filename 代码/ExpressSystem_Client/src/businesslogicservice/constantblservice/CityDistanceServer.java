package businesslogicservice.constantblservice;

public interface CityDistanceServer {

	public double getDistance(String city1,String city2);
	
	public boolean addDistance(String city1,String city2,String distance);
	
	public boolean changeDistance(String city1,String city2,String distance);
	
}
