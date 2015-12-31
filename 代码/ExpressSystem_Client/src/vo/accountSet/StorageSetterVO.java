package vo.accountSet;

import vo.exception.ExceptionMessage;

public class StorageSetterVO {


	String StorageNum;
	String orderNum;
	String date;
	String[] location;
	ExceptionMessage exMessage;
	
	public StorageSetterVO(String storageNum, String orderNum, String date,
			String[] location) {
		StorageNum = storageNum;
		this.orderNum = orderNum;
		this.date = date;
		this.location = location;
		
		this.exMessage=new ExceptionMessage();
	}
	
	public StorageSetterVO(String WrongMessage){
		this.exMessage=new ExceptionMessage(WrongMessage);
	}
	
	//Setters and Getters
	public String getStorageNum() {
		return StorageNum;
	}


	public void setStorageNum(String storageNum) {
		StorageNum = storageNum;
	}


	public String getOrderNum() {
		return orderNum;
	}


	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
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
