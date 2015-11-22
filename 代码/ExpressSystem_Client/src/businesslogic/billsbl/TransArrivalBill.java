package businesslogic.billsbl;

import po.BillPO;
import po.Message;

public class TransArrivalBill extends BillPO{

	private String transCenterNum;//中转中心编号
	private String date;//到达日期
	private String transOrderNum;//中转单编号
	private String place;//出发地
	private GoodState state;//货物到达状态
	public TransArrivalBill(Message billInfor) {
		super(billInfor);
		// TODO Auto-generated constructor stub
		this.transCenterNum=billInfor.getInform(0);
		this.date=billInfor.getInform(1);
		this.transOrderNum=billInfor.getInform(2);
		this.place=billInfor.getInform(3);
		String temp=billInfor.getInform(4);
		if(temp.equals("完好")){
			this.state=GoodState.GOOD;
		}
		else if(temp.equals("丢失")){
           this.state=GoodState.MISS;    
	}
		else if(temp.equals("破损")){
			this.state=GoodState.BROKEN;
		}
	
 }
	//以下是各种get方法
	public String getDate(){
		return date;
	}
	
	public String getTransCenterNum(){
		return transCenterNum;
	}
	
	public String getTransOrderNum(){
		return transOrderNum;
	}
	
	public String getPlace(){
		return place;
	}
	
	public GoodState getGoodState(){
		return state;
	}
	
	enum GoodState{
	GOOD,MISS,BROKEN
}
}
