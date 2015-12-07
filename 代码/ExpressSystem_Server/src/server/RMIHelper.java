package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import data.bankdata.BankDataServerImpl;
import data.billdata.ChargeBillDataServerImpl;
import data.billdata.DeliveryBillDataServerImpl;
import data.billdata.HallArrivalBillDataServerImpl;
import data.billdata.HallEntruckBillDataServerImpl;
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
import data.systemdata.SystemDataServerImpl;
import data.transportdata.TransportDataServerImpl;
import dataservice.bankdataservice.BankDataServer;
import dataservice.billsdataservice.ChargeBillDataServer;
import dataservice.billsdataservice.DeliveryBillDataServer;
import dataservice.billsdataservice.HallArrivalBillDataServer;
import dataservice.billsdataservice.HallEntruckBillDataServer;
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
import dataservice.systemdataservice.SystemDataServer;
import dataservice.transportdataservice.TransportDataServer;

public class RMIHelper {

	public static void init() {
		System.out.println("服务器初始化中，请稍候-----------");
		TimeCounter timeCounter = new TimeCounter();
		timeCounter.start();
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

			HallArrivalBillDataServer hallArrivalBillDataService = new HallArrivalBillDataServerImpl();
			Naming.rebind("hallArrivalBillData", hallArrivalBillDataService);

			ChargeBillDataServer chargeBillDataService = new ChargeBillDataServerImpl();
			Naming.rebind("chargeBillData", chargeBillDataService);

			DeliveryBillDataServer deliveryBillDataService = new DeliveryBillDataServerImpl();
			Naming.rebind("deliveryBillData", deliveryBillDataService);

			HallEntruckBillDataServer hallEntruckBillDataService = new HallEntruckBillDataServerImpl();
			Naming.rebind("hallEntruckBillData", hallEntruckBillDataService);

			PaymentBillDataServer paymentBillDataService = new PaymentBillDataServerImpl();
			Naming.rebind("paymentBillData", paymentBillDataService);

			SendingBillDataServer sendingBillDataService = new SendingBillDataServerImpl();
			Naming.rebind("sendingBillData", sendingBillDataService);
			
			TransArrivalBillDataServer transArrivallDataService = new TransArrivalBillDataServerImpl();
			Naming.rebind("transArrivalBillData", transArrivallDataService);
			
			TransEntruckBillDataServer transEntruckBillDataService = new TransEntruckBillDataServerImpl();
			Naming.rebind("transEntruckBillData", transEntruckBillDataService);
			
			PriceListDataServer priceListDataService = new PriceListDataServerImpl();
			Naming.rebind("priceListData", priceListDataService);
			
			CityDistanceDataServer cityDistanceDataService = new CityDistanceDataServerImpl();
			Naming.rebind("cityDistanceData", cityDistanceDataService);
			
			Inform_CarDataServer carDataService = new Inform_CarDataServerImpl();
			Naming.rebind("carData", carDataService);
			
			Inform_DriverDataServer driverDataService = new Inform_DriverDataServerImpl();
			Naming.rebind("driverData", driverDataService);
			
			CityDataServer cityDataService = new CityDataServerImpl();
			Naming.rebind("cityData", cityDataService);
			
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
