package vo;

import po.SystemUserPO;
import vo.exception.ExceptionMessage;

/**
 * 系统用户的VO对象
 * @author rabook
 *
 */
public class SystemUserVO {

	String id;
	String key;
	
	String identity;
	String userName;
	
	ExceptionMessage exMessage;
	
	public SystemUserVO(SystemUserPO user){
		this.id=user.getID();
		this.key=user.getKey();
		this.identity=user.getIdentity();
		this.userName=user.getUserName();
		
		exMessage=new ExceptionMessage();
		
	}
	
	public SystemUserVO(ExceptionMessage exMessage){
		this.exMessage=exMessage;
	    
	}
	
	public String getID(){
		return this.id;
	}
	
	public String getKey(){
		return this.key;
	}
	
	public String getIdentity(){
		return this.identity;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public void setName(String newName){
		this.userName=newName;
	}
	
	public void setKey(String newKey){
		this.key=newKey;
	}

	//用于传递错误信息
		public boolean isWrong(){
			return exMessage.isWrong();
		}
		
		public String getWrongMessage(){
			return exMessage.getMessage();
		}

}
