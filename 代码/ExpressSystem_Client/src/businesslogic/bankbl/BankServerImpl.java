package businesslogic.bankbl;

/**
 * 银行账号操作的实现
 * 
 */
import client.RMIHelper;
import dataservice.bankdataservice.BankDataServer;
import po.BankPO;
import businesslogicservice.bankblservice.bankServer;

public class BankServerImpl implements bankServer {
	BankDataServer dataServer;

	public BankServerImpl() {
		// RMI实现
		dataServer=RMIHelper.getBankData();
	}

	/*
	 * 添加账号
	 * 
	 * @see
	 * businesslogicservice.bankblservice.bankServer#addBank(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public BankPO addBank(String name, String balance) {
		// TODO Auto-generated method stub
		if (dataServer.find(name) != null)
			return null;
		else {
			BankPO bank = new BankPO(name, Double.valueOf(balance));
			return bank;
		}

	}

	/*
	 * 删除账号
	 * 
	 * @see businesslogicservice.bankblservice.bankServer#removeBank(java.lang.
	 * String)
	 */
	@Override
	public boolean removeBank(String name) {
		// TODO Auto-generated method stub
		BankPO bank = dataServer.find(name);
		if (bank == null) {
			return false;
		} else {
			dataServer.delete(bank);
			return true;
		}
	}

	/*
	 * 修改账号名
	 * 
	 * @see
	 * businesslogicservice.bankblservice.bankServer#changeBankName(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public boolean changeBankName(String name, String newName) {
		// TODO Auto-generated method stub
		BankPO bank = dataServer.find(name);
		if (bank == null) {
			return false;
		} else {
			bank.setid(newName);
			dataServer.update(bank);
			return true;
		}
	}

	/*
	 * 查询账户
	 * 
	 * @see businesslogicservice.bankblservice.bankServer#inquireBank(java.lang.
	 * String)
	 */
	@Override
	public BankPO inquireBank(String name) {
		// TODO Auto-generated method stub
		BankPO bank = dataServer.find(name);
		return bank;
	}

	/*
	 * 付款
	 * 
	 * @see
	 * businesslogicservice.bankblservice.bankServer#giveMoney(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean giveMoney(String name, String money) {
		// TODO Auto-generated method stub
		BankPO bank = dataServer.find(name);
		if (bank == null) {
			System.out.println("该账号不存在！");
			return false;
		} else {
			double gold = Double.valueOf(money);
			double balance = bank.getBalance();
			double newBalance = gold - balance;
			if (newBalance < 0) {
				System.out.println("余额不足！");
				return false;
			} else {
				bank.setBalance(newBalance);
				dataServer.update(bank);
				return true;
			}

		}
	}

	/*
	 * 收款
	 * 
	 * @see
	 * businesslogicservice.bankblservice.bankServer#getMoney(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean getMoney(String name, String money) {
		// TODO Auto-generated method stub
		BankPO bank = dataServer.find(name);
		if (bank == null) {
			System.out.println("该账号不存在！");
			return false;
		} else {
			double gold = Double.valueOf(money);
			double balance = bank.getBalance();
			double newBalance = gold + balance;

			bank.setBalance(newBalance);
			dataServer.update(bank);
			return true;
		}
	}

}
