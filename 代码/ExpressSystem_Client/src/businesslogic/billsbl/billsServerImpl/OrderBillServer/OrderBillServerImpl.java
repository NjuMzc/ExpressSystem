package businesslogic.billsbl.billsServerImpl.OrderBillServer;

import client.RMIHelper;
import dataservice.billsdataservice.OrderBillDataServer;
import po.Message;
import po.bills.OrderBill;
import businesslogicservice.billsblservice.OrderBillServer;

public class OrderBillServerImpl implements OrderBillServer {

	OrderBillDataServer dataServer;
	
	public OrderBillServerImpl(){
		this.dataServer=RMIHelper.getOrderBillData();
		
	}

	@Override
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
		
		return bill;
	}

	@Override
	public OrderBill findBill(String id) {
		// TODO Auto-generated method stub
		OrderBill bill=dataServer.findBill(id);
		return bill;
	}

	@Override
	public boolean removeBill(String id) {
		// TODO Auto-generated method stub
		return dataServer.removeBill(id);
	}

	@Override
	public void updateBill(OrderBill bill) {
		// TODO Auto-generated method stub
		
	}



}
