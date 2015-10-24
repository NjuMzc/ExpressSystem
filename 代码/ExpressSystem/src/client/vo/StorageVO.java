package client.vo;

import java.util.ArrayList;

public class StorageVO {

	private ArrayList<ListItem> GoodList;
	
	private boolean[] capacity;
	
	public StorageVO(int capacity){
		this.capacity=new boolean[capacity];
		this.GoodList=new ArrayList<ListItem>();
	}
	
	
}

class ListItem{
	
	public ListItem(Good good,int a,int b,int c,int d){
		this.good=good;
		this.location=new int[4];
		this.location[0]=a;
		this.location[1]=b;
		this.location[2]=c;
		this.location[3]=d;
		
	}
	private Good good;
	
	private int[] location;
	
	Good getGood(){
		return this.good;
	}
	
	int[] getLocatoin(){
		return this.location;
	}
}
