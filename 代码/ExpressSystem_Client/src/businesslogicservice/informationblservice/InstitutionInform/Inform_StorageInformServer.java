package businesslogicservice.informationblservice.InstitutionInform;

import java.util.Iterator;

import po.Institution.StoragePO;
import po.Workers.StorageKeeperPO;

public interface Inform_StorageInformServer {
 
	public boolean addKeeper(String storageID,String keeperID);
	
	public boolean removeKeeper(String storageID,String keeperID);
	
	public Iterator<StorageKeeperPO> getAllKeeper(String storageID);
	
	public Iterator<StoragePO> getByLocation(String place);
}
