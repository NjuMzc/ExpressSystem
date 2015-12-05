package po.Institution.storageAssist;

import java.io.Serializable;

/**
 * 库存报警装置，仓库的辅助类
 * 
 * @author rabook
 *
 */
public class StorageAlerter implements Serializable{
	private double rate;

	public StorageAlerter() {
		rate = 0.9;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public boolean Alert(double cmpRate) {
		if (cmpRate > rate) {
			System.out.println("报警了报警了！");
			// 不知道报警是个什么样子，没有接口
			return false;
		}
		return true;
	}
}
