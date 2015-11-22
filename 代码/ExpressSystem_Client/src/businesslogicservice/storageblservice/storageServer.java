package businesslogicservice.storageblservice;

import po.Message;
import vo.BillVO;
import vo.StorageVO;



public interface storageServer {
	

	public BillVO makeImportBill(Message message);
	
	public BillVO makeExportBill(Message message);
	

	public StorageVO getGoodsList();
	

	public Message getStorageHistory(String startTim,String endTime);

	
	public Message changeStorage(String id,String newLocation);

}
