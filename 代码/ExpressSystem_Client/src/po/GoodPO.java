package po;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayList;


/**
 * 货物的PO对象
 * @author nick
 *
 */
public class GoodPO implements Remote,Serializable{
    private String id;//编号，与订单号一致
	
	private String depature;//出发地
	
	private String destination;//目的地
	
	private enum arriveState{OK,MISS,BAD};//到达状态
	
	private enum transState{Received,ArriveSendHall,ArriveSendStorage,
		              Delivering,ArriveReceiveHall,ArriveReceiveStorage};//运输状态
		              
    private transState tranState;
    
    private arriveState ArriveState;
    
    private ArrayList<String> trace;//历史轨迹
    
    
    
    public GoodPO(String id,String depature,String destination){
    	this.id=id;
    	this.destination=destination;
    	this.depature=depature;
    	this.ArriveState=arriveState.OK;
    	this.tranState=transState.Delivering;
    }
    
    public void addTrace(String inform){
    	trace.add(inform);
    }
    
    public ArrayList getTrace(){
    	return this.trace;
    }
    
    public void setTransState(String tranState){
    	this.tranState=transState.valueOf(tranState);
    }
    
    public String getTransState(){
    	return this.tranState.toString();
    }
    
    public void setArriveState(String State){
    	this.ArriveState=arriveState.valueOf(State);
    }

    public String getArriveState(){
    	return this.ArriveState.toString();
    }
    
    public String getID(){
    	return id;
    }
}
