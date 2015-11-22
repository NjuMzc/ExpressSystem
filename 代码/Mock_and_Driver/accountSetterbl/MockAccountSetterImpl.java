package Mock_and_Driver.accountSetterbl;

import po.Message;
import businesslogic.accountSetbl.accountSetterImpl;

public class MockAccountSetterImpl extends accountSetterImpl {

	public void set(Message message) {
		// TODO Auto-generated method stub
    System.out.println("account is set!");
	}
}
