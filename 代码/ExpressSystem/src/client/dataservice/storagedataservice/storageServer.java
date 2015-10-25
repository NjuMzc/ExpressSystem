package client.dataservice.storagedataservice;

import client.po.BillPO;
import client.po.StoragePO;
import client.vo.Message;

/**
 * storage数据层的增删改查
 * @author Nick
 *
 */
public interface storageServer {
	
	public void insert(StoragePO po);
	
	public void delete(StoragePO po);
	
	public void update(StoragePO po);
	
	public StoragePO find(String id);

}
