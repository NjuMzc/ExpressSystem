package businesslogicservice.transportblservice;

import po.Message;
import po.bills.OrderBill;

public interface Trans_MakingOrderServer {
	
      public OrderBill makeOrder(Message msg);
}
