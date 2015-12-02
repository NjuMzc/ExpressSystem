package po.Workers;

import po.Institution.StoragePO;

/**
 * 仓库管理员的PO对象
 * @author rabook
 *
 */

public class StorageKeeperPO {
	private String id;//编号，同系统用户账号
	private StoragePO storage;//所在的仓库
	private String name;//姓名
	
	public StorageKeeperPO(String id,String name,StoragePO storage){
		this.id=id;
		this.name=name;
		this.storage=storage;
	}
	
	//Setter and Getter
	public void setName(String name){
		this.name=name;
	}
	
	public void setStorage(StoragePO storage){
		this.storage=storage;
	}
	
	public String getID(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public StoragePO getStorage(){
		return storage;
	}

}
