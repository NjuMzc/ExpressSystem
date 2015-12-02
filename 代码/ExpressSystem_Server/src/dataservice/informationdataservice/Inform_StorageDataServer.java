package dataservice.informationdataservice;

import po.Institution.StoragePO;

public interface Inform_StorageDataServer {

	public void update(StoragePO storage);
	
	public StoragePO find(String id);
	
}
