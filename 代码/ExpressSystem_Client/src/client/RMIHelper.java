package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.bankdataservice.BankDataServer;
import dataservice.billsdataservice.HallArrivalBillDataServer;
import dataservice.billsdataservice.OrderBillDataServer;
import dataservice.billsdataservice.ReceiveBillDataServer;
import dataservice.informationdataservice.Inform_HallDataServer;
import dataservice.systemdataservice.SystemDataServer;
import dataservice.transportdataservice.TransportDataServer;
import po.Institution.HallPO;

public class RMIHelper {
	private static SystemDataServer systemData;
	private static OrderBillDataServer orderBillData;
	private static TransportDataServer transportData;
	private static ReceiveBillDataServer receiveBillData;
	private static BankDataServer bankData;
	private static Inform_HallDataServer hallData;
	public static void init() {
		try {
			systemData = (SystemDataServer) Naming.lookup("rmi://localhost:1099/systemData");
			orderBillData = (OrderBillDataServer) Naming.lookup("rmi://localhost:1099/orderBillData");
			transportData = (TransportDataServer) Naming.lookup("rmi://localhost:1099/transportData");
			receiveBillData = (ReceiveBillDataServer) Naming.lookup("rmi://localhost:1099/receiveBillData");
			bankData = (BankDataServer) Naming.lookup("rmi://localhost:1099/bankData");
			hallData = (Inform_HallDataServer) Naming.lookup("rmi://localhost:1099/hallData");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

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
	
	public static BankDataServer getBankData(){
		return bankData;
	}
	
	public static Inform_HallDataServer getHallData(){
		return hallData;
	}
}
