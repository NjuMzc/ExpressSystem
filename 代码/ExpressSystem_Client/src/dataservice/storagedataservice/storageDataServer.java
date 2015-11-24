package dataservice.storagedataservice;

import po.BillPO;
import po.Message;
import po.StoragePO;

/**
 * storage的数据层增删改查
 * @author Nick
 *
 */
public interface storageDataServer {
	
	public void insert(StoragePO po);
	
	public void delete(StoragePO po);
	
	public void update(StoragePO po);
	
	public StoragePO find(String id);

}
