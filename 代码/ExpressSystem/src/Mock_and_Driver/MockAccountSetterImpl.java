package Mock_and_Driver;

import client.businesslogic.accountSetbl.accountSetterImpl;
import client.vo.Message;

public class MockAccountSetterImpl extends accountSetterImpl {

	public void set(Message message) {
		// TODO Auto-generated method stub
    System.out.println("account is set!");
	}
}
