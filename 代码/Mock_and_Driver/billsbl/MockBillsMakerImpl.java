package Mock_and_Driver.billsbl;

import java.rmi.RemoteException;

import po.BillPO;
import po.Message;
import businesslogic.billsbl.BillsFactory;
import businesslogic.billsbl.BillsMakerImpl;
import businesslogic.billsbl.OrderBill;
import businesslogicservice.systemblservice.systemServer;
import dataservice.billsdataservice.billsDataServer;

public class MockBillsMakerImpl extends BillsMakerImpl {

	BillsFactory billsFactory;
	
	billsDataServer dataServer;
	
	public MockBillsMakerImpl(billsDataServer dataServer) {
		super(dataServer);
		billsFactory=new BillsFactory();
		this.dataServer=dataServer;
	}

	public OrderBill makeOrderBill(Message message) {
		// TODO Auto-generated method stub
		BillPO bill=billsFactory.makeOrderBill(message);
		System.out.println("Order Bill is made!");
		return (OrderBill) bill;
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
