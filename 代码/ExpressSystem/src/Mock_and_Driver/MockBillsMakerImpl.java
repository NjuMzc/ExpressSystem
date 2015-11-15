package Mock_and_Driver;

import client.businesslogic.billsbl.BillsMakerImpl;
import client.businesslogicservice.systemblservice.systemServer;
import client.po.BillPO;
import client.vo.Message;

public class MockBillsMakerImpl extends BillsMakerImpl {

	public BillPO makeOrderBill(Message message) {
		// TODO Auto-generated method stub
		System.out.println("Order Bill is made!");
		return null;
	}

	public BillPO makeDeliveryBill(Message message) {
		// TODO Auto-generated method stub
		System.out.println("DeliveryBill is made!");
		return null;
	}

	public BillPO makeImportBill(Message message) {
		// TODO Auto-generated method stub
       System.out.println("Import Bill is made!");
		return null;
	}

	public BillPO makeExportBill(Message message) {
		// TODO Auto-generated method stub
		System.out.println("Export Bill is made!");
		return null;
	}

	public BillPO makeHallArrivalBill(Message message) {
		// TODO Auto-generated method stub
		System.out.println("HallArrival Bill is made");
		return null;
	}

	public BillPO makeTransArrivalBill(Message message) {
		// TODO Auto-generated method stub
		System.out.println("TransArrival Bill is made!");
		return null;
	}

	public BillPO makePaymentBill(Message message) {
		// TODO Auto-generated method stub
		System.out.println("Payment Bill is made!");
		return null;
	}

	public BillPO makeChargeBill(Message message) {
		// TODO Auto-generated method stub
		System.out.println("Charge Bill is made!");
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
