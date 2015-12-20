package po.bills;

import java.io.Serializable;
import java.rmi.Remote;

import po.Message;

public class ReceiveBill implements Remote, Serializable {

	private String time;// 收件时间
	private String orderNum; // 订单编号
	private String receiver;// 收件方名称

	private BillApproverPO approveBill;

	public ReceiveBill(String id, String name, String time) {

		// TODO Auto-generated constructor stub

		this.orderNum = id;
		this.time = time;
		this.receiver = name;
		approveBill = new BillApproverPO();
	}

	// 以下是各种get方法
	public String getTime() {
		return time;
	}

	public String getID() {
		return orderNum;
	}

	public String getReceiverName() {
		return receiver;
	}

	public BillApproverPO submit() {
		approveBill.setState("Submit");

		approveBill.setEaseInform(time, orderNum, "收件单");

		approveBill.addInform("收件单编号:" + orderNum);
		approveBill.addInform("收件日期:" + time);
		approveBill.addInform("收件方:" + receiver);
		return approveBill;
	}

}
