package Mock_and_Driver.bankbl;

import client.businesslogicservice.bankblservice.bankServer;
import client.vo.Message;

public class bankDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Message msg=new Message();
        bankServer bankServer=new  MockBankServerImpl();
        bankServer.addBank("110", 10.5);
        bankServer.changeBank("110",msg);
        bankServer.inquireBank("110");
        bankServer.update("110", 10);
	}

}
