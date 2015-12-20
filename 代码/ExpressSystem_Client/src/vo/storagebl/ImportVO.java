package vo.storagebl;

import vo.exception.ExceptionMessage;

public class ImportVO {

	ExceptionMessage exMessage;

	String goodID;
	String date;
	String destination;
	String[] locatinon;
	
	public ImportVO(){
		exMessage=new ExceptionMessage();
	}
	
	public ImportVO(String wrongMessage){
		exMessage=new ExceptionMessage(wrongMessage);
	}
	
	public ImportVO(String goodID, String date, String destination,
			String[] location){
		this.date=date;
		this.goodID=goodID;
		this.destination=destination;
		this.locatinon=location;
		
		exMessage=new ExceptionMessage();
	}
	
	public String getWrongInform(){
		return exMessage.getMessage();
	}
	
	
	public String getGoodID() {
		return goodID;
	}

	public String getDate() {
		return date;
	}

	public String getDestination() {
		return destination;
	}

	public String[] getLocatinon() {
		return locatinon;
	}
}
