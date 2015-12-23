package businesslogic.billsbl.HallEntruckBillServer;

import java.util.Iterator;

import businesslogic.billsbl.approver.BillApproverServerImpl;
import businesslogicservice.billApprover.BillApproveServer;
import client.RMIHelper;
import dataservice.billsdataservice.HallEntruckBillDataServer;
import po.Message;
import po.bills.HallEntruckBill;

public class HallEntruckBillServer {
    HallEntruckBillDataServer dataServer;
    HallEntruckFeeCalculator calculator;
    BillApproveServer approver;
    
    public HallEntruckBillServer(){
    	calculator=new HallEntruckFeeCalculator();
    	//RMI
    	dataServer=RMIHelper.getHallEntruckData();
    	approver=new BillApproverServerImpl();
    }
	
	public HallEntruckBill makeBill(Message message,Iterator<String> orderList){
		HallEntruckBill bill=new HallEntruckBill(message, orderList);
		double fee=calculator.calculateFee(bill);
		bill.setPayment(fee);
		dataServer.addBill(bill);
		approver.addBill(bill.submit());
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
