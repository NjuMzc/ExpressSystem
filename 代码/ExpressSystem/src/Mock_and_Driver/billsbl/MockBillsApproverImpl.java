package Mock_and_Driver.billsbl;

import client.businesslogic.billsbl.BillsApproverImpl;
import client.businesslogic.billsbl.BillsList;
import client.po.BillPO;

public class MockBillsApproverImpl extends BillsApproverImpl {
	BillsList list;
	
	public MockBillsApproverImpl(){
		this.list=new MockBillsList();
	}
	
	public void approveBill(BillPO bill, boolean judge) {
		// TODO Auto-generated method stub
		list.remove(bill);
		System.out.println("Bill is approved!");
		
	}

	public void inform(BillPO bill) {
		// TODO Auto-generated method stub
		list.add(bill);
		System.out.println("Bill is informed!");
	}


}
