package client.businesslogicservice.paymentblservice;

import client.vo.Bill;
import client.vo.Message;

public interface payer {
	
	public Bill pay(Message message);

}
