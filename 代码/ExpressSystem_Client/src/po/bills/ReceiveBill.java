package po.bills;

import po.BillPO;
import po.Message;

public class ReceiveBill extends BillPO{

	private String  time;//收件时间
	private String  orderNum; //订单编号
	private String receiver;//收件方名称
	
	public ReceiveBill(Message billInfor) {
		super(billInfor);
		// TODO Auto-generated constructor stub
		
		this.orderNum=billInfor.getInform(0);
		this.time=billInfor.getInform(1);
		this.receiver=billInfor.getInform(2);
	}

	//以下是各种get方法
	public String getTime(){
		return time;
	}
	
	public String getOrderNum(){
		return orderNum;
	}
	
	public String getReceiver(){
		return receiver;
	}
	
	
}
