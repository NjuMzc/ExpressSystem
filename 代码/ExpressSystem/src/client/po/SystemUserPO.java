package client.po;

import java.io.Serializable;

public class SystemUserPO implements Serializable {
	String id;
	String key;
	
	String identity;
	
	public SystemUserPO(String id,String key,String identity){
		this.id=id;
		this.key=key;
		this.identity=identity;
		
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

}
