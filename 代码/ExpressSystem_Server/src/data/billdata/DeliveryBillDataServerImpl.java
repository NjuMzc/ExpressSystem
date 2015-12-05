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

import dataservice.billsdataservice.DeliveryBillDataServer;
import po.bills.DeliveryBill;

public class DeliveryBillDataServerImpl extends UnicastRemoteObject implements DeliveryBillDataServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2002233704170163232L;
	private final String path = "src/dataList/billList/deliveryList.dat";
	private ArrayList<DeliveryBill> deliveryBills;

	public DeliveryBillDataServerImpl() throws RemoteException {
		super();
		load();

	}

	@Override
	public void addBill(DeliveryBill bill) throws RemoteException {
		deliveryBills.add(bill);
		save();
	}

	@Override
	public boolean removeBill(String id) throws RemoteException {
		DeliveryBill poInArray = findBill(id);
		if (poInArray != null) {
			deliveryBills.remove(poInArray);
			save();
			System.out.println("成功删除");
			return true;
		}
		System.out.println("找不到该单据");
		return false;
	}

	@Override
	public DeliveryBill findBill(String id) throws RemoteException {
		for (DeliveryBill deliveryBill : deliveryBills) {
			if (deliveryBill.getId().equals(id))
				return deliveryBill;
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
			oos.writeObject(deliveryBills);
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
			deliveryBills = (ArrayList<DeliveryBill>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (EOFException e) {
			deliveryBills = new ArrayList<DeliveryBill>();
			save();
			load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
