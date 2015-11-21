package server.server;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.*;

public class RMIHelper {
	public static void init() {
        try {
            LocateRegistry.createRegistry(6666);
            System.out.println("服务器端启动成功");

        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }
}
