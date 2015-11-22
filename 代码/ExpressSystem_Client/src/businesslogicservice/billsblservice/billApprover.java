package businesslogicservice.billsblservice;

import po.BillPO;
import vo.BillVO;

/**
 * �ýӿ������ṩ�������ݵķ���
 * @author Ma
 *
 */

public interface billApprover {
	
	public void approveBill(BillPO bill,boolean judge);

	public void inform(BillPO bill);
}
