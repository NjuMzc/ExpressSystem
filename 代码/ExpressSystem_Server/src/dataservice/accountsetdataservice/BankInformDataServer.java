package dataservice.accountsetdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.accountSet.BankInform;

public interface BankInformDataServer extends Remote{
	public void addInform(BankInform inform)throws RemoteException;
	
	public ArrayList<BankInform> getInform()throws RemoteException;
	
	public void clean()throws RemoteException;//清空之前的数据
}
