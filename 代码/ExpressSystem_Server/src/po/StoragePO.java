package po;

import java.util.ArrayList;

/**
 * �ֿ��PO����
 * @author nick
 *
 */

public class StoragePO {

	private ArrayList<ListItem> GoodList;
	
	private boolean[] capacity;
	
	public StoragePO(int capacity){
		this.capacity=new boolean[capacity];
		this.GoodList=new ArrayList<ListItem>();
	}
	
	
}

class ListItem{
	
	public ListItem(GoodPO good,int a,int b,int c,int d){
		this.good=good;
		this.location=new int[4];
		this.location[0]=a;
		this.location[1]=b;
		this.location[2]=c;
		this.location[3]=d;
		
	}
	private GoodPO good;
	
	private int[] location;
	
	GoodPO getGood(){
		return this.good;
	}
	
	int[] getLocatoin(){
		return this.location;
	}
}
