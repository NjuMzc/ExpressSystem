package Mock_and_Driver.bankbl;

import po.Message;
import vo.BankVO;
import businesslogic.bankbl.Bank;
import businesslogic.bankbl.BankServerImpl;

public class MockBankServerImpl extends BankServerImpl{

	public BankVO addBank(String name, double balance) {
		// TODO Auto-generated method stub
		Bank bank=new MockBank(name,balance);
		System.out.println("Bank is added!");
		return null;
	}

	public boolean removeBank(String name) {
		// TODO Auto-generated method stub
		System.out.println("Bank is removed!");
		return false;
	}

	public void changeBank(String name, Message message) {
		// TODO Auto-generated method stub
       System.out.println("Bank is changed!");
	}

	public BankVO inquireBank(String name) {
		// TODO Auto-generated method stub
		System.out.println("Bank is inquired!");
		return null;
	}

	public void update(String name, double payment) {
		// TODO Auto-generated method stub
		System.out.println("Bank is updated!");

	}
}
