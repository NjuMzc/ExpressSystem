package businesslogic.informationbl;

import java.util.ArrayList;

import client.RMIHelper;
import dataservice.informationdataservice.Inform_HallDataServer;
import po.Institution.HallPO;
import po.Workers.HallStaffPO;
import businesslogic.LocationNumGetter;
import businesslogicservice.informationblservice.InstitutionInform.Inform_HallInformServer;

public class Inform_HallInformServerImpl implements Inform_HallInformServer {

	Inform_HallDataServer dataServer;
	
	public Inform_HallInformServerImpl(){
		this.dataServer=RMIHelper.getHallData();
	}

	@Override
	public HallPO addHall(String place) {
		// TODO Auto-generated method stub
		String locationNum=LocationNumGetter.getNum(place);
		
		int counter=0;
		String count="000";
		while(dataServer.find(locationNum+count)!=null){
			counter++;
			if(counter<=9){
				count="00"+String.valueOf(counter);
			}else if(counter<=99){
				count="0"+String.valueOf(counter);
			}else if(counter<=999){
				count=String.valueOf(counter);
			}else
				count="---";
		}
		
		HallPO hall=new HallPO(locationNum+count);
		dataServer.addHall(hall);
		return hall;
	}

	@Override
	public boolean removeHall(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addStaff(HallPO hall, String StaffID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeStaff(HallPO hall, String StaffID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<HallStaffPO> getAllStaff(HallPO hall) {
		// TODO Auto-generated method stub
		return null;
	}


}
