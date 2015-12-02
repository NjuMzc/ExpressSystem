package dataservice.informationdataservice;

import po.Workers.StorageKeeperPO;

public interface Inform_KeeperDataServer {
	
	public StorageKeeperPO find(String id);
	
	public void addKeeper(StorageKeeperPO keeper);
	
	public void deleteKeeper(StorageKeeperPO keeper);
	
	public void update(StorageKeeperPO keeper);

}
