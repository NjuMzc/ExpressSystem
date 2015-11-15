package Mock_and_Driver.systembl;

import client.businesslogicservice.systemblservice.systemServer;
import client.vo.Message;

public class systemDriver {
	public static void main(String[] args){
		Message message=new Message();
		
		systemServer server=new MockSystemBlServerImpl();
		server.addUser(message);
		server.removeUser("1");
		server.changeUser("1", message);
		server.inquire("1");
		server.login("1", "1");
		
	}

}
