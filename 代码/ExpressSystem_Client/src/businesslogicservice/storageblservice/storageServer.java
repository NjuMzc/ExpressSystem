package businesslogicservice.storageblservice;

import java.util.Iterator;

import po.Institution.storageAssist.Record;
import po.Institution.storageAssist.StorageInfo;




public interface storageServer {
	
    public boolean ImportGood(String  storageID,String goodID,String location,String date);//入库，要同时修改货物与仓库的储存信息
    
    public boolean ExportGood(String storageID,String goodID,String location,String date);//出库，同上
    
	public StorageInfo[] getGoodsList(String storageID,int area,int row,int shelf);//获得当前仓库货物清单
	
	public Iterator<Record> getStorageHistory(String storageID,String startTime,String endTime);//获得出入库记录功能

	public boolean changeStorage(String storageID,String oldLocation,String newLocation);//分区调整功能

}
