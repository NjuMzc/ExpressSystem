package dataservice.informationdataservice;

import java.rmi.Remote;

import po.Workers.TranStaffPO;

public interface Inform_TranStaffDataServer extends Remote{

	public void addStaff(TranStaffPO staff);
	
	public TranStaffPO find(String id);
	
	public void deleteStaff(TranStaffPO staff);
	
	public void update(TranStaffPO staff);
}
