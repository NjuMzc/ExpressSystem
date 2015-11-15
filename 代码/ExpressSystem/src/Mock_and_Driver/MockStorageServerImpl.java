package Mock_and_Driver;

import client.businesslogic.storagebl.StorageServerImpl;
import client.vo.BillVO;
import client.vo.Message;
import client.vo.StorageVO;

public class MockStorageServerImpl extends StorageServerImpl{

	public BillVO makeImportBill(Message message) {
		// TODO Auto-generated method stub
		System.out.println("Import Bill is made!");
		return null;
	}

	public BillVO makeExportBill(Message message) {
		// TODO Auto-generated method stub
		System.out.println("Export Bill is made!");
		return null;
	}

	public StorageVO getGoodsList() {
		// TODO Auto-generated method stub
		System.out.println("Goods List is got!");
		return null;
	}

	public Message getStorageHistory(String startTim, String endTime) {
		// TODO Auto-generated method stub
		System.out.println("Storage History is got!");
		return null;
	}

	public Message changeStorage(String id, String newLocation) {
		// TODO Auto-generated method stub
		System.out.println("Storage is changed!");
		return null;
	}
}
