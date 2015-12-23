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

	private final String path = "src/dataList/billList/chargeList.dat";
	private ArrayList<ChargeBill> chargeBills;

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
		ChargeBill poInArray = findBill(id);
		if (poInArray != null) {
			chargeBills.remove(poInArray);
			save();
			System.out.println("成功删除");
			return true;
		} else {
			System.out.println("找不到该单据");
			return false;
		}
	}

	@Override
	public ChargeBill findBill(String id) throws RemoteException {
		for (ChargeBill chargeBill : chargeBills) {
			if (chargeBill.getId().equals(id))
				return chargeBill;
		}
		return null;
	}
	
	@Override
	public ArrayList<ChargeBill> findBill(String date, String hallId)
			throws RemoteException {
		ArrayList<ChargeBill> list = new ArrayList<ChargeBill>();
		for (ChargeBill chargeBill : chargeBills) {
			if(chargeBill.getDate().equals(date)&&chargeBill.getHallId().equals(hallId))
				list.add(chargeBill);
		}
		return list;
	}

	@Override
	public ArrayList<ChargeBill> getAll() throws RemoteException {
		return chargeBills;
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
				chargeBills = new ArrayList<ChargeBill>();
				save();
				load();
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



}
