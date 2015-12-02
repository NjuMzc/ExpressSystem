package dataservice.billsdataservice;

import java.rmi.Remote;

import po.bills.HallArrivalBill;

public interface HallArrivalBillDataServer extends Remote{
    public void addBill(HallArrivalBill bill);
	
	public boolean removeBill(String id);
	
	public HallArrivalBill findBill(String id);
	
}
