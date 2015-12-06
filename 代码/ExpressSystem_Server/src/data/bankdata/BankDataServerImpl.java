package data.bankdata;

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

import dataservice.bankdataservice.BankDataServer;
import po.BankPO;

public class BankDataServerImpl extends UnicastRemoteObject implements BankDataServer {
	private final String path="src/dataList/bankList.dat";
	private ArrayList<BankPO> banks;
	public BankDataServerImpl() throws RemoteException{
		super();
		load();
	}

	public BankPO find(String id) throws RemoteException {
		for (BankPO bankPO : banks) {
			if(bankPO.getid().equals(id))
				return bankPO;
		}
		return null;
	}

	public void insert(BankPO po) throws RemoteException {
		banks.add(po);
		save();
	}

	public void delete(BankPO po) throws RemoteException {
		String id = po.getid();
		BankPO poInArray =find(id);
		if(poInArray!=null){
			banks.remove(poInArray);
			save();
			System.out.println("成功删除");
		}else{
			System.out.println("找不到该账户");
		}
	}

	public void update(BankPO po) throws RemoteException {
		String id = po.getid();
		BankPO poInArray = find(id);
		if(poInArray!=null){
			int index =banks.indexOf(poInArray);
			banks.remove(index);
			banks.add(index, po);
			save();
			System.out.println("成功更改");
		}else{
			System.out.println("找不到该账户");
		}
	}

	@Override
	public ArrayList getAllBank() throws RemoteException {
		return banks;
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
			oos.writeObject(banks);
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
				banks = new ArrayList<BankPO>();
				save();
				load();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(list));
			banks = (ArrayList<BankPO>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (EOFException e) {
			banks = new ArrayList<BankPO>();
			save();
			load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}
