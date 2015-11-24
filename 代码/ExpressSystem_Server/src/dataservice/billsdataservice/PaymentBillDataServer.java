package dataservice.billsdataservice;

import po.bills.PaymentBill;

public interface PaymentBillDataServer {
    public void addBill(PaymentBill bill);
	
	public boolean removeBill(String id);
	
	public PaymentBill findBill(String id);
	
}
