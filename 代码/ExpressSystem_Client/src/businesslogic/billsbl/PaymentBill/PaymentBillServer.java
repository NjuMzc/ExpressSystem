package businesslogic.billsbl.PaymentBill;

import client.RMIHelper;
import businesslogic.billsbl.approver.BillApproverServerImpl;
import businesslogicservice.billApprover.BillApproveServer;
import dataservice.billsdataservice.PaymentBillDataServer;
import po.bills.PaymentBill;
import vo.paymentbl.PayVO;

public class PaymentBillServer {
	PaymentBillDataServer dataServer;
	BillApproveServer approver;
	PaymentBillIdMaker idMaker;

	public PaymentBillServer() {
		this.dataServer = RMIHelper.getPaymentBillData();
		this.approver = new BillApproverServerImpl();
		this.idMaker = new PaymentBillIdMaker();

	}

	public PaymentBill makeBill(PayVO payInform) {
		String date = payInform.getDate();// 付款日期
		String payer = payInform.getPayer();// 付款人
		String account = payInform.getAccount();// 付款账号
		String tiaoMu = payInform.getTiaoMu();// 付款条目
		String money = payInform.getMoney();// 付款金额
		String beiZhu = payInform.getBeiZhu();// 备注
		PaymentBill bill = new PaymentBill(date, payer, account, tiaoMu, money, beiZhu);
		if (idMaker.giveId(bill) == null) {
			return null;
		}
		bill.setId(idMaker.giveId(bill));
		dataServer.addBill(bill);
		approver.addBill(bill.submit());
		return bill;
	}

	public PaymentBill getBill(String id) {
		PaymentBill bill = dataServer.findBill(id);
		return bill;
	}

}
