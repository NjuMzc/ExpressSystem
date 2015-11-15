package Mock_and_Driver.billsbl;

import client.businesslogic.billsbl.BillsMakerImpl;
import client.businesslogic.billsbl.OrderBill;
import client.businesslogicservice.billsblservice.billApprover;
import client.businesslogicservice.billsblservice.billFinder;
import client.businesslogicservice.billsblservice.billMaker;
import client.vo.Message;

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
