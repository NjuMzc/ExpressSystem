package businesslogic.storagebl;

import java.io.Serializable;
/**
 * 用于存储仓库相应位置的信息
 */

import po.GoodPO;

public class StorageInfo implements Serializable{
	private GoodPO good;
	private String time;

	public StorageInfo(GoodPO good, String time) {
		this.good = good;
		this.time = time;
	}

	public GoodPO getGood() {
		return good;
	}

	public String getTime() {
		return time;
	}
}
