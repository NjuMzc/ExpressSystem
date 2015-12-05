package po.bills;

public class SendingBill {

	private String time;//到达日期
	private String orderID;//托运单条形码号
	private String senderID;//快递员姓名
	
	private String id;//该单据的编号，同托运单条形码号
	
	public SendingBill(String time,String orderID,String senderID) {
		this.time=time;
		this.orderID=orderID;
		this.senderID=senderID;
		
		this.id=orderID;
	}

	//以下是get方法
	public String getTime(){
		return time;
	}
	
	public String getOrderID(){
		return orderID;
	}
	
	public String  getSenderID(){
		return senderID;
	}
	
	public String getID(){
		return id;
	}
}
