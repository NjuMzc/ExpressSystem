package Mock_and_Driver.accountSetterbl;

import po.Message;
import businesslogicservice.accountSetblservice.accountSetter;

public class AccountSetterDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       accountSetter accountSetter=new MockAccountSetterImpl();
       accountSetter.set(new Message());
	}

}
