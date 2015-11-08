package client.dataStub;

import client.dataservice.storagedataservice.storageDataServer;
import client.po.StoragePO;

public class storageDataServer_Stub implements storageDataServer{

	public void insert(StoragePO po) {
		// TODO Auto-generated method stub
		System.out.println("A StoragePO is added in data!");
	}

	public void delete(StoragePO po) {
		// TODO Auto-generated method stub
		System.out.println("A StoragePO is deleted in data!");
	}

	public void update(StoragePO po) {
		// TODO Auto-generated method stub
		System.out.println("A StoragePO is updated in data!");
	}

	public StoragePO find(String id) {
		// TODO Auto-generated method stub
		System.out.println("A StoragePO is found in data!");
		return null;
	}

}
