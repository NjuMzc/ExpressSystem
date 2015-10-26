package client.blDriver;

import client.blStub.*;
import client.vo.BillVO;
import client.vo.Message;

public class billsblservice_Driver {


		 
		public void drive(){
			System.out.println("This is billsblservice_Driver.");
		     Message message=new Message();
			 billMaker_Stub billMaker=new billMaker_Stub();
			 billFinder_Stub billFinder=new billFinder_Stub();
			 billApprover_Stub billApprover=new billApprover_Stub();
			 
			 BillVO bill=billMaker.makeBill(message);
			 billFinder.findBill("123456");
			 billApprover.approveBill(bill, true);
		}

		
		public static void main(String args[]){
			billsblservice_Driver billsDriver=new billsblservice_Driver();
			billsDriver.drive();
		}
	
}
