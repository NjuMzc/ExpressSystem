package businesslogic.billsbl.HallArrivalBillServer;

import businesslogic.billsbl.approver.BillApproverServerImpl;
import businesslogicservice.billApprover.BillApproveServer;
import client.RMIHelper;
import dataservice.billsdataservice.HallArrivalBillDataServer;
import po.bills.HallArrivalBill;

public class HallArrivalBillServer  {
	HallArrivalBillDataServer dataServer;
	BillApproveServer approver;
	
	public HallArrivalBillServer(){
		//RMI赋值
		dataServer=RMIHelper.getHallArrivalBillData();
		
		approver=new BillApproverServerImpl();
	}
	
	public HallArrivalBill makeBill(String GoodID,String date,String transOrderNum,String departure,String state){
		
		HallArrivalBill bill=new HallArrivalBill(GoodID,state,transOrderNum,departure,state);
		dataServer.addBill(bill);
		approver.addBill(bill.submit());
		
		return bill;
	}
	
	public HallArrivalBill getBill(String id){
		HallArrivalBill bill=dataServer.findBill(id);
		if(bill==null){
			return null;
		}else 
			return bill;
		
	}

}
