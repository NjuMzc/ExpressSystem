package businesslogic.billsbl.DeliveryBillServer;

import java.util.Iterator;

import businesslogic.billsbl.approver.BillApproverServerImpl;
import businesslogicservice.billApprover.BillApproveServer;
import client.RMIHelper;
import dataservice.billsdataservice.DeliveryBillDataServer;
import po.Message;
import po.bills.DeliveryBill;

public class DeliveryBillServer {
	DeliveryBillDataServer dataServer;
	DeliveryFeeCalculator calculator;
	BillApproveServer approver;
	
	public DeliveryBillServer(){
		this.dataServer=RMIHelper.getDeliveryBillData();
		calculator=new DeliveryFeeCalculator();
		approver=new BillApproverServerImpl();
	}
	
	public DeliveryBill makeBill(Message message,Iterator<String> billList){
		DeliveryBill bill=new DeliveryBill(message, billList);
		bill.setFee(calculator.calculateFee(bill));
		dataServer.addBill(bill);
		approver.addBill(bill.submit());
		
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
