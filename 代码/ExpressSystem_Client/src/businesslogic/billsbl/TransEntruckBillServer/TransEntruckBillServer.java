package businesslogic.billsbl.TransEntruckBillServer;

import java.util.Iterator;

import businesslogic.billsbl.approver.BillApproverServerImpl;
import businesslogicservice.billApprover.BillApproveServer;
import client.RMIHelper;
import dataservice.billsdataservice.TransEntruckBillDataServer;
import po.Message;
import po.bills.TransEntruckBill;

public class TransEntruckBillServer {
	
	   TransEntruckBillDataServer dataServer;
	   TransEntruckFeeCalculator calculator;
	   
	   BillApproveServer approver;
	   
	   public TransEntruckBillServer(){
		   dataServer=RMIHelper.getTransEntruckBillData();
		   calculator=new TransEntruckFeeCalculator();
		   approver=new BillApproverServerImpl();
	   }
		
		public TransEntruckBill makeBill(Message message,Iterator<String> orderList){
			TransEntruckBill bill=new TransEntruckBill(message, orderList);
			double fee=calculator.calculateFee(bill);
			bill.setPayment(fee);
			dataServer.addBill(bill);
			approver.addBill(bill.submit());
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
