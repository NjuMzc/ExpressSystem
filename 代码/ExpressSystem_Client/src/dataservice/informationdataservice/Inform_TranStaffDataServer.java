package dataservice.informationdataservice;

import po.Workers.TranStaffPO;

public interface Inform_TranStaffDataServer {

	public void addStaff(TranStaffPO staff);
	
	public TranStaffPO find(String id);
	
	public void deleteStaff(TranStaffPO staff);
	
	public void update(TranStaffPO staff);
}
