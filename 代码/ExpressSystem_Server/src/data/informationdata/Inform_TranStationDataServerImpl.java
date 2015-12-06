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

import dataservice.informationdataservice.Inform_TranStationDataServer;
import po.Institution.TranStationPO;
import po.Workers.TranStaffPO;

public class Inform_TranStationDataServerImpl extends UnicastRemoteObject implements Inform_TranStationDataServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9014538512641697085L;

	private final String path = "src/dataList/informationList/tranStationList.dat";
	private ArrayList<TranStationPO> tranStations;
	public Inform_TranStationDataServerImpl() throws RemoteException {
		super();
		load();
	}

	@Override
	public void addTranStation(TranStationPO station) throws RemoteException {
		tranStations.add(station);
		save();
	}

	@Override
	public TranStationPO find(String id) throws RemoteException {
		for (TranStationPO tranStationPO : tranStations) {
			if(tranStationPO.getID().equals(id))
				return tranStationPO;
		}
		return null;
	}

	@Override
	public void update(TranStationPO station) throws RemoteException {
		String id= station.getID();
		TranStationPO poInArray = find(id);
		if(poInArray!=null){
			int index = tranStations.indexOf(poInArray);
			tranStations.remove(index);
			tranStations.add(index, station);
			save();
			System.out.println("Updated");
		}else{
			System.out.println("Nou Found");
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
			oos.writeObject(tranStations);
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
				tranStations = new ArrayList<TranStationPO>();
				save();
				load();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(list));
			tranStations = (ArrayList<TranStationPO>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (EOFException e) {
			tranStations = new ArrayList<TranStationPO>();
			save();
			load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
