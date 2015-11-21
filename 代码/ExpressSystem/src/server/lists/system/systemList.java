package server.lists.system;

import client.po.SystemUserPO;

public interface systemList {
	boolean addUser(SystemUserPO po);
	
	SystemUserPO find(String id);
	
	boolean delUser(SystemUserPO po);
	
	boolean update(SystemUserPO po);
	
	int size();
}
