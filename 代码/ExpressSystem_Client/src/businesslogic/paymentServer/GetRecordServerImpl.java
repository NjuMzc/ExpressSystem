package businesslogic.paymentServer;

import java.util.ArrayList;
import java.util.Iterator;

import po.bills.ChargeBill;
import po.bills.PaymentBill;
import vo.paymentbl.RecordVO;
import businesslogic.DateHelper;
import businesslogic.billsbl.ChargeBillServer.ChargeBillServer;
import businesslogic.billsbl.PaymentBill.PaymentBillServer;
import businesslogicservice.paymentblservice.GetRecord;

public class GetRecordServerImpl implements GetRecord {
	PaymentBillServer paymentServer;
	ChargeBillServer chargeServer;
	
	public GetRecordServerImpl(){
		this.paymentServer=new PaymentBillServer();
		this.chargeServer=new ChargeBillServer();
	}
	@Override
	public RecordVO getRecord(String start, String end) {
		// TODO Auto-generated method stub
		Iterator<PaymentBill> paymentbills=paymentServer.getAll();
		Iterator<ChargeBill> chargebills=chargeServer.getAll();
		
		ArrayList<PaymentBill> payments=new ArrayList<>();
		
		ArrayList<ChargeBill>  charges=new ArrayList<>();
		
		while(paymentbills.hasNext()){
			PaymentBill bill=paymentbills.next();
			if(DateHelper.isBetween(bill.getDate(), start, end)){
				payments.add(bill);
			}
			
		}
		
		while(chargebills.hasNext()){
			ChargeBill bill=chargebills.next();
			if(DateHelper.isBetween(bill.getDate(), start, end)){
				charges.add(bill);
			}
		}
		RecordVO result=new RecordVO(payments, charges);
	
		
		return result;
		
	}

}
