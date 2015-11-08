package client.blDriver;

import client.businesslogicservice.systemblservice.systemServer;
import client.vo.Message;

public class systemblservice_Driver {
	public void drive(systemServer systemserver,Message message){
		System.out.println("This is systemblservice_Driver");
		systemserver.login("12", "liu");
		systemserver.addUser(message);
		systemserver.removeUser("11");
		systemserver.changeUser("liuxing", message);
		systemserver.inquire("12");
	}

}
