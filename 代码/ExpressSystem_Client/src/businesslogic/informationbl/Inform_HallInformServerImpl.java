package businesslogic.informationbl;

import java.util.ArrayList;
import java.util.Iterator;

import client.RMIHelper;
import dataservice.informationdataservice.Inform_HallDataServer;
import dataservice.informationdataservice.Inform_HallStaffDataServer;
import po.SystemUserPO;
import po.Institution.HallPO;
import po.Workers.HallStaffPO;
import businesslogic.LocationNumGetter;
import businesslogic.systembl.SystemBlServerImpl;
import businesslogicservice.informationblservice.InstitutionInform.Inform_HallInformServer;
import businesslogicservice.systemblservice.*;

public class Inform_HallInformServerImpl implements Inform_HallInformServer {

	Inform_HallDataServer HallDataServer;
	Inform_HallStaffDataServer StaffDataServer;
	
	systemServer systemServer;
	
	public Inform_HallInformServerImpl(){
		this.HallDataServer=RMIHelper.getHallData();
		systemServer=new SystemBlServerImpl();
		
		//RMI实现
	}

	@Override
	public HallPO addHall(String place) {
		// TODO Auto-generated method stub
		String locationNum=LocationNumGetter.getNum(place);
		
		int counter=0;
		String count="000";
		while(HallDataServer.find(locationNum+count)!=null){
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
		HallDataServer.addHall(hall);
		return hall;
	}

	@Override
	public boolean removeHall(String id) {
		// TODO Auto-generated method stub
		HallPO hall=HallDataServer.find(id);
		if(hall==null)
			return false;
		else{
			HallDataServer.deleteHall(hall);
			return true;
		}
	}

	@Override
	public boolean addStaff(String HallID, String StaffID) {
		// TODO Auto-generated method stub
		HallPO hall=HallDataServer.find(HallID);
		SystemUserPO user=systemServer.inquire(StaffID);
		
		if(hall==null||user==null)
			return false;
		
		HallStaffPO staff=StaffDataServer.find(StaffID);
		
		//如果该员工对象已经存在
		if(staff!=null){
			if(staff.getHall()!=null){
				System.out.println("该员工已经在某个营业厅工作了！");
				return false;
			}else{
				hall.addHallStaff(staff);
				staff.setHall(hall);
				
				HallDataServer.updateHall(hall);
				StaffDataServer.update(staff);
				return true;
			}
		}//员工对象不存在
		else{
			staff=new HallStaffPO(StaffID, user.getUserName(), hall);
			hall.addHallStaff(staff);
			
			HallDataServer.updateHall(hall);
			StaffDataServer.addStaff(staff);
			return true;
		}
		
	}

	@Override
	public boolean removeStaff(String HallID, String StaffID) {
		// TODO Auto-generated method stub
		HallPO hall=HallDataServer.find(HallID);
		HallStaffPO staff=StaffDataServer.find(StaffID);
		
		if(hall==null||staff==null)
			return false;
		
		hall.removeHallStaff(staff);
		staff.setHall(null);
		
		HallDataServer.updateHall(hall);
		StaffDataServer.update(staff);
		
		return true;
	}

	@Override
	public Iterator<HallStaffPO> getAllStaff(String HallID) {
		// TODO Auto-generated method stub
		HallPO hall=HallDataServer.find(HallID);
		if(hall==null)
			return null;
		
		return hall.getAllStaff().iterator();
	}

	@Override
	public Iterator<HallPO> getByLocation(String place) {
		// TODO Auto-generated method stub
		String location=LocationNumGetter.getNum(place);
		String flow="000";
		int counter=0;
		ArrayList<HallPO> list=new ArrayList<HallPO>();
		HallPO hall=HallDataServer.find(location+flow);
		
		
		while(hall!=null){
			list.add(hall);
			counter++;
			if(counter<=9)
				flow="00"+String.valueOf(counter);
			else if(counter<=99)
				flow="0"+String.valueOf(counter);
			else
				flow=String.valueOf(counter);
			
			hall=HallDataServer.find(location+flow);
		}
		return list.iterator();
	}




}
