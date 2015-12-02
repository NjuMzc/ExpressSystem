package data.billdata;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataservice.billsdataservice.HallArrivalBillDataServer;
import po.bills.HallArrivalBill;

public class HallArrivalBillDataServerImpl extends UnicastRemoteObject implements HallArrivalBillDataServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2932379216194659858L;
	private final String path = "src/dataList/billList/hallArrivalList.dat";
	private ArrayList<HallArrivalBill> hallArrivalBills;

	public HallArrivalBillDataServerImpl() throws RemoteException {
		super();
		load();
	}

	@Override
	public void addBill(HallArrivalBill bill) throws RemoteException {
		hallArrivalBills.add(bill);
		save();
	}

	@Override
	public boolean removeBill(String id) throws RemoteException {
		HallArrivalBill poInArray = findBill(id);
		if (poInArray != null) {
			hallArrivalBills.remove(poInArray);
			System.out.println("Deleted");
			return true;
		} else {
			System.out.println("Not Found");
			return false;

		}
	}

	@Override
	public HallArrivalBill findBill(String id) throws RemoteException {
		for (HallArrivalBill hallArrivalBill : hallArrivalBills) {
			if (hallArrivalBill.getID().equals(id))
				return hallArrivalBill;
		}
		return null;
	}

	private void save() {
		File list = new File(path);
		if (!list.exists())
			try {
				list.createNewFile();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(list));
			oos.writeObject(hallArrivalBills);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void load() {
		File list = new File(path);
		if (!list.exists())
			try {
				list.createNewFile();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(list));
			hallArrivalBills = (ArrayList<HallArrivalBill>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (EOFException e) {
			hallArrivalBills = new ArrayList<HallArrivalBill>();
			save();
			load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
