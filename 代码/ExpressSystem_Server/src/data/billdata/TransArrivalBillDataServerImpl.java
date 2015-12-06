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

import dataservice.billsdataservice.TransArrivalBillDataServer;
import po.bills.TransArrivalBill;

public class TransArrivalBillDataServerImpl extends UnicastRemoteObject implements TransArrivalBillDataServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4643040254174487318L;
	private final String path = "src/dataList/billList/transArrivalList.dat";
	private ArrayList<TransArrivalBill> transArrivalBills;

	public TransArrivalBillDataServerImpl() throws RemoteException {
		super();
		load();
	}

	@Override
	public void addBill(TransArrivalBill bill) throws RemoteException {
		transArrivalBills.add(bill);
		save();
	}

	@Override
	public boolean removeBill(String id) throws RemoteException {
		TransArrivalBill poInArray = findBill(id);
		if (poInArray != null) {
			transArrivalBills.remove(poInArray);
			save();
			System.out.println("成功删除");
			return true;
		}
		System.out.println("找不到该单据");
		return false;
	}

	@Override
	public TransArrivalBill findBill(String id) throws RemoteException {
		for (TransArrivalBill transArrivalBill : transArrivalBills) {
			if (transArrivalBill.getID().equals(id))
				return transArrivalBill;
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
			oos.writeObject(transArrivalBills);
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
				transArrivalBills = new ArrayList<TransArrivalBill>();
				save();
				load();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(list));
			transArrivalBills = (ArrayList<TransArrivalBill>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (EOFException e) {
			transArrivalBills = new ArrayList<TransArrivalBill>();
			save();
			load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
