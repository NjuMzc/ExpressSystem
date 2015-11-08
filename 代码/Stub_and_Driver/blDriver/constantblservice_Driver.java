package client.blDriver;

import client.businesslogicservice.constantblservice.constantServer;
import client.vo.Message;

public class constantblservice_Driver {

	public void drive(constantServer c, Message m) {
		System.out.println("This is constantblservice_Driver");

		c.getConstant("d");
		c.setConstant(m);
	}
}
