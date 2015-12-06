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

import dataservice.billsdataservice.TransEntruckBillDataServer;
import po.bills.TransEntruckBill;

public class TransEntruckBillDataServerImpl extends UnicastRemoteObject implements TransEntruckBillDataServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2560505726276545764L;
	private final String path = "src/dataList/billList/transEntruckList.dat";
	private ArrayList<TransEntruckBill> transEntruckBills;

	public TransEntruckBillDataServerImpl() throws RemoteException {
		super();
		load();
	}

	@Override
	public void addBill(TransEntruckBill bill) throws RemoteException {
		transEntruckBills.add(bill);
		save();
	}

	@Override
	public boolean removeBill(String id) throws RemoteException {
		TransEntruckBill poInArray = findBill(id);
		if (poInArray != null) {
			transEntruckBills.remove(poInArray);
			save();
			System.out.println("成功删除");
			return true;
		}
		System.out.println("找不到该单据");
		return false;
	}

	@Override
	public TransEntruckBill findBill(String id) throws RemoteException {
		for (TransEntruckBill transEntruckBill : transEntruckBills) {
			if (transEntruckBill.getId().equals(id))
				return transEntruckBill;
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
			oos.writeObject(transEntruckBills);
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
				transEntruckBills = new ArrayList<TransEntruckBill>();
				save();
				load();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(list));
			transEntruckBills = (ArrayList<TransEntruckBill>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (EOFException e) {
			transEntruckBills = new ArrayList<TransEntruckBill>();
			save();
			load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
