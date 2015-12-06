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

import dataservice.billsdataservice.PaymentBillDataServer;
import po.bills.PaymentBill;

public class PaymentBillDataServerImpl extends UnicastRemoteObject implements PaymentBillDataServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1705841743928311161L;
	private final String path = "src/dataList/billList/paymentList.dat";
	private ArrayList<PaymentBill> paymentBills;

	public PaymentBillDataServerImpl() throws RemoteException {
		super();
		load();
	}

	@Override
	public void addBill(PaymentBill bill) throws RemoteException {
		paymentBills.add(bill);
		save();
	}

	@Override
	public boolean removeBill(String id) throws RemoteException {
		PaymentBill poInArray = findBill(id);
		if (poInArray != null) {
			paymentBills.remove(poInArray);
			save();
			System.out.println("成功删除");
		}
		System.out.println("找不到该单据");
		return false;
	}

	@Override
	public PaymentBill findBill(String id) throws RemoteException {
		for (PaymentBill paymentBill : paymentBills) {
			if (paymentBill.getId().equals(id))
				return paymentBill;
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
			oos.writeObject(paymentBills);
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
				paymentBills = new ArrayList<PaymentBill>();
				save();
				load();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(list));
			paymentBills = (ArrayList<PaymentBill>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (EOFException e) {
			paymentBills = new ArrayList<PaymentBill>();
			save();
			load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
