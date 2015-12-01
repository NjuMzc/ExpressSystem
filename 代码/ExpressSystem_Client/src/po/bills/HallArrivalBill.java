package po.bills;


import po.Message;

public class HallArrivalBill{

	private String date;//到达日期
	private String transOrderNum;//中转单编号
	private String departure;//出发地
	private String state;//货物到达状态
	
	private String id;//单据编号
	
	public HallArrivalBill(Message billInfor) {
		// TODO Auto-generated constructor stub
		this.date=billInfor.getInform(0);
		this.transOrderNum=billInfor.getInform(1);
		this.departure=billInfor.getInform(2);
		String temp=billInfor.getInform(3);
		if(temp.equals("完好")){
			this.state="OK";
		}
		else if(temp.equals("丢失")){
           this.state="MISS";    
	}
		else{
			this.state="BAD";
		}
		//单据编号和中转单编号相同
		this.id=transOrderNum;
	}
	
	public String getDate(){
		return date;
	}
	
	public String getTransOrderNum(){
		return transOrderNum;
	}
	
	public String getDeparture(){
		return departure;
	}
	
	public String getGoodState(){
		return state;
	}

	public String getID(){
		return id;
	}
}
