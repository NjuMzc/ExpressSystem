package client.po;

import java.io.Serializable;

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

}
