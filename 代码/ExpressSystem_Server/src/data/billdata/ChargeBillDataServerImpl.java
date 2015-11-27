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

import dataservice.billsdataservice.ChargeBillDataServer;
import po.bills.ChargeBill;

public class ChargeBillDataServerImpl extends UnicastRemoteObject implements ChargeBillDataServer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2224265360684397199L;

	final String path = "src/dataList/billList/chargeList.dat";
	ArrayList<ChargeBill> chargeBills;

	public ChargeBillDataServerImpl() throws RemoteException {
		super();
		load();
	}

	@Override
	public void addBill(ChargeBill bill) throws RemoteException {
		chargeBills.add(bill);
		save();
	}

	@Override
	public boolean removeBill(String id) throws RemoteException {
		
		return false;
	}

	@Override
	public ChargeBill findBill(String id) throws RemoteException {
		
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
			oos.writeObject(chargeBills);
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
			chargeBills = (ArrayList<ChargeBill>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (EOFException e) {
			chargeBills = new ArrayList<ChargeBill>();
			save();
			load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		try {
			ChargeBillDataServerImpl a = new ChargeBillDataServerImpl();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
