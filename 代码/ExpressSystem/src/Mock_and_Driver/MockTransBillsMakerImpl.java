package Mock_and_Driver;

import client.businesslogic.transportbl.transportBillsMakerImpl;
import client.po.BillPO;
import client.vo.Message;

public class MockTransBillsMakerImpl extends transportBillsMakerImpl {

	public BillPO makeOrderBill(Message message) {
		// TODO Auto-generated method stub
		System.out.println("Order Bill is made!");
		return null;
	}

	public BillPO makeDeliveryBill(Message message) {
		// TODO Auto-generated method stub
		System.out.println("Delivery Bill is made!");
		return null;
	}

	public BillPO makeHallArrivalBill(Message message) {
		// TODO Auto-generated method stub
		System.out.println("Hall Arrival Bill is made!");
		return null;
	}

	public BillPO makeTransArrivalBill(Message message) {
		// TODO Auto-generated method stub
		System.out.println("TransArrival Bill is made!");
		return null;
	}

	public BillPO makeEntruckBill(Message message) {
		// TODO Auto-generated method stub
		System.out.println("Entruck Bill is made!");
		return null;
	}

	public BillPO makeSendingBill(Message message) {
		// TODO Auto-generated method stub
		System.out.println("Sending Bill is made!");
		return null;
	}

	public BillPO makeReceiveBill(Message message) {
		// TODO Auto-generated method stub
		System.out.println("Receive Bill is made!");
		return null;
	}
}
