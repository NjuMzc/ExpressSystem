package dataservice.storagedataservice;

import po.BillPO;
import po.Message;
import po.StoragePO;

/**
 * storage���ݲ����ɾ�Ĳ�
 * @author Nick
 *
 */
public interface storageDataServer {
	
	public void insert(StoragePO po);
	
	public void delete(StoragePO po);
	
	public void update(StoragePO po);
	
	public StoragePO find(String id);

}
