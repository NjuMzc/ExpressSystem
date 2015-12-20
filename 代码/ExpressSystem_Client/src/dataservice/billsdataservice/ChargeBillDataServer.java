package dataservice.billsdataservice;

import java.rmi.Remote;
import java.util.ArrayList;
import java.util.Iterator;

import po.bills.ChargeBill;

public interface ChargeBillDataServer extends Remote {

    public void addBill(ChargeBill bill);
	
	public boolean removeBill(String id);
	
	public ChargeBill findBill(String id);
	
	public ArrayList<ChargeBill> findBill(String date,String hallId);

}
