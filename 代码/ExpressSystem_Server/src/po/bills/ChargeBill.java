package po.bills;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayList;
import java.util.Iterator;

import po.Message;

public class ChargeBill implements Remote, Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = -8423661811000610549L;


	private String date;//收款日期
	private double money;//收款金额
	private String senderNum;// 快递员编号
	private ArrayList<String> orderNumbers;// 托运订单条形码号
	
	private String id;//单据编号,格式为日期8位+4位流水号
	

	public ChargeBill(String date,String money,String senderNum,Iterator<String> orderNumbers) {
		// TODO Auto-generated constructor stub
        this.date=date;
        this.money=Double.valueOf(money);
        this.senderNum=senderNum;
        
        this.orderNumbers=new ArrayList<String>();
        while(orderNumbers.hasNext()){
        	this.orderNumbers.add(orderNumbers.next());
        }
        
        this.id=date+"0000";
	}

     //Getters
	public String getDate() {
		return date;
	}


	public double getMoney() {
		return money;
	}


	public String getSenderNum() {
		return senderNum;
	}


	public Iterator<String> getOrderNumbers() {
		return orderNumbers.iterator();
	}


	public String getId() {
		return id;
	}

	public void setId(String id){
		this.id=id;
	}
}