package businesslogic.bankbl;

/**
 * 银行账号操作的实现
 * 
 */
import java.util.ArrayList;
import java.util.Iterator;

import client.RMIHelper;
import dataservice.bankdataservice.BankDataServer;
import po.BankPO;
import vo.BankVO;
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
	public BankVO addBank(String name, String balance) {
		// TODO Auto-generated method stub
		if (dataServer.find(name) != null){
			BankVO result=new BankVO("该名字单据已存在！");
			return result;
		}else if(balance==""||name==""){
			BankVO result=new BankVO("账户信息尚不完全请补充！");
			return result;
		}
		
		try{
			double temp=Double.valueOf(balance);
		}catch(NumberFormatException e){
			BankVO result=new BankVO("输入的数据格式不正确！");
			return result;
		}
		
		
			BankPO bank = new BankPO(name, Double.valueOf(balance));
			dataServer.insert(bank);
			
			BankVO result= new BankVO(bank);
			return result;
		

	}

	/*
	 * 删除账号
	 * 
	 * @see businesslogicservice.bankblservice.bankServer#removeBank(java.lang.
	 * String)
	 */
	@Override
	public BankVO removeBank(String name) {
		// TODO Auto-generated method stub
		BankPO bank = dataServer.find(name);
		if (bank == null) {
			BankVO result=new BankVO("未查找到该账户！");
			return result;
		} else {
			dataServer.delete(bank);
			BankVO result=new BankVO("0","0");
			return result;
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
	public BankVO changeBankName(String name, String newName) {
		// TODO Auto-generated method stub
		BankPO bank = dataServer.find(name);
		if (bank == null) {
			BankVO result=new BankVO("未查找到该账户！");
			return result;
		} else {
			bank.setid(newName);
			dataServer.update(bank);
			BankVO result=new BankVO(bank);
			return result;
		}
	}

	/*
	 * 查询账户
	 * 
	 * @see businesslogicservice.bankblservice.bankServer#inquireBank(java.lang.
	 * String)
	 */
	@Override
	public BankVO inquireBank(String name) {
		// TODO Auto-generated method stub
		BankPO bank = dataServer.find(name);
		if (bank == null) {
			BankVO result=new BankVO("未查找到该账户！");
			return result;
		} else {
			BankVO result=new BankVO(bank);
			return result;
		}
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
	
	/*
	 * 获得所有账户目录
	 * (non-Javadoc)
	 * @see businesslogicservice.bankblservice.bankServer#getAll()
	 */
	@Override
	public Iterator<BankVO> getAll(){
		ArrayList<BankPO> list=dataServer.getAllBank();
		Iterator<BankPO> banks=list.iterator();
		
        ArrayList<BankVO> resultList=new ArrayList<>();
        
        while(banks.hasNext()){
        	BankVO bank=new BankVO(banks.next());
        	resultList.add(bank);
        }
		
		return resultList.iterator();
		
	}
}
