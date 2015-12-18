package businesslogic.informationbl;

import java.util.ArrayList;
import java.util.Iterator;

import client.RMIHelper;
import dataservice.informationdataservice.Inform_TranStaffDataServer;
import dataservice.informationdataservice.Inform_TranStationDataServer;
import po.SystemUserPO;
import po.Institution.TranStationPO;
import po.Workers.TranStaffPO;
import businesslogic.LocationNumGetter;
import businesslogic.systembl.SystemBlServerImpl;
import businesslogicservice.informationblservice.InstitutionInform.Inform_TranStationInformServer;
import businesslogicservice.systemblservice.systemServer;

public class Inform_TranStationInformServerImpl implements Inform_TranStationInformServer{

	Inform_TranStaffDataServer staffDataServer;
	Inform_TranStationDataServer stationDataServer;
	systemServer systemServer;
	
	public Inform_TranStationInformServerImpl(){
		systemServer=new SystemBlServerImpl();
		//RMI实现
		staffDataServer=RMIHelper.getTranStaffData();
		stationDataServer=RMIHelper.getTranStationData();
		
		Inform_TranStationInitial init=new Inform_TranStationInitial();
		init.init();
		
	}
	
	@Override
	public boolean addStaff(String stationID, String staffID) {
		TranStationPO station=stationDataServer.find(stationID);
		SystemUserPO user=systemServer.inquire(staffID);
		
		if(station==null||user==null)
			return false;
		
		TranStaffPO staff=staffDataServer.find(staffID);
		
		//如果该员工对象已经存在
		if(staff!=null){
			if(staff.getStation()!=null){
				System.out.println("该员工已经在某个中转中心工作了！");
				return false;
			}else{
				station.addStaff(staff);
				staff.setStation(station);
				
				stationDataServer.update(station);
				staffDataServer.update(staff);
				return true;
			}
		}//员工对象不存在
		else{
			staff=new TranStaffPO(user.getUserName(), staffID, station);
			station.addStaff(staff);
			
			stationDataServer.update(station);
			staffDataServer.addStaff(staff);
			return true;
		}
	}

	@Override
	public boolean removeStaff(String stationID, String staffID) {
		// TODO Auto-generated method stub
		TranStationPO station=stationDataServer.find(stationID);
		TranStaffPO staff=staffDataServer.find(staffID);
		
		if(station==null||staff==null)
			return false;
		
		Iterator<TranStaffPO> it=station.getAllStaff().iterator();
		while(it.hasNext()){
			TranStaffPO staff2=(TranStaffPO) it.next();
			if(staff2.getId().equals(staff.getId())){
				it.remove();
			}
		}
		staff.setStation(null);

		stationDataServer.update(station);
		staffDataServer.update(staff);
		
		return true;
	}

	@Override
	public Iterator<TranStaffPO> getAllStaff(String stationID) {
		// TODO Auto-generated method stub
		TranStationPO station=stationDataServer.find(stationID);
		if(station==null)
			return null;
		
		return station.getAllStaff().iterator();
	}

	@Override
	public Iterator<TranStationPO> getByLocation(String place) {
		// TODO Auto-generated method stub
		String location=LocationNumGetter.getNum(place);
		ArrayList<TranStationPO> list=new ArrayList<TranStationPO>();
		TranStationPO hall=stationDataServer.find(location);
		list.add(hall);
		
		return list.iterator();
	}

}
