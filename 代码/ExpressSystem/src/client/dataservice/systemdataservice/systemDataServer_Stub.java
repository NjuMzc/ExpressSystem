package client.dataservice.systemdataservice;

import client.po.SystemUserPO;

public class systemDataServer_Stub implements systemDataServer {

	public SystemUserPO find(String id) {
		// TODO Auto-generated method stub
		SystemUserPO user=new SystemUserPO("2015010001","nova123321","manager");
		
		return user;
	}

	public void insert(SystemUserPO po) {
		// TODO Auto-generated method stub

	}

	public void delete(SystemUserPO po) {
		// TODO Auto-generated method stub

	}

	public void update(SystemUserPO po) {
		// TODO Auto-generated method stub

	}

}
