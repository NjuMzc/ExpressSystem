package po.bills;

import java.io.Serializable;
import java.rmi.Remote;

public class SendingBill implements Serializable, Remote {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4389552756921550742L;
	private String time;// 到达日期
	private String orderID;// 托运单条形码号
	private String senderID;// 快递员姓名

	private String id;// 该单据的编号，同托运单条形码号
	private BillApproverPO approveBill;

	public SendingBill(String time, String orderID, String senderID) {
		this.time = time;
		this.orderID = orderID;
		this.senderID = senderID;

		this.id = orderID;
		approveBill = new BillApproverPO();
	}

	// 以下是get方法
	public String getTime() {
		return time;
	}

	public String getOrderID() {
		return orderID;
	}

	public String getSenderID() {
		return senderID;
	}

	public String getID() {
		return id;
	}
	
	public BillApproverPO submit() {
		approveBill.setState("Submit");

		approveBill.setEaseInform(time, id, "派件单");

		approveBill.addInform("派件单编号:" + id);
		approveBill.addInform("派件日期:" + time);
		approveBill.addInform("快递员编号:"+senderID);
		
		return approveBill;
	}
}
