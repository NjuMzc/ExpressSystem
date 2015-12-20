package vo.exception;

public class ExceptionMessage {

	String wrongMessage;
	boolean isWrong;
	
	public ExceptionMessage(String wrongMessage){
		this.wrongMessage=wrongMessage;
		this.isWrong=true;
	}
	
	public ExceptionMessage(){
		this.wrongMessage="";
		this.isWrong=false;
	}
	
	public String getMessage(){
		return wrongMessage;
	}
	
	public void setMessage(String message){
		this.wrongMessage=message;
		this.isWrong=true;
	}
	
	public boolean isWrong(){
		return isWrong;
	}
}
