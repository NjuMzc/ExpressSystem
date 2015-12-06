package po.bills;
import java.io.Serializable;
import java.rmi.Remote;
/**
 * 中转中心装车单的po对象
 */
import java.util.ArrayList;
import java.util.Iterator;

import po.Message;

public class TransEntruckBill implements Serializable,Remote{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7278223348350309861L;
	private String date;//装车日期
	private String transNum;//中转中心汽运编号，营业厅编号6位+日期8位+5位流水号
	private String destination;//到达地
	private String carNum;//车辆代号
	private String supervisor;//监装员姓名
	private String transportor;//押运员姓名
	private ArrayList<String> orderNumbers;//所有订单编号
	
	private double payment;//运费,自动计算
	private String id;//本单据的id，同汽运编号
	
	public TransEntruckBill(Message billInfor,Iterator<String> orderList) {
		// TODO Auto-generated constructor stub
		this.date=billInfor.getInform(0);
		this.transNum=billInfor.getInform(1);
		this.destination=billInfor.getInform(2);
		this.carNum=billInfor.getInform(3);
		this.supervisor=billInfor.getInform(4);
		this.transportor=billInfor.getInform(5);
		
		this.orderNumbers=new ArrayList<String>();
		while(orderList.hasNext()){
			orderNumbers.add(orderList.next());
		}
   
	    this.payment=0;//自动根据出发地目的地生成运费
	    this.id=transNum;
	
	}
     //Getters
	
	public String getDate() {
		return date;
	}

	public String getTransNum() {
		return transNum;
	}

	public String getDestination() {
		return destination;
	}

	public String getCarNum() {
		return carNum;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public String getTransportor() {
		return transportor;
	}

	public Iterator<String> getOrderNum() {
		return orderNumbers.iterator();
	}

	public double getPayment() {
		return payment;
	}

	public String getId() {
		return id;
	}
	
	public void setPayment(double payment){
		this.payment=payment;
	}
}
