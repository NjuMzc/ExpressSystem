package client.vo;

/**
 * 单据的父类VO对象
 * @author rabook
 *
 */

public class BillVO {
	
	private Message billInfor;
	
	private static enum State{Draft,Ready,Finish};
	
	private State billState;
	
	public BillVO(Message billInfor){
		this.billInfor=billInfor;
		this.billState=State.Draft;
	}
	
	public State getState(){
		return this.billState;
	}
	
	public void setState(State newState){
		this.billState=newState;
	}
	
	public Message getInformation(){
		return this.billInfor;
	}

}
