package businesslogic.billsbl;

import po.BillPO;
import po.Message;

public class EntruckBill extends BillPO {

	private String time;//时间
	private String  transNum;//汽运编号
	private String  carNum;//车辆代号
	private String   arrival;//到达地
	private String  supervisor;//监装员
	private String transportor;//押运员
	private String orderNum;//所有订单编号
	private  double payment;//运费
	
	public EntruckBill(Message billInfor) {
		super(billInfor);
		// TODO Auto-generated constructor stub
	this.time=billInfor.getInform(0);
	this.transNum=billInfor.getInform(1);
	this.carNum=billInfor.getInform(2);
	this.arrival=billInfor.getInform(3);
	this.supervisor=billInfor.getInform(4);
	this.transportor=billInfor.getInform(5);
	this.orderNum=billInfor.getInform(6);
	this.payment=0;//自动根据出发地目的地生成运费，待完善
	
	}

	//以下是各种get方法
	
	 public String getTime(){
		 return time;
	 }
	 
    public String getTransNum(){	 
    	return transNum;
    }
	
    public String getCarNum(){
    	return carNum;
    }
    
    public String getArrival(){
    	return arrival;
    }
    
    public String getSupervisor(){
    	return supervisor;
    }
    
    public String getTransportor(){
    	return transportor;
    }
    
    public  String getOrderNum(){
    	return orderNum;
    }
    
    public double getPayment(){
    	return payment;
    }
}
