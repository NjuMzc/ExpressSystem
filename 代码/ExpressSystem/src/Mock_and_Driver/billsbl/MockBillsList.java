package Mock_and_Driver.billsbl;

import client.businesslogic.billsbl.BillsList;
import client.po.BillPO;

public class MockBillsList extends BillsList {
	
	public void add(BillPO bill){
		System.out.println("Bill is added into the queue.");
	}
	
	public void remove(BillPO bill){
		System.out.println("Bill is removed form the queue.");
	}

}
