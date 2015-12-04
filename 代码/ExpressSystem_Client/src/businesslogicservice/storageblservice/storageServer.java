package businesslogicservice.storageblservice;

import java.util.Iterator;

import po.GoodPO;
import po.Message;
import po.Institution.StoragePO;
import po.bills.ExportBill;
import po.bills.ImportBill;
import vo.BillVO;
import vo.StorageVO;



public interface storageServer {
	
    public boolean ImportGood(StoragePO storage,GoodPO good);//入库，要同时修改货物与仓库的储存信息
    
    public boolean ExportGood(StoragePO storage,GoodPO good);//出库，同上
    
	public Iterator<GoodPO> getGoodsList(StoragePO storage);//获得当前仓库货物清单
	
	public Iterator getStorageHistory(StoragePO storage,String startTim,String endTime);//获得出入库记录功能

	public Iterator changeStorage(StoragePO storage,String GoodId,String newLocation);//分区调整功能

}
