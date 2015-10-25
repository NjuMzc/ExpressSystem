package client.dataservice.billsdataservice;

import client.po.BillPO;


/**
 * 该接口用于提供审批单据的数据层服务
 * @author nick
 *
 */
public interface billApprover {

	public void approveBill(BillPO bill,boolean judge);
}
