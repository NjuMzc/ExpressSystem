package client.businesslogic.storagebl;

import client.po.GoodPO;
import client.vo.Message;

/**
 * 仓库的抽象类
 * @author rabook
 *
 */
public class Storage {
	public void addGoods(GoodPO good,String location){
		
	}
	
	public void removeGoods(String id){
		
	}

	public Message getGoodList() {
		return null;
	}
	
	public Message getIOHistory(String start,String end){
		return null;
	}
	
	public void changeStorage(String id,String newLocation){
		
	}
}
