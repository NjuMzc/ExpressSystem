package businesslogicservice.transportblservice.tranStaff;

import java.util.Iterator;

import po.Message;
import po.bills.TransEntruckBill;

/**
 * 中转中心业务员装车管理功能
 * @author rabook
 *
 */
public interface Trans_TransEntruckServer {

	public TransEntruckBill makeBill(Message message,Iterator<String> orderList);
}
