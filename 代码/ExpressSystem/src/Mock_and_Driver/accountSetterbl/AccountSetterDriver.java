package Mock_and_Driver.accountSetterbl;

import client.businesslogicservice.accountSetblservice.accountSetter;
import client.vo.Message;

public class AccountSetterDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       accountSetter accountSetter=new MockAccountSetterImpl();
       accountSetter.set(new Message());
	}

}
