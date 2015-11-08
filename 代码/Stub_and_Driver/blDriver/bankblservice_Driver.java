package client.blDriver;

import client.businesslogicservice.bankblservice.bankServer;
import client.vo.Message;

public class bankblservice_Driver {

	 public void drive(bankServer bankserver,Message m){
		 System.out.println("This is bankblservice_Driver ");
	    
		 bankserver.addBank("luo",5.3 );
		 bankserver.removeBank("gf");
		 bankserver.changeBank("sg",m);
		 
	 }
}
