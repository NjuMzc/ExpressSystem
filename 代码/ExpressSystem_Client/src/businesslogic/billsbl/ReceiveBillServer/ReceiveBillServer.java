package businesslogic.billsbl.ReceiveBillServer;

import client.RMIHelper;
import dataservice.billsdataservice.ReceiveBillDataServer;
import po.bills.ReceiveBill;
import businesslogic.billsbl.OrderBillServer.OrderBillServer;

public class ReceiveBillServer  {
	
	ReceiveBillDataServer dataServer;
	OrderBillServer orderBillServer;
	
	public ReceiveBillServer(){
		orderBillServer=new OrderBillServer();
		//RMI实现赋值
		dataServer=RMIHelper.getReceiBillData();
	}

	public ReceiveBill makeBill(String id, String name, String time) {
		// TODO Auto-generated method stub
		if(orderBillServer.findBill(id)==null){
			System.out.println("输入的订单不存在！");
			return null;
		}else{
			ReceiveBill bill=new ReceiveBill(id, name, time);
			dataServer.addBill(bill);
			return bill;
		}
	}

	public ReceiveBill getBill(String id) {
		// TODO Auto-generated method stub
		ReceiveBill bill=dataServer.findBill(id);
		if(bill!=null){
			return bill;
		}else{
			System.out.println("目标收货单不存在！");
			return null;
		}
			
	}

}
