package Mock_and_Driver;

import client.businesslogic.salarybl.salaryServerImpl;
import client.po.SalaryPO;
import client.vo.Message;

public class MockSalaryServerImpl extends salaryServerImpl {

	public SalaryPO setSalary(Message message) {
		// TODO Auto-generated method stub
		System.out.println("Salary is set!");
		return null;
	}

	public SalaryPO getSalary(Message message) {
		// TODO Auto-generated method stub
		System.out.println("Salary is got!");
		return null;
	}
}
