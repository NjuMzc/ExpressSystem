package client.dataDriver;

import client.dataservice.salarydataservice.salaryDataServer;
import client.vo.Message;

public class salarydataservice_Driver {
	
	public void drive(salaryDataServer server,Message message){
		
		System.out.println("This is salarydataservice_Driver.");
		server.find("123456");
		server.insert(message);
		
	}

}
