package Mock_and_Driver.billsbl;

import po.Message;
import businesslogic.billsbl.BillsMakerImpl;
import businesslogic.billsbl.OrderBill;
import businesslogicservice.billsblservice.billApprover;
import businesslogicservice.billsblservice.billFinder;
import businesslogicservice.billsblservice.billMaker;

public class BillDriver {
	
	public static void main(String[] args){
		 Message message=new Message();
			
		 billMaker billsMaker=new MockBillsMakerImpl(null);
		 
		 OrderBill orderbill=(OrderBill) billsMaker.makeOrderBill(message);
		 
		 billApprover billApprover=new MockBillsApproverImpl();
		 
		 billApprover.inform(orderbill);
		 
		 billApprover.approveBill(orderbill, true);
		 
		 billFinder billFinder=new MockBillsFinderImpl();
		 
		 billFinder.findBill("123");
		
	}


}
