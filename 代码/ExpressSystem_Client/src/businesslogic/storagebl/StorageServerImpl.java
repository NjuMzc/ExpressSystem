package businesslogic.storagebl;

import java.util.Iterator;

import businesslogicservice.storageblservice.storageServer;
import client.RMIHelper;
import dataservice.informationdataservice.Inform_StorageDataServer;
import dataservice.transportdataservice.TransportDataServer;
import po.GoodPO;
import po.Institution.StoragePO;

/**
 * 
 * @author nick
 *
 */
public class StorageServerImpl implements storageServer {
	Inform_StorageDataServer storageServer;
	TransportDataServer goodServer;

	public StorageServerImpl() {
		// RMI
		storageServer = RMIHelper.getStorageData();
		goodServer = RMIHelper.getTransportData();
	}

	@Override
	public boolean ImportGood(String storageID, String goodID, String location, String date) {
		StoragePO storage = storageServer.find(storageID);
		GoodPO good = goodServer.find(goodID);
		try {
			if (storage.importGood(good, location, date)) {
				storageServer.update(storage);
				return true;
			}
			return false;
		} catch (NullPointerException e) {
			if (storage == null)
				System.out.println("该仓库不存在");
			if (good == null)
				System.out.println("该货物不存在");
			return false;
		}

	}

	@Override
	public boolean ExportGood(String storageID, String goodID, String location, String date) {
		StoragePO storage = storageServer.find(storageID);
		GoodPO good = goodServer.find(goodID);
		try {
			if (storage.exportGood(good, location, date)) {
				storageServer.update(storage);
				return true;
			}
			return false;
		} catch (NullPointerException e) {
			if (storage == null)
				System.out.println("该仓库不存在");
			if (good == null)
				System.out.println("该货物不存在");
			return false;
		}
	}

	@Override
	public StorageInfo[] getGoodsList(String storageID, int area, int row, int shelf) {
		StoragePO storage = storageServer.find(storageID);
		return storage.getStorageInfo(area, row, shelf);
	}

	@Override
	public Iterator getStorageHistory(String storageID, String startTime, String endTime) {
		StoragePO storage = storageServer.find(storageID);
		return storage.getIORecord(startTime, endTime).iterator();
	}

	@Override
	public boolean changeStorage(String storageID, String oldLocation, String newLocation) {
		return false;
	}

}
