package businesslogic.billsbl.approver;

import java.util.Iterator;

import client.RMIHelper;
import dataservice.billsdataservice.BillApproverDataServer;
import po.bills.BillApproverList;
import po.bills.BillApproverPO;
import businesslogicservice.billApprover.BillApproveServer;

public class BillApproverServerImpl implements BillApproveServer {
	
	BillApproverDataServer dataServer;
	BillApproverList list;
	
	public BillApproverServerImpl(){
		//RMI
		dataServer=RMIHelper.getBillApproverData();
		list=dataServer.get();
	}

	@Override
	public Iterator<BillApproverPO> getList() {
		// TODO Auto-generated method stub
		list=dataServer.get();
		return list.getList().iterator();
	}

	@Override
	public BillApproverPO getByNum(int n) {
		// TODO Auto-generated method stub
		list=dataServer.get();
		return list.getByNum(n);
	}

	@Override
	public void accept(int n) {
		// TODO Auto-generated method stub
		list=dataServer.get();
		BillApproverPO bill=list.getByNum(n);
		bill.setState("Approved");
		
		list.remove(n);
		dataServer.update(list);
	}

	@Override
	public void refuse(int n) {
		// TODO Auto-generated method stub
		list=dataServer.get();
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

	@Override
	public void approveAll() {
		// TODO Auto-generated method stub
		list=dataServer.get();
		Iterator<BillApproverPO> it=list.getList().iterator();
		while(it.hasNext()){
			BillApproverPO bill=it.next();
			bill.setState("Approved");
		}
		list.getList().clear();
		dataServer.update(list);
	}

}
