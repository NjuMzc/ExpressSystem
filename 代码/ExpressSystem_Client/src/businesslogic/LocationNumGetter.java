package businesslogic;

import businesslogic.constantbl.CityServerImpl;

/**
 * 一个辅助类
 * 
 * @author rabook
 *
 */
public class LocationNumGetter {
	
	public static CityServerImpl cityServer=new CityServerImpl();

	public static String getNum(String place) {
		String locationNum;
		
		locationNum=cityServer.getId(place);

		return locationNum;
	}

}
