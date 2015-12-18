package vo.storagebl;

import vo.exception.ExceptionMessage;

public class ImportVO {

	ExceptionMessage exMessage;
	
	public ImportVO(){
		exMessage=new ExceptionMessage();
	}
	
	public ImportVO(String wrongMessage){
		exMessage=new ExceptionMessage(wrongMessage);
	}
	
	public String getWrongInform(){
		return exMessage.getMessage();
	}
}
