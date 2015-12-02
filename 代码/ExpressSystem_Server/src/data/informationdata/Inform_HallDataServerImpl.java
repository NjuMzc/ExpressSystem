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

import dataservice.informationdataservice.Inform_HallDataServer;
import po.Institution.HallPO;

public class Inform_HallDataServerImpl extends UnicastRemoteObject implements Inform_HallDataServer {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2769537207813564932L;
	private final String path = "src/dataList/informationList/hallList.dat";
	private ArrayList<HallPO> halls;

	public Inform_HallDataServerImpl() throws RemoteException {
		super();
		load();
	}

	@Override
	public void addHall(HallPO hall) throws RemoteException {
		halls.add(hall);
		save();
	}

	@Override
	public HallPO find(String id) throws RemoteException {
		for (HallPO hallPO : halls) {
			if(hallPO.getID().equals(id))
				return hallPO;
		}
		return null;
	}

	@Override
	public void deleteHall(HallPO hall) throws RemoteException {
		String id = hall.getID();
		HallPO poInArray= find(id);
		if(poInArray!=null){
			halls.remove(poInArray);
			save();
			System.out.println("成功删除");
		}else{
			System.out.println("找不到该机构");
		}
	}

	@Override
	public void updateHall(HallPO hall) throws RemoteException {
		String id = hall.getID();
		HallPO poInArray = find(id);
		if(poInArray!=null){
			int index = halls.indexOf(poInArray);
			halls.remove(index);
			halls.add(index, hall);
			save();
			System.out.println("成功更改");
		}else{
			System.out.println("找不到该机构");
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
			oos.writeObject(halls);
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
			halls = (ArrayList<HallPO>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (EOFException e) {
			halls = new ArrayList<HallPO>();
			save();
			load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	

}
