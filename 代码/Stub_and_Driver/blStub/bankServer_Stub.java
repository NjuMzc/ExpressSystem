package client.blStub;

import client.businesslogicservice.bankblservice.bankServer;
import client.vo.BankVO;
import client.vo.Message;

public class bankServer_Stub implements bankServer {

	public BankVO addBank(String name, double balance) {
		// TODO Auto-generated method stub
		System.out.println("Bank is add");
		return null;
	}

	public boolean removeBank(String name) {
		// TODO Auto-generated method stub
		System.out.println("Bank is removed");
		return false;
	}

	public void changeBank(String name, Message message) {
		// TODO Auto-generated method stub
		System.out.println("Bank is changed");

	}

	public BankVO inquireBank(String name) {
		// TODO Auto-generated method stub
		System.out.println("Bank is inquired");
		return null;
	}

}
