package businesslogic.billsbl;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

import po.BillPO;

/**
 * 带审批单据的列表，BillsApproverImpl的辅助类
 * @author rabook
 *
 */
public class BillsList {
		
    Stack stack;
    
    public BillsList(){
    	this.stack=new Stack<BillPO>();
    }
	
	public void add(BillPO bill){
		stack.add(bill);
	
	}
	
	public void remove(BillPO bill){
		stack.remove(bill);
	}

}
