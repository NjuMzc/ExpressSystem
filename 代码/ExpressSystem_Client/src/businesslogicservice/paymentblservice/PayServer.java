package businesslogicservice.paymentblservice;

import vo.paymentbl.PayVO;

/**
 * 新建付款单进行成本管理
 * @author rabook
 *
 */
public interface PayServer {

	public PayVO makeBill(PayVO pay);
	
}
