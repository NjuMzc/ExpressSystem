package businesslogic.billsbl.DeliveryBillServer;

import java.util.Iterator;

import client.RMIHelper;
import dataservice.billsdataservice.DeliveryBillDataServer;
import po.Message;
import po.bills.DeliveryBill;

public class DeliveryBillServer {
	DeliveryBillDataServer dataServer;
	DeliveryFeeCalculator calculator;
	
	public DeliveryBillServer(){
		this.dataServer=RMIHelper.getDeliveryBillData();
		calculator=new DeliveryFeeCalculator();
	}
	
	public DeliveryBill makeBill(Message message,Iterator<String> billList){
		DeliveryBill bill=new DeliveryBill(message, billList);
		bill.setFee(calculator.calculateFee(bill));
		dataServer.addBill(bill);
		
		return bill;
	}
	
	public DeliveryBill getBill(String id){
		try{
			DeliveryBill bill=dataServer.findBill(id);
			return bill;
		}catch(NullPointerException e){
			System.out.println("目标单据不存在");
			return null;
		}
	}

}
