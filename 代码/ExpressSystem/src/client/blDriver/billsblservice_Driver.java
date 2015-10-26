package client.blDriver;

import client.businesslogicservice.billsblservice.billApprover;
import client.businesslogicservice.billsblservice.billFinder;
import client.businesslogicservice.billsblservice.billMaker;
import client.vo.BillVO;
import client.vo.Message;

public class billsblservice_Driver {

        public void drive(billMaker billMaker,billApprover billApprover,billFinder billFinder,Message message){
			System.out.println("This is billsblservice_Driver.");
			 
			 BillVO bill=billMaker.makeBill(message);
			 billFinder.findBill("123456");
			 billApprover.approveBill(bill, true);
		}

	
}
