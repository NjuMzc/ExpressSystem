package businesslogic.storagebl;

import client.RMIHelper;
import dataservice.transportdataservice.TransportDataServer;
import vo.storagebl.ChaKanVO;
import vo.storagebl.ExportVO;
import vo.storagebl.ImportVO;
import vo.storagebl.PanDianVO;
import businesslogic.billsbl.ExportBillServer.ExportBillServer;
import businesslogic.billsbl.ImportBillServer.ImportBillServer;
import businesslogicservice.storageblservice.StorageManager;
import businesslogicservice.storageblservice.StorageServer;

public class StorageServerImpl implements StorageServer {
	StorageManager storageManager;
	ImportBillServer importBillServer;
	ExportBillServer exportBillServer;
	TransportDataServer dataServer;
	
	public StorageServerImpl(){
		storageManager=new StorageManagerImpl();
		importBillServer=new ImportBillServer();
		exportBillServer=new ExportBillServer();
		dataServer=RMIHelper.getTransportData();
	}

	@Override
	public ImportVO Import(ImportVO importMessage) {
		// TODO Auto-generated method stub
		String goodID=importMessage.getGoodID();
		String[] location=importMessage.getLocatinon();
		String date=importMessage.getDate();
		String destination=importMessage.getDestination();
		
		ImportVO returnMessage;
		
		//错误信息检查
		if(goodID.equals("")){
			returnMessage=new ImportVO("请输入订单号!");
			return returnMessage;
		}
		
		for(int i=0;i<4;i++){
		    String temp=location[i];
		    if(temp.equals("")){
		    	returnMessage=new ImportVO("请输入货物位置信息!");
				return returnMessage;
		    }
		}
		
	    if(destination.equals("")){
	    	returnMessage=new ImportVO("请输入目的地!");
			return returnMessage;
	    }
	    
	    //处理输入
	    String location2="";
	    for(int i=0;i<4;i++){
	    	if(location[i].length()==1){
	    		location2+="0";
	    	}
	    	location2+=location[i];
	    }
	    
	    if(!storageManager.ImportGood(goodID, location2, date)){
	    	returnMessage=new ImportVO("目标仓库位置现在已经存在商品");
			return returnMessage;
	    }
	    
	    
		importBillServer.makeBill(goodID, date, destination, location);
		
	    returnMessage=new ImportVO();
		
		return returnMessage;
	}

	@Override
	public ExportVO Export(ExportVO exportMessage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChaKanVO chaKan(String date1, String date2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PanDianVO panDian(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void exportTable() {
		// TODO Auto-generated method stub
		
	}

}
