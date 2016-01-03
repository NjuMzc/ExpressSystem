package businesslogic.billsbl.OrderBillServer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import client.RMIHelper;
import dataservice.billsdataservice.OrderBillDataServer;
import dataservice.billsdataservice.ReceiveBillDataServer;
import po.bills.OrderBill;
import po.bills.ReceiveBill;

public class OrderTimeCal {
    OrderBillDataServer order;
    ReceiveBillDataServer receive;
    
    public OrderTimeCal(){
         order=RMIHelper.getOrderBillData();
         receive=RMIHelper.getReceiBillData();
    	 
    }
    
    public int getDay(String city1,String city2) throws ParseException{
    	int num=0;
    	int all=0;
    	int result=0;
    	
    	Iterator<ReceiveBill> receives=receive.getAll().iterator();
    	
    	while(receives.hasNext()){
    		ReceiveBill bill=receives.next();
    		OrderBill orderbill=order.findBill(bill.getID());
    		
    		if(city1.equals(orderbill.getDepature().substring(0, 2))&&
    				city2.equals(orderbill.getDestination().substring(0, 2))){
    			   num++;
    			
    			   SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    			   java.util.Date now;
				
					now = df.parse(bill.getTime());
				
    			   java.util.Date date;
				
    			   String time=orderbill.getID();
					date = df.parse("2016-"+time.substring(3,5)+"-"+time.substring(5,7));
				
    			   long l=now.getTime()-date.getTime();
    			   long day=l/(24*60*60*1000);
    			   System.out.println(""+day+"天");
    			   
    			   all+=day;
    		}
    		
    	}
    	if(num==0){
    		return 0;
    	}
    	
    	result=all/num;
    	
    	
    	return result;
    }
	
}
