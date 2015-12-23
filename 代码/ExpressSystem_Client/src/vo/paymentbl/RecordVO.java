package vo.paymentbl;

import java.util.ArrayList;
import java.util.Iterator;

import po.bills.ChargeBill;
import po.bills.PaymentBill;

public class RecordVO {

	ArrayList<PaymentBill> paymentbills;
	
	ArrayList<ChargeBill>  chargebills;
	
	public RecordVO(ArrayList<PaymentBill> paymentbills,ArrayList<ChargeBill>  chargebills){
		this.paymentbills=paymentbills;
		this.chargebills=chargebills;
		
	}
	
	public Iterator<PaymentBill> getPayments(){
		return paymentbills.iterator();
	}
	
	public Iterator<ChargeBill> getCharges(){
		return chargebills.iterator();
	}
}
