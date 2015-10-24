package client.businesslogicservice.salaryblservice;

import client.vo.Message;
import client.vo.SalaryVO;

/**
 * 该接口提供薪水策略制定的服务
 * @author rabook
 *
 */
public interface salaryServer {

	public SalaryVO setSalaty(Message message);
	
	public SalaryVO getSalaty(Message message);
	
}
