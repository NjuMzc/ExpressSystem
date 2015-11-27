package businesslogic.transportbl;

/**
 * 操作和货物相关的持久化数据修改
 * 
 */
import java.util.ArrayList;

import client.RMIHelper;
import dataservice.transportdataservice.TransportDataServer;
import po.GoodPO;
import po.bills.OrderBill;

public class GoodController {
	TransportDataServer dataServer;
	
	public GoodController(){
		this.dataServer=RMIHelper.getTransportData();
		
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
	
	//获得货物的运输状态
	public String getGoodTransState(String id){
		GoodPO good=dataServer.find(id);
		if(good==null){
			return "Can't Find this Good!";
		}else
		    return good.getTransState();
	}
	
	//获得货物的历史轨迹
	public ArrayList<String> getGoodTrace(String id){
		GoodPO good=dataServer.find(id);
		if(good==null){
			return null;
		}else
		    return good.getTrace();
	}
}
