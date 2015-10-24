package client.businesslogicservice.transportblservice;

import client.vo.Bill;
import client.vo.Message;

public interface sender {
 
	public Bill send(Message message);
	
}
