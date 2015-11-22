package client.businesslogic.billsbl;
/**
 * 单据新建接口的实现类
 * 持有一个BillsFactory
 * 依赖billsDataServer接口
 */
import java.rmi.RemoteException;

import client.businesslogicservice.billsblservice.billMaker;
import client.dataservice.billsdataservice.billsDataServer;
import client.po.BillPO;
import client.vo.BillVO;
import client.vo.Message;

public class BillsMakerImpl implements billMaker {

	BillsFactory billsFactory;
	
	billsDataServer dataServer;
	
	public BillsMakerImpl(billsDataServer dataServer){
		this.billsFactory=new BillsFactory();
		this.dataServer=dataServer;
		
	}

	public BillPO makeOrderBill(Message message) {
		// TODO Auto-generated method stub
		OrderBill bill=new OrderBill(message);

		return bill;
	}

	public BillPO makeDeliveryBill(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BillPO makeImportBill(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BillPO makeExportBill(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BillPO makeHallArrivalBill(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BillPO makeTransArrivalBill(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BillPO makePaymentBill(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BillPO makeChargeBill(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BillPO makeEntruckBill(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BillPO makeSendingBill(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	public BillPO makeReceiveBill(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

}
