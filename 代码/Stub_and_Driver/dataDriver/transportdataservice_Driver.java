package client.dataDriver;

import java.rmi.RemoteException;

import client.dataservice.transportdataservice.transportDataServer;
import client.po.*;

public class transportdataservice_Driver {
	
	public void drive(transportDataServer server,GoodPO po) throws RemoteException{
		System.out.println("This is transportdataservice_Driver.");
		server.find("123456");
		server.insert(po);
		server.update(po);
	}

}
