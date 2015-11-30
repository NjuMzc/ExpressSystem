package businesslogic;
/**
 * 一个辅助类
 * @author rabook
 *
 */
public class LocationNumGetter {
	
	public static String getNum(String place){
		String locationNum;
		
		switch(place){
		case "BeiJing":
			locationNum="010";
			break;
		case "NanJing":
			locationNum="025";
		    break;
		case "GuangZhou":
			locationNum="020";
			break;
		case "ShangHai":
			locationNum="021";
			break;
		default:
		    locationNum="000";
		}
		
		return locationNum;
	}

}
