package client.businesslogic.storagebl;

import client.businesslogicservice.storageblservice.storageServer;
import client.vo.BillVO;
import client.vo.Message;
import client.vo.StorageVO;

public class storageServer_Stub implements storageServer {

	public BillVO storageBillsMake(Message message) {
		// TODO Auto-generated method stub
		System.out.println("storageBill is made");
		return null;
	}

	public StorageVO getStorageList() {
		// TODO Auto-generated method stub
		System.out.println("storagelist is got");
		return null;
	}

	public Message getStorageHistory(String startTim, String endTime) {
		// TODO Auto-generated method stub
		System.out.println("StorageHistory is got");
		return null;
	}

	public Message changeStorage(String id, String newLocation) {
		// TODO Auto-generated method stub
		System.out.println("Storage is changed");
		return null;
	}

}
