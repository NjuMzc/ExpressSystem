package po.bills;

import java.io.Serializable;
import java.rmi.Remote;
import java.text.SimpleDateFormat;
import java.util.Date;

import po.Message;

/**
 * 订单的类，继承了BillPO类
 * @author rabook
 */
public class OrderBill implements Remote,Serializable {
    
	private Client sender;//寄件人信息
	private Client receiver;//收件人信息
	private GoodInfo goodInfor;//货物信息
	private Kind kind;//货物种类
	private Bagging bagging;//包装种类
	private double bagFee;//包装费
	private double charge;//运费
	private String time;//预计时间
	private String id;//自动生成ID
	
	private BillApproverPO billForApprove;
	
	/*
	 * 构造器
	 */
	public OrderBill(Message billInfor) {
		// TODO Auto-generated constructor stub
		//寄件人信息
		this.sender=new Client();
		this.sender.name=billInfor.getInform(0);
	    this.sender.location=billInfor.getInform(7);
	    this.sender.unit=billInfor.getInform(1);
	    this.sender.telephone=billInfor.getInform(8);
	    this.sender.mobile=billInfor.getInform(14);
	    
	    //收件人信息
	    this.receiver=new Client();
	    this.receiver.name=billInfor.getInform(2);
	    this.receiver.location=billInfor.getInform(9);
	    this.receiver.unit=billInfor.getInform(3);
	    this.receiver.telephone=billInfor.getInform(10);
	    this.receiver.mobile=billInfor.getInform(15);
	    
	    //货物信息
	    this.goodInfor=new GoodInfo();
	    this.goodInfor.num=Integer.parseInt(billInfor.getInform(4));
	    this.goodInfor.weight=Double.parseDouble(billInfor.getInform(11));
	    this.goodInfor.size=billInfor.getInform(5);
	    this.goodInfor.name=billInfor.getInform(12);
	    
	    //快递类型
	    //如果输入有错误，这里默认设置为标准快递
	    String temp=billInfor.getInform(16);
	    if(temp.equals("经济快递")){
	    	this.kind=Kind.ecnomic;
	    }else if(temp.equals("标准快递")){
	    	this.kind=Kind.standard;
	    }else if(temp.equals("特快专递")){
	    	this.kind=Kind.express;
	    }else{
	    	System.out.println(temp+" 生成快递类型出错，置为默认标准快递");
	    	this.kind=Kind.standard;
	    }
	    
	    //包装类型
	    temp=billInfor.getInform(17);
	    if(temp.equals("纸箱")){
	    	this.bagging=Bagging.paper;
	    }else if(temp.equals("木箱")){
	    	this.bagging=Bagging.wood;
	    }else if(temp.equals("包装袋")){
	    	this.bagging=Bagging.bag;
	    }else if(temp.equals("其他")){
	    	this.bagging=Bagging.other;
	    }else{
	    	System.out.println(temp+" 生成包装费出错，置为默认快递袋");
	    	this.bagging=Bagging.bag;
	    }
	    
	    //包装费
	    this.bagFee=Double.parseDouble(billInfor.getInform(6));
	    
	    //以下三项需要辅助类来生成
	    this.id="0";//编号
	    this.charge=0;//费用
	    this.time="0";//时间
	    
	    this.billForApprove=new  BillApproverPO();
	}
	//以下是各种get方法
	
	//订单种类
	public String getKind() {
		return kind.toString();
	}

	//订单包装类型
	public String getBagging() {
		return bagging.toString();
	}

	//订单包装费
	public String getBagFee() {
		return String.valueOf(bagFee);
	}

	//订单费用
	public String getCharge() {
		return String.valueOf(charge);
	}

	//订单预计到达时间
	public String getTime() {
		return time;
	}
	
	//寄件人姓名
	public String getSenderName(){
		return sender.name;
	}
	
	//寄件人地址
	public String getSenderLocation(){
		return sender.location;
	}
	
