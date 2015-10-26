package client.dataDriver;

import client.dataservice.storagedataservice.storageDataServer;
import client.po.*;

public class storagedataservice_Driver {

	public void drive(storageDataServer server,StoragePO po){
		System.out.println("This is storagedataservice_Driver.");
		server.delete(po);
		server.find("123456");
		
	}
}
