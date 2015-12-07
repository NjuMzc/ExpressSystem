package dataservice.billsdataservice;

import po.bills.BillApproverList;

public interface BillApproverDataServer {

	public BillApproverList get();
	
	public void update(BillApproverList list);
}
