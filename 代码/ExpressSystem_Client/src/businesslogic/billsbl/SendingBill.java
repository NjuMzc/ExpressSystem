package businesslogic.billsbl;

import po.BillPO;
import po.Message;

public class SendingBill extends BillPO {

	private String time;//到达日期
	private String number;//托运单条形码号
	private String senderNum;//快递员编号
	
	public SendingBill(Message billInfor) {
		super(billInfor);
		// TODO Auto-generated constructor stub
	    this.time=billInfor.getInform(0);
	    this.number=billInfor.getInform(1);
	    this.senderNum=billInfor.getInform(2);
	}

	//以下是get方法
	public String getTime(){
		return time;
	}
	
	public String getNumber(){
		return number;
	}
	
	public String  getSenderNum(){
		return senderNum;
	}
}
