package server;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RMISocketFactory;

import data.accountSetdata.StorageInformDataServerImpl;
import data.bankdata.BankDataServerImpl;
import data.billdata.BillApproverDataServerImpl;
import data.billdata.ChargeBillDataServerImpl;
import data.billdata.DeliveryBillDataServerImpl;
import data.billdata.ExportBillDataServerImpl;
import data.billdata.HallArrivalBillDataServerImpl;
import data.billdata.HallEntruckBillDataServerImpl;
import data.billdata.ImportBillDataServerImpl;
import data.billdata.OrderBillDataServerImpl;
import data.billdata.PaymentBillDataServerImpl;
import data.billdata.ReceiveBillDataServerImpl;
import data.billdata.SendingBillDataServerImpl;
import data.billdata.TransArrivalBillDataServerImpl;
import data.billdata.TransEntruckBillDataServerImpl;
import data.constantdata.CityDataServerImpl;
import data.constantdata.CityDistanceDataServerImpl;
import data.constantdata.PriceListDataServerImpl;
import data.informationdata.Inform_CarDataServerImpl;
import data.informationdata.Inform_DriverDataServerImpl;
import data.informationdata.Inform_HallDataServerImpl;
import data.informationdata.Inform_HallStaffDataServerImpl;
import data.informationdata.Inform_KeeperDataServerImpl;
import data.informationdata.Inform_StorageDataServerImpl;
import data.informationdata.Inform_TranStaffDataServerImpl;
import data.informationdata.Inform_TranStationDataServerImpl;
import data.salarydata.SalaryDataServerImpl;
import data.systemdata.SystemDataServerImpl;
import data.transportdata.TransportDataServerImpl;
import dataservice.accountsetdataservice.StorageInformDataServer;
import dataservice.bankdataservice.BankDataServer;
import dataservice.billsdataservice.BillApproverDataServer;
import dataservice.billsdataservice.ChargeBillDataServer;
import dataservice.billsdataservice.DeliveryBillDataServer;
import dataservice.billsdataservice.ExportBillDataServer;
import dataservice.billsdataservice.HallArrivalBillDataServer;
import dataservice.billsdataservice.HallEntruckBillDataServer;
import dataservice.billsdataservice.ImportBillDataServer;
import dataservice.billsdataservice.OrderBillDataServer;
import dataservice.billsdataservice.PaymentBillDataServer;
import dataservice.billsdataservice.ReceiveBillDataServer;
import dataservice.billsdataservice.SendingBillDataServer;
import dataservice.billsdataservice.TransArrivalBillDataServer;
import dataservice.billsdataservice.TransEntruckBillDataServer;
import dataservice.constantdataservice.CityDataServer;
import dataservice.constantdataservice.CityDistanceDataServer;
import dataservice.constantdataservice.PriceListDataServer;
import dataservice.informationdataservice.Inform_CarDataServer;
import dataservice.informationdataservice.Inform_DriverDataServer;
import dataservice.informationdataservice.Inform_HallDataServer;
import dataservice.informationdataservice.Inform_HallStaffDataServer;
import dataservice.informationdataservice.Inform_KeeperDataServer;
import dataservice.informationdataservice.Inform_StorageDataServer;
import dataservice.informationdataservice.Inform_TranStaffDataServer;
import dataservice.informationdataservice.Inform_TranStationDataServer;
import dataservice.salarydataservice.SalaryDataServer;
import dataservice.systemdataservice.SystemDataServer;
import dataservice.transportdataservice.TransportDataServer;

public class RMIHelper {

	private static String hostIP = "localhost";
	private static String port = "8400";

