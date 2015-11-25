package businesslogic.billsbl.billsServerImpl.ReceiveBillServer;

import dataservice.billsdataservice.ReceiveBillDataServer;
import po.bills.ReceiveBill;
import businesslogic.billsbl.billsServerImpl.OrderBillServer.OrderBillServerImpl;
import businesslogicservice.billsblservice.OrderBillServer;
import businesslogicservice.billsblservice.ReceiveBillServer;

public class ReceiveBillServerImpl implements ReceiveBillServer {
	
	ReceiveBillDataServer dataServer;
	OrderBillServer orderBillServer;
	
	public ReceiveBillServerImpl(){
		orderBillServer=new OrderBillServerImpl();
		//RMI实现赋值
		
	}

	@Override
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

	@Override
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
