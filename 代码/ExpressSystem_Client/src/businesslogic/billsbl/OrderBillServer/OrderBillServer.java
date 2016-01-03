package businesslogic.billsbl.OrderBillServer;

import java.text.ParseException;

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
	OrderTimeCal dayCal;
	BillApproveServer approveServer;
	
	public OrderBillServer(){
		this.dataServer=RMIHelper.getOrderBillData();
		
		dayCal=new OrderTimeCal();
		idMaker=new OrderBill_IDMaker(dataServer);
		calculator=new OrderBill_ChargeCalculator();
		approveServer=new BillApproverServerImpl();
		
	}

	public OrderBill makeBill(Message msg) {
		// TODO Auto-generated method stub
		try{
			OrderBill bill=new OrderBill(msg);
			
			//设置ID以及计算运费
			bill.setID(idMaker.giveID(bill));
			bill.setCharge(calculator.calculate(bill));
			try {
				bill.setTime("约"+dayCal.getDay(bill.getDepature().substring(0, 2), 
						bill.getDestination().substring(0, 2))+"天后到达");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//加入持久化数据中
			dataServer.addBill(bill);
			
			approveServer.addBill(bill.submit());
			
			return bill;
			
		}catch(NumberFormatException e){
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
