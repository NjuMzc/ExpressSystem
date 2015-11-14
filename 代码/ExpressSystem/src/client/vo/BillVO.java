package client.vo;

/**
 * 所有单据的父类
 * @author rabook
 *
 */

public class BillVO {
	
	
	private static enum State{Draft,Ready,Finish};
	
	private State billState;
	
	
	public State getState(){
		return this.billState;
	}
	
	public void setState(State newState){
		this.billState=newState;
	}
	

}
