package po.bills;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.Iterator;

import po.Message;

public class TransArrivalBill implements Serializable,Remote{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6567383100027565940L;
	private String tranStationNum;//中转中心编号
	private String date;//到达日期
	private String transOrderNum;//中转单编号
	private String departure;//出发地
	private String state;//货物到达状态
	private String goodID;//货物编号
	
	private String id;//单据编号
	
	private BillApproverPO approveBill;
	
	public TransArrivalBill(String tranStationNum,String GoodID,String date, String transOrderNum, String departure, String state) {
		// TODO Auto-generated constructor stub
		this.tranStationNum=tranStationNum;
		this.date=date;
		this.transOrderNum=transOrderNum;
		this.departure=departure;
		String temp=state;
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
		this.id=transOrderNum+goodID;
		this.goodID=GoodID;
		
		approveBill = new BillApproverPO();
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
	
	public String getGoodID(){
		return goodID;
	}
	
	public String getTranStationNum(){
		return tranStationNum;
	}
	

	public BillApproverPO submit() {
		approveBill.setState("Submit");

		approveBill.setEaseInform(date, id, "中转中心到达单");

		approveBill.addInform("到达单编号:" + id);
		approveBill.addInform("到达日期:" + date);
		approveBill.addInform("中转中心编号:"+tranStationNum);
		approveBill.addInform("中转单编号："+transOrderNum);
		approveBill.addInform("出发地:"+departure);
		approveBill.addInform("货物到达状态："+state);
		approveBill.addInform("货物编号："+goodID);



		return approveBill;

	}
}
