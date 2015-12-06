package businesslogic.informationbl;

import po.Workers.HallStaffPO;
import dataservice.informationdataservice.Inform_HallStaffDataServer;

public class Inform_HallStaffInformServerImpl {

	Inform_HallStaffDataServer dataServer;
	
	public HallStaffPO getStaff(String id){
		HallStaffPO staff=dataServer.find(id);
		if(staff==null)
			return null;
		else
			return staff;
	}
}
