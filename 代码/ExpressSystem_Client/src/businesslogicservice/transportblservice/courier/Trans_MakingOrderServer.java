package businesslogicservice.transportblservice.courier;

import po.Message;
import po.bills.OrderBill;
import vo.BillVO;

public interface Trans_MakingOrderServer {
	
      public BillVO makeOrder(Message msg);
}
