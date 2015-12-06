package po.bills;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayList;
import java.util.Iterator;

import po.Message;

public class DeliveryBill implements Serializable,Remote{

    private String kind;//中转类型，分为：air，railway，highway
	private String date;//装车日期
	private String deliveryNum;//中转单编号 中转中心编号3位+日期8位+7位流水号
	private String transNum;//运输编号（航班号、火车号、汽车号都可能）
	private String departure;//出发地
	private String destination;//到达地
	private String containerNum;//货柜号
	private String supervisor;//监装员
	
	private ArrayList<String> billNumList;//所有装运单号
	
	private double fee;//运费,自动计算
	private String id;//该单据的id，同中转单编号
	
	
	
	public DeliveryBill(Message message,Iterator<String> billList) {
		// TODO Auto-generated constructor stub
		this.kind=message.getInform(0);
		this.date=message.getInform(1);
		this.deliveryNum=message.getInform(2);
		this.transNum=message.getInform(3);
		this.departure=message.getInform(4);
		this.destination=message.getInform(5);
		this.containerNum=message.getInform(6);
		this.supervisor=message.getInform(7);
		
		this.billNumList=new ArrayList<String>();
		while(billList.hasNext()){
			billNumList.add(billList.next());
		}
		
		this.fee=0;
		this.id=deliveryNum;
	}
	
	//各种get方法
	public String getDate() {
		return date;
	}



	public String getDeliveryNum() {
		return deliveryNum;
	}



	public String getTransNum() {
		return transNum;
	}



	public String getDeparture() {
		return departure;
	}



	public String getDestination() {
		return destination;
	}



	public String getContainerNum() {
		return containerNum;
	}



	public String getSupervisor() {
		return supervisor;
	}
	
	public String getFee(){
		return String.valueOf(fee);
	}
	
	public Iterator<String> getBillNumList(){
		return billNumList.iterator();
	}
	
	public String getKind(){
		return kind;
	}
	
	public String getId(){
		return id;
	}
	
	public void setFee(double fee){
		this.fee=fee;
	}

}
