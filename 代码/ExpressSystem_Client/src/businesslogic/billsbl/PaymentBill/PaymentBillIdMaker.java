package businesslogic.billsbl.PaymentBill;

import businesslogic.DateHelper;
import po.bills.PaymentBill;
import client.RMIHelper;
import dataservice.billsdataservice.PaymentBillDataServer;

public class PaymentBillIdMaker {
	PaymentBillDataServer dataServer;
	
	public PaymentBillIdMaker(){
		this.dataServer=RMIHelper.getPaymentBillData();
	}

	public String giveId(PaymentBill bill){
		String result="";
		result+=bill.getDate();
		String FlowNum="000";
		String date=DateHelper.changeFormat(bill.getDate());
		
		result=date+FlowNum;
		while(dataServer.findBill(result)!=null){
			
			int flow=Integer.valueOf(FlowNum);
			flow++;
			if(flow<=9){
				FlowNum="00"+String.valueOf(flow);
			}else if(flow<=99){
				FlowNum="0"+String.valueOf(flow);
			}else if(flow<=999){
				FlowNum=String.valueOf(flow);
			}else{
				return null;
			}
				
			result=date+FlowNum;
		}
		return result;		
	}
}
