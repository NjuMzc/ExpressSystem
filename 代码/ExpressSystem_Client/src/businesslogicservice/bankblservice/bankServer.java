package businesslogicservice.bankblservice;

import java.util.Iterator;

import vo.BankVO;

/**
 * 银行账号的相关功能
 * @author rabook
 *
 */

public interface bankServer {
	
	public BankVO addBank(String name,String balance);
	
	public BankVO removeBank(String name);
	
	public BankVO changeBankName(String name,String newName);
	
	public BankVO inquireBank(String name);
	
	public boolean giveMoney(String name,String money);
	
	public boolean getMoney(String name,String money);
	
	public Iterator<BankVO> getAll();

}
