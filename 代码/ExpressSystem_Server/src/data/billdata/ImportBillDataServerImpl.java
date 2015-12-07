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

import dataservice.billsdataservice.ImportBillDataServer;
import po.bills.ImportBill;

public class ImportBillDataServerImpl extends UnicastRemoteObject implements ImportBillDataServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4518507143253987292L;
	private final String path = "src/dataList/billList/importList.dat";
	private ArrayList<ImportBill> importBills;

	public ImportBillDataServerImpl() throws RemoteException {
		super();
		load();
	}

	@Override
	public void addBill(ImportBill bill) throws RemoteException {
		importBills.add(bill);
		save();
	}

	@Override
	public boolean removeBill(String id) throws RemoteException {
		ImportBill poInArray = findBill(id);
		if (poInArray != null) {
			importBills.remove(poInArray);
			save();
			return true;
		}
		return false;
	}

	@Override
	public ImportBill findBill(String id) throws RemoteException {
		for (ImportBill importBill : importBills) {
			if (importBill.getId().equals(id))
				return importBill;
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
			oos.writeObject(importBills);
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
				importBills = new ArrayList<ImportBill>();
				save();
				load();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(list));
			importBills = (ArrayList<ImportBill>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (EOFException e) {
			importBills = new ArrayList<ImportBill>();
			save();
			load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
