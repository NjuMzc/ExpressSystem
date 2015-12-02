package dataservice.informationdataservice;

import java.rmi.Remote;

import po.Institution.StoragePO;

public interface Inform_StorageDataServer extends Remote{

	public void update(StoragePO storage);
	
	public StoragePO find(String id);
	
}
