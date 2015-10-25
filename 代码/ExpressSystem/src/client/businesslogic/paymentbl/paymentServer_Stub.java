package client.businesslogic.paymentbl;

import client.businesslogicservice.paymentblservice.paymentServer;
import client.vo.BillVO;
import client.vo.Message;

public class paymentServer_Stub implements paymentServer {

	public BillVO paymentBillsMake(Message message) {
		// TODO Auto-generated method stub
		System.out.println("PaymentBills is made");
		return null;
	}

	public Message getPaymentHistory(String start, String end) {
		// TODO Auto-generated method stub
		System.out.println("PaymentHistory is got");
		return null;
	}

	public Message getEarning() {
		// TODO Auto-generated method stub
		System.out.println("Earning is got");
		return null;
	}

	public void export(Message message) {
		// TODO Auto-generated method stub
		System.out.println("Export!");

	}

}
