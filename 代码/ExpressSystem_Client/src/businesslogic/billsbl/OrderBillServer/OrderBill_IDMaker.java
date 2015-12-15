package businesslogic.billsbl.OrderBillServer;

import java.text.SimpleDateFormat;
import java.util.Date;

import businesslogic.constantbl.CityServerImpl;
import businesslogicservice.constantblservice.CityServer;
import dataservice.billsdataservice.OrderBillDataServer;
import po.bills.OrderBill;

public class OrderBill_IDMaker {

	OrderBillDataServer dataServer;
	CityServer cityServer;

	public OrderBill_IDMaker(OrderBillDataServer dataServer) {
		this.dataServer = dataServer;
		cityServer = new CityServerImpl();
	}

	public String giveID(OrderBill bill) {
		// 给bill分配一个ID
		// ID格式为:出发地城市代号3位+日期4位+流水号3位
		String locationNum;
		String Date;
		String FlowNum = "000";

		// 获得日期
		SimpleDateFormat df = new SimpleDateFormat("MMdd");// 设置日期格式
		Date = df.format(new Date());// new Date()为获取当前系统时间

		// 获得区号
		locationNum = cityServer.getId(bill.getDepature().substring(0, 2));
		String id = locationNum + Date + FlowNum;

		while (dataServer.findBill(id) != null) {
			int flow = Integer.valueOf(FlowNum);
			flow++;
			if (flow <= 9) {
				FlowNum = "00" + String.valueOf(flow);
			} else if (flow <= 99) {
				FlowNum = "0" + String.valueOf(flow);
			} else if (flow <= 999) {
				FlowNum = String.valueOf(flow);
			}

			id = locationNum + Date + FlowNum;
		}
		return id;
	}

}
