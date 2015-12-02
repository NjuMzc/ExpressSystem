package data.transportdata;

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

import dataservice.transportdataservice.TransportDataServer;
import po.GoodPO;

public class TransportDataServerImpl extends UnicastRemoteObject implements TransportDataServer {
	private final String path = "src/dataList/goodList.dat";
	private ArrayList<GoodPO> goods;

	public TransportDataServerImpl() throws RemoteException {
		super();
		load();
	}

	@Override
	public void insert(GoodPO po) throws RemoteException {
		goods.add(po);
		save();
	}

	@Override
	public void update(GoodPO po) throws RemoteException {
		String id = po.getID();
		GoodPO poInArray = find(id);
		if (poInArray != null) {
			int index = goods.indexOf(poInArray);
			goods.remove(index);
			goods.add(index, po);
			save();
			System.out.println("成功更改");
		} else {
			System.out.println("找不到该货物");
		}
	}

	@Override
	public GoodPO find(String id) throws RemoteException {
		for (GoodPO goodPO : goods) {
			if (goodPO.getID().equals(id))
				return goodPO;
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
			oos.writeObject(goods);
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
			goods = (ArrayList<GoodPO>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (EOFException e) {
			goods = new ArrayList<GoodPO>();
			save();
			load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
