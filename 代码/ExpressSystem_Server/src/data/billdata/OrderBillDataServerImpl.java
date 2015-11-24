package data.billdata;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataservice.billsdataservice.OrderBillDataServer;
import po.Message;
import po.SystemUserPO;
import po.bills.OrderBill;

public class OrderBillDataServerImpl extends UnicastRemoteObject implements OrderBillDataServer {
	final String path = "src/dataList/billList/orderList.dat";
	private ArrayList<OrderBill> orderBills;

	public OrderBillDataServerImpl() throws RemoteException {
		super();
		load();
	}

	@Override
	public void addBill(OrderBill bill) throws RemoteException {
		orderBills.add(bill);
		save();
	}

	@Override
	public boolean removeBill(String id) throws RemoteException {
		OrderBill po = findBill(id);
		if (po != null) {
			orderBills.remove(po);
			save();
			System.out.println("成功删除");
			return true;
		} else {
			System.out.println("找不到该单据");
			return false;
		}
	}

	@Override
	public OrderBill findBill(String id) throws RemoteException {
		for (OrderBill orderBill : orderBills) {
			if (orderBill.getID().equals(id))
				return orderBill;
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
			oos.writeObject(orderBills);
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
			orderBills = (ArrayList<OrderBill>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (EOFException e) {
			orderBills = new ArrayList<OrderBill>();
			save();
			load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/*
	 * 测试用后期删除
	 */
	public void print() {
		for (OrderBill orderBill : orderBills) {
			System.out.println(orderBill.getSenderName());
		}
	}
	
	public static void main(String[] args) {
		try {
			OrderBillDataServerImpl a = new OrderBillDataServerImpl();
			a.addBill(new OrderBill(new Message()));
			a.print();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
