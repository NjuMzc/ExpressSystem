package businesslogic.billsbl.DeliveryBillServer;

import java.util.Iterator;

import businesslogic.billsbl.OrderBillServer.OrderBillServer;
import businesslogic.constantbl.CityDistanceServerImpl;
import businesslogic.constantbl.PriceListServerImpl;
import businesslogicservice.constantblservice.CityDistanceServer;
import businesslogicservice.constantblservice.PriceListServer;
import po.bills.DeliveryBill;

public class DeliveryFeeCalculator {
	CityDistanceServer city;
	PriceListServer price;
	OrderBillServer billServer;
	
	public DeliveryFeeCalculator(){
		this.city=new CityDistanceServerImpl();
		this.price=new PriceListServerImpl();
		this.billServer=new OrderBillServer();
	}

	public double calculateFee(DeliveryBill bill){
		
		double result=0;
		String city1=bill.getDeparture();
		String city2=bill.getDestination();
		
		String kind=bill.getKind();
		
		result=city.getDistance(city1, city2);
		
		if(kind.equals("飞机")){
			result*=price.getAirPrice();
		}else if(kind.equals("火车")){
			result*=price.getTrainPrice();
		}else if(kind.equals("汽车")){
			result*=price.getCarPrice();
		}else {
			result=0;
		}
		
		Iterator<String> goods=bill.getBillNumList();
		double weight=0;
		while(goods.hasNext()){
			weight+=Double.valueOf(billServer.findBill(goods.next()).getGoodWeight());
		}
		result*=weight/1000;
		
		return result;
	}
}
