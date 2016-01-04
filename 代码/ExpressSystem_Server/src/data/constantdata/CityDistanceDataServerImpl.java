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

import dataservice.constantdataservice.CityDistanceDataServer;
import po.constants.CityDistancePO;

public class CityDistanceDataServerImpl extends UnicastRemoteObject implements CityDistanceDataServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4130980889191056600L;
	private final String path = "src/dataList/cityDistanceList.dat";
	private ArrayList<CityDistancePO> cityDistances;
	
	public CityDistanceDataServerImpl() throws RemoteException {
		super();
		load();
	}

	@Override
	public void add(CityDistancePO distance) throws RemoteException {
		cityDistances.add(distance);
		save();
	}

	@Override
	public CityDistancePO get(String city1, String city2) throws RemoteException {
		for (CityDistancePO cityDistancePO : cityDistances) {
			if(cityDistancePO.isThis(city1, city2))
				return cityDistancePO;
		}
		return null;
	}

	@Override
	public void update(String city1,String city2,String distance) throws RemoteException {
		CityDistancePO poInArray =get(city1, city2);
		if(poInArray!=null){
			poInArray.setDistance(distance);
			save();
			System.out.println("成功更改");
		}else{
			System.out.println("找不到两城市");
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
			oos.writeObject(cityDistances);
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
				cityDistances = new ArrayList<CityDistancePO>();
				save();
				load();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(list));
			cityDistances = (ArrayList<CityDistancePO>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (EOFException e) {
			cityDistances = new ArrayList<CityDistancePO>();
			save();
			load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<CityDistancePO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
	   
		return cityDistances;
	}
	
}
