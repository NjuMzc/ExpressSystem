package data.constantdata;

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

import dataservice.constantdataservice.PriceListDataServer;
import po.GoodPO;
import po.constants.PriceListPO;

public class PriceListDataServerImpl extends UnicastRemoteObject implements PriceListDataServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6519227197989532233L;
	private final String path = "src/dataList/priceList.dat";
	private PriceListPO priceList;

	public PriceListDataServerImpl() throws RemoteException {
		super();
		load();
	}

	@Override
	public PriceListPO get() throws RemoteException {
		return priceList == null ? null : priceList;
	}

	@Override
	public void update(PriceListPO priceList) throws RemoteException {
		this.priceList=priceList;
		save();
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
			oos.writeObject(priceList);
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
				priceList = new PriceListPO();
				save();
				load();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(list));
			priceList = (PriceListPO) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (EOFException e) {
			priceList = new PriceListPO();
			save();
			load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
