package dataservice.accountsetdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import po.accountSet.StorageInform;

public interface StorageInformDataServer extends Remote{

	public void addInform(StorageInform inform);
	
	public ArrayList<StorageInform> getInform();
	
	public void clean();//清空之前的数据
}
