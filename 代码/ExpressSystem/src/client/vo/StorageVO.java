package client.vo;

import java.util.ArrayList;

/**
 * ²Ö¿âµÄVO¶ÔÏó
 * @author rabook
 *
 */

public class StorageVO {

	private ArrayList<ListItem> GoodList;
	
	private boolean[] capacity;
	
	public StorageVO(int capacity){
		this.capacity=new boolean[capacity];
		this.GoodList=new ArrayList<ListItem>();
	}
	
	
}

class ListItem{
	
	public ListItem(GoodVO good,int a,int b,int c,int d){
		this.good=good;
		this.location=new int[4];
		this.location[0]=a;
		this.location[1]=b;
		this.location[2]=c;
		this.location[3]=d;
		
	}
	private GoodVO good;
	
	private int[] location;
	
	GoodVO getGood(){
		return this.good;
	}
	
	int[] getLocatoin(){
		return this.location;
	}
}
