package client.blDriver;

import client.businesslogicservice.paymentblservice.paymentServer;
import client.dataservice.systemdataservice.systemDataServer;
import client.vo.BillVO;
import client.vo.Message;

public class paymentblservice_Driver {
	public void driver(paymentServer paymentserver,Message message){
		System.out.println("This is paymentblservice_Driver");
		paymentserver. paymentBillsMake(message) ;
		
		paymentserver.getPaymentHistory("1", "4");
		paymentserver.getEarning();
		paymentserver.export(message);
	}

}
