package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.bankdataservice.BankDataServer;
import dataservice.billsdataservice.BillApproverDataServer;
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
	
	public static void init() {
		try {
			systemData = (SystemDataServer) Naming.lookup("rmi://localhost:1099/systemData");
			orderBillData = (OrderBillDataServer) Naming.lookup("rmi://localhost:1099/orderBillData");
			transportData = (TransportDataServer) Naming.lookup("rmi://localhost:1099/transportData");
			receiveBillData = (ReceiveBillDataServer) Naming.lookup("rmi://localhost:1099/receiveBillData");
			bankData = (BankDataServer) Naming.lookup("rmi://localhost:1099/bankData");
			hallData = (Inform_HallDataServer) Naming.lookup("rmi://localhost:1099/hallData");
			hallStaffData = (Inform_HallStaffDataServer) Naming.lookup("rmi://localhost:1099/hallStaffData");
			keeperData = (Inform_KeeperDataServer) Naming.lookup("rmi://localhost:1099/keeperData");
			storageData = (Inform_StorageDataServer) Naming.lookup("rmi://localhost:1099/storageData");
			tranStaffData = (Inform_TranStaffDataServer) Naming.lookup("rmi://localhost:1099/tranStaffData");
			tranStationData = (Inform_TranStationDataServer) Naming.lookup("rmi://localhost:1099/tranStationData");
			hallArrivalBillData = (HallArrivalBillDataServer) Naming.lookup("rmi://localhost:1099/hallArrivalBillData");
			chargeBillData = (ChargeBillDataServer) Naming.lookup("rmi://localhost:1099/chargeBillData");
			deliveryBillData = (DeliveryBillDataServer) Naming.lookup("rmi://localhost:1099/deliveryBillData");
			hallEntruckData = (HallEntruckBillDataServer) Naming.lookup("rmi://localhost:1099/hallEntruckBillData");
			paymentBillData = (PaymentBillDataServer) Naming.lookup("rmi://localhost:1099/paymentBillData");
			sendingBillData = (SendingBillDataServer) Naming.lookup("rmi://localhost:1099/sendingBillData");
			transArrivalBillData = (TransArrivalBillDataServer) Naming
					.lookup("rmi://localhost:1099/transArrivalBillData");
			transEntruckBillData = (TransEntruckBillDataServer) Naming
					.lookup("rmi://localhost:1099/transEntruckBillData");
			priceListData = (PriceListDataServer) Naming.lookup("rmi://localhost:1099/priceListData");
			cityDistanceData = (CityDistanceDataServer) Naming.lookup("rmi://localhost:1099/cityDistanceData");
			carData = (Inform_CarDataServer) Naming.lookup("rmi://localhost:1099/carData");
			driverData =(Inform_DriverDataServer)Naming.lookup("rmi://localhost:1099/driverData");
			cityData=(CityDataServer)Naming.lookup("rmi://localhost:1099/cityData");
			billApproverData =(BillApproverDataServer)Naming.lookup("rmi://localhost:1099/billApproverData");
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

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
