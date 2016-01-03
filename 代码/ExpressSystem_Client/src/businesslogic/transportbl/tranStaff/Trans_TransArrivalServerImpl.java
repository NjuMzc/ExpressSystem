package businesslogic.transportbl.tranStaff;

import client.RMIHelper;
import dataservice.informationdataservice.Inform_TranStaffDataServer;
import po.GoodPO;
import po.Institution.TranStationPO;
import po.Workers.TranStaffPO;
import po.bills.TransArrivalBill;
import businesslogic.LocationNumGetter;
import businesslogic.billsbl.TransArrivalBillServer.TransArrivalBillServer;
import businesslogic.systembl.SystemHelper;
import businesslogic.transportbl.GoodController;
import businesslogicservice.informationblservice.InstitutionInform.Inform_TranStationInformServer;
import businesslogicservice.transportblservice.tranStaff.Trans_TransArrivalServer;

public class Trans_TransArrivalServerImpl implements Trans_TransArrivalServer {

	TransArrivalBillServer billServer;
	GoodController goodController;
	Inform_TranStationInformServer stationServer;
	Inform_TranStaffDataServer staffServer;
	TranStaffPO staffNow;
	
	public Trans_TransArrivalServerImpl(){
		billServer=new TransArrivalBillServer();
		goodController=new GoodController();
		staffServer=RMIHelper.getTranStaffData();
		staffNow=staffServer.find(SystemHelper.getUserID());
		
	}

	@Override
	public TransArrivalBill makeBill(String tranStationID, String GoodID,
			String date, String transOrderNum, String departure,
			String state) {
		// TODO Auto-generated method stub
		if(goodController.getGood(GoodID)==null){
			return null;
		}
		
		if(tranStationID.equals("")||GoodID.equals("")||transOrderNum.equals("")
				||departure.equals("")){
			return null;
		}
        TransArrivalBill bill = billServer.makeBill(tranStationID,GoodID, date, transOrderNum, departure, state);
		
		staffNow=staffServer.find(SystemHelper.getUserID());
		
		TranStationPO station=staffNow.getStation();

		//增加新的货物轨迹
		goodController.addTrace(GoodID, "于"+date+"到达了"+station.getName());
		
		if(isSenderStation(station.getID(),departure)){//如果是寄件人中转中心
			goodController.setGoodTransState(GoodID, "ArriveSendStorage");
		}else if(isReceiverStation(station.getID(), GoodID)){//如果是收件人中转中心
			goodController.setGoodTransState(GoodID, "ArriveReceiveStorage");
		}

		return bill;
	}

	/**
	 * 辅助方法，判断是否是寄件人的中转中心
	 * @param stationID
	 * @param departure
	 * @return
	 */
	public boolean isSenderStation(String stationID,String departure){
		String depatureNum=LocationNumGetter.getNum(departure);
		
		if(stationID==depatureNum)
			return true;
		else 
			return false;
		
	}
	
	/**
	 * 辅助方法，判断是否是收件人中转中心
	 * @param hallID
	 * @param transOrderNum
	 * @return
	 */
	public boolean isReceiverStation(String stationID,String GoodID){
     
		GoodPO good=goodController.getGood(GoodID);
		if(good.getDestination()==stationID)
			return true;
		else
	        return false;
	}

	

}
