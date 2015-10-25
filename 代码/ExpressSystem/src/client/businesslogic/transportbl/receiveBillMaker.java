package client.businesslogic.transportbl;

import client.businesslogic.billsbl.receiveBillFactory;
import client.businesslogic.billsbl.receiveBillVO;
import client.businesslogicservice.transportblservice.transportBillsMaker;
import client.vo.BillVO;
import client.vo.Message;

public class receiveBillMaker implements transportBillsMaker{

	public BillVO makeTransBill(Message message) {
		// TODO Auto-generated method stub
		System.out.println("我是逻辑层中的处理收件单录入的方法，我利用单据中的方法新建了一个收件单并更新了货物状态！");
		receiveBillFactory factory=new receiveBillFactory();
		receiveBillVO Bill=(receiveBillVO) factory.makeBill(message);
		

		return Bill;
	}

}
