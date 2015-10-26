package client.dataDriver;

import java.rmi.RemoteException;

import client.dataStub.billsDataServer_Stub;
import client.dataservice.billsdataservice.billsDataServer;
import client.po.BillPO;
import client.vo.Message;

public class billsdataservice_Driver {
	
	public void drive(billsDataServer billsDataServer,Message msg) throws RemoteException{
		System.out.println("This is billsdataservice_Driver.");
		BillPO po=new BillPO(msg);
		billsDataServer.find("12");
		billsDataServer.insert(po);
		billsDataServer.update(po);
		
	}
	
	public static void main(String[] args){
		billsDataServer billsDataServer_Stub = new  billsDataServer_Stub();
		Message msg = new Message();
		billsdataservice_Driver driver = new billsdataservice_Driver();
		try {
			driver.drive(billsDataServer_Stub,msg);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
