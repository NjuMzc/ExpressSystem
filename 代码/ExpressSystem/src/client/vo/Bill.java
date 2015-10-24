package client.vo;

public class Bill {
	
	private Information billInfor;
	
	private enum State{Draft,Ready,Finish};
	
	private State billState;
	
	public Bill(Information billInfor){
		this.billInfor=billInfor;
		this.billState=State.Draft;
	}
	
	public State getState(){
		return this.billState;
	}
	
	public void setState(State newState){
		this.billState=newState;
	}
	
	public Information getInformation(){
		return this.billInfor;
	}

}
