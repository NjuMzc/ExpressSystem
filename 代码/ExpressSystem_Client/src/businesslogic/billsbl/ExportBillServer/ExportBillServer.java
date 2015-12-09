package businesslogic.billsbl.ExportBillServer;

import po.bills.ExportBill;
import client.RMIHelper;
import businesslogic.billsbl.approver.BillApproverServerImpl;
import businesslogicservice.billApprover.BillApproveServer;
import dataservice.billsdataservice.ExportBillDataServer;

public class ExportBillServer {
	ExportBillDataServer dataServer;
	BillApproveServer approveServer;
	
	public ExportBillServer(){
		dataServer=RMIHelper.getExportBillData();
		approveServer=new BillApproverServerImpl();
		
	}

	public ExportBill makeBill(String orderNum,String date,String destination,String loader,
			String DeliveryNum,String transportNum){
		
		ExportBill bill=new ExportBill(orderNum, date, destination, loader, DeliveryNum, transportNum);
		dataServer.addBill(bill);
		approveServer.addBill(bill.submit());
		
		return bill;
		
	}
	
	public ExportBill getBill(String id){
		ExportBill bill=dataServer.findBill(id);
		return bill;
	}
}
