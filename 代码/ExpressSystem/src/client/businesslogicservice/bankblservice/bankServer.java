package client.businesslogicservice.bankblservice;

import client.vo.BankVO;
import client.vo.Message;

/**
 * 该接口提供账户管理的相关服务
 * 包括
 * 银行账户的增删改查
 * @author rabook
 *
 */

public interface bankServer {
	
	public BankVO addBank(String name,double balance);
	
	public boolean removeBank(String name);
	
	public void changeBank(String name,Message message);
	
	public BankVO inquireBank(String name);

}
