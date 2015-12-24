package businesslogic.paymentServer;

import java.util.Iterator;

import po.bills.ChargeBill;
import po.bills.PaymentBill;
import vo.paymentbl.ProfitVO;
import businesslogic.DateHelper;
import businesslogic.billsbl.ChargeBillServer.ChargeBillServer;
import businesslogic.billsbl.PaymentBill.PaymentBillServer;
import businesslogicservice.paymentblservice.GetProfitServer;

public class GetProfitServerImpl implements GetProfitServer {
	PaymentBillServer paymentServer;
	ChargeBillServer chargeServer;

	
	public GetProfitServerImpl(){
		this.paymentServer=new PaymentBillServer();
		this.chargeServer=new ChargeBillServer();
	}
	@Override
	public ProfitVO getProfit(String start, String end) {
		// TODO Auto-generated method stub
		if(!DateHelper.compare(start, end)){
			ProfitVO result=new ProfitVO("日期输入错误!");
			return result;
		}
		Iterator<PaymentBill> paymentbills=paymentServer.getAll();
		Iterator<ChargeBill> chargebills=chargeServer.getAll();
		
		double input=0;
		double output=0;
		
		while(paymentbills.hasNext()){
			PaymentBill bill=paymentbills.next();
			if(DateHelper.isBetween(bill.getDate(), start, end)){
				output+=bill.getMoney();
			}
			
		}
		
		while(chargebills.hasNext()){
			ChargeBill bill=chargebills.next();
			if(DateHelper.isBetween(bill.getDate(), start, end)){
				input+=bill.getMoney();
			}
		}
		
		ProfitVO result=new ProfitVO(input, output);
	
		
		return result;
	}

}
