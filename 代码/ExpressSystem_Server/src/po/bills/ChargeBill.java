package po.bills;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayList;
import java.util.Iterator;

public class ChargeBill implements Remote, Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = -8423661811000610549L;


	private String date;//收款日期
	private double money;//收款金额
	private String senderNum;// 快递员编号
	private String senderName;//快递员姓名
	private ArrayList<String> orderNumbers;// 托运订单条形码号
	
	private String id;//单据编号,格式为日期8位+4位流水号
	private String hallId;//营业厅编号
	
	private BillApproverPO approveBill;
	

	public ChargeBill(String date,String money,String senderNum,String senderName,Iterator<String> orderNumbers) {
		// TODO Auto-generated constructor stub
        this.date=date;
        this.money=Double.valueOf(money);
        this.senderNum=senderNum;
        this.senderName=senderName;
        this.orderNumbers=new ArrayList<String>();
        while(orderNumbers.hasNext()){
        	this.orderNumbers.add(orderNumbers.next());
        }
        
        this.id=date+"0000";
        this.hallId="000";
        this.approveBill=new BillApproverPO();
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


	public ArrayList<String> getOrderNumbers() {
		return orderNumbers;
	}


	public String getId() {
		return id;
	}

	public void setId(String id){
		this.id=id;
	}
	
	public String getSenderName(){
		return senderName;
	}
	
	public void setSenderNum(String senderName){
		this.senderName=senderName;
	}
	
	public String getHallId() {
		return hallId;
	}

	public void setHallId(String hallId) {
		this.hallId = hallId;
	}
	
	public BillApproverPO submit(){
		approveBill.setState("Submit");
		
		approveBill.setEaseInform(date, id, "收款单");
		
		approveBill.addInform("收款单编号:"+id);
		approveBill.addInform("收款日期:"+date);
		approveBill.addInform("收款金额:"+money);
		approveBill.addInform("快递员编号:"+senderNum);
		approveBill.addInform("全部托运单条形码号：");
		
		Iterator<String> it=orderNumbers.iterator();
		while(it.hasNext()){
			approveBill.addInform("托运单编号:"+it.next());
		}
		
		return approveBill;
		
	}
}