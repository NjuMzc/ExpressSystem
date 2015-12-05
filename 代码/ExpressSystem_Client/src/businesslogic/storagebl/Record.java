package businesslogic.storagebl;

import java.io.Serializable;

import po.GoodPO;
/**
 * 用于存储出入信息（货物、出入库种类、时间、位置）
 * @author nick
 *
 */


public class Record implements Serializable {
	GoodPO po;
	IO_Type type;
	String date;
	String location;

	public Record(GoodPO po, IO_Type type, String date, String location) {
		this.po = po;
		this.type = type;
		this.date = date;
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	public GoodPO getPo() {
		return po;
	}

	public IO_Type getType() {
		return type;
	}

	public String getDate() {
		return date;
	}

}