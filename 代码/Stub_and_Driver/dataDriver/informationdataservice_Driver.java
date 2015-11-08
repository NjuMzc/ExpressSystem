package client.dataDriver;

import java.rmi.RemoteException;

import client.dataStub.informationDataServer_Stub;
import client.dataservice.informationdataservice.informationDataServer;
import client.po.InformationPO;

public class informationdataservice_Driver {

	public void drive(informationDataServer informationDataServer,InformationPO po) throws RemoteException{
		System.out.println("This is informationdataservice_Driver.");
		informationDataServer.insert(po);
		informationDataServer.find("414");
		informationDataServer.update(po);
		informationDataServer.delete(po);
	}
	
	public static void main(String[] args){
		informationDataServer informationDataServer_Stub = new informationDataServer_Stub();
		InformationPO po = new InformationPO();
		informationdataservice_Driver driver = new informationdataservice_Driver();
		try {
			driver.drive(informationDataServer_Stub, po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
