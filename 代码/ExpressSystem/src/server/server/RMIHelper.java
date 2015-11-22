package server.server;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.*;

import server.data.systemdata.SystemDataServerImpl;
import server.dataservice.systemdataservice.SystemDataServer;

public class RMIHelper {
	public static void init() {
        try {
            LocateRegistry.createRegistry(6666);
            System.out.println("服务器端启动成功");
            SystemDataServer systemDataService = new SystemDataServerImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }
}
