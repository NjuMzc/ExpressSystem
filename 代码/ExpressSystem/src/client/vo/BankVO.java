package client.vo;

/**
 * 银行账户的VO对象
 * @author rabook
 *
 */

public class BankVO {
	
	private String name;
	
	private double balance;
	
	public BankVO(String name,double balance){
		this.name=name;
		this.balance=balance;
	}

}
