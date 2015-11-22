package Mock_and_Driver.salarybl;

import po.Message;
import businesslogicservice.salaryblservice.salaryServer;

public class salaryDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Message message=new Message();
 
		salaryServer server=new MockSalaryServerImpl();
		server.getSalary(message);
		server.setSalary(message);
	}

}
