package po.accountSet;

public class StorageInform {

	String StorageNum;
	String orderNum;
	String date;
	String[] location;
	
	
	public StorageInform(String storageNum, String orderNum, String date,
			String[] location) {
		super();
		StorageNum = storageNum;
		this.orderNum = orderNum;
		this.date = date;
		this.location = location;
	}


	//Setters and Getters
	public String getStorageNum() {
		return StorageNum;
	}


	public void setStorageNum(String storageNum) {
		StorageNum = storageNum;
	}


	public String getOrderNum() {
		return orderNum;
	}


	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String[] getLocation() {
		return location;
	}


	public void setLocation(String[] location) {
		this.location = location;
	}
	
	
	
}
