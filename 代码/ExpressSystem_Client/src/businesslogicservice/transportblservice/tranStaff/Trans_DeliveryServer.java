package businesslogicservice.transportblservice.tranStaff;

import java.util.Iterator;

import po.Message;
import po.bills.DeliveryBill;

public interface Trans_DeliveryServer {
	
	public DeliveryBill makeBill(Message message,Iterator<String> billList);

}
