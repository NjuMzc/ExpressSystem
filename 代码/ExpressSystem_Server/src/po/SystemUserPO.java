package po;

import java.io.Serializable;
/**
 * 系统用户的抽象类
 * @author rabook
 *
 */
public class SystemUserPO implements Serializable {
	String id;
	String key;
	
	String identity;
	String userName;
	
	public SystemUserPO(String id,String key,String identity,String userName){
		this.id=id;
		this.key=key;
		this.identity=identity;
		this.userName=userName;
		
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

}
