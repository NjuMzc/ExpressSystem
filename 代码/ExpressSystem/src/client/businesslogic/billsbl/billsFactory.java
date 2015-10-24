package client.businesslogic.billsbl;

import client.businesslogicservice.billsblservice.billMaker;
import client.vo.BillVO;
import client.vo.Message;

public class billsFactory implements billMaker {

	public BillVO makeBill(Message information) {
		// TODO Auto-generated method stub
		BillVO aBill=new BillVO(information);
		return null;
	}

}
