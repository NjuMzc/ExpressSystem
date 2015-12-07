package dataservice.salarydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.salary.SalaryPO;
import po.salary.Staff_Type;

public interface SalaryDataServer extends Remote{

	public SalaryPO getSalary(Staff_Type type) throws RemoteException;
	
	public void update(SalaryPO po)throws RemoteException;
}
