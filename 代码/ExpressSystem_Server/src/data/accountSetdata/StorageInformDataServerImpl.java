package data.accountSetdata;

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

import dataservice.accountsetdataservice.StorageInformDataServer;
import po.accountSet.StorageInform;

public class StorageInformDataServerImpl extends UnicastRemoteObject implements StorageInformDataServer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2426548623624141629L;
	private final String path = "src/dataList/accountSetList/storageInformList.dat";
	private ArrayList<StorageInform> storageInform;

	public StorageInformDataServerImpl() throws RemoteException {
		super();
		load();
	}

	@Override
	public void addInform(StorageInform inform) throws RemoteException {
		storageInform.add(inform);
		save();
	}

	@Override
	public ArrayList<StorageInform> getInform() throws RemoteException {
		return storageInform;
	}

	@Override
	public void clean() throws RemoteException {
		storageInform.clear();
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
			oos.writeObject(storageInform);
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
				storageInform = new ArrayList<StorageInform>();
				save();
				load();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(list));
			storageInform = (ArrayList<StorageInform>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (EOFException e) {
			storageInform = new ArrayList<StorageInform>();
			save();
			load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
