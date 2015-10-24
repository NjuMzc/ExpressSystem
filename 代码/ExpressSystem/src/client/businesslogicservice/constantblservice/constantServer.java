package client.businesslogicservice.constantblservice;

import client.vo.ConstantVO;
import client.vo.Message;

/**
 * 该接口提供常量制定的服务
 * @author rabook
 *
 */
public interface constantServer {

	public ConstantVO setConstant(Message message);
	
	public ConstantVO getConstant(String name);
	
}
