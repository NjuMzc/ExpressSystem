package server.data.systemdata;

import client.po.SystemUserPO;
import server.dataservice.systemdataservice.systemDataServer;
import server.lists.system.systemList;
import server.lists.system.impl.systemListImpl;

public class SystemDataServerImpl implements systemDataServer {
	systemList list;
	public SystemDataServerImpl() {
		list= new systemListImpl();
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

}
