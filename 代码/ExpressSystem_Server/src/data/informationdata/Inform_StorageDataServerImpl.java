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

import dataservice.informationdataservice.Inform_StorageDataServer;
import po.Institution.StoragePO;

public class Inform_StorageDataServerImpl extends UnicastRemoteObject implements Inform_StorageDataServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6519809664263657267L;


	private final String path = "src/dataList/informationList/storageList.dat";
	private ArrayList<StoragePO> storages;

	public Inform_StorageDataServerImpl() throws RemoteException {
		super();
		load();
	}

	@Override
	public void add(StoragePO storage) throws RemoteException {
		storages.add(storage);
		save();
	}

	@Override
	public void update(StoragePO storage) throws RemoteException {
		String id = storage.getID();
		StoragePO poInArray = find(id);
		if (poInArray != null) {
			int index = storages.indexOf(poInArray);
			storages.remove(index);
			storages.add(index, storage);
			save();
			System.out.println("修改成功");
		} else {
			System.out.println("Not Found");
		}
	}

	@Override
	public StoragePO find(String id) throws RemoteException {
		for (StoragePO storagePO : storages) {
			if (storagePO.getID().equals(id))
				return storagePO;
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
			oos.writeObject(storages);
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
				storages = new ArrayList<StoragePO>();
				save();
				load();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(list));
			storages = (ArrayList<StoragePO>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (EOFException e) {
			storages = new ArrayList<StoragePO>();
			save();
			load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
