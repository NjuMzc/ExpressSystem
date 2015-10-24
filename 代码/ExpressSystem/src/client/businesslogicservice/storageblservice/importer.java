package client.businesslogicservice.storageblservice;

import client.vo.Bill;
import client.vo.Message;

public interface importer {
        
	public Bill importe(Message message);
	
}
