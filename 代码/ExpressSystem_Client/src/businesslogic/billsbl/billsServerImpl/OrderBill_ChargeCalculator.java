package businesslogic.billsbl.billsServerImpl;

import businesslogicservice.systemblservice.systemServer;
import po.bills.OrderBill;

public class OrderBill_ChargeCalculator {
	
	public double calculate(OrderBill bill){
		
		return 0;
	}
	//为各城市编号
   public int getValue(String place){
	   if(place.equals("BeiJing"))
		   return 1;
	   if(place.equals("ShangHai"))
		   return 2;
	   if(place.equals("GuangZhou"))
		   return 3;
	   if(place.equals("NanJing"))
		   return 5;
	   else return 0;
	   //返回值均为质数
   }
   // 得到城市间距离
	public double getDistance(String place1,String place2){
		switch(getValue(place1)*getValue(place2)){
		case 2:return 1064.7;//北京、上海
		case 3:return 1888.8;//北京、广州
		case 5:return 900;//北京、南京
		case  6:return 1214;//上海、广州
		case 10:return 266;//上海、南京
		case  15:return 1132;//广州、南京
         default: return 0;//原地
		}
		
	}
	
}
