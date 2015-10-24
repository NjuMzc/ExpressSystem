package client.businesslogicservice.paymentblservice;

import client.vo.Bill;
import client.vo.Message;

public interface charger {
	
	public Bill charge(Message message);

}
