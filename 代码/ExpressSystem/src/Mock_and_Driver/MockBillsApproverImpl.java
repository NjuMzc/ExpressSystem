package Mock_and_Driver;

import client.businesslogic.billsbl.BillsApproverImpl;
import client.businesslogic.billsbl.BillsList;
import client.po.BillPO;

public class MockBillsApproverImpl extends BillsApproverImpl {
	BillsList list;
	
	public MockBillsApproverImpl(){
		this.list=new BillsList();
	}
	
	public void approveBill(BillPO bill, boolean judge) {
		// TODO Auto-generated method stub
		System.out.println("Bill is approved!");
	}

	public void inform(BillPO bill) {
		// TODO Auto-generated method stub
		System.out.println("Bill is informed!");
	}


}
