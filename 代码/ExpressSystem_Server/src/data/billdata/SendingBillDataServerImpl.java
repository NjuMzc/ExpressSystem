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

import dataservice.billsdataservice.SendingBillDataServer;
import po.bills.SendingBill;

public class SendingBillDataServerImpl extends UnicastRemoteObject implements SendingBillDataServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 768885588431007648L;
	private final String path = "src/dataList/billList/sendingList.dat";
	private ArrayList<SendingBill> sendingBills;

	public SendingBillDataServerImpl() throws RemoteException {
		super();
		load();
	}

	@Override
	public void addBill(SendingBill bill) throws RemoteException {
		sendingBills.add(bill);
		save();
	}

	@Override
	public boolean removeBill(String id) throws RemoteException {
		SendingBill poInArray = findBill(id);
		if (poInArray != null) {
			sendingBills.remove(poInArray);
			save();
			System.out.println("成功删除");
			return true;
		}
		System.out.println("找不到该单据");
		return false;
	}

	@Override
	public SendingBill findBill(String id) throws RemoteException {
		for (SendingBill sendingBill : sendingBills) {
			if (sendingBill.getID().equals(id))
				return sendingBill;
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
			oos.writeObject(sendingBills);
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
				sendingBills = new ArrayList<SendingBill>();
				save();
				load();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(list));
			sendingBills = (ArrayList<SendingBill>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (EOFException e) {
			sendingBills = new ArrayList<SendingBill>();
			save();
			load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
