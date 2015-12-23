package businesslogic.billsbl.SendingBillServer;

import businesslogic.billsbl.approver.BillApproverServerImpl;
import businesslogicservice.billApprover.BillApproveServer;
import client.RMIHelper;
import po.bills.SendingBill;
import dataservice.billsdataservice.SendingBillDataServer;

public class SendingBillServer {
	SendingBillDataServer dataServer;
	BillApproveServer approver;
	
	public SendingBillServer(){
		//RMI实现
		dataServer=RMIHelper.getSendingBillData();
		approver=new BillApproverServerImpl();
	}
	
	//制作新的订单
	public SendingBill makeBill(String time,String orderID,String sender){
		SendingBill bill=new SendingBill(time, orderID, sender);
		dataServer.addBill(bill);
		approver.addBill(bill.submit());
		return bill;
		
	}
	
	public SendingBill getBill(String id){
		try{
			SendingBill bill=dataServer.findBill(id);
			return bill;
		}catch(NullPointerException e){
			System.out.println("目标单据不存在！");
			return null;
		}
	}

}
