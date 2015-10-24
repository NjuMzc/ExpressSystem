package client.businesslogicservice.billsblservice;

import client.vo.BillVO;

/**
 * 该接口用于提供审批单据的服务
 * @author Ma
 *
 */

public interface billApprover {
	
	public void approveBill(BillVO bill,boolean judge);

}
