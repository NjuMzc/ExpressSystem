package businesslogic.transportbl;

import dataservice.transportdataservice.TransportDataServer;
import po.GoodPO;
import po.bills.OrderBill;

public class GoodController {
	TransportDataServer dataServer;
	
	public GoodController(TransportDataServer dataServer){
		this.dataServer=dataServer;
		
	}

	//新建货物对象
	public GoodPO makeGood(OrderBill bill){
        GoodPO good=new GoodPO(bill.getID(), bill.getDepature(),bill.getDestination());
        dataServer.insert(good);
		return good;
	}
	
	//增加新的货物轨迹
	public void addTrace(String id,String inform){
		GoodPO good=dataServer.find(id);
		good.addTrace(inform);
		dataServer.update(good);
	}
	
	//修改货物的运输状态
	public void setGoodTransState(String id,String newState){
		GoodPO good=dataServer.find(id);
		good.setTransState(newState);
		dataServer.update(good);
	}
}
