package businesslogicservice.informationblservice.InstitutionInform;

import java.util.ArrayList;

import po.Institution.HallPO;
import po.Workers.HallStaffPO;

public interface Inform_HallInformServer {
	
	public HallPO addHall(String place);
	
	public boolean removeHall(String id);
	
	public boolean addStaff(HallPO hall,String StaffID);
	
	public boolean removeStaff(HallPO hall,String StaffID);
	
	public ArrayList<HallStaffPO> getAllStaff(HallPO hall);
	

}
