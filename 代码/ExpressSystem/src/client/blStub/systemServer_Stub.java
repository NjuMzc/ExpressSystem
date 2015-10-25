package client.blStub;

import client.businesslogicservice.systemblservice.systemServer;
import client.vo.Message;
import client.vo.SystemUserVO;

public class systemServer_Stub implements systemServer {

	public boolean login(String id, String key) {
		// TODO Auto-generated method stub
		System.out.println("login!");
		return false;
	}

	public SystemUserVO addUser(Message message) {
		// TODO Auto-generated method stub
		System.out.println("User is added");
		return null;
	}

	public boolean removeUser(String id) {
		// TODO Auto-generated method stub
		System.out.println("User is removed");
		return false;
	}

	public void changeUser(String name, Message message) {
		// TODO Auto-generated method stub
		System.out.println("User is changed");

	}

	public SystemUserVO inquire(String id) {
		// TODO Auto-generated method stub
		System.out.println("SystemUserVO is inquired");
		return null;
	}

}
