package Mock_and_Driver;

import client.businesslogic.billsbl.BillsApproverImpl;
import client.po.BillPO;

public class MockBillsFinderImpl extends BillsApproverImpl  {

	public BillPO findBill(String id) {
		// TODO Auto-generated method stub
		System.out.println("Bill is found!");
		return null;
	}
}
