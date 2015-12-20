package businesslogic.billsbl.ImportBillServer;

import client.RMIHelper;
import businesslogic.billsbl.approver.BillApproverServerImpl;
import businesslogicservice.billApprover.BillApproveServer;
import po.bills.ImportBill;
import dataservice.billsdataservice.ImportBillDataServer;

public class ImportBillServer {

	ImportBillDataServer dataServer;
	BillApproveServer approver;
	
	public ImportBillServer(){
	   //RMIHelper
		dataServer=RMIHelper.getImportBillData();
		
		approver=new BillApproverServerImpl();
		
		
	}
	
	public ImportBill makeBill(String orderNum,String date,String destination,String[] location){
		
		ImportBill bill=new ImportBill(orderNum, date, destination, location);
		dataServer.addBill(bill);
		approver.addBill(bill.submit());
		
		return bill;
		
	}
	
	public ImportBill getBill(String id){
		ImportBill bill=dataServer.findBill(id);
		return bill;
		
	}
}
