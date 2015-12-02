package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import data.bankdata.BankDataServerImpl;
import data.billdata.OrderBillDataServerImpl;
import data.billdata.ReceiveBillDataServerImpl;
import data.informationdata.Inform_HallDataServerImpl;
import data.informationdata.Inform_HallStaffDataServerImpl;
import data.informationdata.Inform_KeeperDataServerImpl;
import data.informationdata.Inform_StorageDataServerImpl;
import data.informationdata.Inform_TranStaffDataServerImpl;
import data.informationdata.Inform_TranStationDataServerImpl;
import data.systemdata.SystemDataServerImpl;
import data.transportdata.TransportDataServerImpl;
import dataservice.bankdataservice.BankDataServer;
import dataservice.billsdataservice.OrderBillDataServer;
import dataservice.billsdataservice.ReceiveBillDataServer;
import dataservice.informationdataservice.Inform_HallDataServer;
import dataservice.informationdataservice.Inform_HallStaffDataServer;
import dataservice.informationdataservice.Inform_KeeperDataServer;
import dataservice.informationdataservice.Inform_StorageDataServer;
import dataservice.informationdataservice.Inform_TranStaffDataServer;
import dataservice.informationdataservice.Inform_TranStationDataServer;
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

			ReceiveBillDataServer receiveBillDataService = new ReceiveBillDataServerImpl();
			Naming.rebind("receiveBillData", receiveBillDataService);

			BankDataServer bankDataService = new BankDataServerImpl();
			Naming.rebind("bankData", bankDataService);

			Inform_HallDataServer hallDataService = new Inform_HallDataServerImpl();
			Naming.rebind("hallData", hallDataService);

			Inform_HallStaffDataServer hallStaffDataService = new Inform_HallStaffDataServerImpl();
			Naming.rebind("hallStaffData", hallStaffDataService);

			Inform_KeeperDataServer keeperDataService = new Inform_KeeperDataServerImpl();
			Naming.rebind("keeperData", keeperDataService);

			Inform_StorageDataServer storageDataService = new Inform_StorageDataServerImpl();
			Naming.rebind("storageData", storageDataService);

			Inform_TranStaffDataServer tranStaffDataService = new Inform_TranStaffDataServerImpl();
			Naming.rebind("tranStaffData", tranStaffDataService);
			
			Inform_TranStationDataServer tranStationDataService = new Inform_TranStationDataServerImpl();
			Naming.rebind("tranStationData", tranStationDataService);

			System.out.println("服务器端启动成功");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

}
