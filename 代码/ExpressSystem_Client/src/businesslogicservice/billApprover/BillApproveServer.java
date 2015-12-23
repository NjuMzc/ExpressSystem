package businesslogicservice.billApprover;

import java.util.Iterator;

import po.bills.BillApproverPO;

public interface BillApproveServer {

	public Iterator<BillApproverPO> getList();
	
	public BillApproverPO getByNum(int n);
	
	public void accept(int n);
	
	public void refuse(int n);
	
	public void addBill(BillApproverPO bill);
	
	public void approveAll();
}
