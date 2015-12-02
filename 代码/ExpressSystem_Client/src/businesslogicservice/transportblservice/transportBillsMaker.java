package businesslogicservice.transportblservice;

import po.BillPO;
import po.Message;
import vo.BillVO;

/**
 * 运输过程中产生的单据制作的接口，依赖bill模块
 * @author Ma
 *
 */

public interface transportBillsMaker {
	
//	public BillPO makeOrderBill(Message message);

	public BillPO makeDeliveryBill(Message message);

//	public BillPO makeHallArrivalBill(Message message);

	public BillPO makeTransArrivalBill(Message message);

	public BillPO makeEntruckBill(Message message);

	public BillPO makeSendingBill(Message message);

//	public BillPO makeReceiveBill(Message message);

	
}
