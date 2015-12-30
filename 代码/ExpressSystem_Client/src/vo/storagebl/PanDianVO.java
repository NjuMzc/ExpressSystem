package vo.storagebl;

import po.bills.ImportBill;
import businesslogic.billsbl.ImportBillServer.ImportBillServer;
import vo.exception.ExceptionMessage;

public class PanDianVO {
	ExceptionMessage exMessage;

	String num;
	String date;
	String destination;
	String[] location;
	
	public PanDianVO(){
		exMessage=new ExceptionMessage();
	}

	
	public PanDianVO(String num, String date, String destination,
			String[] location) {
		this.num = num;
		this.date = date;
		ImportBillServer billServer=new ImportBillServer();
		ImportBill bill=billServer.getBill(num);
		this.destination = bill.getDestination();
		this.location = location;
		exMessage=new ExceptionMessage();
	}

	public PanDianVO(String wrongMessage){
		exMessage=new ExceptionMessage(wrongMessage);
	}
	
	
	public String getNum() {
		return num;
	}


	public void setNum(String num) {
		this.num = num;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public String[] getLocation() {
		return location;
	}


	public void setLocation(String[] location) {
		this.location = location;
	}
	
	// 用于传递错误信息
	public boolean isWrong() {
		return exMessage.isWrong();
	}

	public String getWrongMessage() {
		return exMessage.getMessage();
	}

}
