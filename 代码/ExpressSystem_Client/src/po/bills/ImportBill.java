package po.bills;

import java.io.Serializable;
import java.rmi.Remote;

public class ImportBill implements Serializable, Remote {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4699251393596331823L;

	String orderNum;// 快递编号
	String date;// 入库日期
	String destination;// 目的地
	String[] location;// 位置信息

	String id;// 该单据的id，同OrderNum

	BillApproverPO approveBill;

	public ImportBill(String orderNum, String date, String destination, String[] location) {
		this.orderNum = orderNum;
		this.date = date;
		this.destination = destination;
		this.location = new String[4];
		this.location = location;

		this.id = orderNum;
		this.approveBill = new BillApproverPO();
	}

	// Getter
	public String getOrderNum() {
		return orderNum;
	}

	public String getDate() {
		return date;
	}

	public String getDestination() {
		return destination;
	}

	public String[] getLocation() {
		return location;
	}

	public String getId() {
		return id;
	}

	public BillApproverPO submit() {
		approveBill.setState("Submit");

		approveBill.setEaseInform(date, id, "入库单");

		approveBill.addInform("入库单编号:" + id);
		approveBill.addInform("入库日期:" + date);
		approveBill.addInform("目的地：" + destination);
		approveBill.addInform("位置信息：" + location[0] + "区" + location[1] + "排" + location[2] + "架" + location[3] + "号");
		return approveBill;
	}

}
