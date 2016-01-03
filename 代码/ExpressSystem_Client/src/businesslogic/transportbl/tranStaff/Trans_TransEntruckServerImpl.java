package businesslogic.transportbl.tranStaff;

import java.util.Iterator;

import po.GoodPO;
import po.Message;
import po.bills.TransEntruckBill;
import businesslogic.billsbl.TransEntruckBillServer.TransEntruckBillServer;
import businesslogic.transportbl.GoodController;
import businesslogicservice.transportblservice.tranStaff.Trans_TransEntruckServer;

public class Trans_TransEntruckServerImpl implements Trans_TransEntruckServer {
	TransEntruckBillServer billServer;
	GoodController goodController;

	public Trans_TransEntruckServerImpl() {
		billServer = new TransEntruckBillServer();
		goodController = new GoodController();
	}

	@Override
	public TransEntruckBill makeBill(Message message, Iterator<String> orderList) {
		// TODO Auto-generated method stub

		for (int i = 0; i < message.length(); i++) {
			if (message.getInform(i).equals("")) {
				return null;
			}
		}

		TransEntruckBill bill = new TransEntruckBill(message, orderList);
		while (orderList.hasNext()) {
			try {
				GoodPO good = goodController.getGood(orderList.next());
				good.setTransState("Delivering");

			} catch (NullPointerException e) {
				System.out.println("目标货物不存在！");
				return null;

			}
		}
		return bill;
	}

}
