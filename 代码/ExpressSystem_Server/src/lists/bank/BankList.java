package lists.bank;

import po.BankPO;

public interface BankList {
	boolean addUser(BankPO po);
	
	BankPO find(String id);
	
	boolean delUser(BankPO po);
	
	boolean update(BankPO po);
}
