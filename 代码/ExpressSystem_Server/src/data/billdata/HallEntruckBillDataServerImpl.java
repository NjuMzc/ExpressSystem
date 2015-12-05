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

import dataservice.billsdataservice.HallEntruckBillDataServer;
import po.bills.HallArrivalBill;
import po.bills.HallEntruckBill;

public class HallEntruckBillDataServerImpl extends UnicastRemoteObject implements HallEntruckBillDataServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9202048429589105908L;

	private String path = "src/dataList/billList/hallEntruckList.dat";
	private ArrayList<HallEntruckBill> hallEntruckBills;

	public HallEntruckBillDataServerImpl() throws RemoteException {
		super();
		load();
	}

	@Override
	public void addBill(HallEntruckBill bill) throws RemoteException {
		hallEntruckBills.add(bill);
		save();
	}

	@Override
	public boolean removeBill(String id) throws RemoteException {
		HallEntruckBill poInArray = findBill(id);
		if (poInArray != null) {
			hallEntruckBills.remove(poInArray);
			save();
			System.out.println("成功删除");
			return true;
		}
		System.out.println("找不到该单据");
		return false;
	}

	@Override
	public HallEntruckBill findBill(String id) throws RemoteException {
		for (HallEntruckBill hallEntruckBill : hallEntruckBills) {
			if (hallEntruckBill.getId().equals(id))
				return hallEntruckBill;
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
			oos.writeObject(hallEntruckBills);
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
			hallEntruckBills = (ArrayList<HallEntruckBill>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (EOFException e) {
			hallEntruckBills = new ArrayList<HallEntruckBill>();
			save();
			load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
