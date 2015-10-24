package client.vo;

public class Bill {
	
	private Message billInfor;
	
	private enum State{Draft,Ready,Finish};
	
	private State billState;
	
	public Bill(Message billInfor){
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
