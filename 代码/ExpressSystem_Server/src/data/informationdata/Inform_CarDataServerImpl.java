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

import dataservice.informationdataservice.Inform_CarDataServer;
import po.Workers.CarPO;

public class Inform_CarDataServerImpl extends UnicastRemoteObject implements Inform_CarDataServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -530564427569989361L;
	private final String path = "src/dataList/informationList/carList.dat";
	private ArrayList<CarPO> cars;

	public Inform_CarDataServerImpl() throws RemoteException {
		super();
		load();
	}

	@Override
	public void addCar(CarPO car) throws RemoteException {
		cars.add(car);
		save();
	}

	@Override
	public CarPO getCar(String carId) throws RemoteException {
		for (CarPO carPO : cars) {
			if (carPO.getId().equals(carId))
				return carPO;
		}
		return null;
	}

	@Override
	public boolean updateCar(CarPO car) throws RemoteException {
		String id = car.getId();
		CarPO poInArray = getCar(id);
		if (poInArray != null) {
			int index = cars.indexOf(poInArray);
			cars.remove(index);
			cars.add(index, car);
			save();
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteCar(CarPO car) throws RemoteException {
		String id = car.getId();
		CarPO poInArray = getCar(id);
		if (poInArray != null) {
			cars.remove(poInArray);
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
			oos.writeObject(cars);
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
				cars = new ArrayList<CarPO>();
				save();
				load();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(list));
			cars = (ArrayList<CarPO>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (EOFException e) {
			cars = new ArrayList<CarPO>();
			save();
			load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
