package client.dataservice.systemdataservice;

import client.po.SystemUserPO;



public interface systemDataServer {

	public SystemUserPO find(String id);
	
	public void insert(SystemUserPO po);
	
	public void delete(SystemUserPO po);
	
	public void update(SystemUserPO po);
	 
}
