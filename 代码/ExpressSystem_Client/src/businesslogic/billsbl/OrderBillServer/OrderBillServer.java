package businesslogic.billsbl.OrderBillServer;

import client.RMIHelper;
import dataservice.billsdataservice.OrderBillDataServer;
import po.Message;
import po.bills.OrderBill;

public class OrderBillServer {

	OrderBillDataServer dataServer;
	
	public OrderBillServer(){
		this.dataServer=RMIHelper.getOrderBillData();
		
	}

	public OrderBill makeBill(Message msg) {
		// TODO Auto-generated method stub
		OrderBill bill=new OrderBill(msg);
		OrderBill_IDMaker idMaker=new OrderBill_IDMaker(dataServer);
		OrderBill_ChargeCalculator calculator=new OrderBill_ChargeCalculator();
		
		//设置ID以及计算运费
		bill.setID(idMaker.giveID(bill));
		bill.setCharge(calculator.calculate(bill));

		//加入持久化数据中
		dataServer.addBill(bill);
		System.out.println("Add "+bill.getID());
		
		return bill;
	}

	public OrderBill findBill(String id) {
		// TODO Auto-generated method stub
		OrderBill bill=dataServer.findBill(id);
		return bill;
	}

	public boolean removeBill(String id) {
		// TODO Auto-generated method stub
		return dataServer.removeBill(id);
	}

	public void updateBill(OrderBill bill) {
		// TODO Auto-generated method stub
		
	}



}
