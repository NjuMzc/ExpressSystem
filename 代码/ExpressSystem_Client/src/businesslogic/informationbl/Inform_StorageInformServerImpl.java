package businesslogic.informationbl;

import java.util.ArrayList;
import java.util.Iterator;

import client.RMIHelper;
import dataservice.informationdataservice.Inform_KeeperDataServer;
import dataservice.informationdataservice.Inform_StorageDataServer;
import po.SystemUserPO;
import po.Institution.StoragePO;
import po.Workers.StorageKeeperPO;
import businesslogic.LocationNumGetter;
import businesslogic.systembl.SystemBlServerImpl;
import businesslogicservice.informationblservice.InstitutionInform.Inform_StorageInformServer;
import businesslogicservice.systemblservice.*;

public class Inform_StorageInformServerImpl implements Inform_StorageInformServer{
	
	Inform_StorageDataServer storageDataServer;
	Inform_KeeperDataServer keeperDataServer;
	systemServer systemServer;
	
    public Inform_StorageInformServerImpl(){
    	systemServer=new SystemBlServerImpl();
    	//RMI
    	storageDataServer=RMIHelper.getStorageData();
    	keeperDataServer=RMIHelper.getKeeperData();
    }
    
	@Override
	public boolean addKeeper(String storageID,String keeperID) {
		// TODO Auto-generated method stub
		StoragePO storage=storageDataServer.find(storageID);
		SystemUserPO user=systemServer.inquire(keeperID);
		
		if(storage==null||user==null)
			return false;
		
		StorageKeeperPO staff=keeperDataServer.find(keeperID);
		
		//如果该员工对象已经存在
		if(staff!=null){
			if(staff.getStorage()!=null){
				System.out.println("该员工已经在某个仓库工作了！");
				return false;
			}else{
				storage.addKeeper(staff);
				staff.setStorage(storage);
				
				storageDataServer.update(storage);
				keeperDataServer.update(staff);
				return true;
			}
		}//员工对象不存在
		else{
			staff=new StorageKeeperPO(keeperID,user.getUserName(), storage);
			storage.addKeeper(staff);
			
			storageDataServer.update(storage);
			keeperDataServer.addKeeper(staff);
			return true;
		}
	}

	@Override
	public boolean removeKeeper(String storageID,String keeperID) {
		// TODO Auto-generated method stub
		StoragePO storage=storageDataServer.find(storageID);
		StorageKeeperPO staff=keeperDataServer.find(keeperID);
		
		if(storage==null||staff==null)
			return false;
		
		Iterator<StorageKeeperPO> it=storage.getAllKeeper().iterator();
		while(it.hasNext()){
			StorageKeeperPO staff2=(StorageKeeperPO) it.next();
			if(staff2.getID().equals(staff.getID())){
				it.remove();
			}
		}
		staff.setStorage(null);

		storageDataServer.update(storage);
		keeperDataServer.update(staff);
		
		return true;
	}

	@Override
	public Iterator<StorageKeeperPO> getAllKeeper(String storageID) {
		// TODO Auto-generated method stub
		StoragePO storage=storageDataServer.find(storageID);
		if(storage==null)
			return null;
		return storage.getAllKeeper().iterator();
	}

	@Override
	public Iterator<StoragePO> getByLocation(String place) {
		// TODO Auto-generated method stub
		String location=LocationNumGetter.getNum(place);
		ArrayList<StoragePO> list=new ArrayList<StoragePO>();
		StoragePO hall=storageDataServer.find(location);
		list.add(hall);
		
		return list.iterator();
	}

}
