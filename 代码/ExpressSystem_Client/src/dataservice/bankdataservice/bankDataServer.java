package dataservice.bankdataservice;

import java.util.ArrayList;

import po.BankPO;

public interface BankDataServer {
	public BankPO find(String id);

	public void insert(BankPO po);

	public void delete(BankPO po);

	public void update(BankPO po);

	public ArrayList getAllBank();

}
