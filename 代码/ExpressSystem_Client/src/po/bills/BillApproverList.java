package po.bills;

import java.util.ArrayList;

public class BillApproverList {

	ArrayList<BillApproverPO>  list;
	
	public BillApproverList(){
		list=new ArrayList<BillApproverPO>();
	}
	
	public void add(BillApproverPO bill){
		list.add(bill);
	}
	
	//删除
	public void remove(int n){
		list.remove(n);
	}
	
	public ArrayList<BillApproverPO> getList(){
		return list;
	}
	
	public BillApproverPO getByNum(int n){
		return list.get(n);
	}
}
