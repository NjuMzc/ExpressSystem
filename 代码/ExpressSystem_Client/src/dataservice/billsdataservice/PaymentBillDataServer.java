package dataservice.billsdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import po.bills.PaymentBill;

public interface PaymentBillDataServer extends Remote{
    public void addBill(PaymentBill bill);
	
	public boolean removeBill(String id) ;
	
	public PaymentBill findBill(String id) ;
	
	public ArrayList<PaymentBill> getAll();
}
