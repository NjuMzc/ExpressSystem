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

import dataservice.informationdataservice.Inform_KeeperDataServer;
import po.Workers.StorageKeeperPO;

public class Inform_KeeperDataServerImpl extends UnicastRemoteObject implements Inform_KeeperDataServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5162741849380741398L;

	private final String path = "src/dataList/informationList/keeperList.dat";
	private ArrayList<StorageKeeperPO> keepers;

	public Inform_KeeperDataServerImpl() throws RemoteException {
		super();
		load();
	}

	@Override
	public StorageKeeperPO find(String id) throws RemoteException {
		for (StorageKeeperPO keeper : keepers) {
			if (keeper.getID().equals(id))
				return keeper;
		}
		return null;
	}

	@Override
	public void addKeeper(StorageKeeperPO keeper) throws RemoteException {
		keepers.add(keeper);
		save();
	}

	@Override
	public void deleteKeeper(StorageKeeperPO keeper) throws RemoteException {
		String id = keeper.getID();
		StorageKeeperPO poInArray = find(id);
		if (poInArray != null) {
			keepers.remove(poInArray);
			save();
			System.out.println("删除成功");
		} else {
			System.out.println("Not Found");
		}
	}

	@Override
	public void update(StorageKeeperPO keeper) throws RemoteException {
		String id = keeper.getID();
		StorageKeeperPO poInArray = find(id);
		if (poInArray != null) {
			int index = keepers.indexOf(poInArray);
			keepers.remove(index);
			keepers.add(index, keeper);
			save();
			System.out.println("修改成功");
		} else {
			System.out.println("Not Found");
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
			oos.writeObject(keepers);
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
				keepers = new ArrayList<StorageKeeperPO>();
				save();
				load();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(list));
			keepers = (ArrayList<StorageKeeperPO>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (EOFException e) {
			keepers = new ArrayList<StorageKeeperPO>();
			save();
			load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
