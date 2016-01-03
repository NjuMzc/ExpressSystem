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

import dataservice.accountsetdataservice.BankInformDataServer;
import po.accountSet.BankInform;

public class BankInformDataServerImpl extends UnicastRemoteObject implements BankInformDataServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2628692222926915382L;
	private final String path = "src/dataList/accountSetList/bankInformList.dat";
	private ArrayList<BankInform> bankInform;
	
	public BankInformDataServerImpl() throws RemoteException {
		super();
		load();
	}

	@Override
	public void addInform(BankInform inform) throws RemoteException {
		bankInform.add(inform);
		save();
	}

	@Override
	public ArrayList<BankInform> getInform() throws RemoteException {
		return bankInform;
	}

	@Override
	public void clean() throws RemoteException {
		bankInform.clear();
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
			oos.writeObject(bankInform);
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
				bankInform = new ArrayList<BankInform>();
				save();
				load();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(list));
			bankInform = (ArrayList<BankInform>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (EOFException e) {
			bankInform = new ArrayList<BankInform>();
			save();
			load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}
