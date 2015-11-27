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

import dataservice.informationdataservice.Inform_HallStaffDataServer;
import po.Institution.HallPO;
import po.Workers.HallStaffPO;

public class Inform_HallStaffDataServerImpl extends UnicastRemoteObject implements Inform_HallStaffDataServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3944464479342626181L;
	final String path = "src/dataList/informationList/hallStaffList.dat";
	ArrayList<HallStaffPO> hallStaffs;
	public Inform_HallStaffDataServerImpl() throws RemoteException {
		super();
		load();
	}

	@Override
	public void addStaff(HallStaffPO staff) throws RemoteException {
		hallStaffs.add(staff);
		save();
	}

	@Override
	public HallStaffPO find(String id) throws RemoteException {
		for (HallStaffPO hallStaffPO : hallStaffs) {
			if(hallStaffPO.getId().equals(id))
				return hallStaffPO;
		}
		return null;
	}

	@Override
	public void deleteStaff(HallStaffPO staff) throws RemoteException {
		String id = staff.getId();
		HallStaffPO poInArray = find(id);
		if(poInArray!=null){
			hallStaffs.remove(poInArray);
			save();
			System.out.println("成功删除");
		}else{
			System.out.println("找不到该员工");
		}
	}

	@Override
	public void update(HallStaffPO staff) throws RemoteException {
		String id = staff.getId();
		HallStaffPO poInArray = find(id);
		if(poInArray!=null){
			int index = hallStaffs.indexOf(poInArray);
			hallStaffs.remove(index);
			hallStaffs.add(index,staff);
			save();
			System.out.println("成功更改");
		}else{
			System.out.println("找不到该员工");
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
			oos.writeObject(hallStaffs);
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
			hallStaffs = (ArrayList<HallStaffPO>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (EOFException e) {
			hallStaffs = new ArrayList<HallStaffPO>();
			save();
			load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	

}
