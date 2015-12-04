package businesslogic.billsbl.TransArrivalBillServer;

import po.bills.TransArrivalBill;
import client.RMIHelper;
import dataservice.billsdataservice.TransArrivalBillDataServer;

public class TransArrivalBillServer {
	TransArrivalBillDataServer dataServer;
	
	public TransArrivalBillServer(){
		//RMI赋值
		
	}
	
	public TransArrivalBill makeBill(String tranStationNum,String GoodID,String date,String transOrderNum,String departure,String state){
		
		TransArrivalBill bill=new TransArrivalBill(tranStationNum, GoodID, date, transOrderNum, departure, state);
		dataServer.addBill(bill);
		
		return bill;
	}
	
	public TransArrivalBill getBill(String id){
		TransArrivalBill bill=dataServer.findBill(id);
		if(bill==null){
			return null;
		}else 
			return bill;
		
	}
}
