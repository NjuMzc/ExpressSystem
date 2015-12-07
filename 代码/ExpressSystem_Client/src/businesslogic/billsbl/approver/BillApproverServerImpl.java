package businesslogic.billsbl.approver;

import java.util.Iterator;

import dataservice.billsdataservice.BillApproverDataServer;
import po.bills.BillApproverList;
import po.bills.BillApproverPO;
import businesslogicservice.billApprover.BillApproveServer;

public class BillApproverServerImpl implements BillApproveServer {
	
	BillApproverDataServer dataServer;
	BillApproverList list;
	
	public BillApproverServerImpl(){
		//RMI
		
		list=dataServer.get();
	}

	@Override
	public Iterator<BillApproverPO> getList() {
		// TODO Auto-generated method stub
		
		return list.getList().iterator();
	}

	@Override
	public BillApproverPO getByNum(int n) {
		// TODO Auto-generated method stub
		
		return list.getByNum(n);
	}

	@Override
	public void accept(int n) {
		// TODO Auto-generated method stub

		BillApproverPO bill=list.getByNum(n);
		bill.setState("Approved");
		
		list.remove(n);
		dataServer.update(list);
	}

	@Override
	public void refuse(int n) {
		// TODO Auto-generated method stub
		BillApproverPO bill=list.getByNum(n);
		bill.setState("Approved");
		
		list.remove(n);
		dataServer.update(list);
	}

	@Override
	public void addBill(BillApproverPO bill) {
		// TODO Auto-generated method stub
		list.add(bill);
		dataServer.update(list);
	}

}
