package dataservice.billsdataservice;

import java.rmi.Remote;

import po.bills.ChargeBill;

public interface ChargeBillDataServer extends Remote {

    public void addBill(ChargeBill bill);
	
	public boolean removeBill(String id);
	
	public ChargeBill findBill(String id);

}
