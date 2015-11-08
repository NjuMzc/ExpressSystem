package client.dataDriver;

import client.dataStub.constantDataServer_Stub;
import client.dataservice.constantdataservice.constantDataServer;
import client.po.ConstantPO;

public class constantdataservice_Driver {

	public void drive(constantDataServer constantDataServer,ConstantPO po){
		System.out.println("This is constantdataservice_Driver.");
		constantDataServer.insert(po);
		constantDataServer.update(po);
		constantDataServer.find("12312");
		constantDataServer.delete(po);
	}
	
	public static void main(String[] arg){
		constantDataServer constantDataServer_Stub = new constantDataServer_Stub();
		ConstantPO po = new ConstantPO();
		constantdataservice_Driver driver =  new constantdataservice_Driver();
		driver.drive(constantDataServer_Stub, po);
	}
}
