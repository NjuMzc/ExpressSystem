package client.dataDriver;

import java.rmi.RemoteException;

import client.dataStub.accountSetDataServer_Stub;
import client.dataservice.accountSetdataservice.accountSetDataServer;
import client.vo.Message;

public class accountSetdataservice_Driver {

	public void drive(accountSetDataServer accountSetDataServer, Message msg) throws RemoteException {
		System.out.println("This is accountSetdataservice_Driver.");
		accountSetDataServer.find("123");
		accountSetDataServer.insert(msg);
	}
	
	public static void main(String[] arg){
		accountSetDataServer accountSetDataServer_Stub = new accountSetDataServer_Stub();
		Message msg = new Message();
		accountSetdataservice_Driver driver = new accountSetdataservice_Driver();
		try {
			driver.drive(accountSetDataServer_Stub, msg);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
