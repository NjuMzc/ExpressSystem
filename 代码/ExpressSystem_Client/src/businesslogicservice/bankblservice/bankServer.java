package businesslogicservice.bankblservice;

import po.BankPO;
import po.Message;
import vo.BankVO;

/**
 * 银行账号的相关功能
 * @author rabook
 *
 */

public interface bankServer {
	
	public BankPO addBank(String name,String balance);
	
	public boolean removeBank(String name);
	
	public boolean changeBankName(String name,String newName);
	
	public BankPO inquireBank(String name);
	
	public boolean giveMoney(String name,String money);
	
	public boolean getMoney(String name,String money);

}
