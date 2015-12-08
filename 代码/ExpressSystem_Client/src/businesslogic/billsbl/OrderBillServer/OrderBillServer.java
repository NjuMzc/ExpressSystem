package businesslogic.billsbl.OrderBillServer;

import businesslogic.billsbl.approver.BillApproverServerImpl;
import businesslogicservice.billApprover.BillApproveServer;
import client.RMIHelper;
import dataservice.billsdataservice.OrderBillDataServer;
import po.Message;
import po.bills.OrderBill;

public class OrderBillServer {

	OrderBillDataServer dataServer;
	OrderBill_IDMaker idMaker;
	OrderBill_ChargeCalculator calculator;
	BillApproveServer approveServer;
	
	public OrderBillServer(){
		this.dataServer=RMIHelper.getOrderBillData();
		
	}

	public OrderBill makeBill(Message msg) {
		// TODO Auto-generated method stub
		try{
			OrderBill bill=new OrderBill(msg);
			idMaker=new OrderBill_IDMaker(dataServer);
			calculator=new OrderBill_ChargeCalculator();
			approveServer=new BillApproverServerImpl();
			
			//设置ID以及计算运费
			bill.setID(idMaker.giveID(bill));
			bill.setCharge(calculator.calculate(bill));

			//加入持久化数据中
			dataServer.addBill(bill);
			System.out.println("Add "+bill.getID());
			
			approveServer.addBill(bill.submit());
			
			return bill;
			
		}catch(NumberFormatException e){
			System.out.println("信息输入有误！");
			return null;
		}
		
		
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
