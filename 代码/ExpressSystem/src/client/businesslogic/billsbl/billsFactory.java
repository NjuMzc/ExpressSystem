package client.businesslogic.billsbl;

import client.businesslogicservice.billsblservice.billMaker;
import client.vo.Bill;
import client.vo.Message;

public class billsFactory implements billMaker {

	public Bill makeBill(Message information) {
		// TODO Auto-generated method stub
		Bill aBill=new Bill(information);
		return null;
	}

}
