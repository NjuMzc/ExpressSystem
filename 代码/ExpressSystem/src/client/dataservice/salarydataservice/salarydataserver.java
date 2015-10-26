package client.dataservice.salarydataservice;

import client.po.SalaryPO;
import client.vo.Message;

public interface salaryDataServer {
	
	public SalaryPO find(String id);
	
	public SalaryPO insert(Message message);

}
