package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

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
	private static SystemDataServer systemData;
	private static OrderBillDataServer orderBillData;
	private static TransportDataServer transportData;
	private static ReceiveBillDataServer receiveBillData;
	private static BankDataServer bankData;
	private static Inform_HallDataServer hallData;
	private static Inform_HallStaffDataServer hallStaffData;
	private static Inform_KeeperDataServer keeperData;
	private static Inform_StorageDataServer storageData;
	private static Inform_TranStaffDataServer tranStaffData;
	private static Inform_TranStationDataServer tranStationData;
	

	private static HallArrivalBillDataServer hallArrivalBillData;
	private static ChargeBillDataServer chargeBillData;
	private static DeliveryBillDataServer deliveryBillData;
	private static HallEntruckBillDataServer hallEntruckData;
	private static PaymentBillDataServer paymentBillData;
	private static SendingBillDataServer sendingBillData;
	private static TransArrivalBillDataServer transArrivalBillData;
	private static TransEntruckBillDataServer transEntruckBillData;
	private static PriceListDataServer priceListData;
	private static CityDistanceDataServer cityDistanceData;
	private static Inform_CarDataServer carData;
	private static Inform_DriverDataServer driverData;
	private static CityDataServer cityData;
	private static BillApproverDataServer billApproverData;
	private static ExportBillDataServer exportBillData;
	private static ImportBillDataServer importBillData;
	private static SalaryDataServer salaryData;
	private static StorageInformDataServer storageInformData;

	private static String hostIP = "172.28.153.101";
	private static String port = "8400";

	public static void init() {
		hostIP = "localhost";// 如果要联机了请将这一行注释或删除

		try {
			systemData = (SystemDataServer) Naming.lookup("rmi://" + hostIP + ":" + port + "/systemData");
			orderBillData = (OrderBillDataServer) Naming.lookup("rmi://" + hostIP + ":" + port + "/orderBillData");
			transportData = (TransportDataServer) Naming.lookup("rmi://" + hostIP + ":" + port + "/transportData");
			receiveBillData = (ReceiveBillDataServer) Naming
					.lookup("rmi://" + hostIP + ":" + port + "/receiveBillData");
			bankData = (BankDataServer) Naming.lookup("rmi://" + hostIP + ":" + port + "/bankData");
			hallData = (Inform_HallDataServer) Naming.lookup("rmi://" + hostIP + ":" + port + "/hallData");
			hallStaffData = (Inform_HallStaffDataServer) Naming
					.lookup("rmi://" + hostIP + ":" + port + "/hallStaffData");
			keeperData = (Inform_KeeperDataServer) Naming.lookup("rmi://" + hostIP + ":" + port + "/keeperData");
			storageData = (Inform_StorageDataServer) Naming.lookup("rmi://" + hostIP + ":" + port + "/storageData");
			tranStaffData = (Inform_TranStaffDataServer) Naming
					.lookup("rmi://" + hostIP + ":" + port + "/tranStaffData");
			tranStationData = (Inform_TranStationDataServer) Naming
					.lookup("rmi://" + hostIP + ":" + port + "/tranStationData");
			hallArrivalBillData = (HallArrivalBillDataServer) Naming
					.lookup("rmi://" + hostIP + ":" + port + "/hallArrivalBillData");
			chargeBillData = (ChargeBillDataServer) Naming.lookup("rmi://" + hostIP + ":" + port + "/chargeBillData");
			deliveryBillData = (DeliveryBillDataServer) Naming
					.lookup("rmi://" + hostIP + ":" + port + "/deliveryBillData");
			hallEntruckData = (HallEntruckBillDataServer) Naming
					.lookup("rmi://" + hostIP + ":" + port + "/hallEntruckBillData");
			paymentBillData = (PaymentBillDataServer) Naming
					.lookup("rmi://" + hostIP + ":" + port + "/paymentBillData");
			sendingBillData = (SendingBillDataServer) Naming
					.lookup("rmi://" + hostIP + ":" + port + "/sendingBillData");
			transArrivalBillData = (TransArrivalBillDataServer) Naming
					.lookup("rmi://" + hostIP + ":" + port + "/transArrivalBillData");
			transEntruckBillData = (TransEntruckBillDataServer) Naming
					.lookup("rmi://" + hostIP + ":" + port + "/transEntruckBillData");
			priceListData = (PriceListDataServer) Naming.lookup("rmi://" + hostIP + ":" + port + "/priceListData");
			cityDistanceData = (CityDistanceDataServer) Naming
					.lookup("rmi://" + hostIP + ":" + port + "/cityDistanceData");
			carData = (Inform_CarDataServer) Naming.lookup("rmi://" + hostIP + ":" + port + "/carData");
			driverData = (Inform_DriverDataServer) Naming.lookup("rmi://" + hostIP + ":" + port + "/driverData");
			cityData = (CityDataServer) Naming.lookup("rmi://" + hostIP + ":" + port + "/cityData");
			billApproverData = (BillApproverDataServer) Naming
					.lookup("rmi://" + hostIP + ":" + port + "/billApproverData");
			exportBillData = (ExportBillDataServer) Naming.lookup("rmi://" + hostIP + ":" + port + "/exportBillData");
			importBillData = (ImportBillDataServer) Naming.lookup("rmi://" + hostIP + ":" + port + "/importBillData");
			salaryData = (SalaryDataServer) Naming.lookup("rmi://" + hostIP + ":" + port + "/salaryData");
			storageInformData = (StorageInformDataServer) Naming
					.lookup("rmi://" + hostIP + ":" + port + "/storageInformData");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

	}
	
	public static StorageInformDataServer getStorageInformData() {
		return storageInformData;
	}

	public static SalaryDataServer getSalaryData() {
		return salaryData;
	}

	public static ImportBillDataServer getImportBillData() {
		return importBillData;
	}

	public static ExportBillDataServer getExportBillData() {
		return exportBillData;
	}

	public static BillApproverDataServer getBillApproverData() {
		return billApproverData;
	}

	public static CityDataServer getCityData() {
		return cityData;
	}

	public static Inform_DriverDataServer getDriverData() {
		return driverData;
	}

	public static Inform_CarDataServer getCarData() {
		return carData;
	}

	public static CityDistanceDataServer getCityDistanceData() {
		return cityDistanceData;
	}

	public static PriceListDataServer getPriceListData() {
		return priceListData;
	}

	public static TransEntruckBillDataServer getTransEntruckBillData() {
		return transEntruckBillData;
	}

	public static TransArrivalBillDataServer getTransArrivalBillData() {
		return transArrivalBillData;
	}

	public static SendingBillDataServer getSendingBillData() {
		return sendingBillData;
	}

	public static PaymentBillDataServer getPaymentBillData() {
		return paymentBillData;
	}

	public static HallEntruckBillDataServer getHallEntruckData() {
		return hallEntruckData;
	}

	public static DeliveryBillDataServer getDeliveryBillData() {
		return deliveryBillData;
	}

	public static SystemDataServer getSystemData() {
		return systemData;
	}

	public static OrderBillDataServer getOrderBillData() {
		return orderBillData;
	}

	public static TransportDataServer getTransportData() {
		return transportData;
	}

	public static ReceiveBillDataServer getReceiBillData() {
		return receiveBillData;
	}

	public static BankDataServer getBankData() {
		return bankData;
	}

	public static Inform_HallDataServer getHallData() {
		return hallData;
	}

	public static Inform_HallStaffDataServer getHallStaffData() {
		return hallStaffData;
	}

	public static Inform_KeeperDataServer getKeeperData() {
		return keeperData;
	}

	public static Inform_StorageDataServer getStorageData() {
		return storageData;
	}

	public static Inform_TranStaffDataServer getTranStaffData() {
		return tranStaffData;
	}

	public static Inform_TranStationDataServer getTranStationData() {
		return tranStationData;
	}

	public static HallArrivalBillDataServer getHallArrivalBillData() {
		return hallArrivalBillData;
	}

	public static ChargeBillDataServer getChargeBillData() {
		return chargeBillData;
	}
}
