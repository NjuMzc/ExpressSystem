package client.dataDriver;

import client.dataservice.systemdataservice.systemDataServer;
import client.po.SystemPO;

public class systemdataservice_Driver {
	
	public void drive(systemDataServer server,SystemPO po){
		
		System.out.println("This is systemdataservice_Driver.");
		server.delete(po);
		server.find("123456");
		server.insert(po);
		server.update(po);
		
	}

}
