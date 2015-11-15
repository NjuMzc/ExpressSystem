package Mock_and_Driver.salarybl;

import client.businesslogicservice.salaryblservice.salaryServer;
import client.vo.Message;

public class salaryDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Message message=new Message();
 
		salaryServer server=new MockSalaryServerImpl();
		server.getSalary(message);
		server.setSalary(message);
	}

}
