package vo.storagebl;

import po.GoodPO;
import po.Institution.storageAssist.Record;

public class RecordVO {
 
	Record record;
	
	String money;
	
    public RecordVO(Record record,String money){
    	this.record=record;
    	this.money=money;
    }
    
	public String getLocation() {
		return record.getLocation();
	}

	public GoodPO getGood() {
		return record.getPo();
	}

	public String getType() {
		return record.getType().toString();
	}

	public String getDate() {
		return record.getDate();
	}
	
	public String getMoney(){
		return money;
	}
}
