package po.Institution;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayList;

import po.GoodPO;
import po.Institution.storageAssist.CapacityReocrder;
import po.Institution.storageAssist.IORecorder;
import po.Institution.storageAssist.IO_Type;
import po.Institution.storageAssist.Record;
import po.Institution.storageAssist.StorageAlerter;
import po.Institution.storageAssist.StorageInfo;
import po.Institution.storageAssist.StoreList;
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
	private ArrayList<String> ids;

	public StoragePO(String id) {
		ids = new ArrayList<>();
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

	public ArrayList<StoreList> getAllList() {
		return capacity.getAllList();
	}

	// 货物入库时的操作
	public String importGood(GoodPO good, String location, String date) {
		if (capacity.importGood(good, date, location)) {
			int area = Integer.valueOf(location.substring(0, 1));
			double rate = capacity.getRate(area);
			if (alert.Alert(rate)) {
				ioInfo.addRecord(good, IO_Type.IMPORT, date, location);
				String idAndLocation = good.getID() + location;
				ids.add(idAndLocation);
				return "入库成功";
			}
			return "库存报警";
		} else {
			return "数组越界或已有货物";
		}
	}

	//  对应快递编号与位置信息
	public String getLocation(String id) {
		for (String string : ids) {
			String ID = string.substring(0, 10);
			if (ID.equals(id)) {
				return string.substring(10);
			}
		}
		return "null";
	}

	// 货物出库时的操作
	public boolean exportGood(GoodPO good, String location, String date) {
		if (capacity.exportGood(location)) {
			ioInfo.addRecord(good, IO_Type.EXPORT, date, location);
			String idAndLocation = good.getID() + location;
			ids.remove(idAndLocation);
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
		if(info==null){
			return false;
		}
		String date = info.getTime();
		GoodPO good = info.getGood();
		capacity.exportGood(oldLocation);
		return importGood(good, newLocation, date).equals("入库成功");
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
