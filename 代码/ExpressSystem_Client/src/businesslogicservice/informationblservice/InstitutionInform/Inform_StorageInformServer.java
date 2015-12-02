package businesslogicservice.informationblservice.InstitutionInform;

import java.util.ArrayList;
import java.util.Iterator;

import po.Workers.StorageKeeperPO;

public interface Inform_StorageInformServer {
 
	public boolean addKeeper(String storageID,String keeperID);
	
	public boolean removeKeeper(String storageID,String keeperID);
	
	public Iterator<StorageKeeperPO> getAllKeeper(String storageID);
	
	
}
