package vo;

import po.BankPO;
import vo.exception.ExceptionMessage;

/**
 * 银行账户界面的VO对象
 * 
 * @author rabook
 * 
 */

public class BankVO {

	String money;
	String name;

	ExceptionMessage exMessage;

	public BankVO(String WrongMessage) {
		this.money = "-1";
		this.name = "-1";
		this.exMessage = new ExceptionMessage(WrongMessage);
	}

	public BankVO(String name, String money) {
		this.name = name;
		this.money = money;
		this.exMessage = new ExceptionMessage();
	}
	
	public BankVO(BankPO bank){
		this.name=bank.getid();
		this.money=String.valueOf(bank.getBalance());
		this.exMessage=new ExceptionMessage();
	}

	public String getMoney() {
		return money;
	}

	public String getName() {
		return name;
	}

	// 用于传递错误信息
	public boolean isWrong() {
		return exMessage.isWrong();
	}

	public String getWrongMessage() {
		return exMessage.getMessage();
	}

}
