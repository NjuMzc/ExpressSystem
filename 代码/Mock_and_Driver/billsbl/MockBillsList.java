package Mock_and_Driver.billsbl;

import po.BillPO;
import businesslogic.billsbl.BillsList;

public class MockBillsList extends BillsList {
	
	public void add(BillPO bill){
		System.out.println("Bill is added into the queue.");
	}
	
	public void remove(BillPO bill){
		System.out.println("Bill is removed form the queue.");
	}

}
