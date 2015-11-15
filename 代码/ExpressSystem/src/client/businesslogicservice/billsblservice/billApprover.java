package client.businesslogicservice.billsblservice;

import client.po.BillPO;
import client.vo.BillVO;

/**
 * 该接口用于提供审批单据的服务
 * @author Ma
 *
 */

public interface billApprover {
	
	public void approveBill(BillPO bill,boolean judge);

	public void inform(BillPO bill);
}
