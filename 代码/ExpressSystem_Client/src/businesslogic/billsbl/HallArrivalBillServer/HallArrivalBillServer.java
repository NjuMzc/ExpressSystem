package businesslogic.billsbl.HallArrivalBillServer;

import client.RMIHelper;
import dataservice.billsdataservice.HallArrivalBillDataServer;
import po.Message;
import po.bills.HallArrivalBill;

public class HallArrivalBillServer {
	HallArrivalBillDataServer dataServer;
	
	public HallArrivalBillServer(){
		//RMI赋值
		
	}
	
	public HallArrivalBill makeBill(String date,String transOrderNum,String departure,String state){
		Message message=new Message();
		
		message.addInform(date);
		message.addInform(transOrderNum);
		message.addInform(departure);
		message.addInform(state);
		
		HallArrivalBill bill=new HallArrivalBill(message);
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
