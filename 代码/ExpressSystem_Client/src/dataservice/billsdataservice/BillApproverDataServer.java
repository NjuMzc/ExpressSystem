package dataservice.billsdataservice;

import java.rmi.Remote;

import po.bills.BillApproverList;

public interface BillApproverDataServer extends Remote{

	public BillApproverList get();
	
	public void update(BillApproverList list);
}
