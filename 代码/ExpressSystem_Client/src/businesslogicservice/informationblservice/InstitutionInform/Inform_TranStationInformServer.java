package businesslogicservice.informationblservice.InstitutionInform;

import java.util.Iterator;

import po.Institution.TranStationPO;
import po.Workers.TranStaffPO;

public interface Inform_TranStationInformServer {

	public boolean addStaff(String stationID,String staffID);
	
	public boolean removeStaff(String stationID,String staffID);
	
	public Iterator<TranStaffPO> getAllStaff(String stationID);
	
	public Iterator<TranStationPO> getByLocation(String place);
}
