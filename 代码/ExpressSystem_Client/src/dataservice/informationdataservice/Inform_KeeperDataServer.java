package dataservice.informationdataservice;

import java.rmi.Remote;

import po.Workers.StorageKeeperPO;

public interface Inform_KeeperDataServer extends Remote {

	public StorageKeeperPO find(String id);

	public void addKeeper(StorageKeeperPO keeper);

	public void deleteKeeper(StorageKeeperPO keeper);

	public void update(StorageKeeperPO keeper);

}
