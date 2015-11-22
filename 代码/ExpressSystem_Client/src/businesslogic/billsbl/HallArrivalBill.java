package businesslogic.billsbl;


import po.BillPO;
import po.Message;
import businesslogic.billsbl.TransArrivalBill.GoodState;

public class HallArrivalBill extends BillPO {

	private String date;//到达日期
	private String transOrderNum;//中转单编号
	private String place;//出发地
	private GoodState state;//货物到达状态
	
	public HallArrivalBill(Message billInfor) {
		super(billInfor);
		// TODO Auto-generated constructor stub
		this.date=billInfor.getInform(0);
		this.transOrderNum=billInfor.getInform(1);
		this.place=billInfor.getInform(2);
		String temp=billInfor.getInform(3);
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
	
	public String getDate(){
		return date;
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
