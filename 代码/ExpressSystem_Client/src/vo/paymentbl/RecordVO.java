package vo.paymentbl;

import java.util.ArrayList;
import java.util.Iterator;

import po.bills.ChargeBill;
import po.bills.PaymentBill;
import vo.exception.ExceptionMessage;

public class RecordVO {

	ArrayList<PaymentBill> paymentbills;
	
	ArrayList<ChargeBill>  chargebills;
	
	ExceptionMessage exMessage;
	
	public RecordVO(ArrayList<PaymentBill> paymentbills,ArrayList<ChargeBill>  chargebills){
		this.paymentbills=paymentbills;
		this.chargebills=chargebills;
		
		exMessage=new ExceptionMessage();
	}
	
	public Iterator<PaymentBill> getPayments(){
		return paymentbills.iterator();
	}
	
	public Iterator<ChargeBill> getCharges(){
		return chargebills.iterator();
	}
	
	//用于传递错误信息
	public boolean isWrong(){
		return exMessage.isWrong();
	}
	
	public String getWrongMessage(){
		return exMessage.getMessage();
	}
}
