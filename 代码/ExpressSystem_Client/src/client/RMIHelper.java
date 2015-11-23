package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import po.SystemUserPO;
import dataservice.systemdataservice.SystemDataServer;

public class RMIHelper {
	private static SystemDataServer systemData;
	public static void init() {
		try {
			systemData = (SystemDataServer) Naming.lookup("rmi://localhost:1099/systemData");
			
		
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

	}

	public static SystemDataServer getSystemData(){
		return systemData;
	}
}
