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

import dataservice.billsdataservice.ReceiveBillDataServer;
import po.Message;
import po.bills.ReceiveBill;

public class ReceiveBillDataServerImpl extends UnicastRemoteObject implements ReceiveBillDataServer {
	final String path = "src/dataList/billList/receiveList.dat";
	ArrayList<ReceiveBill> receiveBills;

	public ReceiveBillDataServerImpl() throws RemoteException {
		super();
		load();
	}

	@Override
	public void addBill(ReceiveBill bill) throws RemoteException {
		receiveBills.add(bill);
		save();
	}

	@Override
	public boolean removeBill(String id) throws RemoteException {
		ReceiveBill po = findBill(id);
		if (po != null) {
			receiveBills.remove(po);
			save();
			System.out.println("成功删除");
			return true;
		} else {
			System.out.println("找不到该单据");
			return false;
		}
	}

	@Override
	public ReceiveBill findBill(String id) throws RemoteException {
		for (ReceiveBill receiveBill : receiveBills) {
			if (receiveBill.getID().equals(id))
				return receiveBill;
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
			oos.writeObject(receiveBills);
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
			receiveBills = (ArrayList<ReceiveBill>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (EOFException e) {
			receiveBills = new ArrayList<ReceiveBill>();
			save();
			load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
}
