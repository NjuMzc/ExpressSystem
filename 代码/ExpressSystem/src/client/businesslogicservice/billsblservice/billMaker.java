package client.businesslogicservice.billsblservice;

import client.po.BillPO;
import client.vo.*;

/**
 * 单据制作的接口
 * @author rabook
 *
 */

public interface billMaker {

	public BillPO makeOrderBill(Message message);
	
	public BillPO makeDeliveryBill(Message message);
	
	public BillPO makeImportBill(Message message);
	
	public BillPO makeExportBill(Message message);
	
	public BillPO makeHallArrivalBill(Message message);
	
	public BillPO makeTransArrivalBill(Message message);
	
	public BillPO makePaymentBill(Message message);
	
	public BillPO makeChargeBill(Message message);
	
	public BillPO makeEntruckBill(Message message);
	
	public BillPO makeSendingBill(Message message);
	
	public BillPO makeReceiveBill(Message message);
	

	
}
