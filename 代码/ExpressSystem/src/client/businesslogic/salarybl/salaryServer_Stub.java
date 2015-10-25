package client.businesslogic.salarybl;

import client.businesslogicservice.salaryblservice.salaryServer;
import client.vo.Message;
import client.vo.SalaryVO;

public class salaryServer_Stub implements salaryServer {

	public SalaryVO setSalary(Message message) {
		// TODO Auto-generated method stub
		System.out.println("Salary is set");
		return null;
	}

	public SalaryVO getSalary(Message message) {
		// TODO Auto-generated method stub
		System.out.println("Salary is got");
		return null;
	}

}
