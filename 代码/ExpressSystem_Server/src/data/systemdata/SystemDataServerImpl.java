package data.systemdata;

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

import dataservice.systemdataservice.SystemDataServer;
import po.SystemUserPO;

public class SystemDataServerImpl extends UnicastRemoteObject implements SystemDataServer {
	private final String path = "src/dataList/userList.dat";
	private ArrayList<SystemUserPO> users;

	public SystemDataServerImpl() throws RemoteException {
		super();
		load();
	}

	public SystemUserPO find(String id) throws RemoteException {
		for (SystemUserPO po : users) {
			if (po.getID().equals(id))
				return po;
		}
		return null;
	}

	public void insert(SystemUserPO po) throws RemoteException {
		users.add(po);
		save();
	}

	public void delete(SystemUserPO po) throws RemoteException {
		String id = po.getID();
		SystemUserPO poInArray = find(id);
		if (poInArray != null) {
			int index = users.indexOf(poInArray);
			users.remove(index);
			System.out.println("成功删除");
			save();
		} else {
			System.out.println("找不到该用户");
		}
	}

	public void update(SystemUserPO po) throws RemoteException {
		String id = po.getID();
		SystemUserPO poInArray = find(id);
		if (poInArray != null) {
			int index = users.indexOf(poInArray);
			users.remove(index);
			users.add(index, po);
			System.out.println("成功更改");
			save();

		} else {
			System.out.println("找不到该用户");

		}
	}

	public int getUserNum() throws RemoteException {
		return users.size();
	}

	@Override
	public ArrayList getAllUsers() throws RemoteException {
		return users;
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
			oos.writeObject(users);
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
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(list));
			users = (ArrayList<SystemUserPO>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (EOFException e) {
			users = new ArrayList<SystemUserPO>();
			save();
			load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
