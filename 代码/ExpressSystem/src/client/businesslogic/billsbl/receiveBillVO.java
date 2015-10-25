package client.businesslogic.billsbl;

import client.vo.BankVO;
import client.vo.BillVO;
import client.vo.Message;

public class receiveBillVO extends BillVO{
	
	private String name;
	private String time;
	private String num;

	public receiveBillVO(Message billInfor) {
		super(billInfor);
		// TODO Auto-generated constructor stub
		this.name=billInfor.getInform(0);
		this.num=billInfor.getInform(1);
		this.time=billInfor.getInform(2);
		
	}
	
	public String getName() {
		return name;
	}

	public String getTime() {
		return time;
	}

	public String getNum() {
		return num;
	}

	
	
}
