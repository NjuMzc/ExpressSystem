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
	
	public static String changeFormat(String date){
		
	      String[] dates=date.split("-");
	      String year=dates[0];
	      String month=dates[1];
	      String day=dates[2];
	      
	      if(month.length()==1){
	    	  month="0"+month;
	      }
	      
	      if(day.length()==1){
	    	  day="0"+day;
	      }
	      
	      return year+month+day;
	}
	
	public static boolean compare(String start,String end){
		String a=changeFormat(start);
		String b=changeFormat(end);
		
		if(Integer.valueOf(a)>Integer.valueOf(b))
			return false;
		else
			return true;
		
		
	}
}
