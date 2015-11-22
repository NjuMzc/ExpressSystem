package Mock_and_Driver.salarybl;

import po.Message;
import po.SalaryPO;
import businesslogic.salarybl.salaryServerImpl;

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
