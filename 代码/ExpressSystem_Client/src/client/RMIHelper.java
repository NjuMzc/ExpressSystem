package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.bankdataservice.BankDataServer;
import dataservice.billsdataservice.ChargeBillDataServer;
import dataservice.billsdataservice.DeliveryBillDataServer;
import dataservice.billsdataservice.HallArrivalBillDataServer;
import dataservice.billsdataservice.HallEntruckBillDataServer;
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
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

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
