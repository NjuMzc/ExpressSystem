package vo.paymentbl;

import java.util.ArrayList;

import po.bills.ChargeBill;
import vo.exception.ExceptionMessage;

public class ChargeVO {
	private String date;//收款日期
	private double money;//收款金额
	private String sender;// 快递员编号
	private ArrayList<String> orderNumbers;// 托运订单条形码号
	
	private String id;//单据编号,格式为日期8位+4位流水号
	
	private ExceptionMessage exMessage;//错误信息
	
	public ChargeVO() {
        exMessage=new ExceptionMessage();
	}
	
	public ChargeVO(ChargeBill bill){
	    this.date=bill.getDate();
	    this.money=bill.getMoney();
	    this.sender=bill.getSenderNum();
	    this.orderNumbers=bill.getOrderNumbers();
	    this.id=bill.getId();
	    
	    this.exMessage=new ExceptionMessage();
	}
	
	public ChargeVO(ExceptionMessage exMessage){
		this.exMessage=exMessage;
	}
	
	//Setters and Getters
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getSenderNum() {
		return sender;
	}

	public void setSenderNum(String senderNum) {
		this.sender = senderNum;
	}

	public ArrayList<String> getOrderNumbers() {
		return orderNumbers;
	}

	public void setOrderNumbers(ArrayList<String> orderNumbers) {
		this.orderNumbers = orderNumbers;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	//用于传递错误信息
	public boolean isWrong(){
		return exMessage.isWrong();
	}
	
	public String getWrongMessage(){
		return exMessage.getMessage();
	}
}
