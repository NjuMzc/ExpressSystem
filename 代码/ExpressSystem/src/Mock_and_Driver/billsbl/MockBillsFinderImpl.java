package Mock_and_Driver.billsbl;

import client.businesslogic.billsbl.BillsApproverImpl;
import client.businesslogic.billsbl.BillsFinderImpl;
import client.po.BillPO;

public class MockBillsFinderImpl extends BillsFinderImpl  {

	public BillPO findBill(String id) {
		// TODO Auto-generated method stub
		System.out.println("Bill is found!");
		return null;
	}
}
