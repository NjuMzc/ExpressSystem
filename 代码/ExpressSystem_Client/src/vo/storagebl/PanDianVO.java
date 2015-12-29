package vo.storagebl;

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
		this.destination = destination;
		this.location = location;
		exMessage=new ExceptionMessage();
	}

	public PanDianVO(String wrongMessage){
		exMessage=new ExceptionMessage(wrongMessage);
	}
	
	public String getWrongInform(){
		return exMessage.getMessage();
	}
}
