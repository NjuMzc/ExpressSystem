package Mock_and_Driver.paymentbl;

import po.Message;
import businesslogicservice.paymentblservice.paymentServer;

public class paymentDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Message message=new Message();

		paymentServer server=new MockPaymentServerImpl();
		server.export(message);
		server.makeChargeBill(message);
		server.makePaymentBills(message);
		server.getEarning();
		server.getPaymentHistory("1", "2");
	}

}
