package data.salarydata;

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

import dataservice.salarydataservice.SalaryDataServer;
import po.salary.SalaryPO;
import po.salary.Staff_Type;

public class SalaryDataServerImpl extends UnicastRemoteObject implements SalaryDataServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4421890721298011275L;
	private final String path = "src/dataList/salaryList.dat";
	private ArrayList<SalaryPO> salaries;
	
	public SalaryDataServerImpl() throws RemoteException {
		super();
		load();
	}

	@Override
	public SalaryPO getSalary(Staff_Type type) throws RemoteException {
		for (SalaryPO salaryPO : salaries) {
			if(salaryPO.getStaffType().equals(type))
				return salaryPO;
		}
		return null;
	}

	@Override
	public void update(SalaryPO po) throws RemoteException {
		Staff_Type type = po.getStaffType();
		SalaryPO poInArray = getSalary(type);
		if(poInArray!=null){
			int index = salaries.indexOf(poInArray);
			salaries.remove(index);
			salaries.add(index, po);
			save();
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
			oos.writeObject(salaries);
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
				salaries = new ArrayList<SalaryPO>();
				salaries.add(new SalaryPO(Staff_Type.MANAGER));
				salaries.add(new SalaryPO(Staff_Type.ACCOUNTANT));
				salaries.add(new SalaryPO(Staff_Type.COURIER));
				salaries.add(new SalaryPO(Staff_Type.BUSINESSMAN));
				salaries.add(new SalaryPO(Staff_Type.TRANSMAN));
				salaries.add(new SalaryPO(Staff_Type.STORAGE_MANAGER));
				salaries.add(new SalaryPO(Staff_Type.SYSTEM_MANAGER));
				save();
				load();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(list));
			salaries = (ArrayList<SalaryPO>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
			e.printStackTrace();
		} catch (EOFException e) {
			salaries = new ArrayList<SalaryPO>();
			salaries.add(new SalaryPO(Staff_Type.MANAGER));
			salaries.add(new SalaryPO(Staff_Type.ACCOUNTANT));
			salaries.add(new SalaryPO(Staff_Type.COURIER));
			salaries.add(new SalaryPO(Staff_Type.BUSINESSMAN));
			salaries.add(new SalaryPO(Staff_Type.TRANSMAN));
			salaries.add(new SalaryPO(Staff_Type.STORAGE_MANAGER));
			salaries.add(new SalaryPO(Staff_Type.SYSTEM_MANAGER));
			save();
			load();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}
