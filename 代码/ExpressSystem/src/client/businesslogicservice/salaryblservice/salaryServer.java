package client.businesslogicservice.salaryblservice;

import client.po.SalaryPO;
import client.vo.Message;
import client.vo.SalaryVO;

/**
 * 
 * @author rabook
 *
 */
public interface salaryServer {

	public SalaryPO setSalary(Message message);
	
	public SalaryPO getSalary(Message message);
	
}
