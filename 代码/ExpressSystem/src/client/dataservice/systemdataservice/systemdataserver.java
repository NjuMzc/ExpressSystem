package client.dataservice.systemdataservice;

import client.po.SystemPO;

public interface systemDataServer {

	public SystemPO find(String id);
	
	public void insert(SystemPO po);
	
	public void delet(SystemPO po);
	 
}
