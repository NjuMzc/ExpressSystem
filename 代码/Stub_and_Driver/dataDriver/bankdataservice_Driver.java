package client.dataDriver;

import java.rmi.RemoteException;

import client.dataStub.bankDataServer_Stub;
import client.dataservice.bankdataservice.bankDataServer;
import client.po.BankPO;

public class bankdataservice_Driver {
	
	public void drive(bankDataServer bankDataServer,BankPO po) throws RemoteException{
		System.out.println("This is bankdataservice_Driver.");
		bankDataServer.find("123");
		bankDataServer.insert(po);
		bankDataServer.delete(po);
		bankDataServer.update(po);
	}
	
	public static void main(String[] arg){
		bankDataServer bankDataServer= new bankDataServer_Stub();
		BankPO po =new BankPO();
		bankdataservice_Driver driver =new bankdataservice_Driver();
		try {
			driver.drive(bankDataServer, po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
