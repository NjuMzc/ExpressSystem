package po.Institution;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayList;

import po.GoodPO;
import po.Workers.StorageKeeperPO;

/**
 * 中转中心仓库的对象
 * @author nick
 *
 */

public class StoragePO implements Serializable,Remote{
    private String id;//中转中心仓库编号，同中转中心编号
	private ArrayList<ListItem> GoodList;//该仓库的货物清单
	private boolean[][][][] capacity;//该仓库的容量列表
	private ArrayList<StorageKeeperPO> keeperList;//仓库管理员列表
	
	
	public StoragePO(String id){
		this.id=id;
		this.capacity=new boolean[3][10][10][10];//设定容量为每个3000
		this.GoodList=new ArrayList<ListItem>();
		this.keeperList=new ArrayList<StorageKeeperPO>();
	}
	
	//Setter and Getter
	public String getID(){
		return id;
	}
	
	public ArrayList<StorageKeeperPO> getAllKeeper(){
		return keeperList;
	}
	
	//增删人员
	public void addKeeper(StorageKeeperPO keeper){
		keeperList.add(keeper);
	}
	
	public void removeKeeper(StorageKeeperPO keeper){
		keeperList.remove(keeper);
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
