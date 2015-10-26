package client.blDriver;

import client.businesslogicservice.storageblservice.storageServer;
import client.vo.Message;

public class storageblservice_Driver {
	public void drive(storageServer storageserver,Message message){
		System.out.println("This is storageblservice_Driver");
		storageserver.getStorageList();
		storageserver.getStorageHistory("1", "2");
		storageserver.changeStorage("12", "±±¾©");
		
	}

}
