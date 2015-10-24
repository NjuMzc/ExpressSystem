package client.businesslogicservice.transportblservice;

import client.vo.Bill;
import client.vo.Message;


public interface finisher  {

	public Bill finish(Message message);
	
}
