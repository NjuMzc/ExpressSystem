package businesslogic.billsbl.TransEntruckBillServer;

import java.util.Iterator;

import businesslogic.billsbl.OrderBillServer.OrderBillServer;
import businesslogic.constantbl.PriceListServerImpl;
import businesslogicservice.constantblservice.PriceListServer;
import po.bills.TransEntruckBill;

public class TransEntruckFeeCalculator {
	PriceListServer price;
	OrderBillServer billServer;
	
	public TransEntruckFeeCalculator(){
		this.price=new PriceListServerImpl();
		this.billServer=new OrderBillServer();
	}
	
	public double calculateFee(TransEntruckBill bill){
        double result=price.getCarPrice();
		
		Iterator<String> goods=bill.getOrderNum();
		double weight=0;
		while(goods.hasNext()){
			weight+=Double.valueOf(billServer.findBill(goods.next()).getGoodWeight());
		}
		result*=30*weight/1000;
		
		return result;
	}
}
