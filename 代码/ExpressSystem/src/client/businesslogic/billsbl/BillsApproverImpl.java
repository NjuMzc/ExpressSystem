package client.businesslogic.billsbl;
/**
 * 单据审批接口的实现
 * 持有唯一的一个BillsList对象
 */
import client.businesslogicservice.billsblservice.billApprover;
import client.po.BillPO;
import client.vo.BillVO;

public class BillsApproverImpl implements billApprover {
    BillsList billList;

	public void approveBill(BillPO bill, boolean judge) {
		// TODO Auto-generated method stub
		
	}

	public void inform(BillPO bill) {
		// TODO Auto-generated method stub
		
	}

}
