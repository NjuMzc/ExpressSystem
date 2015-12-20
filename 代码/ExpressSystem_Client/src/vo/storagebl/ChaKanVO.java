package vo.storagebl;

import vo.exception.ExceptionMessage;

public class ChaKanVO {
	ExceptionMessage exMessage;
	
	public ChaKanVO(){
		exMessage=new ExceptionMessage();
	}
	
	public ChaKanVO(String wrongMessage){
		exMessage=new ExceptionMessage(wrongMessage);
	}
	
	public String getWrongInform(){
		return exMessage.getMessage();
	}
}