	//寄件人单位
	public String getSenderUnit(){
		return sender.unit;
	}
	
	//寄件人电话
	public String getSenderTelephone(){
		return sender.telephone;
	}
	
	//寄件人手机
	public String getSenderMobile(){
		return sender.mobile;
	}
	
	//收件人姓名
	public String getReceiverName(){
		return receiver.name;
	}
	
	//收件人地址
	public String getReceiverLocation(){
		return receiver.location;
	}
	
	//收件人单位
	public String getReceiverUnit(){
		return receiver.unit;
	}
	
	//收件人电话
	public String getReceiverTelephone(){
		return receiver.telephone;
	}
	
	//收件人手机
	public String getReceiverMobile(){
		return receiver.mobile;
	}
	
	//货物数量
	public String getGoodNum(){
		return String.valueOf(goodInfor.num);
	}
	
	//货物重量
	public String getGoodWeight(){
		return String.valueOf(goodInfor.weight);
	}
	
	//货物体积
	public String getGoodVolume(){
		return String.valueOf(goodInfor.volume);
	}
	
	//货物尺寸
	public String getGoodSize(){
		return goodInfor.size;
	}
	
	//货物名
	public String getGoodName(){
		return goodInfor.name;
	}
	
	//提供给货物信息的出发地与目的地
	public String getDepature(){
		
		return this.sender.location;
	}
	
	public String getDestination(){
		return this.receiver.location;
	}
	
	//返回ID
	public String getID(){
		return this.id;
	}
	
	//三个对外的Set方法
	public void setID(String id){
		this.id=id;
	}
	
	public void setCharge(double charge){
		this.charge=charge;
	}
	
	public void setTime(String Time){
		this.time=Time;
	}
	
	public BillApproverPO submit(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String date=df.format(new Date());// new Date()为获取当前系统时间
		System.out.println(date);
		billForApprove.setEaseInform(date, id, "货物订单");
		
		billForApprove.addInform("货物订单编号:"+this.getID());
	
		billForApprove.addInform("寄件人姓名:"+this.getSenderName());
		billForApprove.addInform("寄件人地址:"+this.getSenderLocation());
		billForApprove.addInform("寄件人单位:"+this.getSenderUnit());
		billForApprove.addInform("寄件人电话:"+this.getSenderTelephone());
		billForApprove.addInform("寄件人手机:"+this.getSenderMobile());
		
		billForApprove.addInform("收件人姓名:"+this.getReceiverName());
		billForApprove.addInform("收件人地址:"+this.getReceiverLocation());
		billForApprove.addInform("收件人单位:"+this.getReceiverUnit());
		billForApprove.addInform("收件人电话:"+this.getReceiverTelephone());
		billForApprove.addInform("收件人手机:"+this.getReceiverMobile());
		
	    billForApprove.addInform("货物数量:"+this.getGoodNum());
	    billForApprove.addInform("货物名字:"+this.getGoodName());
	    billForApprove.addInform("货物尺寸:"+this.getGoodSize());
	    billForApprove.addInform("货物体积:"+this.getGoodVolume());
	    billForApprove.addInform("货物重量:"+this.getGoodWeight());
	    
	    billForApprove.addInform("快递类型:"+this.getKind());
	    billForApprove.addInform("包装类型:"+this.getBagging());
	    billForApprove.addInform("包装费:"+this.getBagFee());
	    
	    billForApprove.addInform("运费:"+this.getCharge()+"    "+"预计时间:"+this.getTime());
	    
	    return billForApprove;
	}
}

class Client implements Serializable{
	
	String name;
	String location;
	String unit;
	String telephone;
	String mobile;
	
}

class GoodInfo implements Serializable{
	
	int num;
	double weight;
	String size;
	String name;
	double volume;
	
}

enum Kind{
	ecnomic,
	standard,
	express;
}

enum Bagging{
	paper,
	wood,
	bag,	
	other
}
