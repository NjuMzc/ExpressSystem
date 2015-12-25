package businesslogic.paymentServer;

import po.bills.PaymentBill;
import vo.BankVO;
import vo.exception.ExceptionMessage;
import vo.paymentbl.PayVO;
import businesslogic.bankbl.BankServerImpl;
import businesslogic.billsbl.PaymentBill.PaymentBillServer;
import businesslogicservice.bankblservice.bankServer;
import businesslogicservice.paymentblservice.PayServer;

public class PayServerImpl implements PayServer {
	PaymentBillServer billServer;
	bankServer bankServer;

	public PayServerImpl(){
		billServer=new PaymentBillServer();
		bankServer=new BankServerImpl();
	}
	
	@Override
	public PayVO makeBill(PayVO pay) {
		// TODO Auto-generated method stub
		PayVO payInform;
		BankVO bank;
		
		//对输入的信息格式进行检查
	    if(pay.getDate().equals("")){
	    	ExceptionMessage exMessage=new ExceptionMessage("请输入付款日期！");
			payInform=new PayVO(exMessage);
			return payInform;
	    }
	    
	    if(pay.getAccount().equals("")){
	    	ExceptionMessage exMessage=new ExceptionMessage("请输入付款账户！");
			payInform=new PayVO(exMessage);
			return payInform;
	    }
	    
	    if(pay.getMoney().equals("")){
	    	ExceptionMessage exMessage=new ExceptionMessage("请输入付款金额！");
			payInform=new PayVO(exMessage);
			return payInform;
	    }
	   
		try{
			double temp=Double.valueOf(pay.getMoney());
		}catch(NumberFormatException e){
			ExceptionMessage exMessage=new ExceptionMessage("数据输入格式错误！请检查付款金额项目是否正确输入！");
			payInform=new PayVO(exMessage);
			return payInform;
		}
		
		//对银行账户存在情况进行检查
		bank=bankServer.inquireBank(pay.getAccount());
		if(bank==null){
			ExceptionMessage exMessage=new ExceptionMessage("输入的银行账户不存在！");
			payInform=new PayVO(exMessage);
			return payInform;
		}
		
		if(Double.valueOf(bank.getMoney()) < Double.valueOf(pay.getMoney())){
			ExceptionMessage exMessage=new ExceptionMessage("目标银行账户余额不足！");
			payInform=new PayVO(exMessage);
			return payInform;
		}
		
	    //输入没有任何错误
		PaymentBill bill=billServer.makeBill(pay);
		
		//单据编号超过极限
		if(bill==null){
			ExceptionMessage exMessage=new ExceptionMessage("系统单据编号已用完！请联系本公司工作人员进行维护。");
			payInform=new PayVO(exMessage);
			return payInform;
		}
		
		bankServer.giveMoney(bill.getAccount(), String.valueOf(bill.getMoney()));
		
		payInform=new PayVO(bill);
		
		return null;
	}

}
