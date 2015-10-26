package client.dataStub;

import client.dataservice.constantdataservice.constantDataServer;
import client.po.ConstantPO;
import client.vo.Message;

public class constantDataServer_Stub implements constantDataServer {

	public ConstantPO find(Message message) {
		// TODO Auto-generated method stub
		System.out.println("A constantPO is found in data!");
		return null;
	}

	public ConstantPO delete(ConstantPO po) {
		// TODO Auto-generated method stub
		System.out.println("A constantPO is deleted in data!");
		return null;
	}

	public void insert(ConstantPO po) {
		// TODO Auto-generated method stub
		System.out.println("A constantPO is added in data!");
	}

}
