package data.billdata;

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

import dataservice.billsdataservice.BillApproverDataServer;
import po.bills.BillApproverList;

public class BillApproverDataServerImpl extends UnicastRemoteObject implements BillApproverDataServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8416244365960449257L;
	private final String path = "src/dataList/billList/approverList.dat";
	private BillApproverList billApprovers;

	public BillApproverDataServerImpl() throws RemoteException {
		super();
		load();
	}

	@Override
	public BillApproverList get() throws RemoteException {
		return billApprovers==null? null:billApprovers;
	}

	@Override
	public void update(BillApproverList list) throws RemoteException {
		billApprovers = list;
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
			oos.writeObject(billApprovers);
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
				billApprovers = new BillApproverList();
				save();
				load();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(list));
			billApprovers = (BillApproverList) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (EOFException e) {
			billApprovers = new BillApproverList();
			save();
			load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}
