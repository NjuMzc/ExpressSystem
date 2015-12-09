package businesslogic.billsbl.PaymentBill;

import client.RMIHelper;
import businesslogic.billsbl.approver.BillApproverServerImpl;
import businesslogicservice.billApprover.BillApproveServer;
import dataservice.billsdataservice.PaymentBillDataServer;
import po.bills.BillApproverPO;
import po.bills.PaymentBill;

public class PaymentBillServer {
	PaymentBillDataServer dataServer;
	BillApproveServer approver;
	
	public PaymentBillServer(){
		this.dataServer=RMIHelper.getPaymentBillData();
		this.approver=new BillApproverServerImpl();
		
	}
	
	public PaymentBill makeBill(String date,String payer,String account,String tiaoMu,String money,String beiZhu){
		PaymentBill bill=new PaymentBill(date, payer, account, tiaoMu, money, beiZhu);
		dataServer.addBill(bill);
//		approver.addBill(BillApproverPO.submit());
		return bill;
	}
	
	public PaymentBill getBill(String id){
		PaymentBill bill=dataServer.findBill(id);
		return bill;
	}

}
