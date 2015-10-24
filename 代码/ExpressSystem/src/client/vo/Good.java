package client.vo;

import java.util.ArrayList;

public class Good {
	
	private String id;
	
	private String depature;
	
	private String destination;
	
	private enum arriveState{OK,MISS,BAD};
	
	private enum transState{Received,ArriveSendHall,ArriveSendStorage,
		              Delivering,ArriveReceiveHall,ArriveReceiveStorage};
		              
    private transState tranState;
    
    private arriveState arriveState;
    
    private ArrayList<String> trace;
    
    
    
    public Good(String id,String depature,String destination){
    	this.id=id;
    	this.destination=destination;
    	this.depature=depature;
    	this.arriveState=arriveState.OK;
    	this.tranState=transState.Delivering;
    }
    
    public void addTrace(String inform){
    	trace.add(inform);
    }
    
    public ArrayList getTrace(){
    	return this.trace;
    }
    
    public void setTransState(transState tranState){
    	this.tranState=tranState;
    }
    
    public transState getTransState(){
    	return this.tranState;
    }

}
