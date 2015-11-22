package server.lists.system;

import client.po.SystemUserPO;

public interface SystemList  {
	boolean addUser(SystemUserPO po);
	
	SystemUserPO find(String id);
	
	boolean delUser(SystemUserPO po);
	
	boolean update(SystemUserPO po);
	
	int size();
}
