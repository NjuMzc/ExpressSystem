package Mock_and_Driver.paymentbl;

import client.businesslogic.paymentbl.PaymentRecord;
import client.po.BillPO;

public class MockPaymentRecord extends PaymentRecord{
	
	public void add(BillPO bill){
		System.out.println("A record is added");
	}
	
	public void getRecord(String start,String end){
		System.out.println("Get Record!");
	}

}
