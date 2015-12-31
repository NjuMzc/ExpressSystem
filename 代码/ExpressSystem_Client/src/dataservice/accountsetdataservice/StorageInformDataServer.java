package dataservice.accountsetdataservice;

import java.util.ArrayList;

import po.accountSet.StorageInform;

public interface StorageInformDataServer {

	public void addInform(ArrayList<StorageInform> list);
	
	public ArrayList<StorageInform> getInform();
}
