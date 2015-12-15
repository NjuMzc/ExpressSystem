package businesslogic.paymentServer;

import po.bills.ChargeBill;
import vo.exception.ExceptionMessage;
import vo.paymentbl.ChargeVO;
import vo.paymentbl.PayVO;
import businesslogic.billsbl.ChargeBillServer.ChargeBillServer;
import businesslogicservice.paymentblservice.ChargeServer;

public class ChargeServerImpl implements ChargeServer {
	ChargeBillServer billServer;
	
	public ChargeServerImpl(){
		billServer=new ChargeBillServer();
	}

	@Override
	public ChargeVO makeBill(ChargeVO charge) {
		// TODO Auto-generated method stub
		ChargeVO chargeInform;
		
		//对输入的信息格式进行检查
	    if(charge.getDate().equals("")){
	    	ExceptionMessage exMessage=new ExceptionMessage("请输入收款日期！");
			chargeInform=new ChargeVO(exMessage);
			return chargeInform;
	    }
	    
	    
	    if(String.valueOf(charge.getMoney()).equals("")){
	    	ExceptionMessage exMessage=new ExceptionMessage("请输入付款金额！");
			chargeInform=new ChargeVO(exMessage);
			return chargeInform;
	    }
	   
		try{
			double temp=Double.valueOf(charge.getMoney());
		}catch(NumberFormatException e){
			ExceptionMessage exMessage=new ExceptionMessage("数据输入格式错误！请检查付款金额项目是否正确输入！");
			chargeInform=new ChargeVO(exMessage);
			return chargeInform;
		}
		
		ChargeBill bill=billServer.makeBill(charge.getDate(), String.valueOf(charge.getMoney()), charge.getSenderNum(), charge.getOrderNumbers().iterator());
		
		chargeInform=new ChargeVO(bill);
		return chargeInform;
	}

}
