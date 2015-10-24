package client.businesslogic.billsbl;

import client.businesslogicservice.billsblservice.billMaker;
import client.vo.Bill;
import client.vo.Information;

public class billsFactory implements billMaker {

	public Bill makeBill(Information information) {
		// TODO Auto-generated method stub
		Bill aBill=new Bill(information);
		return null;
	}

}
