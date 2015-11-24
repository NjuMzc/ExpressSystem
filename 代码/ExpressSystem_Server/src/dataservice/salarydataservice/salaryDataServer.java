package dataservice.salarydataservice;

import po.Message;
import po.SalaryPO;

public interface salaryDataServer {
	
	public SalaryPO find(String id);
	
	public SalaryPO insert(Message message);

}
