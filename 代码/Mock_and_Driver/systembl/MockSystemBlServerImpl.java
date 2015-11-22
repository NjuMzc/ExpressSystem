package Mock_and_Driver.systembl;

import po.Message;
import po.SystemUserPO;
import vo.SystemUserVO;
import businesslogic.systembl.SystemBlServerImpl;
import businesslogicservice.systemblservice.systemServer;

public class MockSystemBlServerImpl extends SystemBlServerImpl{



	public SystemUserVO addUser(Message message) {
		// TODO Auto-generated method stub
		SystemUserPO user=new MockSystemUser(null, null, null);
		System.out.println("User is added!");
		return null;
	}

	public boolean removeUser(String id) {
		// TODO Auto-generated method stub
		System.out.println("User is removed!");
		return false;
	}

	public void changeUser(String name, Message message) {
		// TODO Auto-generated method stub
		System.out.println("User is changed!");

	}

	public SystemUserVO inquire(String id) {
		// TODO Auto-generated method stub
		System.out.println("Inquireed!");
		return null;
	}
}
