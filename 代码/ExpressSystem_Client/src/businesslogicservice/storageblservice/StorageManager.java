package businesslogicservice.storageblservice;

import java.util.ArrayList;
import java.util.Iterator;

import po.Institution.storageAssist.Record;
import po.Institution.storageAssist.StorageInfo;
import po.Institution.storageAssist.StoreList;
import vo.storagebl.PanDianVO;




public interface StorageManager {
	
    public String ImportGood(String goodID,String location,String date);//入库，要同时修改货物与仓库的储存信息
    
    public boolean ExportGood(String ID,String date);//出库，同上
    
	public StorageInfo[] getGoodsList(int area,int row,int shelf);//获得当前仓库货物清单
	
	public Iterator<Record> getStorageHistory(String startTime,String endTime);//获得出入库记录功能

	public boolean changeStorage(String oldLocation,String newLocation);//分区调整功能

	public ArrayList<StoreList> getList();
}
