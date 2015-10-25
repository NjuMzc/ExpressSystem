package client.dataStub;

import client.dataservice.systemdataservice.systemDataServer;
import client.po.SystemPO;

public class systemDataServer_Stub implements systemDataServer{

	public SystemPO find(String id) {
		// TODO Auto-generated method stub
		System.out.println("A SystemPO is found in data!");
		return null;
	}

	public void insert(SystemPO po) {
		// TODO Auto-generated method stub
		System.out.println("A SystemPO is added in data!");
	}

	public void delet(SystemPO po) {
		// TODO Auto-generated method stub
		System.out.println("A SystemPO is deleted in data!");
	}

}
