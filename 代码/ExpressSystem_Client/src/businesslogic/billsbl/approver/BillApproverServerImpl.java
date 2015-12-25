package businesslogic.billsbl.approver;

import java.util.ArrayList;
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
	public void approvePiLiang(int[] nums) {
		// TODO Auto-generated method stub
		list=dataServer.get();
		ArrayList<BillApproverPO> billlist=list.getList();
		
		for(int i=0;i<billlist.size();i++){
			if(i==nums[i]){
				billlist.get(i).setState("Approved");
			}
		}
		
		for(int i=0;i<billlist.size();i++){
			if(i==nums[i]){
				list.remove(i);
			}
		}
		
		dataServer.update(list);
	}

}
