package po.bills;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class BillApproverPO implements Serializable{

	private enum State{Draft,Submit,Approved};//草稿，提交，审批后
	
	private ArrayList<String> billEaseInform;//储存单据的概要信息,0是日期,1是类型,2是编号
	
	private ArrayList<String> billInform;//储存单据详细信息
	
	private State state;//该单据的状态
	
	
	public BillApproverPO(){
		this.state=state.Draft;
		this.billInform=new ArrayList<String>();
		
	}
	
	public void setEaseInform(String date,String id,String type){
		billEaseInform.add(date);
		billEaseInform.add(type);
		billEaseInform.add(id);
		
	}
	
	public Iterator<String> getEaseInform(){
		return billEaseInform.iterator();
	}
	
	public void setState(String newState){
		this.state=State.valueOf(newState);
	}
	
	public String getState(){
		return state.toString();
	}
	
	public void addInform(String inform){
		billInform.add(inform);
	}
	
	public Iterator<String> getInform(){
		return billInform.iterator();
	}
	
}
