package businesslogicservice.informationblservice.InstitutionInform;

import java.util.ArrayList;

import po.Workers.StorageKeeperPO;

public interface Inform_StorageInformServer {
 
	public boolean addKeeper(String keeperID);
	
	public boolean removeKeeper(String keeperID);
	
	public ArrayList<StorageKeeperPO> getAllKeeper(String storageID);
	
	
}
