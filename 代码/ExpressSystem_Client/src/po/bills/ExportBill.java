package po.bills;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.Iterator;

public class ExportBill implements Serializable, Remote {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4470680442343129454L;
	String orderNum;// 快递编号
	String date;// 日期

	String destination;// 目的地
	String loader;// 装运方式
	String DeliverNum;// 中转单号
	String transportNum;// 汽运编号

	String id;// 该单据的id，同快递编号
	BillApproverPO approveBill;

	public ExportBill(String orderNum, String date, String destination, String loader, String DeliveryNum,
			String transportNum) {

		// TODO Auto-generated constructor stub
		this.orderNum = orderNum;
		this.date = date;
		this.destination = destination;
		this.loader = loader;
		this.DeliverNum = DeliveryNum;
		this.transportNum = transportNum;

		this.id = orderNum;

		approveBill = new BillApproverPO();
	}

	public String getId() {
		return id;
	}

	public String getNumber() {
		return orderNum;
	}

	public String getDate() {
		return date;
	}

	public String getAim() {
		return destination;
	}

	public String getLoader() {
		return loader;
	}

	public String getDeliverNum() {
		return DeliverNum;
	}

	public String getTransportNum() {
		return transportNum;
	}

	public BillApproverPO submit() {
		approveBill.setState("Submit");

		approveBill.setEaseInform(date, id, "出库单");

		approveBill.addInform("出库单编号:" + id);
		approveBill.addInform("出库日期:" + date);
		approveBill.addInform("目的地："+destination);
		approveBill.addInform("装运方式："+loader);
		approveBill.addInform("中专单号："+DeliverNum);
		approveBill.addInform("汽运单号："+transportNum);

		return approveBill;
	}
}
