package client.blStub;

import client.businesslogicservice.constantblservice.constantServer;
import client.vo.ConstantVO;
import client.vo.Message;

public class constantServer_Stub implements constantServer {

	public ConstantVO setConstant(Message message) {
		// TODO Auto-generated method stub
		System.out.println("Constant is set");
		return null;
	}

	public ConstantVO getConstant(String name) {
		// TODO Auto-generated method stub
		System.out.println("Constant is get");
		return null;
	}

}
