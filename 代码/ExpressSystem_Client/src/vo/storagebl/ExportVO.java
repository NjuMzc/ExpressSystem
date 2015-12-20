package vo.storagebl;

import vo.exception.ExceptionMessage;

public class ExportVO {
	ExceptionMessage exMessage;
	
	public ExportVO(){
		exMessage=new ExceptionMessage();
	}
	
	public ExportVO(String wrongMessage){
		exMessage=new ExceptionMessage(wrongMessage);
	}
	
	public String getWrongInform(){
		return exMessage.getMessage();
	}
}
