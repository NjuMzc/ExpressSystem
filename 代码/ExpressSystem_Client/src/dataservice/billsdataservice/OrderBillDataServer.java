package dataservice.billsdataservice;

import java.rmi.Remote;

import po.bills.OrderBill;

public interface OrderBillDataServer extends Remote {
	
	public void addBill(OrderBill bill);
	
	public boolean removeBill(String id);
	
	public OrderBill findBill(String id);
	
    
}
