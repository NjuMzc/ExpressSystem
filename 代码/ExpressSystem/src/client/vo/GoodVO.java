package client.vo;

import java.util.ArrayList;
/**
 * 货物的VO对象
 * @author rabook
 *
 */
public class GoodVO {
	
	private String id;
	
	private String depature;
	
	private String destination;
	
	private enum arriveState{OK,MISS,BAD};
	
	private enum transState{Received,ArriveSendHall,ArriveSendStorage,
		              Delivering,ArriveReceiveHall,ArriveReceiveStorage};
		              
    private transState tranState;
    
    private arriveState arriveState;
    
    private ArrayList<String> trace;
    
    
    
    public GoodVO(String id,String depature,String destination){
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