	public static void init() {
		System.out.println("服务器初始化中，请稍候-----------");
		TimeCounter timeCounter = new TimeCounter();
		timeCounter.start();

		try {
			hostIP = InetAddress.getLocalHost().getHostAddress();
			LocateRegistry.createRegistry(Integer.valueOf(port));
			System.out.println(hostIP);
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		try {

			// System.setProperty("java.rmi.server.hostname", "172.26.196.95");
			// System.setSecurityManager(new RMISecurityManager());

			SystemDataServer systemDataService = new SystemDataServerImpl();
			Naming.rebind("rmi://" + hostIP + ":" + port + "/systemData", systemDataService);

			OrderBillDataServer orderBillDataService = new OrderBillDataServerImpl();
			Naming.rebind("rmi://" + hostIP + ":" + port + "/orderBillData", orderBillDataService);

			TransportDataServer transportDataService = new TransportDataServerImpl();
			Naming.rebind("rmi://" + hostIP + ":" + port + "/transportData", transportDataService);

			ReceiveBillDataServer receiveBillDataService = new ReceiveBillDataServerImpl();
			Naming.rebind("rmi://" + hostIP + ":" + port + "/receiveBillData", receiveBillDataService);

			BankDataServer bankDataService = new BankDataServerImpl();
			Naming.rebind("rmi://" + hostIP + ":" + port + "/bankData", bankDataService);

			Inform_HallDataServer hallDataService = new Inform_HallDataServerImpl();
			Naming.rebind("rmi://" + hostIP + ":" + port + "/hallData", hallDataService);

			Inform_HallStaffDataServer hallStaffDataService = new Inform_HallStaffDataServerImpl();
			Naming.rebind("rmi://" + hostIP + ":" + port + "/hallStaffData", hallStaffDataService);

			Inform_KeeperDataServer keeperDataService = new Inform_KeeperDataServerImpl();
			Naming.rebind("rmi://" + hostIP + ":" + port + "/keeperData", keeperDataService);

			Inform_StorageDataServer storageDataService = new Inform_StorageDataServerImpl();
			Naming.rebind("rmi://" + hostIP + ":" + port + "/storageData", storageDataService);

			Inform_TranStaffDataServer tranStaffDataService = new Inform_TranStaffDataServerImpl();
			Naming.rebind("rmi://" + hostIP + ":" + port + "/tranStaffData", tranStaffDataService);

			Inform_TranStationDataServer tranStationDataService = new Inform_TranStationDataServerImpl();
			Naming.rebind("rmi://" + hostIP + ":" + port + "/tranStationData", tranStationDataService);

			HallArrivalBillDataServer hallArrivalBillDataService = new HallArrivalBillDataServerImpl();
			Naming.rebind("rmi://" + hostIP + ":" + port + "/hallArrivalBillData", hallArrivalBillDataService);

			ChargeBillDataServer chargeBillDataService = new ChargeBillDataServerImpl();
			Naming.rebind("rmi://" + hostIP + ":" + port + "/chargeBillData", chargeBillDataService);

			DeliveryBillDataServer deliveryBillDataService = new DeliveryBillDataServerImpl();
			Naming.rebind("rmi://" + hostIP + ":" + port + "/deliveryBillData", deliveryBillDataService);

			HallEntruckBillDataServer hallEntruckBillDataService = new HallEntruckBillDataServerImpl();
			Naming.rebind("rmi://" + hostIP + ":" + port + "/hallEntruckBillData", hallEntruckBillDataService);

			PaymentBillDataServer paymentBillDataService = new PaymentBillDataServerImpl();
			Naming.rebind("rmi://" + hostIP + ":" + port + "/paymentBillData", paymentBillDataService);

			SendingBillDataServer sendingBillDataService = new SendingBillDataServerImpl();
			Naming.rebind("rmi://" + hostIP + ":" + port + "/sendingBillData", sendingBillDataService);

			TransArrivalBillDataServer transArrivallDataService = new TransArrivalBillDataServerImpl();
			Naming.rebind("rmi://" + hostIP + ":" + port + "/transArrivalBillData", transArrivallDataService);

			TransEntruckBillDataServer transEntruckBillDataService = new TransEntruckBillDataServerImpl();
			Naming.rebind("rmi://" + hostIP + ":" + port + "/transEntruckBillData", transEntruckBillDataService);

			PriceListDataServer priceListDataService = new PriceListDataServerImpl();
			Naming.rebind("rmi://" + hostIP + ":" + port + "/priceListData", priceListDataService);

			CityDistanceDataServer cityDistanceDataService = new CityDistanceDataServerImpl();
			Naming.rebind("rmi://" + hostIP + ":" + port + "/cityDistanceData", cityDistanceDataService);

			Inform_CarDataServer carDataService = new Inform_CarDataServerImpl();
			Naming.rebind("rmi://" + hostIP + ":" + port + "/carData", carDataService);

			Inform_DriverDataServer driverDataService = new Inform_DriverDataServerImpl();
			Naming.rebind("rmi://" + hostIP + ":" + port + "/driverData", driverDataService);

			CityDataServer cityDataService = new CityDataServerImpl();
			Naming.rebind("rmi://" + hostIP + ":" + port + "/cityData", cityDataService);

			BillApproverDataServer billApproverDataService = new BillApproverDataServerImpl();
			Naming.rebind("rmi://" + hostIP + ":" + port + "/billApproverData", billApproverDataService);

			ExportBillDataServer exportBillDataService = new ExportBillDataServerImpl();
			Naming.rebind("rmi://" + hostIP + ":" + port + "/exportBillData", exportBillDataService);

			ImportBillDataServer importBillDataService = new ImportBillDataServerImpl();
			Naming.rebind("rmi://" + hostIP + ":" + port + "/importBillData", importBillDataService);

			SalaryDataServer salaryDataService = new SalaryDataServerImpl();
			Naming.rebind("rmi://" + hostIP + ":" + port + "/salaryData", salaryDataService);

			StorageInformDataServer storageInformDataService = new StorageInformDataServerImpl();
			Naming.rebind("rmi://" + hostIP + ":" + port + "/storageInformData", storageInformDataService);

			System.out.println("服务器端启动成功");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		timeCounter.stop();

	}

}

class TimeCounter extends Thread {
	@Override
	public void run() {
		int i = 1;
		super.run();
		while (true) {
			System.out.println(i + ".......");
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
