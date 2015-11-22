package Mock_and_Driver.constantbl;

import po.ConstantPO;
import po.Message;
import businesslogic.constantbl.constantServerImpl;

public class MockConstantServerImpl extends constantServerImpl{

	public ConstantPO setConstant(Message message) {
		// TODO Auto-generated method stub
		System.out.println("Constant is set!");
		return null;
	}

	public ConstantPO getConstant(String name) {
		// TODO Auto-generated method stub
		System.out.println("Constant is got!");
		return null;
	}
}
