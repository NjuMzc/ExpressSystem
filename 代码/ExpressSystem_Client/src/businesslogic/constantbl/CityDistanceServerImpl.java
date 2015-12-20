package businesslogic.constantbl;

import client.RMIHelper;
import po.constants.CityDistancePO;
import dataservice.constantdataservice.CityDistanceDataServer;
import businesslogicservice.constantblservice.CityDistanceServer;

public class CityDistanceServerImpl implements CityDistanceServer{
    CityDistanceDataServer dataServer;
    
    public CityDistanceServerImpl(){
    	//RMI实现
    	dataServer=RMIHelper.getCityDistanceData();
    	
    	//初始化默认城市
    	if(dataServer.get("北京", "上海")==null){
    	  	addDistance("北京", "上海", "1064.7");
        	addDistance("北京", "广州", "1888.8");
        	addDistance("北京", "南京", "900");
        	addDistance("上海", "广州", "1213");
        	addDistance("上海", "南京", "266");
        	addDistance("广州", "南京", "1132");
    	}
    }
	
	@Override
	public double getDistance(String city1, String city2) {
		// TODO Auto-generated method stub
		CityDistancePO distance=dataServer.get(city1, city2);
		if(distance!=null){
			double result=distance.getDistance();
			return result;
		}else{
			return 0;
		}
		
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
			dataServer.update(city1,city2,distance);
			return true;
		}
	}

}
