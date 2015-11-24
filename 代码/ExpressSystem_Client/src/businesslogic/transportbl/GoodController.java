package businesslogic.transportbl;

import dataservice.transportdataservice.transportDataServer;
import po.GoodPO;
import po.bills.OrderBill;

public class GoodController {
	transportDataServer dataServer;

	public GoodPO makeGood(OrderBill bill){
        GoodPO good=new GoodPO(bill.getID(), bill.getDepature(),bill.getDestination());
        dataServer.insert(good);
		return good;
	}
}
