package businesslogic.billsbl.ChargeBillServer;

import java.util.Iterator;

import po.bills.ChargeBill;
import client.RMIHelper;
import businesslogic.billsbl.approver.BillApproverServerImpl;
import businesslogicservice.billApprover.BillApproveServer;
import dataservice.billsdataservice.ChargeBillDataServer;

public class ChargeBillServer {
	ChargeBillDataServer dataServer;
	BillApproveServer approver;
	
	public ChargeBillServer(){
		this.dataServer=RMIHelper.getChargeBillData();
		approver=new BillApproverServerImpl();
	}
	
	public ChargeBill makeBill(String date,String money,String senderNum,Iterator<String> orderNumbers){
		ChargeBill bill=new ChargeBill(date, money, senderNum, orderNumbers);
		dataServer.addBill(bill);
		approver.addBill(bill.submit());
		
		return bill;
	}
	
	public ChargeBill getBill(String id){
		ChargeBill bill=dataServer.findBill(id);
		return bill;
	}

}
