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

import po.bills.ExportBill;

public class ExportBillDataServerImpl extends UnicastRemoteObject
		implements dataservice.billsdataservice.ExportBillDataServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -888018455841526258L;
	private final String path = "src/dataList/billList/exportList.dat";
	private ArrayList<ExportBill> exportBills;

	public ExportBillDataServerImpl() throws RemoteException {
		super();
		load();
	}

	@Override
	public void addBill(ExportBill bill) throws RemoteException {
		exportBills.add(bill);
		save();
	}

	@Override
	public boolean removeBill(String id) throws RemoteException {
		ExportBill poInArray = findBill(id);
		if (poInArray != null) {
			exportBills.remove(poInArray);
			save();
			return true;
		}
		return false;
	}

	@Override
	public ExportBill findBill(String id) throws RemoteException {
		for (ExportBill exportBill : exportBills) {
			if (exportBill.getId().equals(id))
				return exportBill;
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
			oos.writeObject(exportBills);
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
				exportBills = new ArrayList<ExportBill>();
				save();
				load();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(list));
			exportBills = (ArrayList<ExportBill>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (EOFException e) {
			exportBills = new ArrayList<ExportBill>();
			save();
			load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
