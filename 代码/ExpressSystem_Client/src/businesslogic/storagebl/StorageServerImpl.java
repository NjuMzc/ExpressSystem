package businesslogic.storagebl;

import java.util.ArrayList;
import java.util.Iterator;

import po.Institution.storageAssist.Record;
import po.Institution.storageAssist.StoreList;
import po.bills.OrderBill;
import client.RMIHelper;
import dataservice.transportdataservice.TransportDataServer;
import vo.storagebl.ChaKanVO;
import vo.storagebl.ExportVO;
import vo.storagebl.ImportVO;
import vo.storagebl.PanDianVO;
import vo.storagebl.RecordVO;
import businesslogic.DateHelper;
import businesslogic.billsbl.ExportBillServer.ExportBillServer;
import businesslogic.billsbl.ImportBillServer.ImportBillServer;
import businesslogic.billsbl.OrderBillServer.OrderBillServer;
import businesslogicservice.storageblservice.StorageManager;
import businesslogicservice.storageblservice.StorageServer;

public class StorageServerImpl implements StorageServer {
	StorageManager storageManager;
	ImportBillServer importBillServer;
	ExportBillServer exportBillServer;
	TransportDataServer dataServer;
	OrderBillServer billServer;
	
	public StorageServerImpl(){
		storageManager=new StorageManagerImpl();
		importBillServer=new ImportBillServer();
		exportBillServer=new ExportBillServer();
		dataServer=RMIHelper.getTransportData();
	    billServer=new OrderBillServer();
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
		if(billServer.findBill(goodID)==null){
			returnMessage=new ImportVO("输入的订单不存在!");
			return returnMessage;
		}
		
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
		String orderNum=exportMessage.getOrderNum();
		String date=exportMessage.getDate();

		String destination=exportMessage.getDestination();
		String loader=exportMessage.getLoader();
		String DeliverNum=exportMessage.getDeliverNum();
		String transportNum=exportMessage.getTransportNum();
		
		ExportVO result;
		
		//建议在接口中增加查找一个商品的功能
		
		if(destination.equals("")||loader.equals("")||
				DeliverNum.equals("")||transportNum.equals(""))
				{
					result=new ExportVO("输入的信息不完整请补充!");
					return result;
				}
		
		exportBillServer.makeBill(orderNum, date, destination, loader, DeliverNum, transportNum);
		
		
//		storageManager.ExportGood(orderNum, location, date);  需要修改此处实现
		
		result=new ExportVO();
		return null;
		
		
	}

	@Override
	public ChaKanVO chaKan(String date1, String date2) {
		// TODO Auto-generated method stub
		ChaKanVO result;
		if(!DateHelper.compare(date1, date2)){
			result=new ChaKanVO("输入的日期格式有误!");
			return result;
		}
		ArrayList<RecordVO> list=new ArrayList<>();
		
		Iterator<Record> it=storageManager.getStorageHistory(date1, date2);
		while(it.hasNext()){
			Record a=it.next();
			String id=a.getPo().getID();
			OrderBill bill=billServer.findBill(id);
			if(bill==null){
				result=new ChaKanVO("商品号不存在!");
				return result;
			}
			String money=bill.getCharge();
			
			RecordVO record=new RecordVO(a, money);
			list.add(record);
		}
		result=new ChaKanVO(list);
		
		return result;
	}

	@Override
	public Iterator<PanDianVO> panDian() {
		// TODO Auto-generated method stub
		Iterator<StoreList> it=storageManager.getList().iterator();
		ArrayList<PanDianVO> list=new ArrayList<>();
		while(it.hasNext()){
			StoreList po=it.next();
			
			PanDianVO vo=new PanDianVO(po.getNum(), po.getDate(),po.getDestination(), po.getLocation());
			
			list.add(vo);
		}
		return list.iterator();
	}

	@Override
	public void exportTable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean changeStorage(String oldLocation, String newLocation) {
		// TODO Auto-generated method stub
		
		
		return storageManager.changeStorage(oldLocation, newLocation);
	}

}
