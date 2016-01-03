package dataservice.accountsetdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import po.accountSet.BankInform;

public interface BankInformDataServer extends Remote{
	public void addInform(BankInform inform);
	
	public ArrayList<BankInform> getInform();
	
	public void clean();//清空之前的数据
}
