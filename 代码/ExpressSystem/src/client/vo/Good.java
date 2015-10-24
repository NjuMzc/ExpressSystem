package client.vo;

public class Good {
	
	private String id;
	
	private String depature;
	
	private String definition;
	
	private enum arriveState{OK,MISS,BAD};
	
	private enum transState{Received,ArriveSendHall,ArriveSendStorage,
		              Delivering,ArriveReceiveHall,ArriveReceiveStorage};
		              
    private transState tranState;
    
    private arriveState arriveState;
    
    
    
    public Good(String id,String depature,String definition){
    	this.id=id;
    	this.definition=definition;
    	this.depature=depature;
    	this.arriveState=arriveState.OK;
    	this.tranState=transState.Delivering;
    }
    
    public void setTransState(transState tranState){
    	this.tranState=tranState;
    }
    
    public transState getTransState(){
    	return this.tranState;
    }

}
