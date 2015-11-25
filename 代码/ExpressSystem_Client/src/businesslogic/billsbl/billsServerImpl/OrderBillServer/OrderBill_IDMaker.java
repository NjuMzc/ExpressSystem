package businesslogic.billsbl.billsServerImpl.OrderBillServer;

import java.text.SimpleDateFormat;
import java.util.Date;

import dataservice.billsdataservice.OrderBillDataServer;
import po.bills.OrderBill;

public class OrderBill_IDMaker {
	
	OrderBillDataServer dataServer;
	
	public OrderBill_IDMaker(OrderBillDataServer dataServer){
		this.dataServer=dataServer;
		
	}
	
	public String giveID(OrderBill bill){
		//给bill分配一个ID
		//ID格式为:出发地城市代号3位+日期4位+流水号3位，如果出现编号不够使用，则将城市代号首位设为1,2...9
		String first="0";
		String locationNum;
		String Date;
		String FlowNum="000";
		
		String id;
		
		//获得日期
		SimpleDateFormat df = new SimpleDateFormat("MMdd");//设置日期格式
		Date=df.format(new Date());// new Date()为获取当前系统时间
		
		//获得区号
		switch(bill.getDepature()){
		case "BeiJing":
			locationNum="10";
			break;
		case "NanJing":
			locationNum="25";
		    break;
		case "GuangZhou":
			locationNum="20";
			break;
		case "ShangHai":
			locationNum="21";
			break;
		default:
		    locationNum="00";
		}
		
		id=first+locationNum+Date+FlowNum;
		while(dataServer.findBill(id)!=null){
			if(FlowNum.equals("999")){
				int f=Integer.valueOf(first);
				f++;
				if(f==10){
					System.out.println("单据量超过系统承受极限！");
					return "0000000000";
				}
				first=String.valueOf(f);
			}
			
				int flow=Integer.valueOf(FlowNum);
				flow++;
				if(flow<=9){
					FlowNum="00"+String.valueOf(flow);
				}else if(flow<=99){
					FlowNum="0"+String.valueOf(flow);
				}else if(flow<=999){
					FlowNum=String.valueOf(flow);
				}
				
				id=first+locationNum+Date+FlowNum;
		}
		return id;
	}
	
}
