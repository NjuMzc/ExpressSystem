package vo.paymentbl;

import java.util.ArrayList;
import java.util.Iterator;

import po.bills.ChargeBill;
import vo.exception.ExceptionMessage;

public class SettleVO {
	
	ArrayList<ChargeBill> list;
	private ExceptionMessage exMessage;//错误信息
	
	public SettleVO(ArrayList<ChargeBill> list){
		this.list=list;
		exMessage=new ExceptionMessage();
	}
	
	public SettleVO(ExceptionMessage exMessage){
		this.exMessage=exMessage;
		this.list=new ArrayList<>();
	}
	
	public SettleVO(){
		this.exMessage=new ExceptionMessage();
	}
	
	public SettleVO(String exMessage){
		this.exMessage=new ExceptionMessage(exMessage);
	}

	public Iterator<ChargeBill> getList(){
		
		return list.iterator();
	}
	
	
	public boolean isWrong(){
		return exMessage.isWrong();
	}
	
	public String getWrongMessage(){
		return exMessage.getMessage();
	}
	
}
