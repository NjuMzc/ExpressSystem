package businesslogicservice.informationblservice.InstitutionInform;

import java.util.ArrayList;

import po.Institution.HallPO;
import po.Workers.CarPO;
import po.Workers.DriverPO;
import po.Workers.HallStaffPO;

public interface Inform_HallInformServer {
	
	public HallPO addHall(String place);
	
	public boolean removeHall(String id);
	
	public boolean addStaff(String HallID,String StaffID);
	
	public boolean removeStaff(String HallID,String StaffID);
	
	public ArrayList<HallStaffPO> getAllStaff(String HallID);
	
	public ArrayList<CarPO> getAllCar(String HallID);
	
	public ArrayList<DriverPO> getAllDriver(String HallID);
	

}
