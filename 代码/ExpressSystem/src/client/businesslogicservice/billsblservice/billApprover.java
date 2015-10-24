package client.businesslogicservice.billsblservice;

import client.vo.Bill;

public interface billApprover {
	
	public boolean approveBill(Bill bill,boolean judge);

}
