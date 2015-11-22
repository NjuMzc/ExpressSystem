package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.*;

import data.systemdata.SystemDataServerImpl;
import dataservice.systemdataservice.SystemDataServer;

public class RMIHelper {
	public static void init() {
        try {
            LocateRegistry.createRegistry(1099);
            
            SystemDataServer systemDataService = new SystemDataServerImpl();
            Naming.rebind("systemData", systemDataService);
            System.out.println("服务器端启动成功");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
			e.printStackTrace();
		}


    }
}
