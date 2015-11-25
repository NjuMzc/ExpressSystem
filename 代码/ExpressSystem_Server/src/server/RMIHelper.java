package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.*;

import data.billdata.OrderBillDataServerImpl;
import data.systemdata.SystemDataServerImpl;
import data.transportdata.TransportDataServerImpl;
import dataservice.billsdataservice.OrderBillDataServer;
import dataservice.systemdataservice.SystemDataServer;
import dataservice.transportdataservice.TransportDataServer;

public class RMIHelper {

	public static void init() {
		try {
			LocateRegistry.createRegistry(1099);

			SystemDataServer systemDataService = new SystemDataServerImpl();
			Naming.rebind("systemData", systemDataService);

			OrderBillDataServer orderBillDataService = new OrderBillDataServerImpl();
			Naming.rebind("orderBillData", orderBillDataService);

			TransportDataServer transportDataService = new TransportDataServerImpl();
			Naming.rebind("transportData", transportDataService);

			System.out.println("服务器端启动成功");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

}
