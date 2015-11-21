package client.businesslogic.billsbl;

import client.po.BillPO;
import client.vo.Message;

public class ExportBill extends BillPO{
	
	String number;
	String date;
	String aim;
	String loader;//装运方式
	String DeliverNum;//中转单号
	String transportNum;//汽运编号
	

	public ExportBill(Message message) {
		super(message);
		// TODO Auto-generated constructor stub
		this.number=message.getInform(0);
		this.date=message.getInform(1);
		this.aim=message.getInform(2);
		this.loader=message.getInform(3);
		this.DeliverNum=message.getInform(4);
		this.transportNum=message.getInform(5);
	}
	
	public String getNumber() {
		return number;
	}


	public String getDate() {
		return date;
	}


	public String getAim() {
		return aim;
	}


	public String getLoader() {
		return loader;
	}


	public String getDeliverNum() {
		return DeliverNum;
	}


	public String getTransportNum() {
		return transportNum;
	}

}
