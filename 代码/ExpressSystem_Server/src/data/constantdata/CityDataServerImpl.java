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
import java.util.Iterator;

import dataservice.constantdataservice.CityDataServer;
import po.CityPO;

public class CityDataServerImpl extends UnicastRemoteObject implements CityDataServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2960540795140176144L;
	private final String path = "src/dataList/cityList.dat";
	private ArrayList<CityPO> cities;

	public CityDataServerImpl() throws RemoteException {
		super();
		load();
	}

	@Override
	public void addCity(CityPO city) throws RemoteException {
		cities.add(city);
		save();
	}

	@Override
	public CityPO getById(String id) throws RemoteException {
		for (CityPO cityPO : cities) {
			if(cityPO.getId().equals(id))
				return cityPO;
		}
		return null;
	}

	@Override
	public CityPO getByName(String name) throws RemoteException {
		for (CityPO cityPO : cities) {
			if(cityPO.getName().equals(name))
				return cityPO;
		}
		return null;
	}

	@Override
	public boolean remove(CityPO city) throws RemoteException {
		String id = city.getId();
		CityPO poInArray =getById(id);
		if(poInArray!=null){
			cities.remove(poInArray);
			save();
			return true;
		}
		return false;
	}

	@Override
	public void update(CityPO city) throws RemoteException {
		String id = city.getId();
		CityPO poInArray =getById(id);
		if(poInArray!=null){
			int index = cities.indexOf(poInArray);
			cities.remove(poInArray);
			cities.add(index, city);
			save();
		}

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
			oos.writeObject(cities);
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
				cities = new ArrayList<CityPO>();
				save();
				load();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(list));
			cities = (ArrayList<CityPO>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (EOFException e) {
			cities = new ArrayList<CityPO>();
			save();
			load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<CityPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		
		
		return cities;
	}

}
