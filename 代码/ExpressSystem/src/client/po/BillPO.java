package client.po;

import client.vo.Message;

/**
 * 单据的父类
 * @author nick
 *
 */
public class BillPO {

	//三种状态
	enum State{Draft,Ready,Finish};
	
	State billState;
	
	//单据id
	protected String id;
	
	public BillPO(Message message){
		this.billState=State.Draft;
	}
	
	public String getState(){
		return this.billState.toString();
	}
	
	/*
	 * 设置单据的状态
	 * 输入0为草稿，1为待审批，2为审批通过
	 */
	public void setState(int num){
		if(num==0)
			this.billState=State.Draft;
		else if(num==1)
			this.billState=State.Ready;
		else if(num==2)
			this.billState=State.Finish;
		else
			System.out.println("单据状态输入错误！");
	}
	
	public String getID(){
		return id;
	}
	
}
