package data.informationdata;

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

import dataservice.informationdataservice.Inform_DriverDataServer;
import po.Workers.DriverPO;

public class Inform_DriverDataServerImpl extends UnicastRemoteObject implements Inform_DriverDataServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2898212287845356414L;
	private final String path = "src/dataList/informationList/driverList.dat";
	private ArrayList<DriverPO> drivers;

	public Inform_DriverDataServerImpl() throws RemoteException {
		super();
		load();
	}

	@Override
	public void addDriver(DriverPO driver) throws RemoteException {
		drivers.add(driver);
		save();

	}

	@Override
	public DriverPO getDriver(String driverId) throws RemoteException {
		for (DriverPO driverPO : drivers) {
			if (driverPO.getId().equals(driverId))
				return driverPO;
		}
		return null;
	}

	@Override
	public boolean updateDriver(DriverPO driver) throws RemoteException {
		String id = driver.getId();
		DriverPO poInArray = getDriver(id);
		if (poInArray != null) {
			int index = drivers.indexOf(poInArray);
			drivers.remove(index);
			drivers.add(index, driver);
			save();
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteDriver(DriverPO driver) throws RemoteException {
		String id = driver.getId();
		DriverPO poInArray = getDriver(id);
		if (poInArray != null) {
			drivers.remove(poInArray);
			save();
			return true;
		}
		return false;
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
			oos.writeObject(drivers);
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
				drivers = new ArrayList<DriverPO>();
				save();
				load();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(list));
			drivers = (ArrayList<DriverPO>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (EOFException e) {
			drivers = new ArrayList<DriverPO>();
			save();
			load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
