package businesslogic.billsbl;

import java.util.ArrayList;

import po.BillPO;
import po.Message;

public class DeliveryBill extends BillPO{


	String date;//装车日期
	String deliveryNum;//中转单编号
	String flyNum;//航班号
	String start;//出发地
	String aim;//到达地
	String containerNum;//货柜号
	String supervisor;//监装员
	ArrayList billNumList;//所有装运单号
	Double fee;//运费
	
	
	
	public DeliveryBill(Message message) {
		super(message);
		// TODO Auto-generated constructor stub
		this.date=message.getInform(0);
		this.deliveryNum=message.getInform(1);
		this.flyNum=message.getInform(2);
		this.start=message.getInform(3);
		this.aim=message.getInform(4);
		this.containerNum=message.getInform(5);
		this.supervisor=message.getInform(6);
		int i=0;
		while(message.getInform(i+7)!=null){
			billNumList.add(message.getInform(i+7));
			i++;
		}
	}
	
	//各种get方法
	public String getDate() {
		return date;
	}



	public String getDeliveryNum() {
		return deliveryNum;
	}



	public String getFlyNum() {
		return flyNum;
	}



	public String getStart() {
		return start;
	}



	public String getAim() {
		return aim;
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
	
	public ArrayList getBillNumList(){
		return billNumList;
	}

}
