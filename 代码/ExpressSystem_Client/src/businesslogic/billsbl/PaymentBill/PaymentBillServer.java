package businesslogic.billsbl.PaymentBill;

import client.RMIHelper;
import businesslogic.billsbl.approver.BillApproverServerImpl;
import businesslogicservice.billApprover.BillApproveServer;
import dataservice.billsdataservice.PaymentBillDataServer;
import po.bills.BillApproverPO;
import po.bills.PaymentBill;
import vo.paymentbl.PayVO;

public class PaymentBillServer {
	PaymentBillDataServer dataServer;
	BillApproveServer approver;
	PaymentBillIdMaker idMaker;
	
	public PaymentBillServer(){
		this.dataServer=RMIHelper.getPaymentBillData();
		this.approver=new BillApproverServerImpl();
		this.idMaker=new PaymentBillIdMaker();
		
	}
	
	public PaymentBill makeBill(PayVO payInform){
		PaymentBill bill=new PaymentBill(payInform);
		if(idMaker.giveId(bill)==null){
			return null;
		}
		bill.setId(idMaker.giveId(bill));
		dataServer.addBill(bill);
		approver.addBill(bill.submit());
		return bill;
	}
	
	public PaymentBill getBill(String id){
		PaymentBill bill=dataServer.findBill(id);
		return bill;
	}

}
