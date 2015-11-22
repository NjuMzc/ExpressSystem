package Mock_and_Driver.billsbl;

import po.BillPO;
import businesslogic.billsbl.BillsApproverImpl;
import businesslogic.billsbl.BillsFinderImpl;

public class MockBillsFinderImpl extends BillsFinderImpl  {

	public BillPO findBill(String id) {
		// TODO Auto-generated method stub
		System.out.println("Bill is found!");
		return null;
	}
}
