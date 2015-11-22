package server.data.systemdata;

import client.po.SystemUserPO;
import server.dataservice.systemdataservice.SystemDataServer;
import server.lists.system.SystemList;
import server.lists.system.impl.SystemListImpl;

public class SystemDataServerImpl implements SystemDataServer {
	SystemList list;
	public SystemDataServerImpl() {
		list= new SystemListImpl();
	}
	public SystemUserPO find(String id) {
		SystemUserPO po = list.find(id);
		return po;
	}

	public void insert(SystemUserPO po) {
		list.addUser(po);
	}

	public void delete(SystemUserPO po) {
		list.delUser(po);
	}

	public void update(SystemUserPO po) {
		list.update(po);
	}
	public int getUserNum() {
		// TODO Auto-generated method stub
		return 0;
	}

}
