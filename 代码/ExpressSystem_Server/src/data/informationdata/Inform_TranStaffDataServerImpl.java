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

import dataservice.informationdataservice.Inform_TranStaffDataServer;
import po.Workers.TranStaffPO;

public class Inform_TranStaffDataServerImpl extends UnicastRemoteObject implements Inform_TranStaffDataServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1181823342321141225L;
	private final String path = "src/dataList/informationList/tranStaffList.dat";
	private ArrayList<TranStaffPO> tranStaffs;

	public Inform_TranStaffDataServerImpl() throws RemoteException {
		super();
		load();
	}

	@Override
	public void addStaff(TranStaffPO staff) throws RemoteException {
		tranStaffs.add(staff);
		save();
	}

	@Override
	public TranStaffPO find(String id) throws RemoteException {
		for (TranStaffPO tranStaffPO : tranStaffs) {
			if (tranStaffPO.getId().equals(id))
				return tranStaffPO;
		}
		return null;
	}

	@Override
	public void deleteStaff(TranStaffPO staff) throws RemoteException {
		String id = staff.getId();
		TranStaffPO poInArray = find(id);
		if (poInArray != null) {
			tranStaffs.remove(poInArray);
			save();
			System.out.println("Deleted");
		} else {
			System.out.println("Not Found");
		}
	}

	@Override
	public void update(TranStaffPO staff) throws RemoteException {
		String id = staff.getId();
		TranStaffPO poInArray = find(id);
		if (poInArray != null) {
			int index = tranStaffs.indexOf(poInArray);
			tranStaffs.remove(index);
			tranStaffs.add(index, staff);
			save();
			System.out.println("Updated");
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
			oos.writeObject(tranStaffs);
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
				tranStaffs = new ArrayList<TranStaffPO>();
				save();
				load();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(list));
			tranStaffs = (ArrayList<TranStaffPO>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (EOFException e) {
			tranStaffs = new ArrayList<TranStaffPO>();
			save();
			load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
