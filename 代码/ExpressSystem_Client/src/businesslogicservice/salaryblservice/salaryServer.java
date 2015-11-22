package businesslogicservice.salaryblservice;

import po.Message;
import po.SalaryPO;
import vo.SalaryVO;

/**
 * 
 * @author rabook
 *
 */
public interface salaryServer {

	public SalaryPO setSalary(Message message);
	
	public SalaryPO getSalary(Message message);
	
}
