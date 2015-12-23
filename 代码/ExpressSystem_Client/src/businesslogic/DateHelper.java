package businesslogic;

public class DateHelper {

	public static boolean isBetween(String date,String start,String end){
		String[] dates=date.split("-");
		String[] starts=start.split("-");
		String[] ends=end.split("-");
		
		for(int i=0;i<3;i++){
			if(Integer.valueOf(dates[i])<=Integer.valueOf(ends[i])
					&&Integer.valueOf(dates[i])>=Integer.valueOf(starts[i])){
				continue;
			}else
				return false;
		}
		
		return true;
	}
}
