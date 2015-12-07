package dataservice.salarydataservice;

import java.rmi.Remote;

import po.salary.SalaryPO;
import po.salary.Staff_Type;

public interface SalaryDataServer extends Remote{

	public SalaryPO getSalary(Staff_Type type);
	
	public void update(SalaryPO po);
}
