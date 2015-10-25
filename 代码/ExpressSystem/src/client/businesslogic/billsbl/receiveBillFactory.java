package client.businesslogic.billsbl;

import client.businesslogicservice.billsblservice.billMaker;
import client.vo.BillVO;
import client.vo.Message;

public class receiveBillFactory implements billMaker{

	public BillVO makeBill(Message message) {
		// TODO Auto-generated method stub
		receiveBillVO bill=new receiveBillVO(message);
		System.out.println("我是逻辑层中新建订单的工厂，我新建了一个订单并把它储存到了数据层中！");
		this.update(bill);
		return bill;
	}
	
	public void update(receiveBillVO bill){
		
		System.out.println("数据层中增加了一个收件单");
		System.out.println("收件人姓名为"+bill.getName());
		System.out.println("收件时间为"+bill.getTime());
		System.out.println("收件单号为"+bill.getNum());
	}

}
