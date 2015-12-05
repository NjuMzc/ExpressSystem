package businesslogic.billsbl.HallArrivalBillServer;

import client.RMIHelper;
import dataservice.billsdataservice.HallArrivalBillDataServer;
import po.Message;
import po.bills.HallArrivalBill;

public class HallArrivalBillServer  {
	HallArrivalBillDataServer dataServer;
	
	public HallArrivalBillServer(){
		//RMI赋值
		dataServer=RMIHelper.getHallArrivalBillData();
	}
	
	public HallArrivalBill makeBill(String GoodID,String date,String transOrderNum,String departure,String state){
		
		HallArrivalBill bill=new HallArrivalBill(GoodID,state,transOrderNum,departure,state);
		dataServer.addBill(bill);
		
		return bill;
	}
	
	public HallArrivalBill getBill(String id){
		HallArrivalBill bill=dataServer.findBill(id);
		if(bill==null){
			return null;
		}else 
			return bill;
		
	}

}
