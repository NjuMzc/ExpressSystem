package dataservice.bankdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import po.BankPO;

public interface BankDataServer extends Remote {
	public BankPO find(String id);

	public void insert(BankPO po);

	public void delete(BankPO po);

	public void update(BankPO po);

	public ArrayList<BankPO> getAllBank();

}
