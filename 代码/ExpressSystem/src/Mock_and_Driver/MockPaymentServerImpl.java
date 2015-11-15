package Mock_and_Driver;

import client.businesslogic.paymentbl.PaymentServerImpl;
import client.po.BillPO;
import client.vo.Message;

public class MockPaymentServerImpl extends PaymentServerImpl{

	public Message getPaymentHistory(String start, String end) {
		// TODO Auto-generated method stub
		System.out.println("Payment History is got!");
		return null;
	}

	public Message getEarning() {
		// TODO Auto-generated method stub
		System.out.println("Earning is got!");
		return null;
	}

	public void export(Message message) {
		// TODO Auto-generated method stub
       System.out.println("export!");
	}

	public BillPO makePaymentBills(Message message) {
		// TODO Auto-generated method stub
		System.out.println("Payment Bill is made!");
		return null;
	}

	public BillPO makeChargeBill(Message message) {
		// TODO Auto-generated method stub
		System.out.println("Charge Bill is made!");
		return null;
	}

}
