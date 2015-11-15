package client.businesslogic.billsbl;

import client.po.BillPO;
import client.vo.BillVO;
import client.vo.Message;

/**
 * 订单的类，继承了BillVO类
 * @author rabook
 *
 */
public class OrderBill extends BillPO{
    
	private Client sender;
	private Client receiver;
	private GoodInfo goodInfor;
	private Kind kind;
	private Bagging bagging;
	private double bagFee;
	private String id;
	private double charge;
	private String time;
	
	
	public OrderBill(Message billInfor) {
		// TODO Auto-generated constructor stub
		super(billInfor);
	    this.sender.name=billInfor.getInform(0);
	    this.sender.location=billInfor.getInform(1);
	    this.sender.unit=billInfor.getInform(2);
	    this.sender.telephone=billInfor.getInform(3);
	    this.sender.mobile=billInfor.getInform(4);
	    
	    this.receiver.name=billInfor.getInform(5);
	    this.receiver.location=billInfor.getInform(6);
	    this.receiver.unit=billInfor.getInform(7);
	    this.receiver.telephone=billInfor.getInform(8);
	    this.receiver.mobile=billInfor.getInform(9);
	    
	    this.goodInfor.num=Integer.parseInt(billInfor.getInform(10));
	    this.goodInfor.weight=Double.parseDouble(billInfor.getInform(11));
	    this.goodInfor.volume=Double.parseDouble(billInfor.getInform(12));
	    this.goodInfor.name=billInfor.getInform(13);
	    
	    //如果输入有错误，这里默认设置为标准快递
	    String temp=billInfor.getInform(14);
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
	    
	    //同上
	    temp=billInfor.getInform(15);
	    if(temp.equals("纸箱")){
	    	this.bagging=Bagging.paper;
	    }else if(temp.equals("木箱")){
	    	this.bagging=Bagging.wood;
	    }else if(temp.equals("快递袋")){
	    	this.bagging=Bagging.bag;
	    }else if(temp.equals("其他")){
	    	this.bagging=Bagging.other;
	    }else{
	    	System.out.println(temp+" 生成包装费出错，置为默认快递袋");
	    	this.bagging=Bagging.bag;
	    }
	    
	    
	    this.bagFee=Double.parseDouble(billInfor.getInform(16));
	    
	    this.id=billInfor.getInform(17);
	    
	    this.charge=0;
	    this.time="0";
	}
	

	public GoodInfo getGoodInfor() {
		return goodInfor;
	}

	public Kind getKind() {
		return kind;
	}

	public Bagging getBagging() {
		return bagging;
	}

	public String getBagFee() {
		return String.valueOf(bagFee);
	}

	public String getId() {
		return id;
	}

	public String getCharge() {
		return String.valueOf(charge);
	}

	public String getTime() {
		return time;
	}
}

class Client{
	
	String name;
	String location;
	String unit;
	String telephone;
	String mobile;
	
}

class GoodInfo{
	
	int num;
	double weight;
	double volume;
	String name;
	
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
