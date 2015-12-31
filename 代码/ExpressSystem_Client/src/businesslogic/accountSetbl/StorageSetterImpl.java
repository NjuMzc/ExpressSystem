package businesslogic.accountSetbl;

import java.util.ArrayList;
import java.util.Iterator;

import po.accountSet.StorageInform;
import client.RMIHelper;
import dataservice.accountsetdataservice.StorageInformDataServer;
import dataservice.informationdataservice.Inform_StorageDataServer;
import vo.accountSet.StorageSetterVO;
import vo.storagebl.ImportVO;
import businesslogic.storagebl.StorageServerImpl;
import businesslogicservice.accountSetblservice.storageSetter;

public class StorageSetterImpl implements storageSetter {
	StorageServerImpl storageServer;//方法内构造
	StorageInformDataServer dataServer;//RMI构造
	Inform_StorageDataServer informServer;//RMI构造
	
	
	public StorageSetterImpl(){
		//RMI实现
		informServer=RMIHelper.getStorageData();
	
	}
	
   
	@Override
	public StorageSetterVO addInform(StorageSetterVO vo) {
		// TODO Auto-generated method stub
		String storageID=vo.getStorageNum();
		String date=vo.getDate();
		String orderNum=vo.getOrderNum();
		String[] location=vo.getLocation();
		
		StorageSetterVO result;
		
		if(informServer.find(storageID)==null){
			result=new StorageSetterVO("输入的仓库编号错误!");
			return result;
		}
		
		storageServer=new StorageServerImpl(storageID);
		ImportVO importResult=storageServer.Import(vo);
		
		if(importResult.isWrong()){
			result=new StorageSetterVO(importResult.getWrongMessage());
			return result;
		}
		
		result=new StorageSetterVO(storageID, orderNum, date, location);
		StorageInform inform=new StorageInform(storageID, orderNum, date, location);
		dataServer.addInform(inform);
		
		return result;
	}

	@Override
	public Iterator<StorageSetterVO> getInform() {
		// TODO Auto-generated method stub
		ArrayList<StorageSetterVO> voList=new ArrayList<>();
		
		Iterator<StorageInform> list=dataServer.getInform().iterator();
		while(list.hasNext()){
		      StorageInform inform=list.next();
		      StorageSetterVO vo=new StorageSetterVO(inform.getStorageNum(), inform.getOrderNum(), 
		    		  inform.getDate(), inform.getLocation());
		      voList.add(vo);
		}
		return voList.iterator();
	}


	@Override
	public void clean() {
		// TODO Auto-generated method stub
		dataServer.clean();
	}


	@Override
	public StorageSetterVO checkInform(StorageSetterVO vo) {
		// TODO Auto-generated method stub
		String storageID=vo.getStorageNum();
		String date=vo.getDate();
		String orderNum=vo.getOrderNum();
		String[] location=vo.getLocation();
		
		StorageSetterVO result;
		
		if(informServer.find(storageID)==null){
			result=new StorageSetterVO("输入的仓库编号错误!");
			return result;
		}
		
		storageServer=new StorageServerImpl(storageID);
		ImportVO importResult=storageServer.Import(vo);
		
		if(importResult.isWrong()){
			result=new StorageSetterVO(importResult.getWrongMessage());
			return result;
		}
		
		result=new StorageSetterVO(storageID, orderNum, date, location);
		StorageInform inform=new StorageInform(storageID, orderNum, date, location);
		dataServer.addInform(inform);
		
		return result;
	}

}
