package businesslogicservice.transportblservice.hallStaff;
/**
 * 营业厅业务员装车管理功能
 */
import java.util.Iterator;

import po.Message;
import po.bills.HallEntruckBill;

public interface Trans_HallEntruckServer {
	
	public HallEntruckBill makeBill(Message message,Iterator<String> orderList);

}
