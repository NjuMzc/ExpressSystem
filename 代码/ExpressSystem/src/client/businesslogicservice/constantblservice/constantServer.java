package client.businesslogicservice.constantblservice;

import client.po.ConstantPO;
import client.vo.ConstantVO;
import client.vo.Message;

/**
 * 
 * @author rabook
 *
 */
public interface constantServer {

	public ConstantPO setConstant(Message message);
	
	public ConstantPO getConstant(String name);
	
}
