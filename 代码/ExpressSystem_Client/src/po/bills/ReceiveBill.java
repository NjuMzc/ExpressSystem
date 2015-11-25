package po.bills;

import po.Message;

public class ReceiveBill{

	private String  time;//收件时间
	private String  orderNum; //订单编号
	private String receiver;//收件方名称
	
	public ReceiveBill(String id,String name,String time) {
		
		// TODO Auto-generated constructor stub
		
		this.orderNum=id;
		this.time=time;
		this.receiver=name;
	}

	//以下是各种get方法
	public String getTime(){
		return time;
	}
	
	public String getID(){
		return orderNum;
	}
	
	public String getReceiverName(){
		return receiver;
	}
	
	
}
