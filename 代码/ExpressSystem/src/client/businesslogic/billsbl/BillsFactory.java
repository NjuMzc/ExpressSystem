package client.businesslogic.billsbl;

import client.po.BillPO;
import client.vo.Message;

/**
 * 单据工厂，负责实现所有单据的new工作
 * @author rabook
 *
 */
public class BillsFactory {
	public BillPO makeOrderBill(Message message) {
		// TODO Auto-generated method stub
		OrderBill bill=new OrderBill(message);
		return bill;
	}

	public BillPO makeDeliveryBill(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BillPO makeImportBill(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BillPO makeExportBill(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BillPO makeHallArrivalBill(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BillPO makeTransArrivalBill(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BillPO makePaymentBill(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BillPO makeChargeBill(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BillPO makeEntruckBill(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BillPO makeSendingBill(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BillPO makeReceiveBill(Message message) {
		// TODO Auto-generated method stub
		return null;
	}
}
