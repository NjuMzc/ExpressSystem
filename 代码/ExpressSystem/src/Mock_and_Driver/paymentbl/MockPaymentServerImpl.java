package Mock_and_Driver.paymentbl;

import java.rmi.RemoteException;


import Mock_and_Driver.billsbl.MockBillsMakerImpl;
import client.businesslogic.paymentbl.PaymentRecord;
import client.businesslogic.paymentbl.PaymentServerImpl;
import client.dataservice.billsdataservice.billsDataServer;
import client.po.BillPO;
import client.vo.Message;
import client.businesslogicservice.billsblservice.billMaker;;

public class MockPaymentServerImpl extends PaymentServerImpl{

	PaymentRecord recorder=new MockPaymentRecord();
	billMaker billMaker=new MockBillsMakerImpl(new billsDataServer() {
		
		public void update(BillPO po) throws RemoteException {
			// TODO Auto-generated method stub
			
		}
		
		public void insert(BillPO po) throws RemoteException {
			// TODO Auto-generated method stub
			
		}
		
		public BillPO find(String id) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
	});
	
	public Message getPaymentHistory(String start, String end) {
		// TODO Auto-generated method stub
		recorder.getRecord(start, end);
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
		recorder.add(billMaker.makePaymentBill(message));
		System.out.println("Payment Bill is made!");
		return null;
	}

	public BillPO makeChargeBill(Message message) {
		// TODO Auto-generated method stub
		recorder.add(billMaker.makeChargeBill(message));
		System.out.println("Charge Bill is made!");
		return null;
	}

}
