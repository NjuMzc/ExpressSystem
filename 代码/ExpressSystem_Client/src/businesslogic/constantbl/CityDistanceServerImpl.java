package businesslogic.constantbl;

import po.constants.CityDistancePO;
import dataservice.constantdataservice.CityDistanceDataServer;
import businesslogicservice.constantblservice.CityDistanceServer;

public class CityDistanceServerImpl implements CityDistanceServer{
    CityDistanceDataServer dataServer;
    
    public CityDistanceServerImpl(){
    	//RMI实现
    	
    }
	
	@Override
	public double getDistance(String city1, String city2) {
		// TODO Auto-generated method stub
		CityDistancePO distance=dataServer.get(city1, city2);
		double result=distance.getDistance();
		return result;
	}

	@Override
	public boolean addDistance(String city1, String city2, String distance) {
		// TODO Auto-generated method stub
		CityDistancePO dis=new CityDistancePO(city1, city2, Double.valueOf(distance));
		if(dataServer.get(city1, city2)!=null)
			return false;
		else{
			dataServer.add(dis);
			return true;
		}
		
	}

	@Override
	public boolean changeDistance(String city1, String city2, String distance) {
		// TODO Auto-generated method stub
		CityDistancePO dis=dataServer.get(city1, city2);
		if(dis==null){
			return false;
		}else{
			dis.setDistance(distance);
			dataServer.update(dis);
			return true;
		}
	}

}
