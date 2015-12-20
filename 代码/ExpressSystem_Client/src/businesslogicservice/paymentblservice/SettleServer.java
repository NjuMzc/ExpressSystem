package businesslogicservice.paymentblservice;

import po.bills.ChargeBill;
import vo.paymentbl.SettleVO;

/**
 * 结算管理功能的接口
 * @author rabook
 *
 */
public interface SettleServer {

	public SettleVO Settle(String date,String hallNum);//输入日期和营业厅编号
}
