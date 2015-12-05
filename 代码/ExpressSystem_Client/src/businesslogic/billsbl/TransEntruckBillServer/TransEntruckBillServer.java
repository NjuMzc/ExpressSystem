package businesslogic.billsbl.TransEntruckBillServer;

import java.util.Iterator;

import dataservice.billsdataservice.TransEntruckBillDataServer;
import po.Message;
import po.bills.TransEntruckBill;

public class TransEntruckBillServer {
	
	   TransEntruckBillDataServer dataServer;
	   TransEntruckFeeCalculator calculator;
		
		public TransEntruckBill makeBill(Message message,Iterator<String> orderList){
			TransEntruckBill bill=new TransEntruckBill(message, orderList);
			double fee=calculator.calculateFee(bill);
			bill.setPayment(fee);
			dataServer.addBill(bill);
			return bill;
			
		}
		
		public TransEntruckBill getBill(String id){
		    try{
		    	TransEntruckBill bill=dataServer.findBill(id);
		    	return bill;
		    }catch(NullPointerException e){
		    	System.out.println("目标单据不存在！");
		    	return null;
		    	
		    }
		}

}
