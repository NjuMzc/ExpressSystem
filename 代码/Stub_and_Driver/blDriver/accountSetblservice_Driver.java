package client.blDriver;

import client.blStub.accountSetbl_Stub;
import client.businesslogicservice.accountSetblservice.accountSetter;
import client.vo.Message;

public class accountSetblservice_Driver {

	public void drive(accountSetter accountSetter,Message message) {

		System.out.println("This is accountSetblservice_Driver");
		accountSetter.setAccount(message);
	}
 

}
