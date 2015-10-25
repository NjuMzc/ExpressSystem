package client.businesslogic.billsbl;

import client.businesslogicservice.billsblservice.billApprover;
import client.vo.BillVO;

public class billApprover_Stub implements billApprover {

	public void approveBill(BillVO bill, boolean judge) {
		// TODO Auto-generated method stub
       System.out.println("Bill is approved.");
	}

}
