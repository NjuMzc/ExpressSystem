package businesslogic.billsbl.HallEntruckBillServer;

import java.util.Iterator;

import client.RMIHelper;
import dataservice.billsdataservice.HallEntruckBillDataServer;
import po.Message;
import po.bills.HallEntruckBill;

public class HallEntruckBillServer {
    HallEntruckBillDataServer dataServer;
    HallEntruckFeeCalculator calculator;
    
    public HallEntruckBillServer(){
    	calculator=new HallEntruckFeeCalculator();
    	//RMI
    	dataServer=RMIHelper.getHallEntruckData();
    }
	
	public HallEntruckBill makeBill(Message message,Iterator<String> orderList){
		HallEntruckBill bill=new HallEntruckBill(message, orderList);
		double fee=calculator.calculateFee(bill);
		bill.setPayment(fee);
		dataServer.addBill(bill);
		return bill;
		
	}
	
	public HallEntruckBill getBill(String id){
	    try{
	    	HallEntruckBill bill=dataServer.findBill(id);
	    	return bill;
	    }catch(NullPointerException e){
	    	System.out.println("目标单据不存在！");
	    	return null;
	    	
	    }
	}
}
