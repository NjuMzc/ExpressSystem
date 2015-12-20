package businesslogic.billsbl.OrderBillServer;

import businesslogic.constantbl.CityDistanceServerImpl;
import businesslogicservice.constantblservice.CityDistanceServer;
import po.bills.OrderBill;

public class OrderBill_ChargeCalculator {
	CityDistanceServer distanceServer;
	
	public OrderBill_ChargeCalculator(){
		distanceServer=new CityDistanceServerImpl();
	}
	
	public double calculate(OrderBill bill){
		String departure=bill.getSenderLocation().substring(0, 2);
		String destination=bill.getReceiverLocation().substring(0,2);
		
		double result=0;
		double distance=distanceServer.getDistance(departure, destination);
		//地址输入有误
		if(distance==0){
			return 0;
		}
		distance/=1000;
		
		double weight=Double.valueOf(bill.getGoodWeight());//获得重量
		
		
		String kind=bill.getKind();

		if(kind.equals("ecnomic")){
			//经济快递
			result=weight*distance*18;
		}else if(kind.equals("standard")){
			//标准快递
			result=weight*distance*23;
		}else if(kind.equals("express")){
			//特快专递
			result=weight*distance*25;
		}else{
			return 0;
		}
		
		double bagggingFee=Double.valueOf(bill.getBagFee());
		result+=bagggingFee;
		
		return result;
	}  

}
