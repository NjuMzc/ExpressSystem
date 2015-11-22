package businesslogicservice.constantblservice;

import po.ConstantPO;
import po.Message;
import vo.ConstantVO;

/**
 * 
 * @author rabook
 *
 */
public interface constantServer {

	public ConstantPO setConstant(Message message);
	
	public ConstantPO getConstant(String name);
	
}
