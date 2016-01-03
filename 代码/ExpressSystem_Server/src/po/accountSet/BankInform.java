package po.accountSet;

import java.io.Serializable;
import java.rmi.Remote;

public class BankInform implements Serializable,Remote{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3491757296725530835L;
	String name;
	String money;

	public BankInform(String name, String money) {
		super();
		this.name = name;
		this.money = money;
	}
	
	//Setters and Getters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}

}
