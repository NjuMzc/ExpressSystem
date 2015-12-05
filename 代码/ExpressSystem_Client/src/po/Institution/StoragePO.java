package po.Institution;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayList;

import businesslogic.storagebl.CapacityReocrder;
import businesslogic.storagebl.IORecorder;
import businesslogic.storagebl.IO_Type;
import businesslogic.storagebl.Record;
import businesslogic.storagebl.StorageAlerter;
import businesslogic.storagebl.StorageInfo;
import po.GoodPO;
import po.Workers.StorageKeeperPO;

/**
 * 中转中心仓库的对象
 * 
 * @author nick
 *
 */

public class StoragePO implements Serializable, Remote {
	private String id;// 中转中心仓库编号，同中转中心编号
	private String name;// 仓库名字
	private ArrayList<StorageKeeperPO> keeperList;// 仓库管理员列表
	private CapacityReocrder capacity;// 存储位置信息
	private IORecorder ioInfo;// 出入记录
	private StorageAlerter alert;// 报警器

	public StoragePO(String id) {
		this.id = id;
		this.name = "";
		this.capacity = new CapacityReocrder();
		this.ioInfo = new IORecorder();
		this.alert = new StorageAlerter();
		this.keeperList = new ArrayList<StorageKeeperPO>();
	}

	// Setter and Getter
	public String getID() {
		return id;
	}

	public ArrayList<StorageKeeperPO> getAllKeeper() {
		return keeperList;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	// 货物入库时的操作
	public boolean importGood(GoodPO good, String location, String date) {
		if (capacity.importGood(good, date, location)) {
			int area = Integer.valueOf(location.substring(0, 1));
			double rate = capacity.getRate(area);
			if (alert.Alert(rate)) {
				ioInfo.addRecord(good, IO_Type.IMPORT, date, location);
				return true;
			}
			return false;
		} else {
			return false;
		}
	}

	// 货物出库时的操作
	public boolean exportGood(GoodPO good, String location, String date) {
		if (capacity.exportGood(location)) {
			ioInfo.addRecord(good, IO_Type.EXPORT, date, location);
			return true;
		} else {
			return false;
		}
	}

	// 获取架子货物信息
	public StorageInfo[] getStorageInfo(int a, int b, int c) {
		return capacity.getAllInfor(a, b, c);
	}

	// 获取一段时间内的出入库信息
	public ArrayList<Record> getIORecord(String start, String end) {
		return ioInfo.getRecords(start, end);
	}

	public boolean change(String oldLocation, String newLocation) {
		StorageInfo info = capacity.getInfo(oldLocation);
		String date = info.getTime();
		GoodPO good = info.getGood();
		
		return false;
	}

	// 增删人员
	public void addKeeper(StorageKeeperPO keeper) {
		keeperList.add(keeper);
	}

	public void removeKeeper(StorageKeeperPO keeper) {
		keeperList.remove(keeper);
	}
}

class ListItem {

	public ListItem(GoodPO good, int a, int b, int c, int d) {
		this.good = good;
		this.location = new int[4];
		this.location[0] = a;
		this.location[1] = b;
		this.location[2] = c;
		this.location[3] = d;

	}

	private GoodPO good;

	private int[] location;

	GoodPO getGood() {
		return this.good;
	}

	int[] getLocatoin() {
		return this.location;
	}
}
