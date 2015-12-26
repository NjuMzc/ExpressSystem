package vo;

import vo.exception.ExceptionMessage;

/**
 * 所有单据的父类
 * @author rabook
 *
 */

public class BillVO {
	
	private ExceptionMessage exMessage;//错误信息
	
	String id;
	String fee;
	String date;
	
	public BillVO(){
		this.exMessage=new ExceptionMessage();
	}
	
	public BillVO(String wrongMessage){
		this.exMessage=new ExceptionMessage(wrongMessage);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	//用于传递错误信息
	public boolean isWrong(){
		return exMessage.isWrong();
	}
	
	public String getWrongMessage(){
		return exMessage.getMessage();
	}

}
