package businesslogicservice.transportblservice.hallStaff;

import po.bills.SendingBill;

public interface Trans_HallSendingServer {

	public SendingBill makeBill(String time,String orderID,String sender);
}
