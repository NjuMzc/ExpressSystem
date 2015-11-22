package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import po.SystemUserPO;
import dataservice.systemdataservice.SystemDataServer;

public class RMIHelper {
	public static void init() {
		try {
			SystemDataServer systemData = (SystemDataServer) Naming.lookup("rmi://localhost:1099/systemData");
			SystemUserPO a = systemData.find("201500000");
			System.out.println(a.getID()+" "+a.getKey()+" "+a.getIdentity());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
