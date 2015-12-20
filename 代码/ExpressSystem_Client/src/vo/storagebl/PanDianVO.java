package vo.storagebl;

import vo.exception.ExceptionMessage;

public class PanDianVO {
	ExceptionMessage exMessage;
	
	public PanDianVO(){
		exMessage=new ExceptionMessage();
	}
	
	public PanDianVO(String wrongMessage){
		exMessage=new ExceptionMessage(wrongMessage);
	}
	
	public String getWrongInform(){
		return exMessage.getMessage();
	}
}
