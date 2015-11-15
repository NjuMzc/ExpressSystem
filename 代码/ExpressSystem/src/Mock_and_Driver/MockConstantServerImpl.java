package Mock_and_Driver;

import client.po.ConstantPO;
import client.vo.Message;

public class MockConstantServerImpl {

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
